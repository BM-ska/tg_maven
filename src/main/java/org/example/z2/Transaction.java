package org.example.z2;

public class Transaction {

    private final boolean canCommit = true;

    public void start() {
    }

    public void perform() {
    }

    public void rollback() {
    }

    public boolean isCanCommit() {
        return canCommit;
    }

    void commitTransaction() throws CommitException {
        if (isCanCommit()) {
            throw new CommitException("commit exeption");
        }
    }

    public void end() {
    }

}
