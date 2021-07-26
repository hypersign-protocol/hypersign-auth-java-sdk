package id.hypersign.api;

import id.hypersign.api.utils.JWTManager;
import id.hypersign.credential.Credential;
import id.hypersign.websocket.HSRequest;
import id.hypersign.websocket.HSResponse;
import io.jsonwebtoken.Claims;

import javax.websocket.EncodeException;
import java.io.IOException;

public class HSMiddlewareService {

    private final ConnectionStore connectionStore;

    public HSMiddlewareService() {
        this.connectionStore = ConnectionStore.getInstance();
    }

    /**
     * Verifies JWT authorization token
     */
    public boolean authorize(String hsAuthorizationToken) {

        Claims claim = JWTManager.decodeJWT(hsAuthorizationToken,"");
        return false;
    }

    /**
     * 1- Verifies presentation
     * 2- Generates JWT auth token
     * 3- Notifies JWT Auth token to Websocket client(browser)
     * 4- Returns Userdata and JWT auth token
     */
    public boolean authenticate(String connectionId , String body) throws Exception {
        Credential credential = new Credential();
        String userData = credential.verifyPresentation(body);
        System.out.println("User data is: " + userData);
        String subject = "";
        String hsAuthorizationToken = "dsdsdsds";
        Connection connection = this.connectionStore.getConnection(connectionId);
        connection.connection.getBasicRemote().sendObject(new HSResponse(userData,hsAuthorizationToken));
        this.connectionStore.deleteConnection(connectionId);
        return true;
    }

}


