package com.wjdwo1104.model;

import javax.servlet.http.HttpServlet;


public class PageDto extends HttpServlet {
	private int pageTotal;
	private double total;
	private int pageBlock;
	private int PageStart;
	private int Pageend;
	private double Pageperlist;
	
	
	
	
	public PageDto() {
		super();
	}
	public PageDto(int pageTotal, double total, int pageBlock, int pageStart, int pageend, double pageperlist) {
		super();
		this.pageTotal = pageTotal;
		this.total = total;
		this.pageBlock = pageBlock;
		PageStart = pageStart;
		Pageend = pageend;
		Pageperlist = pageperlist;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getTotal() {
		return (int)total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getPageStart() {
		return PageStart;
	}
	public void setPageStart(int pageStart) {
		PageStart = pageStart;
	}
	public int getPageend() {
		return Pageend;
	}
	public void setPageend(int pageend) {
		Pageend = pageend;
	}
	public int getPageperlist() {
		return (int)Pageperlist;
	}
	public void setPageperlist(double pageperlist) {
		Pageperlist = pageperlist;
	}
	
	
	
	
	
}


