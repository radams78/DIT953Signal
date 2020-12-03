package DIT953.signal;

public interface SignalObserver {
    void actOnSignalChange(String name, SignalStatus newStatus);
}
