/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Books;
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
public class BooksDao {

    public List<Books> getAllBooks() {
        List<Books> books = new ArrayList<Books>();

        Connection connection = Connect.getJDBCConection();
        String sql = "select * from sach";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Books book = new Books();
                book.setMaTL(rs.getString("idTL"));
                book.setTenNXB(rs.getString("tenNXB"));
                book.setSoBPH(rs.getInt("soBPH"));
                book.setTenTG(rs.getString("tenTG"));
                book.setSoTrang(rs.getInt("soTrang"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
    
    public Books getBooksById(String maTL) {
        
        Connection connection = Connect.getJDBCConection();
        String sql = "select * from sach where idTL = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Books book = new Books();
                book.setMaTL(rs.getString("idTL"));
                book.setTenNXB(rs.getString("tenNXB"));
                book.setSoBPH(rs.getInt("soBPH"));
                book.setTenTG(rs.getString("tenTG"));
                book.setSoTrang(rs.getInt("soTrang"));
                
                return book;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addBook(Books book) {
        Connection connection = Connect.getJDBCConection();
        String sql = " INSERT INTO sach( idTL, tenNXB, soBPH, tenTG, soTrang)"
                + " VALUE(?,?,?,?,?) ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getMaTL());
            preparedStatement.setString(2, book.getTenNXB());
            preparedStatement.setInt(3, book.getSoBPH());
            preparedStatement.setString(4, book.getTenTG());
            preparedStatement.setInt(5, book.getSoTrang());
            int rs = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateBook(Books book){
        Connection connection = Connect.getJDBCConection();
        String sql = "Update sach set tenNXB = ? , soBPH = ? , tenTG = ? , "
                + " soTrang = ? where idTL = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTenNXB());
            preparedStatement.setInt(2, book.getSoBPH());
            preparedStatement.setString(3, book.getTenTG());
            preparedStatement.setInt(4, book.getSoTrang());
            preparedStatement.setString(5, book.getMaTL());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteBook(String maTL){
       Connection connection = Connect.getJDBCConection();
       String sql = "delete from sach where idTL = ?";
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
