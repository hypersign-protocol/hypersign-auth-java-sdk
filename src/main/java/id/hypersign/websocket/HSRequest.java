package id.hypersign.websocket;

public class HSRequest {
    String baseURL;
    String jwtSecret;
    long jwtExpiryTime;
    String hsNodeUrl;
    String hsAppId;
    String hsAppSecret;

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getJwtSecret() {
        return jwtSecret;
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    public long getJwtExpiryTime() {
        return jwtExpiryTime;
    }

    public void setJwtExpiryTime(long jwtExpiryTime) {
        this.jwtExpiryTime = jwtExpiryTime;
    }

    public String getHsNodeUrl() {
        return hsNodeUrl;
    }

    public void setHsNodeUrl(String hsNodeUrl) {
        this.hsNodeUrl = hsNodeUrl;
    }

    public String getHsAppId() {
        return hsAppId;
    }

    public void setHsAppId(String hsAppId) {
        this.hsAppId = hsAppId;
    }

    public String getHsAppSecret() {
        return hsAppSecret;
    }

    public void setHsAppSecret(String hsAppSecret) {
        this.hsAppSecret = hsAppSecret;
    }
}
