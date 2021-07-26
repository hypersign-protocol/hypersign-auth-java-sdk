package id.hypersign.api.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpClientUtil {
    private static Logger logger = LogManager.getLogger(HttpClientUtil.class);

    public static CloseableHttpClient getTrustedHttpsClient() {
        return getTrustedHttpsClient(null, 0);
    }

    public static CloseableHttpClient getTrustedHttpsClient(String httpsHost, int httpsPort) {
        try {
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            });

            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build(),new NoopHostnameVerifier());
            HttpClientBuilder clientBuilder = HttpClients.custom().setSSLSocketFactory(sslsf);

            if (httpsHost != null)
                clientBuilder.setProxy(new HttpHost(httpsHost, httpsPort));


            return clientBuilder.build();
        } catch (Exception e) {
            logger.error("Exception while getting TrustedHttpsClient object ");
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to perform Http call to the novus API and gets the response
     *
     * @return NovusResponse response object
     * @Param String jsonRequest
     * @Param String novusURL
     * @Param String jwtToken
     */
    public static String authServerCall(String jsonRequest, String authServerUrl) throws Exception {
        logger.debug("request to auth end point =>" + jsonRequest);
        System.out.println("request to auth end point =>" + jsonRequest);
        ObjectMapper mapper = new ObjectMapper();
        String mockresult ="";
        CloseableHttpClient client = HttpClientUtil.getTrustedHttpsClient();
        HttpPost httpPost = new HttpPost(authServerUrl);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Accept", "application/json");
        HttpEntity payLoad = new StringEntity(jsonRequest, "UTF-8");
        httpPost.setEntity(payLoad);

        CloseableHttpResponse response = client.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                mockresult = EntityUtils.toString(entity);
            }
        }
        logger.debug("Novus Response =>" + mockresult);
        return mockresult;
    }
}