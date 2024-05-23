package courseSequencer.state;

import courseSequencer.context.CourseOrganizer;
import courseSequencer.helper.Helper;
import courseSequencer.util.DataStructures;

public class StateFive implements CourseSequencerStateI{
    CourseOrganizer courseSequencer;
public String toString(){
        return "State Five";
    }
	public void registerCourseAttempt(String course, DataStructures dataObj, Helper helper, CourseSequencerStateI state, CourseOrganizer alternateContextClass){
        helper.assistCourseRegister(course, dataObj, state, alternateContextClass); 
    }
	
	public void changeGroup(CourseSequencerStateI state){
        courseSequencer.changeGroup(state);
    }
	
    public StateFive(CourseOrganizer courseSequencerIn){
        courseSequencer = courseSequencerIn;
    }
}
