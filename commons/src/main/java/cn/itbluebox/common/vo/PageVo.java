package cn.itbluebox.common.vo;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

/**
 * 这个方法是所有的page封装对象需要继承的类
 * 用法
 * ResultVo<PageVo<xxxxxxvo>>   这里的xxxxvo就是 返回的list
 * @author chenshangxian
 */
public class PageVo<T> {

    /**
     * 当前是第几页
     */
    @JsonProperty("page_no")
    private String pageNo;

    /**
     * 单页记录数
     */
    @JsonProperty("page_size")
    private String pageSize;

    /**
     * 总页数
     */
    @JsonProperty("total_page")
    private String totalPage;

    /**
     * 总记录数
     */
    @JsonProperty("total_count")
    private String totalCount;

    /**
     * 是否是第一页
     */
    @JsonProperty("first_page")
    private Boolean firstPage;

    /**
     * 是否是最后一页
     */
    @JsonProperty("last_page")
    private Boolean lastPage;

    /**
     * 分页记录
     */
    private  List<T> records;


    private PageVo(String pageNo, String pageSize, String totalPage, String totalCount, Boolean firstPage, Boolean lastPage, List<T> records) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.firstPage = firstPage;
        this.lastPage = lastPage;
        this.records = records;
    }

    private PageVo() {
    }

    /**
     * 这个是一个工具方法
     */
    public static<T> PageVo pageUtil(Long count, Long pageNo, Long pageSize,
                                     List<T> records) {
        long tp = 0;
        // 如果页数不整除，页数加1
        if (count % pageSize > 0) {
            tp = count / pageSize + 1;
        } else {
            tp = count / pageSize;
        }
        return new PageVo(pageNo.toString(), pageSize.toString(), String.valueOf(tp), count.toString(), pageNo == 1, pageNo == tp,
                records);
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Boolean firstPage) {
        this.firstPage = firstPage;
    }

    public Boolean getLastPage() {
        return lastPage;
    }

    public void setLastPage(Boolean lastPage) {
        this.lastPage = lastPage;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
