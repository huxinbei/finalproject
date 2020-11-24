package com.ie.bean;

public class Manager {
	private String mroot;
	private String mid;
	private String mname;
	private String mpwd;
	public static final int PAGE_SIZE = 3;
	public String getmroot() {
		return mroot;
	}
	public void setmroot(String mroot) {
		this.mroot = mroot;
	}
	public static int getPageSize() {
		return PAGE_SIZE;
	}
	public Manager() {
		
	}
	public Manager(String mid ,String mname,String mpwd,String mroot){
		this.mid=mid;
		this.mname=mname;
		this.mpwd=mpwd;
		this.mroot=mroot;
	}
	public String getmid(){
		return mid;
	}
	public void setmid(String mid){
		this.mid = mid;
	}
	public String getmname(){
		return mname;
	}
	public void setmname(String mname){
		this.mname = mname;
	}
	public String getmpwd(){
		return mpwd;
	}
	public void setmpwd(String mpwd){
		this.mpwd = mpwd;
	}
}
