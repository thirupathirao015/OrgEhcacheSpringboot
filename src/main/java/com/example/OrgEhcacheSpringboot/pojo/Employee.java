package com.example.OrgEhcacheSpringboot.pojo;

import java.io.Serializable;

public class Employee implements Serializable {
private static final long serialVersionUID = 1L;
private int eid;
private String ename;
private String eaddress;

Employee(){
	
}
public Employee(int eid, String ename, String eaddress) {
	super();
	this.eid = eid;
	this.ename = ename;
	this.eaddress = eaddress;
}

public int getEid() {
	return eid;
}

public void setEid(int eid) {
	this.eid = eid;
}

public String getEname() {
	return ename;
}

public void setEname(String ename) {
	this.ename = ename;
}

public String getEaddress() {
	return eaddress;
}

public void setEaddress(String eaddress) {
	this.eaddress = eaddress;
}



}
