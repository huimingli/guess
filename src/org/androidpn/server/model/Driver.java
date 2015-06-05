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
package org.androidpn.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/** 
 * This class represents the basic user object.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
@Entity
@Table(name = "driver")
public class Driver implements Serializable {

  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    
   
    @Column(name = "count")
    private int count;
    
    @Column(name = "face", length = 150)
    private String face;
    
    @Column(name = "age")
    private int age;
    
    @Column(name = "name", length = 50,nullable=false)
    private String name;

    
    public Driver() {
    }

   

   
    public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	 



	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getCount() {
		return count;
	}




	public void setCount(int count) {
		this.count = count;
	}




	public String getFace() {
		return face;
	}




	public void setFace(String face) {
		this.face = face;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

}
