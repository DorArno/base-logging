package com.einwin.mdm.logging.provider.es.repository;

import com.einwin.mdm.logging.provider.es.document.BusinessLogDocument;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * Created by YANG044 on 2017/4/19.
 */
@Component
public interface BusinessLogRepository extends ElasticsearchRepository<BusinessLogDocument, String> {
}
