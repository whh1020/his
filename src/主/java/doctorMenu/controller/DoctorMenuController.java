package com.qhit.doctorMenu.controller; 

import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseRole.pojo.BaseRole;
import com.qhit.common.CommonUtil;
import com.qhit.doctorMenu.pojo.DoctorMenu;
import com.qhit.doctorMenu.service.IDoctorMenuService; 
import com.qhit.doctorMenu.service.impl.DoctorMenuServiceImpl;
import com.qhit.medicineCode.pojo.MedicineCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON; 
import java.io.IOException; 
import java.util.List; 

/** 
* Created by GeneratorCode on 2018/12/22
*/ 

@Controller 
@RequestMapping("/doctorMenu") 
public class DoctorMenuController { 

    @Resource 
    IDoctorMenuService doctorMenuService; 

    @RequestMapping("/insert") 
    public String insert(DoctorMenu doctorMenu, HttpSession session) {
        doctorMenu.setUserId(CommonUtil.getUserId(session));
        doctorMenuService.insert(doctorMenu); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer menuId, HttpServletResponse response) throws IOException { 
        doctorMenuService.delete(menuId); 
        return "forward:list.action"; 
    }
    @RequestMapping("/deleteBatch")
    public String deleteBatch(HttpServletRequest request) throws IOException {
        String[] ids = request.getParameterValues("id");
        doctorMenuService.deleteBatch(ids);
        return "forward:list.action";
    }

    @RequestMapping("/update") 
    public String update(DoctorMenu doctorMenu) { 
        doctorMenuService.update(doctorMenu); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(DoctorMenu doctorMenu) { 
        doctorMenuService.updateSelective(doctorMenu); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer menuId, Model model) { 
        DoctorMenu doctorMenu = doctorMenuService.findById(menuId); 
        model.addAttribute("doctorMenu",doctorMenu); 
        return "doctorMenu/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<DoctorMenu> list = doctorMenuService.findAll(); 
        model.addAttribute("list",list); 
        return "doctorMenu/list"; 
    }

    @RequestMapping("/search")
    public String search(Model model,DoctorMenu doctorMenu) throws IOException {
        List<DoctorMenu> list = doctorMenuService.search(doctorMenu);
        model.addAttribute("list",list);
        model.addAttribute("searchObject",doctorMenu);
        return "doctorMenu/list";
    }

    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<DoctorMenu> list = doctorMenuService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    }

    @RequestMapping("/distributeLoad")
    public String distributeLoad(DoctorMenu doctorMenu, Model model){
        List<MedicineCode> leftList = doctorMenuService.distributeLeft(doctorMenu);
        List<MedicineCode> rightList = doctorMenuService.distributeRight(doctorMenu);
        model.addAttribute("leftList",leftList);
        model.addAttribute("rightList",rightList);
        model.addAttribute("menuId",doctorMenu.getMenuId());
        return "doctorMenu/distribute";
    }
    @RequestMapping("/distributeUpdate")
    public String distributeUpdate(DoctorMenu doctorMenu,HttpServletRequest request){
        String[] medicineInfos = request.getParameterValues("medicineInfo");
        doctorMenuService.distributeUpdate(doctorMenu.getMenuId(),medicineInfos);
        return "forward:list.action";
    }


} 
