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

import org.androidpn.server.dao.AdminDao;
import org.androidpn.server.dao.DriverDao;
import org.androidpn.server.dao.UserDao;
import org.androidpn.server.model.Admin;
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
public class AdminDaoHibernate extends HibernateDaoSupport implements
		AdminDao {

	public Admin getAdmin(int id) {
		// TODO Auto-generated method stub
		return (Admin) getHibernateTemplate().get(Admin.class, id);
	}

	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(
				"from Admin u order by u.id desc");
	}

	public Admin getAdminByName(String name) {
		// TODO Auto-generated method stub
		List admins = getHibernateTemplate().find("from Admin where name=?",
				name);
		if (admins == null || admins.isEmpty()) {
			 return null;
		} else {
			return (Admin) admins.get(0);
		}
	}

	public boolean getAdmin(String name, String password) {
		// TODO Auto-generated method stub
		try {
			String [] params = new String[]{name,password};
		
			List admins = getHibernateTemplate().find("from Admin where name=? and password=?",
					params);
			if (admins == null || admins.isEmpty()) {
				 return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		
	}

 

	
}
