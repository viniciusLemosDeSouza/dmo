package metodos_Genericos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;import com.google.gson.Gson;


import java.io.IOException;

public class geradorUsuario {

    private static final String API_URL = "https://randomuser.me/api/?nat=us";

    public static JsonObject fetchRandomUser() throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(API_URL);
            HttpResponse response = client.execute(request);
            String json = EntityUtils.toString(response.getEntity());

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            return jsonObject;
        }
    }
}