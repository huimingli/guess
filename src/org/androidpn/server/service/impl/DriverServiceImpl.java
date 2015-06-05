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
import org.androidpn.server.dao.DriverDao;
import org.androidpn.server.dao.UserDao;
import org.androidpn.server.model.Admin;
import org.androidpn.server.model.Driver;
import org.androidpn.server.model.User;
import org.androidpn.server.service.AdminService;
import org.androidpn.server.service.DriverService;
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
public class DriverServiceImpl implements DriverService {

	private DriverDao driverDao;
	
	public DriverDao getDriverDao() {
		return driverDao;
	}

	public void setDriverDao(DriverDao driverDao) {
		this.driverDao = driverDao;
	}

	public Driver getDriver(int id) {
		// TODO Auto-generated method stub
		return driverDao.getDriver(id);
	}

	public Driver saveDriver(Driver driver) {
		// TODO Auto-generated method stub
		return driverDao.saveDriver(driver);
	}

	public void removeDriver(int id) {
		// TODO Auto-generated method stub
		driverDao.removeDriver(id);
	}

	public boolean exists(int id) {
		// TODO Auto-generated method stub
		return driverDao.exists(id);
	}

	public List<Driver> getDrivers() {
		// TODO Auto-generated method stub
		return driverDao.getDrivers();
	}

	public Driver getDriverByUsername(String name) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return driverDao.getDriverByUsername(name);
	}

	public void addCount(String name) {
		// TODO Auto-generated method stub
		driverDao.addCount(name);
	}

	public List<Driver> getDriversOrderByCount() {
		// TODO Auto-generated method stub
		return driverDao.getDriversOrderByCount();
	}

    

    
   

}
