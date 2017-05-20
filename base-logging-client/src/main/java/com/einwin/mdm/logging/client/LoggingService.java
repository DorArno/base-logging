package com.einwin.mdm.logging.client;
import org.apache.log4j.Logger;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.einwin.mdm.logging.api.LoggingInterface;
import com.einwin.mdm.logging.api.model.BusinessLog;
import com.einwin.mdm.logging.api.model.OperationLog;
import com.einwin.mdm.logging.api.model.SystemAccessLog;
import com.einwin.mdm.logging.api.service.LoggingRemoteService;


@FeignClient(name = LoggingInterface.SERVICE_NAME, fallback = LoggingService.HystrixClientFallback.class)
public interface LoggingService extends LoggingRemoteService{
	
	 	@Component
	    public static class HystrixClientFallback implements LoggingService {
	 		
	 		private Logger log = Logger.getLogger(LoggingService.class);

			@Override
			public int insertOperationLog(@RequestBody OperationLog opertationlog) {
				log.error("Invoke insertOperationLog method has been Hystrix!");
				return 0;
			}
	
			@Override
			public int insertBusinessLog(@RequestBody BusinessLog businessLog) {
				// TODO Auto-generated method stub
				return 0;
			}
	
			@Override
			public int insertSystemAccessLog(@RequestBody SystemAccessLog systemAccessLog) {
				// TODO Auto-generated method stub
				return 0;
			} 
	 }

}
