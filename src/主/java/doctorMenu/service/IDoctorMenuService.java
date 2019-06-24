package com.qhit.doctorMenu.service;

import java.util.List;
import com.qhit.doctorMenu.pojo.DoctorMenu;
import com.qhit.medicineCode.pojo.MedicineCode;

/**
* Created by GeneratorCode on 2018/12/22
*/

public interface IDoctorMenuService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    DoctorMenu findById(Object id);


    List<DoctorMenu> search(DoctorMenu doctorMenu);

    void deleteBatch(String[] ids);

    List<MedicineCode> distributeLeft(DoctorMenu doctorMenu);

    List<MedicineCode> distributeRight(DoctorMenu doctorMenu);

    void distributeUpdate(Integer menuId, String[] medicineInfos);

    List<DoctorMenu> findUsableDoctorMenu(Integer userId);
}