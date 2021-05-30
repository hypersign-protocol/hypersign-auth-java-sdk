package id.hypersign.websocket;

import com.google.gson.Gson;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class HSRequestDecoder implements Decoder.Text<HSRequest> {

    private static Gson gson = new Gson();

    @Override
    public HSRequest decode(String s) throws DecodeException {
        HSRequest message = gson.fromJson(s, HSRequest.class);
        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    @Override
    public void destroy() {
        // Close resources
    }
}
