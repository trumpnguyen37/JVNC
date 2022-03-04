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
public class Magazine extends Document{
    private int soPH;
    private String thangPH;

    public Magazine() {
    }
    
    public Magazine(int soPH, String thangPH, String maTL, String tenNXB, int soBPH) {
        super(maTL, tenNXB, soBPH);
        this.soPH = soPH;
        this.thangPH = thangPH;
    }

    public int getSoPH() {
        return soPH;
    }

    public void setSoPH(int soPH) {
        this.soPH = soPH;
    }

    public String getThangPH() {
        return thangPH;
    }

    public void setThangPH(String thangPH) {
        this.thangPH = thangPH;
    }
    
    
}
