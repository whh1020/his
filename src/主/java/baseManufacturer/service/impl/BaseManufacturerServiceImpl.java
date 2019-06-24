package com.qhit.baseManufacturer.service.impl;

import com.qhit.baseManufacturer.service.IBaseManufacturerService;
import java.util.List;
import com.qhit.baseManufacturer.dao.IBaseManufacturerDao;
import com.qhit.baseManufacturer.pojo.BaseManufacturer;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2018/12/24
*/

@Service 
public class BaseManufacturerServiceImpl  implements IBaseManufacturerService {

    @Resource 
    IBaseManufacturerDao dao;

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
        BaseManufacturer baseManufacturer = findById(id); 
        return dao.delete(baseManufacturer); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public BaseManufacturer findById(Object id) { 
        List<BaseManufacturer> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<BaseManufacturer> search(BaseManufacturer baseManufacturer) { 
        return dao.search(baseManufacturer); 
    } 


}