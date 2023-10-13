package auxClasses;

import javafx.beans.property.*;
public class ListItem {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty state = new SimpleStringProperty();
    private final StringProperty clientInfo = new SimpleStringProperty();

    public ListItem(int id, String state, String clientInfo) {
        this.id.set(id);
        this.state.set(state);
        this.clientInfo.set(clientInfo);
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "id=" + id +
                ", state=" + state +
                ", clientInfo=" + clientInfo +
                '}';
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty stateProperty() {
        return state;
    }

    public StringProperty clientInfoProperty() {
        return clientInfo;
    }

    // Getters and setters for id, state, and clientInfo
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getState() {
        return state.get();
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getClientInfo() {
        return clientInfo.get();
    }

    public void setClientInfo(String clientInfo) {
        this.clientInfo.set(clientInfo);
    }
}