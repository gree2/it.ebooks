package io.github.gree2.itebooks.model;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by hqlgree2 on 4/2/15.
 */
public class Search extends RealmObject{
    private String Error;
    private double Time;
    private String Total;
    private int Page;
    private RealmList<Book> Books;

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

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(int page) {
        Page = page;
    }

    public RealmList<Book> getBooks() {
        return Books;
    }

    public void setBooks(RealmList<Book> books) {
        Books = books;
    }
}
