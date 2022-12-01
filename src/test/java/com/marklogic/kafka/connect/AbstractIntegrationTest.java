package com.marklogic.kafka.connect;

import com.marklogic.junit5.spring.AbstractSpringMarkLogicTest;
import com.marklogic.junit5.spring.SimpleTestConfig;
import com.marklogic.kafka.connect.sink.MarkLogicSinkConfig;

import java.util.HashMap;
import java.util.Map;

public class AbstractIntegrationTest extends AbstractSpringMarkLogicTest {

    /**
     * @return a config map containing connection values based on the test application configuration
     */
    public Map<String, String> newMarkLogicConfig(SimpleTestConfig testConfig) {
        Map<String, String> config = new HashMap<>();
        config.put(MarkLogicSinkConfig.CONNECTION_HOST, testConfig.getHost());
        config.put(MarkLogicSinkConfig.CONNECTION_PORT, testConfig.getRestPort() + "");
        config.put(MarkLogicSinkConfig.CONNECTION_SECURITY_CONTEXT_TYPE, "DIGEST");
        config.put(MarkLogicSinkConfig.CONNECTION_USERNAME, testConfig.getUsername());
        config.put(MarkLogicSinkConfig.CONNECTION_PASSWORD, testConfig.getPassword());
        return config;
    }
}