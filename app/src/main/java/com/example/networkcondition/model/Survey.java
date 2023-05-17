package com.example.networkcondition.model;

public class Survey {
    private int id;
    private  String road;
    private  String start;
    private  String start_no;
    private  String link;
    private  String end_t;
    private  String end_no;
    private  String sub_link;
    private  String corridor;
    private  String region;
    private  String shoulder_type;

    public Survey() {

    }

    public Survey( String road, String start, String start_no, String link, String end_t, String end_no, String sub_link, String corridor, String region, String shoulder_type) {
        this.road = road;
        this.start = start;
        this.start_no = start_no;
        this.link = link;
        this.end_t = end_t;
        this.end_no = end_no;
        this.sub_link = sub_link;
        this.corridor = corridor;
        this.region = region;
        this.shoulder_type = shoulder_type;
    }
    public Survey(int id, String road, String start, String start_no, String link, String end_t, String end_no, String sub_link, String corridor, String region, String shoulder_type) {
        this.id = id;
        this.road = road;
        this.start = start;
        this.start_no = start_no;
        this.link = link;
        this.end_t = end_t;
        this.end_no = end_no;
        this.sub_link = sub_link;
        this.corridor = corridor;
        this.region = region;
        this.shoulder_type = shoulder_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStart_no() {
        return start_no;
    }

    public void setStart_no(String start_no) {
        this.start_no = start_no;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getEnd_t() {
        return end_t;
    }

    public void setEnd_t(String end_t) {
        this.end_t = end_t;
    }

    public String getEnd_no() {
        return end_no;
    }

    public void setEnd_no(String end_no) {
        this.end_no = end_no;
    }

    public String getSub_link() {
        return sub_link;
    }

    public void setSub_link(String sub_link) {
        this.sub_link = sub_link;
    }

    public String getCorridor() {
        return corridor;
    }

    public void setCorridor(String corridor) {
        this.corridor = corridor;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getShoulder_type() {
        return shoulder_type;
    }

    public void setShoulder_type(String shoulder_type) {
        this.shoulder_type = shoulder_type;
    }
}
