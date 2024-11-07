/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.model;

import java.sql.Date;

public class Model_khoanthu {
    public int makhoanthu;
    public Model_loaikhoanthu tenkhoanthu;
    public int sotienthu;
    public Date ngaybatdauthu;
    public Date ngayketthuc;
    public String mota;

    // Constructor
    public Model_khoanthu(int makhoanthu, Model_loaikhoanthu tenkhoanthu, Date ngaybatdauthu, int sotienthu, Date ngayketthuc, String mota) {
        this.makhoanthu = makhoanthu;
        this.tenkhoanthu = tenkhoanthu;
        this.sotienthu = sotienthu;
        this.ngaybatdauthu = ngaybatdauthu;
        this.ngayketthuc = ngayketthuc;
        this.mota = mota;
    }

    // Getter and Setter methods
    public int getMakhoanthu() {
        return makhoanthu;
    }

    public void setMakhoanthu(int makhoanthu) {
        this.makhoanthu = makhoanthu;
    }

    public Model_loaikhoanthu getTenkhoanthu() {
        return tenkhoanthu;
    }

    public void setTenkhoanthu(Model_loaikhoanthu tenkhoanthu) {
        this.tenkhoanthu = tenkhoanthu;
    }

    public int getSotienthu() {
        return sotienthu;
    }

    public void setSotienthu(int sotienthu) {
        this.sotienthu = sotienthu;
    }

    public Date getNgaybatdauthu() {
        return ngaybatdauthu;
    }

    public void setNgaybatdauthu(Date ngaybatdauthu) {
        this.ngaybatdauthu = ngaybatdauthu;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
