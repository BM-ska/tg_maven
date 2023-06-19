package org.example.z2;

public class CommitException extends RuntimeException {
    public CommitException(String errorMessage) {
        super(errorMessage);
    }
}