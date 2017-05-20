package com.einwin.mdm.logging.provider.es.document;

import java.util.Date;

/**
 * 分页查询BusinessLog
 * Created by YANG044 on 2017/4/19.
 */
public class BusinessLogEsQuery {
    private String content;
    private String destSystemId;
    private String logType;
    private String dataType;
    private String status;
    private String beginDate;
    private String endDate;
    private Integer pageNum; // 当前页码
    private Integer pageSize; // 每页显示数量

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDestSystemId() {
        return destSystemId;
    }

    public void setDestSystemId(String destSystemId) {
        this.destSystemId = destSystemId;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
