package com.garden.web.utils;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Page<T> implements Serializable{

	private static final long serialVersionUID = -7501049484305582871L;
	
	private long pageSize;
	private long pageNumber;
	private long next;
	private long prev;
	private long firstPage;
	private long lastPage;
	@JsonIgnore
	private long limitStartPage;
	private List<T> pageData;

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}

	public long getNext() {
		return next;
	}

	public void setNext(long next) {
		this.next = next;
	}

	public long getPrev() {
		return prev;
	}

	public void setPrev(long prev) {
		this.prev = prev;
	}

	public long getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(long firstPage) {
		this.firstPage = firstPage;
	}

	public long getLastPage() {
		return lastPage;
	}

	public void setLastPage(long lastPage) {
		this.lastPage = lastPage;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	
	public long getLimitStartPage() {
		return limitStartPage;
	}

	public void setLimitStartPage(long limitStartPage) {
		this.limitStartPage = limitStartPage;
	}

	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", next=" + next + ", prev=" + prev
				+ ", firstPage=" + firstPage + ", lastPage=" + lastPage + ", pageData=" + pageData + "]";
	}

}
