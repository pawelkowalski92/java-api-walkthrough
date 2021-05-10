package pl.edu.utp.io;

import pl.edu.utp.utils.MeasureUtils;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class IOExample {

    public static void main(String[] args) {
        String testPage = "https://google.com";
        String testPageContent = MeasureUtils.measureAndGet(() -> safeGetDataFromWebPage(testPage),
                duration -> System.out.println("Loading took: " + duration));
        System.out.println(testPageContent);

        MeasureUtils.measureAndGet(() -> safeSaveDataToFile("testPageContent.html", testPageContent),
                duration -> System.out.println("Saving took: " + duration));

        String lotsOfData = MeasureUtils.generateLotsOfData(500 * 1024 * 1024);
        MeasureUtils.measureAndGet(() -> safeSaveDataToFile("lotsOfData.txt", lotsOfData),
                duration -> System.out.println("Saving a lot of data took: " + duration));
    }

    public static String safeGetDataFromWebPage(String webPage) {
        try {
            return getDataFromWebPage(webPage);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getDataFromWebPage(String webPage) throws Exception {
        URL url = new URL(webPage);
        URLConnection connection = url.openConnection();
        try (InputStream in = connection.getInputStream()) {
            byte[] bytes = in.readAllBytes();
            return new String(bytes);
        }
    }

    public static void safeSaveDataToFile(String fileName, String data) {
        try {
            saveDataToFile(fileName, data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void saveDataToFile(String fileName, String data) throws IOException {
        File file = new File(fileName);
        byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
        try (OutputStream out = new FileOutputStream(file)) {
            out.write(bytes);
        }
    }

    /*
    Just an example of modern way to access web based resources
     */
    public static String getDataFromWebPageUsingHttpClient(String webPage) throws Exception {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
        HttpRequest req = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(webPage))
                .build();
        return client.send(req, HttpResponse.BodyHandlers.ofString())
                .body();
    }


}
