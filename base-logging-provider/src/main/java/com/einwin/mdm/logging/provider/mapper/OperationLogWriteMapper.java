package com.einwin.mdm.logging.provider.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.einwin.mdm.logging.api.model.OperationLog;


@Mapper
public interface OperationLogWriteMapper {

	List<OperationLog> queryPageList(Map<String, Object> params);

	int insert(OperationLog dmo);

	int update(OperationLog dmo);

	int deleteById(Long id);

	OperationLog getById(String id);

}
