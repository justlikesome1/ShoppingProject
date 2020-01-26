package com.woniuxy.entitys;

import java.util.List;

public class PageBean<T>  {
	
	private  int totalCount;//总行�?
	private int pageSize;//每页显示的条目数
	private int currentPage;//当前页码
	private  int pages;//总页�?
	private  List<T> data;//每页显示的数�?
	
	
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PageBean(int totalCount, int pageSize, int currentPage, int pages, List<T> data) {
		super();
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.pages = pages;
		this.data = data;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getPages() {
		return pages = totalCount%pageSize ==0?totalCount/pageSize:totalCount/pageSize+1;
	}


	public List<T> getData() {
		return data;
	}

	
	
	public void setData(List<T> data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "PageBean [totalCount=" + totalCount + ", pageSize=" + pageSize + ", currentPage=" + currentPage
				+ ", pages=" + pages + ", data=" + data + "]";
	}
	
	
	
}
