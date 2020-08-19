package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.cassandra.entity.ElasticSearchEntity;
import com.albot.contentorchestrationservice.cassandra.repository.ElasticSearchRepository;
import com.albot.contentorchestrationservice.util.Util;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class ElasticSearchUtility {

    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchUtility.class);
    private static RestHighLevelClient client;
    private static ElasticSearchRepository elasticSearchRepository;
    private static int maxRetryCount = 3;
    private static int retryCount = 0;

    @Autowired
    public ElasticSearchUtility(RestHighLevelClient client, ElasticSearchRepository elasticSearchRepository) {
        this.client = client;
        this.elasticSearchRepository = elasticSearchRepository;
    }

    public static void restClient(String indexName, String indexId, String requestData) {
        retryCount = retryCount + 1;
        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("Started to elastic search request with indexName {}", indexName);
                IndexRequest indexRequest = new IndexRequest(indexName);
                indexRequest.id(String.valueOf(indexId));
                try {
                    indexRequest.source(requestData, XContentType.JSON);
                    int statusCode = client.index(indexRequest, RequestOptions.DEFAULT).status().getStatus();
                    if ((HttpStatus.OK.value() == statusCode) ||
                            (HttpStatus.CREATED.value() == statusCode)) {
                        logger.info("Got the elastic search response as a {} with indexName {} ", statusCode, indexName);
                    } else {
                        logger.error("Failed to processing elastic search request as {} with indexName {}", statusCode, indexName);
                    }
                } catch (IOException e) {
                    logger.info("Started to insert failed elastic search request with indexName {} into Cassandra database",indexName);
                    if (retryCount < maxRetryCount) {
                        logger.info("Started for retrying failed elastic search request with indexName {} and retryCount {}", indexName ,retryCount);
                        restClient(indexName, indexId, requestData);
                    } else {
                        logger.info("Failed  elastic search request with indexName  after retry also then consider as failed request", indexName);
                        ElasticSearchEntity elasticSearchEntityObj = new ElasticSearchEntity();
                        elasticSearchEntityObj.setIndexName(indexName);
                        elasticSearchEntityObj.setReqData(requestData);
                        elasticSearchEntityObj.setIndexId(indexId);
                        elasticSearchEntityObj.setStatus(Util.Status.FAILED.name());
                        ElasticSearchEntity elasticSearchEntity =
                                elasticSearchRepository.insert(elasticSearchEntityObj);
                        if (!Objects.isNull(elasticSearchEntity)) {
                            logger.info("Successfully inserted failed elastic search request with indexName {} into Cassandra database", indexName);
                        } else {
                            logger.error("Failed to insert failed elastic search request with indexName {} into Cassandra database", indexName);
                        }
                        retryCount = 0;
                    }
                }
            }
        }).start();
    }
}
