package com.PangTingHui.springboot01quick.entities;


public class VideoMakers {

	private Integer id;
	private Integer uid;
    private String lastName;
    private Integer fansCount;
    private Integer playCount;
    private Integer LikesCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }

    public Integer getLikesCount() {
        return LikesCount;
    }

    public void setLikesCount(Integer likesCount) {
        LikesCount = likesCount;
    }


    public VideoMakers() {
    }

    public VideoMakers(Integer id, Integer uid, String lastName, Integer fansCount, Integer playCount, Integer likesCount) {
        this.id = id;
        this.uid = uid;
        this.lastName = lastName;
        this.fansCount = fansCount;
        this.playCount = playCount;
        LikesCount = likesCount;
    }

    public VideoMakers(Integer id, Integer uid) {
        this.id = id;
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "VideoMakers{" +
                "id=" + id +
                ", uid=" + uid +
                ", lastName='" + lastName + '\'' +
                ", fansCount=" + fansCount +
                ", playCount=" + playCount +
                ", LikesCount=" + LikesCount +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
