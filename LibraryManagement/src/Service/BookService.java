/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.BooksDao;
import Model.Books;
import java.util.List;

/**
 *
 * @author win
 */
public class BookService {
    private BooksDao bookDao;
    
    public BookService(){
        bookDao = new BooksDao();
    }
    
    public List<Books> getAllBooks(){
        return bookDao.getAllBooks();
    }
    
    public void addBook(Books book){
        bookDao.addBook(book);
    }
    
    public void deleteBook(String maTL){
        bookDao.deleteBook(maTL);
    }
    
    public Books getBookById(String maTL){
        return bookDao.getBooksById(maTL);
    }
     
    public void updateBook(Books book){
        bookDao.updateBook(book);
    }
}
