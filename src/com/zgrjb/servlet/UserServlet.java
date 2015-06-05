package com.zgrjb.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.androidpn.server.model.Driver;
import org.androidpn.server.service.DriverService;
import org.androidpn.server.service.ServiceLocator;
import org.androidpn.server.service.UserNotFoundException;
import org.androidpn.server.service.impl.AdminServiceImpl;
import org.androidpn.server.service.impl.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		DriverService driverService = ServiceLocator.getDriverService();
		if("addCount".equals(method)){
		 
		}else if("getAllDrivers".equals(method)){
			getAllCinemaForMobile(request, response);
		}
	}
	private void getAllCinemaForMobile(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//DataOutputStream out = new DataOutputStream(response.getOutputStream());
		PrintWriter out = response.getWriter();
		try{
			DriverService driverService = ServiceLocator.getDriverService();
			List<Driver> drivers = driverService.getDrivers();
			//封装到json
			JSONArray driverArray = new JSONArray();
			for(Driver driver : drivers){
				driverArray.add(driver);
			}
			//封装到结果集
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("people.list", driverArray);
			JSONObject resultObject = JSONObject.fromObject(resultMap);
			//封装到顶层结果
			Map<String , Object> topMap  = new HashMap<String, Object>();
			topMap.put("code", "1");
			topMap.put("message", "get all driver success!");
			topMap.put("result", resultObject);
			JSONObject jsonObject = JSONObject.fromObject(topMap);
			//写数据到
			out.write(jsonObject.toString());
			out.flush();
		}catch(Exception e){
			e.printStackTrace();
			out.write(e.getMessage());
			out.flush();
		}
		finally{
			out.close();
		}
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
