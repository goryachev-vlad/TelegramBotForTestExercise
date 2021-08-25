package Massage;

import Model.City;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class ApiMassage {
    public static String getMassage(String message, City city) throws IOException {
        URL url = new URL("http://localhost:8082/api/city?name="+message);
        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }
        JSONObject object = new JSONObject(result);
        city.setMassage(object.getString("massage"));
        return city.getMassage();
    }

}

