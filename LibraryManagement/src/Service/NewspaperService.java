/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.NewspaperDao;
import Model.Newspaper;
import java.util.List;

/**
 *
 * @author win
 */
public class NewspaperService {
    private NewspaperDao newspaperDao;
    
    public NewspaperService(){
        newspaperDao = new NewspaperDao();
    }
    
    public List<Newspaper> getAllNewspaper(){
        return newspaperDao.getAllNewspaper();
    }
    
    public void addNewspaper(Newspaper newspaper){
        newspaperDao.addNewspaper(newspaper);
    }
    
    public void deleteNewspaper(String maTL){
        newspaperDao.deleteNewspaper(maTL);
    }
    
    public Newspaper getNewspaperById(String maTL){
        return newspaperDao.getNewspaperById(maTL);
    }
     
    public void updateNewspaper(Newspaper newspaper){
        newspaperDao.updateNewspaper(newspaper);
    }
}
