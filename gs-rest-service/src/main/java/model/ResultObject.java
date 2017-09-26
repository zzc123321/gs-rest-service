package model;

public class ResultObject {
    private String resultCode="";
    private SearchPager pager;
    public String getResultCode() {
        return resultCode;
    }
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
    public SearchPager getPager() {
        return pager;
    }
    public void setPager(SearchPager pager) {
        this.pager = pager;
    }
}
