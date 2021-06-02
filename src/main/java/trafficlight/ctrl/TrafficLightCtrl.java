package trafficlight.ctrl;

import trafficlight.gui.TrafficLight;
import trafficlight.gui.TrafficLightGui;
import trafficlight.states.State;

public class TrafficLightCtrl {

    private State greenState;

    private State redState;

    private State yellowState;

    private State currentState;

    private State previousState;

    private final TrafficLightGui gui;

    private boolean doRun = true;

    private static TrafficLightCtrl INSTANCE = null;

    public static TrafficLightCtrl getInstance() {
        if (INSTANCE == null){
            INSTANCE = new TrafficLightCtrl();
        }
        return INSTANCE;
    }

    private TrafficLightCtrl() {
        super();
        initStates();
        gui = new TrafficLightGui(this);
        gui.setVisible(true);
        //TO DO useful to update the current state DONE
        currentState.notifyObservers();
    }

    private void initStates() {
        greenState = new State() {
            @Override
            public State getNextState() {
                previousState = currentState;
                //TO DO useful to update the current state and the old one
                //DONE in nextState()
                return yellowState;
            }
            @Override
            public String getColor() {
                return "green";
            }
        };

        redState = new State() {
            @Override
            public State getNextState() {
                previousState = currentState;
                //TO DO useful to update the current state and the old one
                //DONE in nextState()
                return yellowState;
            }
            @Override
            public String getColor() {
                return "red";
            }
        };

        yellowState = new State() {
            @Override
            public State getNextState() {
                if (previousState.equals(greenState)) {
                    previousState = currentState;
                    //TO DO useful to update the current state and the old one
                    //DONE in nextState()
                    return redState;
                }else {
                    previousState = currentState;
                    //TO DO useful to update the current state and the old one
                    //DONE in nextState()
                    return greenState;
                }
            }
            @Override
            public String getColor() {
                return "yellow";
            }
        };
        currentState = greenState;
        previousState = yellowState;
    }

    public State getGreenState() {
        return greenState;
    }

    public State getRedState() {
        return redState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public void run()  {
        int intervall = 1500;
        while (doRun) {
            try {
                Thread.sleep(intervall);
                nextState();
            } catch (InterruptedException e) {
                gui.showErrorMessage(e);
            }
        }
        System.out.println("Stopped");
        System.exit(0);
    }

    public void nextState() {
        currentState = currentState.getNextState();
        previousState.notifyObservers();
        currentState.notifyObservers();
    }

    public void stop() {
        doRun = false;
    }
}