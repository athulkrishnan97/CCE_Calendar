package sema4.com.CCE_HOLISTIC_CALENDAR.Firebase_models;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

// [START post_class]
@IgnoreExtraProperties

public class Post {


    public String uid;
    public String author;
    public String title;
    public String body;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();


    public String day1;
    public String day2;
    public String day3;
    public String day4;
    public String day5;
    public String day6;
    public String day7;
    public String day8;
    public String day9;
    public String day10;
    public String day11;
    public String day12;
    public String day13;
    public String day14;
    public String day15;
    public String day16;
    public String day17;
    public String day18;
    public String day19;
    public String day20;
    public String day21;
    public String day22;
    public String day23;
    public String day24;
    public String day25;
    public String day26;
    public String day27;
    public String day28;
    public String day29;
    public String day30;
    public String day31;





    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String uid, String author, String title, String body) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.body = body;

        this.day1 = day1;
        this.day2 = day2;
        this.day3 = day3;
        this.day4 = day4;
        this.day5 = day5;
        this.day6 = day6;
        this.day7 = day7;
        this.day8 = day8;
        this.day9 = day9;
        this.day10 = day10;
        this.day11 = day11;
        this.day12 = day12;
        this.day13 = day13;
        this.day14 = day14;
        this.day15 = day15;
        this.day16 = day16;
        this.day17 = day17;
        this.day18 = day18;
        this.day19 = day19;
        this.day20 = day20;
        this.day21 = day21;
        this.day22 = day22;
        this.day23 = day23;
        this.day24 = day24;
        this.day25 = day25;
        this.day26 = day26;
        this.day27 = day27;
        this.day28 = day28;
        this.day29 = day29;
        this.day30 = day30;
        this.day31 = day31;



    }

    // [START post_to_map]
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("author", author);
        result.put("title", title);
        result.put("body", body);
        result.put("starCount", starCount);
        result.put("stars", stars);

        return result;
    }




}
