package com.einwin.mdm.logging.api.model;

import java.util.Date;

import com.einwin.framework.model.GenericModel;

public class BusinessLog extends GenericModel<String>{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String dataId;
    
    private String sysCode;

    private int flowFlag;

    private String sourceSystemId;

    private String destSystemId;

    private Integer logType;
    
    private Integer dataType;

    private String content;

    private String errorMsg;

    private String status;

    private Date createdOn;

    private String createdBy;

    private Date modifiedOn;

    private String modifiedBy;

    private int isDeleted;
    
    
	public String getSysCode() {
		return sysCode;
	}

	
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public int getFlowFlag() {
        return flowFlag;
    }

    public void setFlowFlag(int flowFlag) {
        this.flowFlag = flowFlag;
    }

    public String getSourceSystemId() {
        return sourceSystemId;
    }

    public void setSourceSystemId(String sourceSystemId) {
        this.sourceSystemId = sourceSystemId;
    }

    public String getDestSystemId() {
        return destSystemId;
    }

    public void setDestSystemId(String destSystemId) {
        this.destSystemId = destSystemId;
    }

    public Integer getLogType() {
		return logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

}