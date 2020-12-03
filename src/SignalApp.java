import DIT953.signal.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Niklas on 2016-02-23.
 */
public class SignalApp {

    public static void main(String[] args){
        SignalObserver view = new SignalView();
        SignalObserver logger = new SignalLogger();
        Signal signal1 = new Signal("Signal 1");
        signal1.addObserver(view);
        Signal signal2 = new Signal("Signal 2");
        signal2.addObserver(view);
        signal2.addObserver(logger);
        new SpeedController(signal1);
        new Thread(signal1).start();
        new Thread(signal2).start();
    }
}
