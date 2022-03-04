/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author win
 */
public class Newspaper extends Document{
    private String ngayPH;

    public Newspaper() {
    }

    
    
    public Newspaper(String ngayPH, String maTL, String tenNXB, int soBPH) {
        super(maTL, tenNXB, soBPH);
        this.ngayPH = ngayPH;
    }

    public String getNgayPH() {
        return ngayPH;
    }

    public void setNgayPH(String ngayPH) {
        this.ngayPH = ngayPH;
    }
    
    
}
