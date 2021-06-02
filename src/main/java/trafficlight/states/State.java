package trafficlight.states;

//TO DO implement a part of the pattern here DONE

public abstract class State extends Subject{

    public abstract State getNextState();

    public abstract String getColor();

    public String getSting(){
        return getColor();
    }
}