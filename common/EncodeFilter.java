package com.qhit.common;

import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseUser.pojo.BaseUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/11/22.
 */
@WebFilter(filterName = "EncodeFilter",urlPatterns = "*.action")
public class EncodeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        HttpServletRequest request = (HttpServletRequest) req;
        //        获取session
        HttpSession session = request.getSession();
        BaseUser user = (BaseUser) session.getAttribute("sessionUser");
        if(user!=null){
            //            用户发送的请求
            String uri = request.getRequestURI();
            //        判断该用户是否拥有该权限
            //        查询用户包含哪里权限
            List<BaseFunction> functionList = user.getBaseFunctionList();
            boolean flag = false;
            for(BaseFunction function:functionList){
                if(function.getUrl()!=null&&uri.indexOf(function.getUrl())!=-1){
                    flag=true;
                }
            }
            request.setAttribute("qx",flag);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
