package com.example.databasesqlite;

public class InforDataComputer {
    private int iDMay;
    private String tenMay;
    private String hangSX;

    public InforDataComputer() {

    }

    public InforDataComputer(int iDMay, String tenMay, String hangSX) {
        this.iDMay = iDMay;
        this.tenMay = tenMay;
        this.hangSX = hangSX;
    }

    public int getiDMay() {
        return iDMay;
    }

    public void setiDMay(int iDMay) {
        this.iDMay = iDMay;
    }

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }
}
