package com.qhit.doctorMenu.dao;

import com.qhit.doctorMenu.pojo.DoctorMenu;
import com.qhit.medicineCode.pojo.MedicineCode;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/22
*/

@Repository  
public interface IDoctorMenuDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List findByMenuName(Object menuName);

    List findByUserId(Object userId);

    List findByDescription(Object description);

    List findByType(Object type);

    List<DoctorMenu> search(DoctorMenu doctorMenu);

    void deleteBatch(String[] ids);

    List<MedicineCode> distributeLeft(Integer menuId);

    List<MedicineCode> distributeRight(Integer menuId);

    List<DoctorMenu> findUsableDoctorMenu(Integer userId);
}