import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Main class.
 */
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String teamName = input.next();

        try {
            URL url = new URL("https://api.vexdb.io/v1/get_rankings?team=UHRC0");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            String response = IOUtils.toString(connection.getInputStream(), Charset.defaultCharset());

            // Parse json from request
            JSONObject json = new JSONObject(response);
            JSONArray stats = json.getJSONArray("result");

            System.out.println(stats.getJSONObject(0));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
