package trafficlight.ctrl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trafficlight.states.State;

import static org.junit.jupiter.api.Assertions.*;

public class TrafficLightCtrlTest {

    @Test
    @DisplayName("Check next state after green")
    public void checkNextState_afterGreen(){
        TrafficLightCtrl tlc = TrafficLightCtrl.getInstance();
        tlc.setStates(tlc.getGreenState(), tlc.getYellowState());
        assertEquals(tlc.getCurrentState().getNextState(), tlc.getYellowState());
    }

    @Test
    @DisplayName("Check next state after yellow - previous green")
    public void checkNextState_afterYellowPrevGreen(){
        TrafficLightCtrl tlc = TrafficLightCtrl.getInstance();
        tlc.setStates(tlc.getYellowState(), tlc.getGreenState());
        assertEquals(tlc.getCurrentState().getNextState(), tlc.getRedState());
    }

    @Test
    @DisplayName("Check next state after yellow - previous red")
    public void checkNextState_afterYellowPrevRed(){
        TrafficLightCtrl tlc = TrafficLightCtrl.getInstance();
        tlc.setStates(tlc.getYellowState(), tlc.getRedState());
        assertEquals(tlc.getCurrentState().getNextState(), tlc.getGreenState());
    }

    @Test
    @DisplayName("Check next state after red")
    public void checkNextState_afterRed(){
        TrafficLightCtrl tlc = TrafficLightCtrl.getInstance();
        tlc.setStates(tlc.getRedState(), tlc.getYellowState());
        assertEquals(tlc.getCurrentState().getNextState(), tlc.getYellowState());
    }

    @Test
    @DisplayName("check singleton")
    public void checkSingleton(){
        TrafficLightCtrl tlc1 = TrafficLightCtrl.getInstance();
        TrafficLightCtrl tlc2 = TrafficLightCtrl.getInstance();
        assertEquals(tlc1, tlc2);
    }



    @Test
    @DisplayName("setState invalid - current green - prev green")
    public void checkSetSate_green_green(){
        TrafficLightCtrl tlc = TrafficLightCtrl.getInstance();
        State oldCurrent = tlc.getCurrentState();
        State oldPrevious = tlc.getPreviousState();
        tlc.setStates(tlc.getGreenState(), tlc.getGreenState());
        assertEquals(tlc.getCurrentState(), oldCurrent);
        assertEquals(tlc.getPreviousState(), oldPrevious);
    }

    @Test
    @DisplayName("setState valid - current green - prev yellow")
    public void checkSetSate_green_yellow(){
        TrafficLightCtrl tlc = TrafficLightCtrl.getInstance();
        tlc.setStates(tlc.getGreenState(), tlc.getYellowState());
        assertEquals(tlc.getCurrentState(), tlc.getGreenState());
        assertEquals(tlc.getPreviousState(), tlc.getYellowState());
    }

    @Test
    @DisplayName("setState invalid - current green - prev red")
    public void checkSetSate_green_red(){
        TrafficLightCtrl tlc = TrafficLightCtrl.getInstance();
        State oldCurrent = tlc.getCurrentState();
        State oldPrevious = tlc.getPreviousState();
        tlc.setStates(tlc.getGreenState(), tlc.getRedState());
        assertEquals(tlc.getCurrentState(), oldCurrent);
        assertEquals(tlc.getPreviousState(), oldPrevious);
    }

    @Test
    @DisplayName("setState valid - current yellow - prev green")
    public void checkSetSate_yellow_green(){
        TrafficLightCtrl tlc = TrafficLightCtrl.getInstance();
        tlc.setStates(tlc.getYellowState(), tlc.getGreenState());
        assertEquals(tlc.getCurrentState(), tlc.getYellowState());
        assertEquals(tlc.getPreviousState(), tlc.getGreenState());
    }

    @Test
    @DisplayName("setState invalid - current yellow - prev yellow")
    public void checkSetSate_yellow_yellow(){
        TrafficLightCtrl tlc = TrafficLightCtrl.getInstance();
        State oldCurrent = tlc.getCurrentState();
        State oldPrevious = tlc.getPreviousState();
        tlc.setStates(tlc.getYellowState(), tlc.getYellowState());
        assertEquals(tlc.getCurrentState(), oldCurrent);
        assertEquals(tlc.getPreviousState(), oldPrevious);
    }

    @Test
    @DisplayName("setState valid - current yellow - prev red")
    public void checkSetSate_yellow_red(){
        TrafficLightCtrl tlc = TrafficLightCtrl.getInstance();
        tlc.setStates(tlc.getYellowState(), tlc.getRedState());
        assertEquals(tlc.getCurrentState(), tlc.getYellowState());
        assertEquals(tlc.getPreviousState(), tlc.getRedState());
    }


    @Test
    @DisplayName("setState invalid - current red - prev green")
    public void checkSetSate_red_green(){
        TrafficLightCtrl tlc = TrafficLightCtrl.getInstance();
        State oldCurrent = tlc.getCurrentState();
        State oldPrevious = tlc.getPreviousState();
        tlc.setStates(tlc.getRedState(), tlc.getGreenState());
        assertEquals(tlc.getCurrentState(), oldCurrent);
        assertEquals(tlc.getPreviousState(), oldPrevious);
    }

    @Test
    @DisplayName("setState valid - current red - prev yellow")
    public void checkSetSate_red_yellow(){
        TrafficLightCtrl tlc = TrafficLightCtrl.getInstance();
        tlc.setStates(tlc.getRedState(), tlc.getYellowState());
        assertEquals(tlc.getCurrentState(), tlc.getRedState());
        assertEquals(tlc.getPreviousState(), tlc.getYellowState());
    }

    @Test
    @DisplayName("setState invalid - current red - prev red")
    public void checkSetSate_red_red(){
        TrafficLightCtrl tlc = TrafficLightCtrl.getInstance();
        State oldCurrent = tlc.getCurrentState();
        State oldPrevious = tlc.getPreviousState();
        tlc.setStates(tlc.getRedState(), tlc.getRedState());
        assertEquals(tlc.getCurrentState(), oldCurrent);
        assertEquals(tlc.getPreviousState(), oldPrevious);
    }

}
