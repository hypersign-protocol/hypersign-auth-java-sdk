package id.hypersign.websocket;

import com.google.gson.Gson;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class QRDataEncoder implements Encoder.Text<QRData>{
    private static Gson gson = new Gson();
    @Override
    public String encode(QRData object) throws EncodeException {
        String json = gson.toJson(object);
        return json;
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
