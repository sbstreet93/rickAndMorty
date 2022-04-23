package com.mobdev.test.config.feign;

import com.mobdev.test.config.feign.decoder.FeignErrorDecoder;
import com.squareup.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;

public class BaseConfig {
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public FeignErrorDecoder decoder() {
        return new FeignErrorDecoder();
    }
}
