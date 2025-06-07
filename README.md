# Http-Json-Example

This Java program demonstrates how to make an HTTP GET request to a public API using the built-in java.net.http package introduced in Java 11. It fetches a JSON response, processes the returned data, and extracts specific fields for display. The primary goal is to show how Java can interact with web services and parse JSON content, even without relying on external libraries.

The API used in this example is Agify.io, a simple and publicly accessible service that predicts the age of a person based on their name. When a request is made with a query like https://api.agify.io/?name=john, the API responds with a JSON object containing three pieces of data: the name, the predicted age, and the number of data samples (count) used to make the prediction. The response looks something like this:

The program begins by constructing an HTTP client using HttpClient.newHttpClient(), which creates a reusable HTTP client object. Then it builds an HTTP GET request using HttpRequest.newBuilder() with the given URI (Uniform Resource Identifier). The GET method specifies that the client wants to retrieve data from the server.

Once the request is built, the program sends it using client.send(), which returns an HttpResponse<String>. The body of this response is a raw JSON string, which is first printed to the console for visibility.

Instead of using an external library like org.json or Google's Gson (which would normally be ideal for JSON parsing), the program manually extracts values from the raw JSON string using basic string operations. It does so through a helper method that finds values based on the key names. Although this approach is not robust for complex or nested JSON, it is sufficient for simple, flat JSON structures like the one returned by Agify.io.

After extracting the fields "name", "age", and "count" from the JSON string, the program prints each of them with descriptive labels. For instance, it shows the predicted age for the input name and how many data samples were used for the estimate.

This implementation is useful in educational contexts or for quick-and-dirty scripts where you don’t want to introduce library dependencies. However, for production-grade applications or APIs with more complex JSON structures, it is highly recommended to use JSON parsing libraries such as Gson, Jackson, or org.json for safety, maintainability, and clarity.

Overall, this program serves as a practical example of how Java can interface with web APIs, handle network I/O, and process JSON data using only standard libraries. It’s especially valuable for Java developers looking to build web-connected applications or microservices.

