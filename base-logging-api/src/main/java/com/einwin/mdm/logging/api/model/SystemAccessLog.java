package com.einwin.mdm.logging.api.model;

import java.util.Date;

import com.einwin.framework.model.GenericModel;

public class SystemAccessLog extends GenericModel<String>{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
    
    private String systemId;

    private String sysCode;

    private String serviceUrl;

    private String serviceId;

    private String responseMsg;
    
    private String requestMsg;

    private String errorMsg;

    private Integer costTime;

    private Date createdOn;

    private String createdBy;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the sysCode
	 */
	public String getSysCode() {
		return sysCode;
	}

	/**
	 * @param sysCode the sysCode to set
	 */
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	/**
	 * @return the serviceUrl
	 */
	public String getServiceUrl() {
		return serviceUrl;
	}

	/**
	 * @param serviceUrl the serviceUrl to set
	 */
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	/**
	 * @return the serviceId
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @return the responseMsg
	 */
	public String getResponseMsg() {
		return responseMsg;
	}

	/**
	 * @param responseMsg the responseMsg to set
	 */
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	/**
	 * @return the requestMsg
	 */
	public String getRequestMsg() {
		return requestMsg;
	}

	/**
	 * @param requestMsg the requestMsg to set
	 */
	public void setRequestMsg(String requestMsg) {
		this.requestMsg = requestMsg;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * @return the costTime
	 */
	public Integer getCostTime() {
		return costTime;
	}

	/**
	 * @param costTime the costTime to set
	 */
	public void setCostTime(Integer costTime) {
		this.costTime = costTime;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}

	/**
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

}