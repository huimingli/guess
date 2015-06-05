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
package org.androidpn.server.dao.hibernate;

import java.util.List;

import org.androidpn.server.dao.DriverDao;
import org.androidpn.server.dao.UserDao;
import org.androidpn.server.model.Driver;
import org.androidpn.server.model.User;
import org.androidpn.server.service.UserNotFoundException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * This class is the implementation of UserDAO using Spring's HibernateTemplate.
 * 
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class DriverDaoHibernate extends HibernateDaoSupport implements
		DriverDao {

	public Driver getDriver(int id) {
		// TODO Auto-generated method stub
		return (Driver) getHibernateTemplate().get(Driver.class, id);
	}

	public Driver saveDriver(Driver driver) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(driver);
		getHibernateTemplate().flush();
		return driver;
	}

	public void removeDriver(int id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getDriver(id));
	}

	public boolean exists(int id) {
		// TODO Auto-generated method stub
		Driver driver = (Driver) getHibernateTemplate().get(Driver.class, id);
		return driver != null;
	}

	public List<Driver> getDrivers() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Driver");
	}

	public Driver getDriverByUsername(String name) {
		// TODO Auto-generated method stub
		List drivers = getHibernateTemplate().find("from Driver where name=?",
				name);
		if (drivers == null || drivers.isEmpty()) {
			return null;
		} else {
			return (Driver) drivers.get(0);
		}
	}

	public void addCount(String name) {
		// TODO Auto-generated method stub
		List drivers = getHibernateTemplate().find("from Driver where name=?",
				name);
		if (drivers == null || drivers.isEmpty()) {
			return;
		}
		Driver driver = (Driver) drivers.get(0);
		driver.setCount(driver.getCount() + 1);
		getHibernateTemplate().saveOrUpdate(driver);
		getHibernateTemplate().flush();

	}

	public List<Driver> getDriversOrderByCount() {
		// TODO Auto-generated method stub
	 return getHibernateTemplate().find("from Driver u order by u.count desc");
	}

}
