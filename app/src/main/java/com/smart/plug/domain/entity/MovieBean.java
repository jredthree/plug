package com.smart.plug.domain.entity;

import java.util.List;

/**
 * author: smart
 * time: 2016/10/11
 */

public class MovieBean extends BaseBean {

    /**
     * max : 10
     * average : 7.1
     * stars : 35
     * min : 0
     */

    private RatingBean rating;
    /**
     * rating : {"max":10,"average":7.1,"stars":"35","min":0}
     * reviews_count : 31
     * wish_count : 7170
     * douban_site :
     * year : 2015
     * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2387538436.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2387538436.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2387538436.jpg"}
     * alt : https://movie.douban.com/subject/26433966/
     * id : 26433966
     * mobile_url : https://movie.douban.com/subject/26433966/mobile
     * title : 黑处有什么
     * do_count : null
     * share_url : https://m.douban.com/movie/subject/26433966
     * seasons_count : null
     * schedule_url : https://movie.douban.com/subject/26433966/cinema/
     * episodes_count : null
     * countries : ["中国大陆"]
     * genres : ["剧情","犯罪","悬疑"]
     * collect_count : 1176
     * casts : [{"alt":"https://movie.douban.com/celebrity/1362252/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1473845518.63.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1473845518.63.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1473845518.63.jpg"},"name":"苏晓彤","id":"1362252"},{"alt":"https://movie.douban.com/celebrity/1362253/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1473845735.57.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1473845735.57.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1473845735.57.jpg"},"name":"郭笑","id":"1362253"},{"alt":"https://movie.douban.com/celebrity/1362254/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1473846076.82.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1473846076.82.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1473846076.82.jpg"},"name":"陆琦蔚","id":"1362254"},{"alt":"https://movie.douban.com/celebrity/1311659/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/20368.jpg","large":"https://img1.doubanio.com/img/celebrity/large/20368.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/20368.jpg"},"name":"刘丹","id":"1311659"}]
     * current_season : null
     * original_title : 黑处有什么
     * summary : 1991年春夏之交，中原飞机厂家属区内，一起强奸杀人案打破了往日的平静……初二中等生曲靖和老留级生张雪的爸爸同为负责这起案子的警察，但有着迥异的办案风格：曲靖的爸爸出身法医，迂腐和小气的个性让他总是成为大家取笑的对象；张雪的爸爸是退伍军人，办案凭直觉，因为破案率高，是单位的红人……凶手很快被张雪爸爸抓到了，但相同的强奸杀人案再次发生……没人注意到被老师赶出教室的张雪再也没来上课……
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1350900/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1440326772.75.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1440326772.75.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1440326772.75.jpg"},"name":"王一淳","id":"1350900"}]
     * comments_count : 648
     * ratings_count : 1062
     * aka : ["What's in the Darkness"]
     */

    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String year;
    /**
     * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2387538436.jpg
     * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2387538436.jpg
     * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2387538436.jpg
     */

    private ImagesBean images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private Object do_count;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private Object episodes_count;
    private int collect_count;
    private Object current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> countries;
    private List<String> genres;
    /**
     * alt : https://movie.douban.com/celebrity/1362252/
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/1473845518.63.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1473845518.63.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1473845518.63.jpg"}
     * name : 苏晓彤
     * id : 1362252
     */

    private List<CastsBean> casts;
    /**
     * alt : https://movie.douban.com/celebrity/1350900/
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/1440326772.75.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1440326772.75.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1440326772.75.jpg"}
     * name : 王一淳
     * id : 1350900
     */

    private List<DirectorsBean> directors;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        private int max;
        private double average;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class CastsBean {
        private String alt;
        /**
         * small : https://img3.doubanio.com/img/celebrity/small/1473845518.63.jpg
         * large : https://img3.doubanio.com/img/celebrity/large/1473845518.63.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/1473845518.63.jpg
         */

        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class DirectorsBean {
        private String alt;
        /**
         * small : https://img3.doubanio.com/img/celebrity/small/1440326772.75.jpg
         * large : https://img3.doubanio.com/img/celebrity/large/1440326772.75.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/1440326772.75.jpg
         */

        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }
}
