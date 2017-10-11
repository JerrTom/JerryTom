package com.itcast.cn;

public class UserData {

	private Emp emp;
	private Boolean verified;
	private String name;
	private int[] ins;
	
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Boolean getVerified() {
		return verified;
	}
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getIns() {
		return ins;
	}
	public void setIns(int[] ins) {
		this.ins = ins;
	}
}
