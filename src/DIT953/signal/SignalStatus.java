package DIT953.signal;

/**
 * Created by Niklas on 2016-02-23.
 */
public enum SignalStatus {
    RED, TOGREEN, GREEN, TORED;

    private static SignalStatus[] vals = values();
    public SignalStatus next() {
        return vals[(this.ordinal()+1) % vals.length];
    }
}
