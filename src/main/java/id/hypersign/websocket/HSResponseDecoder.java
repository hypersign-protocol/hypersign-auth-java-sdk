package id.hypersign.websocket;

import com.google.gson.Gson;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class HSResponseDecoder implements Decoder.Text<HSResponse> {

    private static Gson gson = new Gson();

    @Override
    public HSResponse decode(String s) throws DecodeException {
        HSResponse message = gson.fromJson(s, HSResponse.class);
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

