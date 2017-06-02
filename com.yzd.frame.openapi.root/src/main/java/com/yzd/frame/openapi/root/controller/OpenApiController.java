package com.yzd.frame.openapi.root.controller;

import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * API网关
 * Created by zd.yao on 2017/6/1.
 */
@Controller
@RequestMapping("OpenApi")
public class OpenApiController {
    /**
     * 使用forward实现API接口转发
     * http://localhost:10001/OpenApi/call?api=demo.hello&v=1
     * @param api=api的方法名
     * @param v=版本号
     * @param request
     * @param response
     * @return
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @RequestMapping("call")
    @ResponseBody
    public void call(String api,String v,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Preconditions.checkArgument(StringUtils.isNotBlank(api),"api is null");
        //api不等于openapi.call
        Preconditions.checkArgument(!"openapi.call".equals(api.toLowerCase()),"api=openapi.call");
        //替换API名称中的.号为/
        api=api.replace(".","/");
        request.getRequestDispatcher("/"+api).forward(request, response);
    }
}
