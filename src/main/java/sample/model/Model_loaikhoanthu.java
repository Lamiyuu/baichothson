/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.model;

/**
 *
 * @author Admin
 */
    public class Model_loaikhoanthu {

    public int getTenKhoanThuId(){
        return tenkhoanthu_id;
    }

    public void setTenKhoanThuId(int tenkhoanthu_id){
    this.tenkhoanthu_id = tenkhoanthu_id;
    }

    public String getTenKhoanThuName(){
    return tenkhoanthu_name;
    }

    public void setTenKhoanThuName(String tenkhoanthu_name){
    this.tenkhoanthu_name = tenkhoanthu_name;
    }

    public Model_loaikhoanthu(int tenkhoanthu_id, String tenkhoanthu_name){
    this.tenkhoanthu_id = tenkhoanthu_id;
    this.tenkhoanthu_name = tenkhoanthu_name;
    }
    public int tenkhoanthu_id;
    public String tenkhoanthu_name;

@Override
public String toString(){
    return tenkhoanthu_name;
    }
}