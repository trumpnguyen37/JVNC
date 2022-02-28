/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.UserDao;
import Model.User;
import java.util.List;

/**
 *
 * @author win
 */
public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }
    
    public  List<User> getAllUers(){
        return userDao.getAllUsers();
    }
}
