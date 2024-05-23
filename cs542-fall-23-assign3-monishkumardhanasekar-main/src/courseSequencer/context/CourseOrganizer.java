package courseSequencer.context;

import courseSequencer.helper.Helper;
import courseSequencer.state.CourseSequencerStateI;
import courseSequencer.state.StateFive;
import courseSequencer.state.StateFour;
import courseSequencer.state.StateOne;
import courseSequencer.state.StateThree;
import courseSequencer.state.StateTwo;
import courseSequencer.util.DataStructures;

public class CourseOrganizer{
    public CourseSequencerStateI stateOne;
    public CourseSequencerStateI stateTwo;
    public CourseSequencerStateI stateThree;
    public CourseSequencerStateI stateFour;
    public CourseSequencerStateI stateFive;

    public Helper helper;
    
    public CourseSequencerStateI state;

    public CourseOrganizer(){
        stateOne = new StateOne(this);
        stateTwo = new StateTwo(this);
        stateThree = new StateThree(this);
        stateThree = new StateFour(this);
        stateFive = new StateFive(this);
        state = stateOne;
        helper = new Helper();
    }

    
    public void registerCourseAttempt(String course, DataStructures dataObj, CourseOrganizer alternateContextClass){
        try{
            state.registerCourseAttempt(course,dataObj,helper,state,alternateContextClass);
        }
        catch(Exception ex){
            ex.printStackTrace();

        }
    }

    public void changeGroup(CourseSequencerStateI stateI){
        this.state=stateI;
    }

    public CourseSequencerStateI getStateOne(){
        return stateOne;
    }
    public CourseSequencerStateI getStateTwo(){
        return stateTwo;
    }
    public CourseSequencerStateI getStateThree(){
        return stateThree;
    }
    public CourseSequencerStateI getStateFour(){
        return stateFour;
    }
    public CourseSequencerStateI getStateFive(){
        return stateFive;
    }

}
