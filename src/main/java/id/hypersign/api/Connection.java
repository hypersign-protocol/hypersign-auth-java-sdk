package id.hypersign.api;

import javax.websocket.Session;
import java.util.UUID;

public class Connection {

    public String connectionId;
    public Session connection;


    public Connection(Session connection) {
        this.connectionId = connection.getId();
        this.connection = connection;
    }

}
