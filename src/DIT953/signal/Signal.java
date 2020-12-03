package DIT953.signal;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Niklas on 2016-02-22.
 */
public class Signal implements Runnable {

    private enum Speed {
        SUPERSLOW, SLOW, NORMAL, FAST, SUPERFAST;

        private static Speed[] vals = values();
        public Speed up() { return vals[Math.min(this.ordinal()+1, vals.length-1)]; }
        public Speed down() { return vals[Math.max(this.ordinal()-1, 0)]; }
    }
    private String name;
    private final Collection<SignalObserver> views;

    private SignalStatus status = SignalStatus.RED;
    private Speed speed = Speed.NORMAL;
    public Signal(String name) {
        this.name = name;
        this.views = new ArrayList<>();
    }

    public void speedUp(){
        speed = speed.up();
    }
    public void slowDown(){
        speed = speed.down();
    }

    public void run(){
        while (speed != null) {
            try {
                longWait();
                nextStatus();
                shortWait();
                nextStatus();
            } catch (InterruptedException e) {
                speed = null;
            }
        }
    }
    private void longWait() throws InterruptedException {
        Thread.sleep(4000/(speed.ordinal()+1));
    }
    private void shortWait() throws InterruptedException {
        Thread.sleep(400);
    }
    private void nextStatus(){
        status = status.next();
        for (SignalObserver view : views) {
            view.actOnSignalChange(name, status);
        }
    }

    public void addObserver(SignalObserver observer) {
        views.add(observer);
    }
    
    public String toString(){
        return name;
    }













  /*
    private List<SignalObserver> observers = new ArrayList<>();
    public void addObserver(SignalObserver observer){
        observers.add(observer);
    }
    public void removeObserver(SignalObserver observer){
        observers.remove(observer);
    }
    private void multicastStatusChange(SignalStatus newStatus){
        for (SignalObserver observer : observers){
            observer.actOnSignalChange(name, newStatus);
        }
    }

*/

}
