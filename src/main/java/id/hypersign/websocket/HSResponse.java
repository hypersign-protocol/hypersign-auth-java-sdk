package id.hypersign.websocket;

public class HSResponse {
    public Object userData;
    public String hsAuthorizationToken;

    public HSResponse(Object userData, String hsAuthorizationToken) {
        this.userData = userData;
        this.hsAuthorizationToken = hsAuthorizationToken;
    }
}
