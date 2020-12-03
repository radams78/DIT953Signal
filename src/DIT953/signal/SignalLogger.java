package DIT953.signal;

/**
 * Created by Niklas on 2016-02-23.
 */
public class SignalLogger implements SignalObserver {

    public void actOnSignalChange(String name, SignalStatus newStatus) {

        System.out.println(name + " has new status: " + newStatus);
    }
}
