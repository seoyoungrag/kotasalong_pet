package study.kotasalong.pet.gangwon.rest;

import javax.servlet.http.HttpServletRequest;

public class PagingVO {

	private int page;
	private int nApp = 20; // 기본 목록 갯수
	private int rows;
	private int startNum;
	private int lastPage;
	private long listCount;
	private long total;
	
	private String sidx;
	private String sord;
	private boolean isSearch;
	
	public boolean isSearch() {
		return isSearch;
	}
	public void setSearch(boolean isSearch) {
		this.isSearch = isSearch;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	public int getnApp() {
		return nApp;
	}
	public void setnApp(int nApp) {
		this.nApp = nApp;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public long getListCount() {
		return listCount;
	}
	public void setListCount(long listCount) {
		this.listCount = listCount;
	}
	
	public String nullTrim(String str) {
    	return nullTrim(str,"");
    }
    
    public String nullTrim(String str, String def) {
    	if (str == null || str.equals("null")) {
    	    return def;
    	}
    	return str.trim();
    }
	
    public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = (this.page-1)*this.rows;	
	}
	public void setPaging(HttpServletRequest request){
		this.page = Integer.parseInt(nullTrim(request.getParameter("page"),"1"));
		this.rows = Integer.parseInt(nullTrim(request.getParameter("rows"),"0"));
		this.rows = this.rows == 0 ? this.nApp : this.rows;
		this.startNum = (this.page-1) == 0 ? 1 : (this.page-1) * this.rows ;	
		this.isSearch = Boolean.parseBoolean(request.getParameter("_search"));
		this.sidx = request.getParameter("sidx");
		this.sord = request.getParameter("sord");
	}
	
	public void setLastPage(){
		this.lastPage = (this.listCount % this.rows > 0)? 1:0;
		this.total = (this.listCount / this.rows) + this.lastPage;
	}
}
