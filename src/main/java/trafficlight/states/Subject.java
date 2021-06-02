package trafficlight.states;

import trafficlight.gui.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer o) {
        observerList.add(o);
    }

    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    public void notifyObservers() {
        observerList.forEach(Observer::update);
    }
}
