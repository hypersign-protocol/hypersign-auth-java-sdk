package id.hypersign.api;


import id.hypersign.websocket.HSWebSocket;

import javax.websocket.EncodeException;
import java.io.IOException;

public class HypersignAuth {
    HSMiddlewareService hsMiddlewareService;

    public HypersignAuth() {
        hsMiddlewareService = new HSMiddlewareService();

    }

    public void authorize(){
        hsMiddlewareService.authorize("dsada");
    }

    public void authenticate() throws IOException, EncodeException {
     hsMiddlewareService.authenticate(null ,"dasdasasd");
    }

    public void extractToken(){
    }

}
