package id.hypersign.api;

import javax.websocket.Session;
import java.util.HashMap;
import java.util.Set;

public class ConnectionStore {

    private static ConnectionStore connectionStore = null;
    HashMap<String, Connection> connectionList;

    private ConnectionStore() {
        this.connectionList = new HashMap<>();
    }

    public String addConnection(Session connection) {
        Connection newConn = new Connection(connection);
        connectionList.put(newConn.connectionId, newConn);
        return newConn.connectionId;
    }

    public Connection getConnection(String connectionId) {
        if (!connectionList.containsKey(connectionId)) return null;
        return connectionList.get(connectionId);
    }

    public String deleteConnection(String connectionId) {
        if (!connectionList.containsKey(connectionId)) return null;
        connectionList.remove(connectionId);
        return connectionId;
    }

    public Set<String> getConnectionIds() {
        return connectionList.keySet();
    }

    public static ConnectionStore getInstance()
    {
        if (connectionStore == null)
            connectionStore = new ConnectionStore();

        return connectionStore;
    }

}
