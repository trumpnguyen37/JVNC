/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Magazine;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author win
 */
public class MagazineDao {

    public List<Magazine> getAllMagazine() {
        List<Magazine> magazine_l = new ArrayList<Magazine>();

        Connection connection = Connect.getJDBCConection();
        String sql = "select * from tapchi";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Magazine magazine = new Magazine();
                magazine.setMaTL(rs.getString("idTL"));
                magazine.setTenNXB(rs.getString("tenNXB"));
                magazine.setSoBPH(rs.getInt("soBPH"));
                magazine.setSoPH(rs.getInt("soPH"));
                magazine.setThangPH(rs.getString("thangPH"));
                magazine_l.add(magazine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return magazine_l;
    }
    
    public Magazine getMagazineById(String maTL) {
        
        Connection connection = Connect.getJDBCConection();
        String sql = "select * from user where idTL = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Magazine magazine = new Magazine();
                magazine.setMaTL(rs.getString("idTL"));
                magazine.setTenNXB(rs.getString("tenNXB"));
                magazine.setSoBPH(rs.getInt("soBPH"));
                magazine.setSoPH(rs.getInt("soPH"));
                magazine.setThangPH(rs.getString("thangPH"));
                
                return magazine;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addMagazine(Magazine magazine) {
        Connection connection = Connect.getJDBCConection();
        String sql = " INSERT INTO tapchi( idTL, tenNXB, soBPH, soPH, thangPH)"
                + " VALUE(?,?,?,?,?) ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, magazine.getMaTL());
            preparedStatement.setString(2, magazine.getTenNXB());
            preparedStatement.setInt(3, magazine.getSoBPH());
            preparedStatement.setInt(4, magazine.getSoPH());
            preparedStatement.setString(5, magazine.getThangPH());
            int rs = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateMagazine(Magazine magazine){
        Connection connection = Connect.getJDBCConection();
        String sql = "Update tapchi set tenNXB = ? , soBPH = ? , soPH = ? , "
                + " thangPH = ? where idTL = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, magazine.getTenNXB());
            preparedStatement.setInt(2, magazine.getSoBPH());
            preparedStatement.setInt(3, magazine.getSoPH());
            preparedStatement.setString(4, magazine.getThangPH());
            preparedStatement.setString(5, magazine.getMaTL());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteMagazine(String maTL){
       Connection connection = Connect.getJDBCConection();
       String sql = "delete from tapchi where idTL = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTL);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
