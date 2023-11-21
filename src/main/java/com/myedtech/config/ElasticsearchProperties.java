package com.myedtech.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("elasticsearch")
public class ElasticsearchProperties {

    private String host = "";

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}