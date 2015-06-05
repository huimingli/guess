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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.androidpn.server.model.Admin;
import org.androidpn.server.model.User;
import org.androidpn.server.service.AdminService;
import org.androidpn.server.service.ServiceLocator;
import org.androidpn.server.service.UserService;
import org.androidpn.server.util.Config;
import org.androidpn.server.xmpp.presence.PresenceManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * A controller class to process the user related requests.
 * 
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class AdminController extends MultiActionController {

	private AdminService adminService;

	public AdminController() {
		adminService = ServiceLocator.getAdminService();
	}

	public ModelAndView send(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name = null;
		String password = null;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		List<FileItem> fileItems = servletFileUpload.parseRequest(request);
		for (FileItem fileItem : fileItems) {
			if ("name".equals(fileItem.getFieldName())) {
				name = fileItem.getString("utf-8");
			}else if("password".equals(fileItem.getFieldName())){
				password = fileItem.getString("utf-8");
			}
		}
		ModelAndView mav = new ModelAndView();
		if(adminService.login(name, password)){
		 
			mav.setViewName("redirect:index.do");			
		}else {
		 
			mav.setViewName("main/error");			
			
		}
		return mav;
	}
}
