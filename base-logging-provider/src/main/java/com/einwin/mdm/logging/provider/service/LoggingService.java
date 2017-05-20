package com.einwin.mdm.logging.provider.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einwin.framework.exception.ApplicationException;
import com.einwin.framework.model.ResponseCode;
import com.einwin.framework.service.GenericService;
import com.einwin.mdm.logging.provider.mapper.BusinessLogMapper;
import com.einwin.mdm.logging.api.model.BusinessLog;
import com.einwin.mdm.logging.api.model.OperationLog;
import com.einwin.mdm.logging.api.model.SystemAccessLog;
import com.einwin.mdm.logging.provider.mapper.OperationLogWriteMapper;
import com.einwin.mdm.logging.provider.mapper.SystemAccessLogWriteMapper;

@Service("loggingService")
public class LoggingService {
	
    protected static final Logger logger = LoggerFactory.getLogger(GenericService.class);
	
    @Autowired
	private BusinessLogMapper businessLogMapper;
	
    @Autowired
	private OperationLogWriteMapper operationLogWriteMapper;
	
    @Autowired
	private SystemAccessLogWriteMapper systemAccessLogWriteMapper;
	
	public int insertOperationLog(OperationLog opertationlog) {
		int returnValue = ResponseCode.INSERT_EXCEPTION.getCode();
		try{
			operationLogWriteMapper.insert(opertationlog);
			returnValue = ResponseCode.SUCCESS.getCode();
		}
		catch(Exception e){
			e.printStackTrace();
			 logger.error(ResponseCode.INSERT_EXCEPTION.getMessage(), e);
	         throw new ApplicationException(ResponseCode.INSERT_EXCEPTION);
		}
		return returnValue;
	}
	
	public int insertBusinessLog(BusinessLog businessLog) {
		int returnValue = ResponseCode.INSERT_EXCEPTION.getCode();
		try{
			businessLogMapper.insert(businessLog);
			returnValue = ResponseCode.SUCCESS.getCode();
		}
		catch(Exception e){
			 logger.error(ResponseCode.INSERT_EXCEPTION.getMessage(), e);
	         throw new ApplicationException(ResponseCode.INSERT_EXCEPTION);
		}
		return returnValue;
	}
	
	public int insertSystemAccessLog(SystemAccessLog systemAccessLog) {
		int returnValue = ResponseCode.INSERT_EXCEPTION.getCode();
		try{
			systemAccessLogWriteMapper.insert(systemAccessLog);
			returnValue = ResponseCode.SUCCESS.getCode();
		}
		catch(Exception e){
			 logger.error(ResponseCode.INSERT_EXCEPTION.getMessage(), e);
	         throw new ApplicationException(ResponseCode.INSERT_EXCEPTION);
		}
		return returnValue;
	}

}
