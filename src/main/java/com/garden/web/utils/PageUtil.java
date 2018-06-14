package com.garden.web.utils;

public class PageUtil {

	public static Page<?> generatePage(Page<?> page, long sum, long prePage, long pageNumber) {
		long lastPage = generateLastPage(sum, prePage);
		prePage = (prePage>0)?prePage:1;
		pageNumber = vaildPageNumber(pageNumber, lastPage);
		page.setPageNumber(pageNumber);
		page.setFirstPage(1);
		page.setLastPage(lastPage);
		page.setNext(generateNext(lastPage, pageNumber));
		page.setPageSize(prePage);
		page.setPrev(generatePrev(pageNumber));
		page.setLimitStartPage(sum/prePage);
		return page;
	}

	private static long vaildPageNumber(long pageNumber, long lastPage) {
		if (pageNumber < 1) {
			return 1;
		} else if (pageNumber > lastPage) {
			return lastPage;
		}
		return pageNumber;
	}

	private static long generateLastPage(long sum, long prePage) {
		long page =  sum / prePage;
		if(sum%prePage > 0){
			page ++;
		}
		return (page>0)?page:1;
	}

	private static long generateNext(long lastPage, long pageNumber) {
		if (pageNumber < lastPage) {
			return pageNumber + 1;
		} else {
			return lastPage;
		}
	}

	private static long generatePrev(long pageNumber) {
		if (pageNumber > 1) {
			return pageNumber - 1;
		} else {
			return 1;
		}
	}

}
