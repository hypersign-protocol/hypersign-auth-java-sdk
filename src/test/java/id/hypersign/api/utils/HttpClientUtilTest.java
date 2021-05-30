package id.hypersign.api.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpClientUtilTest {


    public static void main(String[] args) throws Exception {
        final String baseurl = "https://reqres.in/api/users";
        String input = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        String qrCode = HttpClientUtil.authServerCall(input ,baseurl);
        System.out.println("This is fun");
    }

}