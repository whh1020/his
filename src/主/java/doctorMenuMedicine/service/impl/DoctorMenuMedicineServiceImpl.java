package com.qhit.doctorMenuMedicine.service.impl;

import com.qhit.doctorMenuMedicine.service.IDoctorMenuMedicineService;
import java.util.List;
import com.qhit.doctorMenuMedicine.dao.IDoctorMenuMedicineDao;
import com.qhit.doctorMenuMedicine.pojo.DoctorMenuMedicine;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2018/12/23
*/

@Service 
public class DoctorMenuMedicineServiceImpl  implements IDoctorMenuMedicineService {

    @Resource 
    IDoctorMenuMedicineDao dao;

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
        DoctorMenuMedicine doctorMenuMedicine = findById(id); 
        return dao.delete(doctorMenuMedicine); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public DoctorMenuMedicine findById(Object id) { 
        List<DoctorMenuMedicine> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<DoctorMenuMedicine> search(DoctorMenuMedicine doctorMenuMedicine) { 
        return dao.search(doctorMenuMedicine); 
    }

    @Override
    public List<DoctorMenuMedicine> findByMenuId(Integer menuId) {
        return dao.findByMenuId(menuId);
    }


}