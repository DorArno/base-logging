package com.einwin.mdm.logging.provider.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.einwin.mdm.logging.api.model.BusinessLog;

@Mapper
public interface BusinessLogMapper {

    List<BusinessLog> queryPageList(Map<String, Object> params);
    
    int insert(BusinessLog dmo);

    int update(BusinessLog dmo);
    
    int updateBySysCodeData(BusinessLog dmo);

    int deleteById(String id);
    
    int updateStatusById(@Param("id")String id,@Param("status")String Status);

    BusinessLog getById(String id);
    
}
