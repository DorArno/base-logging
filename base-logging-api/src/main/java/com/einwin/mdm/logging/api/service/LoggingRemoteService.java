package com.einwin.mdm.logging.api.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.einwin.mdm.logging.api.model.BusinessLog;
import com.einwin.mdm.logging.api.model.OperationLog;
import com.einwin.mdm.logging.api.model.SystemAccessLog;

public interface LoggingRemoteService {
	
	/**
	 * 增加操作日志
	 * @param opertationlog
	 * @return
	 */
	@Async
    @GetMapping
    @RequestMapping(value = "/operationlog", method = RequestMethod.PUT)
    public int insertOperationLog(@RequestBody OperationLog opertationlog);

    /**
     * 增加日志
     * @param businessLog
     * @return
     */
	@Async
    @RequestMapping(value = "/businesslog", method = RequestMethod.PUT)
    public int insertBusinessLog(@RequestBody BusinessLog businessLog);
    
    /**
     * 系统访问日志
     * @param systemAccessLog
     * @return
     */
	@Async
    @RequestMapping(value = "/systemaccesslog", method = RequestMethod.PUT)
    public int insertSystemAccessLog(@RequestBody SystemAccessLog systemAccessLog);
}
