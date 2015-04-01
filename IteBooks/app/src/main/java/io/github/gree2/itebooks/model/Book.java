package io.github.gree2.itebooks.model;

import io.realm.RealmObject;

/**
 * Created by hqlgree2 on 4/2/15.
 */
public class Book extends RealmObject {
    private String Error;
    private double Time;
    private long ID;
    private String Title;
    private String SubTitle;
    private String Description;
    private String Author;
    private String ISBN;
    private String Year;
    private String Page;
    private String Publisher;
    private String Image;
    private String Download;

    public String getError() {
        return Error;
    }

    public void setError(String error) {
        Error = error;
    }

    public double getTime() {
        return Time;
    }

    public void setTime(double time) {
        Time = time;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubTitle() {
        return SubTitle;
    }

    public void setSubTitle(String subTitle) {
        SubTitle = subTitle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getPage() {
        return Page;
    }

    public void setPage(String page) {
        Page = page;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDownload() {
        return Download;
    }

    public void setDownload(String download) {
        Download = download;
    }
}
