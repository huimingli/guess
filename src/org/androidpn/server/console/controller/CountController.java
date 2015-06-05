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
import org.androidpn.server.service.DriverService;
import org.androidpn.server.service.ServiceLocator;
import org.androidpn.server.util.Config;
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
public class CountController extends MultiActionController {

	 
	private DriverService driverService;
	public CountController() {
		driverService = ServiceLocator.getDriverService();
	}

	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Driver> driverList = driverService.getDriversOrderByCount();
		
		 ModelAndView mav = new ModelAndView();
		request.setAttribute("driverList", driverList);
		//mav.addObject("driverList", driverList);
		mav.setViewName("driver/list");
		return mav;
	}

	 
	 

}
