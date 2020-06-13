package com.vc.web.model;

public class FireStoreTimestamp {
    private long seconds;
    private long nanoseconds;

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public long getNanoseconds() {
        return nanoseconds;
    }

    public void setNanoseconds(long nanoseconds) {
        this.nanoseconds = nanoseconds;
    }

    public FireStoreTimestamp(long seconds, long nanoseconds) {
        this.seconds = seconds;
        this.nanoseconds = nanoseconds;
    }
}
