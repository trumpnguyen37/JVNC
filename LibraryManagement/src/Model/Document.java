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
public class Document {
    public String maTL;
    public String tenNXB;
    public int soBPH;

    public Document() {
    }

    public Document(String maTL, String tenNXB, int soBPH) {
        this.maTL = maTL;
        this.tenNXB = tenNXB;
        this.soBPH = soBPH;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public int getSoBPH() {
        return soBPH;
    }

    public void setSoBPH(int soBPH) {
        this.soBPH = soBPH;
    }
    
    
}
