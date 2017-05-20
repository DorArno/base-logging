package com.einwin.mdm.logging.api.model;

import java.util.Date;

import com.einwin.framework.model.GenericModel;

public class OperationLog extends GenericModel<String>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String dataId;

    private Integer dataType;

    private String content;

    private String createdBy;

    private Date createdOn;
    
    private String sysCode;
    
    private int flowFlag;
    
    private String tableName;
    
	public String getSysCode() {
		return sysCode;
	}

	
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	
	public int getFlowFlag() {
		return flowFlag;
	}

	
	public void setFlowFlag(int flowFlag) {
		this.flowFlag = flowFlag;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}