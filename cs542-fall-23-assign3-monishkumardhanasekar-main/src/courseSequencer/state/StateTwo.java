package courseSequencer.state;

import courseSequencer.context.CourseOrganizer;
import courseSequencer.helper.Helper;
import courseSequencer.util.DataStructures;

public class StateTwo implements CourseSequencerStateI{
    CourseOrganizer courseSequencer;
	public String toString(){
        return "State Two";
    }
	public void registerCourseAttempt(String course, DataStructures dataObj, Helper helper, CourseSequencerStateI state, CourseOrganizer alternateContextClass){
        helper.assistCourseRegister(course, dataObj, state, alternateContextClass); 
    }
	
	public void changeGroup(CourseSequencerStateI state){
        courseSequencer.changeGroup(state);
    }
	
    public StateTwo(CourseOrganizer courseSequencerIn){
        courseSequencer = courseSequencerIn;
    }
}
