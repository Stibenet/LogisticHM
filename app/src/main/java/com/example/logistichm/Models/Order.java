package com.example.logistichm.Models;

public class Order {
    private String whereFrom, where, dateTimeOrder, numberMovers, comment, choosePay;

    public Order() {
    }

    public Order(String whereFrom, String where, String dateTimeOrder, String numberMovers, String comment, String choosePay) {
        this.whereFrom = whereFrom;
        this.where = where;
        this.dateTimeOrder = dateTimeOrder;
        this.numberMovers = numberMovers;
        this.comment = comment;
        this.choosePay = choosePay;
    }

    public String getWhereFrom() {
        return whereFrom;
    }

    public void setWhereFrom(String whereFrom) {
        this.whereFrom = whereFrom;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getDateTimeOrder() {
        return dateTimeOrder;
    }

    public void setDateTimeOrder(String dateTimeOrder) {
        this.dateTimeOrder = dateTimeOrder;
    }

    public String getNumberMovers() {
        return numberMovers;
    }

    public void setNumberMovers(String numberMovers) {
        this.numberMovers = numberMovers;
    }

    public String getChoosePay() {
        return choosePay;
    }

    public void setChoosePay(String choosePay) {
        this.choosePay = choosePay;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
