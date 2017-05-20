/**   
 * Copyright © 2016 Arvato. All rights reserved.
 * 
 * @Title: SystemInfoMapper.java 
 * @Prject: mdm-dao
 * @Package: com.mdm.user.dao.write.invokesystem 
 * @Description: TODO
 * @author: gaod003   
 * @date: 2016年9月23日 下午4:12:30 
 * @version: V1.0   
 */
package com.einwin.mdm.logging.provider.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.einwin.mdm.logging.api.model.SystemAccessLog;



/** 
 * @ClassName: SystemAccessLogWriteMapper 
 * @Description: TODO
 * @author: gaod003
 * @date: 2016年9月23日 下午4:12:30  
 */
@Mapper
public interface SystemAccessLogWriteMapper {
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: TODO
	 * @param accessLog
	 * @return
	 * @return: int
	 */
	int insert(SystemAccessLog accessLog);
	
}
