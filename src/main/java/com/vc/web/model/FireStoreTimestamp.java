package com.vc.web.model;

public class FireStoreTimestamp {
    private long seconds;
    private long nanoseconds;

    public FireStoreTimestamp(long seconds, long nanoseconds) {
        this.seconds = seconds;
        this.nanoseconds = nanoseconds;
    }
}
