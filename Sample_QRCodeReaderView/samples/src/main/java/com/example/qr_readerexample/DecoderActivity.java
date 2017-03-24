package com.example.qr_readerexample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;


public class DecoderActivity extends AppCompatActivity
    implements ActivityCompat.OnRequestPermissionsResultCallback, QRCodeReaderView.OnQRCodeReadListener {

  private static final int MY_PERMISSION_REQUEST_CAMERA = 0;
  private static final int FACE_FRONT = 1;
  private static final int FACE_BACK = 0;
  private int face;

  private ViewGroup mainLayout;
  private RelativeLayout scanLayout;

  private QRCodeReaderView qrCodeReaderView;
  private QROverlayView overlayView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_decoder);

    face = getIntent().getIntExtra("face", FACE_FRONT);

    Button tv = (Button) findViewById(R.id.btn_b01_loading_reservation_confirm);
    tv.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(DecoderActivity.this, DecoderActivity.class);
        intent.putExtra("face", face == FACE_BACK ? FACE_FRONT : FACE_BACK);
        startActivity(intent);
        finish();
      }
    });
    mainLayout = (ViewGroup) findViewById(R.id.main_layout);
    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        == PackageManager.PERMISSION_GRANTED) {
      initQRCodeReaderView();
    } else {
      requestCameraPermission();
    }
  }

  @Override protected void onResume() {
    super.onResume();

    if (qrCodeReaderView != null) {
      qrCodeReaderView.startCamera();
    }
  }

  @Override protected void onPause() {
    super.onPause();

    if (qrCodeReaderView != null) {
      qrCodeReaderView.stopCamera();
    }
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode != MY_PERMISSION_REQUEST_CAMERA) {
      return;
    }

    if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
      Snackbar.make(mainLayout, "Camera permission was granted.", Snackbar.LENGTH_SHORT).show();
      initQRCodeReaderView();
    } else {
      Snackbar.make(mainLayout, "Camera permission request was denied.", Snackbar.LENGTH_SHORT)
          .show();
    }
  }

  // Called when a QR is decoded
  // "text" : the text encoded in QR
  // "points" : points where QR control points are placed
  @Override public void onQRCodeRead(String text, PointF[] points) {
    Toast.makeText(this,"onQRCodeRead:==="+text,Toast.LENGTH_SHORT).show();
    Log.e("tag","解码成功=== "+text);

    overlayView.setBackColorByState(2);

  }

  private void requestCameraPermission() {
    if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
      Snackbar.make(mainLayout, "Camera access is required to display the camera preview.",
          Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
        @Override public void onClick(View view) {
          ActivityCompat.requestPermissions(DecoderActivity.this, new String[] {
              Manifest.permission.CAMERA
          }, MY_PERMISSION_REQUEST_CAMERA);
        }
      }).show();
    } else {
      Snackbar.make(mainLayout, "Permission is not available. Requesting camera permission.",
          Snackbar.LENGTH_SHORT).show();
      ActivityCompat.requestPermissions(this, new String[] {
          Manifest.permission.CAMERA
      }, MY_PERMISSION_REQUEST_CAMERA);
    }
  }

  private void initQRCodeReaderView() {
    scanLayout = (RelativeLayout) findViewById(R.id.scan_layout);
    qrCodeReaderView = (QRCodeReaderView) scanLayout.findViewById(R.id.qrdecoderview);
    overlayView = (QROverlayView) scanLayout.findViewById(R.id.points_overlay_view);
    qrCodeReaderView.setAutofocusInterval(2000L);
    qrCodeReaderView.setOnQRCodeReadListener(this);
    if(face == FACE_BACK) {
      Log.e("tag","setbackCamera");
      qrCodeReaderView.setBackCamera();
    }else {
      Log.e("tag","setFrontCamera");
      qrCodeReaderView.setFrontCamera();
    }
    qrCodeReaderView.startCamera();
  }

}