/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Newspaper;
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
public class NewspaperDao {

    public List<Newspaper> getAllNewspaper() {
        List<Newspaper> Newspaper_l = new ArrayList<Newspaper>();

        Connection connection = Connect.getJDBCConection();
        String sql = "select * from bao";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Newspaper newspaper = new Newspaper();
                newspaper.setMaTL(rs.getString("idTL"));
                newspaper.setTenNXB(rs.getString("tenNXB"));
                newspaper.setSoBPH(rs.getInt("soBPH"));
                newspaper.setNgayPH(rs.getString("ngayPH"));
                Newspaper_l.add(newspaper);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Newspaper_l;
    }
    
    public Newspaper getNewspaperById(String maTL) {
        
        Connection connection = Connect.getJDBCConection();
        String sql = "select * from bao where idTL = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Newspaper newspaper = new Newspaper();
                newspaper.setMaTL(rs.getString("idTL"));
                newspaper.setTenNXB(rs.getString("tenNXB"));
                newspaper.setSoBPH(rs.getInt("soBPH"));
                newspaper.setNgayPH(rs.getString("ngayPH"));
                
                return newspaper;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addNewspaper(Newspaper newspaper) {
        Connection connection = Connect.getJDBCConection();
        String sql = " INSERT INTO bao( idTL, tenNXB, soBPH, ngayPH)"
                + " VALUE(?,?,?,?) ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newspaper.getMaTL());
            preparedStatement.setString(2, newspaper.getTenNXB());
            preparedStatement.setInt(3, newspaper.getSoBPH());
            preparedStatement.setString(4, newspaper.getNgayPH());
            int rs = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateNewspaper(Newspaper newspaper){
        Connection connection = Connect.getJDBCConection();
        String sql = "Update bao set tenNXB = ? , soBPH = ? , "
                + " ngayPH = ? where idTL = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newspaper.getTenNXB());
            preparedStatement.setInt(2, newspaper.getSoBPH());
            preparedStatement.setString(3, newspaper.getNgayPH());
            preparedStatement.setString(5, newspaper.getMaTL());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteNewspaper(String maTL){
       Connection connection = Connect.getJDBCConection();
       String sql = "delete from bao where idTL = ?";
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
