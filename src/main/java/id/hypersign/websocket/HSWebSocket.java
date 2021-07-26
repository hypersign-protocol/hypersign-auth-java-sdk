package id.hypersign.websocket;



import id.hypersign.api.ConnectionStore;
import id.hypersign.api.utils.HttpClientUtil;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;


@ServerEndpoint(value = "/hsauth", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class HSWebSocket {
    private Session session;
    final String baseurl = "https://stage.hypermine.in/hsauth/hs/api/v2/newsession";
    private static HashMap<String, String> users = new HashMap<>();

    public HSWebSocket() {

    }

    @OnOpen
    public void onOpen(Session session) throws Exception {
        String input = "{\n" +
                "    \"baseUrl\": \"https://192.168.100.116:8443/spring-mvc/rest/auth\"\n" +
                "}";
        this.session = session;
        ConnectionStore.getInstance().addConnection(session);
        Message message = new Message();
        String qrCode = HttpClientUtil.authServerCall(input ,baseurl);
        message.setContent(qrCode);
        System.out.println("QRcode content is " + qrCode);
        session.getBasicRemote().sendObject(message);
    }

    @OnMessage
    public void onMessage(Session session, Message message) throws IOException, EncodeException {
        message.setFrom(users.get(session.getId()));
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {

        ConnectionStore.getInstance().deleteConnection(session.getId());
        Message message = new Message();
        message.setFrom(users.get(session.getId()));
        message.setContent("Disconnected!");

    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

   /* private static void broadcast(Message message) throws IOException, EncodeException {
        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote()
                            .sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

}
