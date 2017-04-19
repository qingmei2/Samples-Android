package com.mei_husky.sampleneterrorutil.model.bean;

import java.util.List;

/**
 * Created by fcn-mq on 2017/4/14.
 * 剧场
 */

public class MovieTheatersModel {

    public int count;

    public int start;

    public int total;

    public List<Subjects> subjects;

    public String title;

    public class Subjects {

        public Rating rating;

        public List<String> genres;

        public String title;

        public List<Casts> casts;

        public int collect_count;

        public String original_title;

        public String subtype;

        public List<Directors> directors;

        public String year;

        public Images images;

        public String alt;

        public String id;

    }

    public class Directors {

        public String alt;

        public Avatars avatars;

        public String name;

        public String id;
    }

    public class Avatars {

        public String small;

        public String large;

        public String medium;
    }

    public class Casts {
        public String alt;

        public Avatars avatars;

        public String name;

        public String id;
    }


    public class Genres {

    }

    public class Images {
        public String small;

        public String large;

        public String medium;
    }

    public class Rating {
        public int max;

        public double average;

        public String stars;

        public int min;
    }
}
