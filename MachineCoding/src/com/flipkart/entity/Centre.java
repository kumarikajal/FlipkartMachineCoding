package com.flipkart.entity;

import java.util.ArrayList;
import java.util.List;

public class Centre {
    List<User> listUser;
    public Centre( int covaxNo, int covisiledNo, String location) {
	super();
    listUser=new ArrayList<User>();
	this.covaxNo = covaxNo;
	CovisiledNo = covisiledNo;
	Location = location;
	
}
   public void adduser(User user)
   {
	   listUser.add(user);
	   
   }
   public Long getCentreId() {
		return centreId;
	}
	public void setCentreId(Long centreId) {
		this.centreId = centreId;
	}
Long centreId; 
   int covaxNo;
   int CovisiledNo;
   String Location;
public List<User> getListUser() {
	return listUser;
}
public void setListUser(List<User> listUser) {
	this.listUser = listUser;
}
public int getCovaxNo() {
	return covaxNo;
}
public void setCovaxNo(int covaxNo) {
	this.covaxNo = covaxNo;
}
public int getCovisiledNo() {
	return CovisiledNo;
}
public void setCovisiledNo(int covisiledNo) {
	CovisiledNo = covisiledNo;
}
public String getLocation() {
	return Location;
}
public void setLocation(String location) {
	Location = location;
}
   
}
