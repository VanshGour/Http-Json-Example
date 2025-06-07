import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpJsonExample {

    public static void main(String[] args) {
        String apiUrl = "https://api.agify.io/?name=john"; // Sample public API

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        try {
            // Send request and get response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print raw response
            System.out.println("Raw JSON Response:");
            System.out.println(response.body());

            // Parse JSON response
            JSONObject jsonObject = new JSONObject();

            // Extract and print data
            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            int count = jsonObject.getInt("count");

            System.out.println("\nParsed Data:");
            System.out.println("Name : " + name);
            System.out.println("Predicted Age : " + age);
            System.out.println("Count : " + count);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error occurred while making HTTP request.");
            e.printStackTrace();
        }
    }
}
