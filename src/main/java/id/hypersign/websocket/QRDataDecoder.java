package id.hypersign.websocket;

import com.google.gson.Gson;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class QRDataDecoder implements Decoder.Text<QRData>  {
    private static Gson gson = new Gson();
    @Override
    public QRData decode(String s) throws DecodeException {
        QRData message = gson.fromJson(s, QRData.class);
        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return false;
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
