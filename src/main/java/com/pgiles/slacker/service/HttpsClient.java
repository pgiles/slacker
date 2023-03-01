package com.pgiles.slacker.service;

import org.springframework.stereotype.Service;

import java.net.URL;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

@Service
public class HttpsClient {

    public String get(String endpoint) {
        URL url;
        try {
            url = new URL(endpoint);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            return getContent(connection);
        } catch (IOException urlException) {
            urlException.printStackTrace();
        }
        return "";
    }

    private String getContent(HttpsURLConnection connection) {
        StringBuilder content = new StringBuilder();
        if (connection != null) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String input;
                while ((input = br.readLine()) != null) {
                    content.append(input);
                }
                br.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return content.toString();
    }


}
