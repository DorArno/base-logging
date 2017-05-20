package com.einwin.mdm.logging.provider.es.service;

import com.einwin.mdm.logging.provider.es.document.BusinessLogDocument;
import com.einwin.mdm.logging.provider.es.document.BusinessLogEsQuery;
import com.einwin.mdm.logging.provider.es.document.PageResultBean;
import com.einwin.mdm.logging.provider.es.repository.BusinessLogRepository;

import org.apache.lucene.queryparser.surround.parser.ParseException;
import org.apache.lucene.queryparser.surround.parser.QueryParser;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * Created by YANG044 on 2017/4/19.
 */
@Service
public class BusinessEsService {
    @Autowired
    BusinessLogRepository businessLogRepository;

    public BusinessLogDocument save(BusinessLogDocument businessLogDocument) {
        return businessLogRepository.save(businessLogDocument);
    }

    public BusinessLogDocument FindOne(String id) {
        return businessLogRepository.findOne(id);
    }

    public int insert(BusinessLogDocument businessLogDocument){
        businessLogDocument.setId(UUID.randomUUID().toString());
        save(businessLogDocument);
        return 1;
    }
    public int update(BusinessLogDocument businessLogDocument){
        save(businessLogDocument);
        return 1;
    }

    public PageResultBean QueryPageList(BusinessLogEsQuery query) {
        PageResultBean result = new PageResultBean();
        Pageable page = null;
        if(query.getPageSize() != null && query.getPageNum() != null){
            page = new PageRequest((query.getPageNum()-1) * query.getPageSize(), query.getPageSize(), new Sort(Sort.Direction.DESC,"createdOn"));
        } else {
            page = new PageRequest(0, 10000, new Sort(Sort.Direction.DESC,"createdOn"));// elasticsearch最大返回数据1w条
        }

        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        System.out.println(query.getContent());

        //内容模糊匹配
        if(!StringUtils.isEmpty(query.getContent())){
                builder.must(QueryBuilders.matchQuery("content", query.getContent()));
        }

        //数据类型
        if(!StringUtils.isEmpty(query.getDataType())&&!"-1".equals(query.getDataType())){
            builder.must(QueryBuilders.termQuery("dataType",query.getDataType()));
        }

        //目标系统
        if(!StringUtils.isEmpty(query.getDestSystemId())&&!"-1".equals(query.getDestSystemId())){
            builder.must(QueryBuilders.termQuery("destSystemId",query.getDestSystemId()));
        }
        if(!StringUtils.isEmpty(query.getBeginDate())){
            builder.must(QueryBuilders.rangeQuery("createdOn").gte(query.getBeginDate()).lte(query.getEndDate()));
        }
       /* if(!StringUtils.isEmpty(query.getEndDate())){
            builder.must(QueryBuilders.rangeQuery("createdOn");
        }*/
        //日志类型
        if(!StringUtils.isEmpty(query.getLogType())&&!"-1".equals(query.getLogType())){
            builder.must(QueryBuilders.termQuery("logType",query.getLogType()));
        }
        //状态
        if(!StringUtils.isEmpty(query.getStatus())&&!"-1".equals(query.getStatus())){
            builder.must(QueryBuilders.termQuery("status",query.getStatus()));
        }

        Page<BusinessLogDocument> dd = businessLogRepository.search(builder, page);
        result.setList(dd.getContent());
        result.setTotalCount(dd.getTotalElements());
        //常规查不到数据， 尝试正则表达式在查询一次。
        if(dd.getTotalElements()==0){
            return QueryPageListByWildcard(query);
        }
        return result;
    }

    public PageResultBean QueryPageListByWildcard(BusinessLogEsQuery query) {
        PageResultBean result = new PageResultBean();
        Pageable page = null;
        if(query.getPageSize() != null && query.getPageNum() != null){
            page = new PageRequest((query.getPageNum()-1) * query.getPageSize(), query.getPageSize(), new Sort(Sort.Direction.DESC,"createdOn"));
        } else {
            page = new PageRequest(0, 100, new Sort(Sort.Direction.DESC,"createdOn"));// elasticsearch最大返回数据1w条
        }

        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        System.out.println(query.getContent());

        //内容模糊匹配
        if(!StringUtils.isEmpty(query.getContent())){
            builder.must(QueryBuilders.wildcardQuery("content", "*"+query.getContent()+"*"));
        }

        //数据类型
        if(!StringUtils.isEmpty(query.getDataType())&&!"-1".equals(query.getDataType())){
            builder.must(QueryBuilders.termQuery("dataType",query.getDataType()));
        }

        //目标系统
        if(!StringUtils.isEmpty(query.getDestSystemId())&&!"-1".equals(query.getDestSystemId())){
            builder.must(QueryBuilders.termQuery("destSystemId",query.getDestSystemId()));
        }
        if(!StringUtils.isEmpty(query.getBeginDate())){
            builder.must(QueryBuilders.rangeQuery("createdOn").gte(query.getBeginDate()).lte(query.getEndDate()));
        }

        //日志类型
        if(!StringUtils.isEmpty(query.getLogType())&&!"-1".equals(query.getLogType())){
            builder.must(QueryBuilders.termQuery("logType",query.getLogType()));
        }
        //状态
        if(!StringUtils.isEmpty(query.getStatus())&&!"-1".equals(query.getStatus())){
            builder.must(QueryBuilders.termQuery("status",query.getStatus()));
        }

        Page<BusinessLogDocument> dd = businessLogRepository.search(builder, page);
        result.setList(dd.getContent());
        result.setTotalCount(dd.getTotalElements());
        return result;
    }
}
