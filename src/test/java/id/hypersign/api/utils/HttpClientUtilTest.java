package id.hypersign.api.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpClientUtilTest {


    public static void main(String[] args) throws Exception {
        final String baseurl = "https://stage.hypermine.in/hsauth/hs/api/v2/newsession";
        String input = "{\n" +
                "    \"baseUrl\": \"http://172.18.208.1:8080/spring-mvc/rest/app/api/v2/auth/\"\n" +
                "}";
        String qrCode = HttpClientUtil.authServerCall(input ,baseurl);
        System.out.println("This is fun");
    }

}