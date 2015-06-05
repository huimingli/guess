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
package org.androidpn.server.service.impl;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.androidpn.server.dao.AdminDao;
import org.androidpn.server.dao.UserDao;
import org.androidpn.server.model.Admin;
import org.androidpn.server.model.User;
import org.androidpn.server.service.AdminService;
import org.androidpn.server.service.UserExistsException;
import org.androidpn.server.service.UserNotFoundException;
import org.androidpn.server.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;

/** 
 * This class is the implementation of UserService.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class AdminServiceImpl implements AdminService {

    

    public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	private AdminDao adminDao;

	public Admin getAdmin(int id) {
		// TODO Auto-generated method stub
		return adminDao.getAdmin(id);
	}

	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return adminDao.getAdmins();
	}

	public Admin getAdminByName(String name) {
		// TODO Auto-generated method stub
		return adminDao.getAdminByName(name);
	}

	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		 return adminDao.getAdmin(name, password);
	}
public void outttt(){
	System.out.println("what the fuck");
}
   

}
