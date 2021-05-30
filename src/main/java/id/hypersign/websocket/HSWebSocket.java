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
    final String baseurl = "https://reqres.in/api/users";
    private static HashMap<String, String> users = new HashMap<>();

    public HSWebSocket() {

    }

    @OnOpen
    public void onOpen(Session session) throws Exception {
        String input = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        this.session = session;
        ConnectionStore.getInstance().addConnection(session);
        Message message = new Message();
        message.setContent("Connected!");
        //Make a rest call to /newSession api by passing base url as a request body and get QR data in response.
        //Set QR data to message content
        String qrCode = HttpClientUtil.authServerCall(input ,baseurl);
        message.setContent(qrCode);
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
