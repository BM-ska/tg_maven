package org.example.z2;

public class Session {

    private final boolean canOpen = true;

    public boolean isCanOpen() {
        return canOpen;
    }

    public void open() throws SessionOpenException {
        if (!isCanOpen()) {
            throw new SessionOpenException("error opening new session");
        }
    }

    public void close() {
    }

}
