/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.MagazineDao;
import Model.Magazine;
import java.util.List;

/**
 *
 * @author win
 */
public class MagazineService {
    private MagazineDao magazineDao;
    
    public MagazineService(){
        magazineDao = new MagazineDao();
    }
    
    public List<Magazine> getAllMagazine(){
        return magazineDao.getAllMagazine();
    }
    
    public void addMagazine(Magazine magazine){
        magazineDao.addMagazine(magazine);
    }
    
    public void deleteMagazine(String maTL){
        magazineDao.deleteMagazine(maTL);
    }
    
    public Magazine getBookById(String maTL){
        return magazineDao.getMagazineById(maTL);
    }
     
    public void updateMagazine(Magazine magazine){
        magazineDao.updateMagazine(magazine);
    }
}
