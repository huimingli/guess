/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package org.androidpn.server.console.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.androidpn.server.model.Driver;
import org.androidpn.server.model.User;
import org.androidpn.server.service.DriverService;
import org.androidpn.server.service.ServiceLocator;
import org.androidpn.server.util.Config;
import org.androidpn.server.xmpp.presence.PresenceManager;
import org.androidpn.server.xmpp.push.NotificationManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * A controller class to process the notification related requests.
 * 
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class DriverController extends MultiActionController {

	private DriverService driverService;

	public DriverController() {
		driverService = ServiceLocator.getDriverService();
	}

	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Driver> driverList = driverService.getDrivers();
		
		 ModelAndView mav = new ModelAndView();
		request.setAttribute("driverList", driverList);
		//mav.addObject("driverList", driverList);
		mav.setViewName("driver/list");
		return mav;
	}
	public ModelAndView send(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name = null;
		String face = null;
		String count = null;
		String age = null;
		 
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		List<FileItem> fileItems = servletFileUpload.parseRequest(request);
		for (FileItem fileItem : fileItems) {
			if ("name".equals(fileItem.getFieldName())) {
				name = fileItem.getString("utf-8");
			}  
			else if ("face".equals(fileItem.getFieldName())) {
				face = uploadImage(request, fileItem); 
			}
			else if ("count".equals(fileItem.getFieldName())) {
				count = fileItem.getString("utf-8");
			}
			else if ("age".equals(fileItem.getFieldName())) {
				age = fileItem.getString("utf-8");
			}
		}
		Driver driver = new Driver();
		driver.setAge(Integer.valueOf(age));
		driver.setCount(Integer.valueOf(count));
		driver.setFace(face);
		driver.setName(name);
		driverService.saveDriver(driver);

		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:index.do");
		return mav;
	}
	private String uploadImage(HttpServletRequest request,FileItem fileItem) throws IOException{
		String uploadPath = getServletContext().getRealPath("/upload");
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()){
			uploadDir.mkdirs();
		}
		if(fileItem!=null&&fileItem.getContentType().startsWith("image")){
			String suffix = fileItem.getName().substring(fileItem.getName().indexOf("."));
			String fileName = System.currentTimeMillis()+suffix;
			InputStream is = fileItem.getInputStream();
			FileOutputStream os = new FileOutputStream(uploadPath+"/"+fileName);
			byte[] b = new byte[1024];
			int len = 0;
			while((len = is.read(b))>0){
				os.write(b,0,len);
				os.flush();
			}
			os.close();
			is.close();
			//String serverName = request.getServerName();
			int serverPort = request.getServerPort();
			String imageUri = request.getContextPath()+"/upload/"+fileName;
			return imageUri;
		}
		return "";
	}

}
