package java_client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ChatbotClient {
    public static void main(String[] args) {
        try {
            String apiUrl = "http://127.0.0.1:8000/chat";
            String userMessage = "Hello";

            JSONObject jsonInput = new JSONObject();
            jsonInput.put("message", userMessage);

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInput.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            System.out.println("Chatbot response: " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
