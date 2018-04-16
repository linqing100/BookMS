package javabean;

public class Page {
   private int start;
   private int count;
   private int pageCount;
   private int totalCount;
   private int everyCount;
   private int currentPage;
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}
public int getEveryCount() {
	return everyCount;
}
public void setEveryCount(int everyCount) {
	this.everyCount = everyCount;
}
public int getStart() {
	return start;
}
public void setStart(int start) {
	this.start = start;
}

public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getPageCount() {
	return pageCount;
}
public void setPageCount(int pageCount) {
	this.pageCount =pageCount;
}
public int getTotalCount() {
	return totalCount;
}
public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
}
   
}
