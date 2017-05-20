package com.einwin.mdm.logging.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.einwin.mdm.logging.provider.es.document.BusinessLogDocument;
import com.einwin.mdm.logging.provider.es.document.BusinessLogEsQuery;
import com.einwin.mdm.logging.provider.es.service.BusinessEsService;
import com.einwin.mdm.logging.provider.service.LoggingService;
import com.einwin.mdm.logging.api.model.BusinessLog;
import com.einwin.mdm.logging.api.model.OperationLog;
import com.einwin.mdm.logging.api.model.SystemAccessLog;
import com.einwin.mdm.logging.api.service.LoggingRemoteService;

import java.util.Date;

@RefreshScope
@RestController
public class LoggingController implements LoggingRemoteService{
	
	@Autowired
	private LoggingService loggingService;

	@Autowired
	private BusinessEsService businessEsService;

	@Override
	public int insertOperationLog(@RequestBody OperationLog opertationlog) {
		System.out.println(opertationlog);
		System.out.println(opertationlog.getContent());
//		try {
//			Thread.currentThread().sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return loggingService.insertOperationLog(opertationlog);
	}

	@Override
	public int insertBusinessLog(@RequestBody BusinessLog businessLog){
		BusinessLogDocument businessLogDocument=new BusinessLogDocument();
		businessLogDocument.setContent(businessLog.getContent());
		businessLogDocument.setDataId(businessLog.getDataId());
		businessLogDocument.setDataType(businessLog.getDataType());
		businessLogDocument.setDestSystemId(businessLog.getDestSystemId());
		businessLogDocument.setErrorMsg(businessLog.getErrorMsg());
		businessLogDocument.setFlowFlag(businessLog.getFlowFlag());
		businessLogDocument.setIsDeleted(businessLog.getIsDeleted());
		businessLogDocument.setLogType(businessLog.getLogType());
		businessLogDocument.setSourceSystemId(businessLog.getSourceSystemId());
		businessLogDocument.setStatus(businessLog.getStatus());
		businessLogDocument.setSysCode(businessLog.getSysCode());
		businessEsService.insert(businessLogDocument);
		return loggingService.insertBusinessLog(businessLog);
	}
	@RequestMapping(value = "/businesslog", method = RequestMethod.POST)
	public int updateBusinessLog(@RequestBody BusinessLog businessLog){

		BusinessLogDocument businessLogDocument=new BusinessLogDocument();
		businessLogDocument.setContent(businessLog.getContent());
		businessLogDocument.setId(businessLog.getId());
		businessLogDocument.setDataId(businessLog.getDataId());
		businessLogDocument.setDataType(businessLog.getDataType());
		businessLogDocument.setDestSystemId(businessLog.getDestSystemId());
		businessLogDocument.setErrorMsg(businessLog.getErrorMsg());
		businessLogDocument.setFlowFlag(businessLog.getFlowFlag());
		businessLogDocument.setIsDeleted(businessLog.getIsDeleted());
		businessLogDocument.setLogType(businessLog.getLogType());
		businessLogDocument.setSourceSystemId(businessLog.getSourceSystemId());
		businessLogDocument.setStatus(businessLog.getStatus());
		businessLogDocument.setSysCode(businessLog.getSysCode());
		businessLogDocument.setModifiedOn(new Date());
		businessEsService.update(businessLogDocument);
		return 1;
	}


	@Override
	public int insertSystemAccessLog(@RequestBody SystemAccessLog systemAccessLog) {
		return loggingService.insertSystemAccessLog(systemAccessLog);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Object test(@RequestParam("content") String content){
		System.out.println("--------");
		//System.out.println(businessEsService.FindOne("bd5fbd12-15eb-4386-bc90-af2240c8db69"));
		BusinessLogEsQuery esQuery=new BusinessLogEsQuery();
		esQuery.setPageNum(1);
		esQuery.setPageSize(10);
		esQuery.setContent(content);
		esQuery.setLogType("1");

		esQuery.setBeginDate("2017-03-29T15:19:23");
		esQuery.setEndDate("2017-04-29T15:19:23");

		return  businessEsService.QueryPageList(esQuery);
	}
}
