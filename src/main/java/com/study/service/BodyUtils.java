package com.study.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BodyUtils {

    public Map<String,Object> getBody(InputStream inputStream) throws IOException {

        String body = null;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;

        try {
            if (inputStream != null) {
                br = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = br.read(charBuffer)) > 0) {
                    sb.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            throw e;
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw e;
                }
            }
        }
        body = sb.toString();
        System.out.println("body"+body);

        ObjectMapper objectMapper = new ObjectMapper();
        //Map<String, Object> map = objectMapper.readValue(body, Map.class);
        Map<String, Object> map = new HashMap<>();

        return map;
    }
}
