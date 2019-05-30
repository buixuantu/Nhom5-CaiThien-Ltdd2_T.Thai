package com.example.doan_nhom5;

public class MidleFood {
    String tenMonAn,ThongTin,HuongDan;
    int imgtenMonAn;

    public MidleFood() {
    }

    public MidleFood(String tenMonAn, String thongTin, String huongDan, int imgtenMonAn) {
        this.tenMonAn = tenMonAn;
        ThongTin = thongTin;
        HuongDan = huongDan;
        this.imgtenMonAn = imgtenMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public String getThongTin() {
        return ThongTin;
    }

    public void setThongTin(String thongTin) {
        ThongTin = thongTin;
    }

    public String getHuongDan() {
        return HuongDan;
    }

    public void setHuongDan(String huongDan) {
        HuongDan = huongDan;
    }

    public int getImgtenMonAn() {
        return imgtenMonAn;
    }

    public void setImgtenMonAn(int imgtenMonAn) {
        this.imgtenMonAn = imgtenMonAn;
    }
}
