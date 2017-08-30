package com.ghawk1ns.perspective.request;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    private static final String _BASE = "https://commentanalyzer.googleapis.com/%s/%%s";

    private final String BASE_PATH_FORMAT;

    final AsyncHttpClient http;
    final ExecutorService transformExecutor;
    final ObjectMapper mapper;

    public Client(int executorThreadCount, String apiKey, String apiVersion) {
        transformExecutor = Executors.newFixedThreadPool(executorThreadCount);
        http = new DefaultAsyncHttpClient();
        mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setSerializationInclusion(Include.NON_DEFAULT);

        StringBuilder urlBuilder = new StringBuilder(String.format(_BASE, apiVersion));
        if (apiKey != null) {
            urlBuilder.append("?key=").append(apiKey);
        }
        BASE_PATH_FORMAT = urlBuilder.toString();
    }

    /**
     *
     * @return the path for a given endpoint: BASE_PATH / API_VERSION / endpoint
     */
    String getEndpoint(String endpoint) {
        return String.format(BASE_PATH_FORMAT, endpoint);
    }
}