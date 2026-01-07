package com.harshit.demo.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class EmailService {

    @Value("${brevo.api.key}")
    private String apiKey;

    @Value("${brevo.sender.email}")
    private String senderEmail;

    public void sendEmail(String name, String email, String phone, String purpose, String message) {

        try {
            URL url = new URL("https://api.brevo.com/v3/smtp/email");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("api-key", apiKey);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = "{"
                    + "\"sender\":{\"email\":\"" + senderEmail + "\"},"
                    + "\"to\":[{\"email\":\"harshit07code@gmail.com\"}],"
                    + "\"subject\":\"Portfolio Contact Message\","
                    + "\"htmlContent\":\""
                    + "<p><b>Name:</b> " + name + "</p>"
                    + "<p><b>Email:</b> " + email + "</p>"
                    + "<p><b>Phone:</b> " + phone + "</p>"
                    + "<p><b>Purpose:</b> " + purpose + "</p>"
                    + "<p><b>Message:</b> " + message + "</p>"
                    + "\""
                    + "}";

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes());
            }

            int code = conn.getResponseCode();
            System.out.println("Brevo HTTP Code: " + code);

            InputStream is = (code >= 200 && code < 300)
                    ? conn.getInputStream()
                    : conn.getErrorStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
