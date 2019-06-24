package com.qhit.doctorMenu.service.impl;

import com.qhit.doctorMenu.service.IDoctorMenuService;
import java.util.List;
import com.qhit.doctorMenu.dao.IDoctorMenuDao;
import com.qhit.doctorMenu.pojo.DoctorMenu;
import com.qhit.doctorMenuMedicine.dao.IDoctorMenuMedicineDao;
import com.qhit.doctorMenuMedicine.pojo.DoctorMenuMedicine;
import com.qhit.medicineCode.pojo.MedicineCode;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2018/12/22
*/

@Service 
public class DoctorMenuServiceImpl  implements IDoctorMenuService {

    @Resource 
    IDoctorMenuDao dao;
    @Resource
    IDoctorMenuMedicineDao doctorMenuMedicineDao;

    @Override 
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 


    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 


    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 


    @Override 
    public boolean delete(Object id) { 
        DoctorMenu doctorMenu = findById(id); 
        return dao.delete(doctorMenu); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public DoctorMenu findById(Object id) { 
        List<DoctorMenu> list = dao.findById(id); 
        return  list.get(0); 
    }

    @Override
    public List<DoctorMenu> search(DoctorMenu doctorMenu) {
        return dao.search(doctorMenu);
    }

    @Override
    public void deleteBatch(String[] ids) {
        dao.deleteBatch(ids);
    }

    @Override
    public List<MedicineCode> distributeLeft(DoctorMenu doctorMenu) {
        return dao.distributeLeft(doctorMenu.getMenuId());
    }

    @Override
    public List<MedicineCode> distributeRight(DoctorMenu doctorMenu) {
        return dao.distributeRight(doctorMenu.getMenuId());
    }

    @Override
    public void distributeUpdate(Integer menuId, String[] medicineInfos) {
//        根据menuId 删除中间表的记录
        List<DoctorMenuMedicine> doctorMenuMedicineList = doctorMenuMedicineDao.findByMenuId(menuId);
        for (DoctorMenuMedicine doctorMenuMedicine:doctorMenuMedicineList) {
            doctorMenuMedicineDao.delete(doctorMenuMedicine.getMdId());
        }
//        往中间表添加记录
        DoctorMenuMedicine doctorMenuMedicine = new DoctorMenuMedicine();
        doctorMenuMedicine.setMenuId(menuId);
        for(String medicineInfo:medicineInfos){
            String[] arr = medicineInfo.split(" ");
            doctorMenuMedicine.setCodeId(Integer.parseInt(arr[0]));
            doctorMenuMedicine.setAmt(Integer.parseInt(arr[1]));
            doctorMenuMedicineDao.insert(doctorMenuMedicine);
        }
    }

    @Override
    public List<DoctorMenu> findUsableDoctorMenu(Integer userId) {
        return dao.findUsableDoctorMenu(userId);
    }


}