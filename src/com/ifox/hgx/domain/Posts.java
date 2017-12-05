package com.ifox.hgx.domain;

import java.sql.Timestamp;

public class Posts {
    private int id ;
    private String photos ;
    private String htmlcontent ;
    private Timestamp createdAt ;
    private int like ;
    private int userId ;


    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", photos='" + photos + '\'' +
                ", htmlcontent='" + htmlcontent + '\'' +
                ", createdAt=" + createdAt +
                ", like=" + like +
                ", userId=" + userId +
                '}';
    }

    public Posts() {
    }

    public Posts(int id, String photos, String htmlcontent, Timestamp createdAt, int like, int userId) {
        this.id = id;
        this.photos = photos;
        this.htmlcontent = htmlcontent;
        this.createdAt = createdAt;
        this.like = like;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getHtmlcontent() {
        return htmlcontent;
    }

    public void setHtmlcontent(String htmlcontent) {
        this.htmlcontent = htmlcontent;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
