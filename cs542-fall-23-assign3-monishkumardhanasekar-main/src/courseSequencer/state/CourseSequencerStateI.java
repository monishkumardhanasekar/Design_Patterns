package courseSequencer.state;

import courseSequencer.context.CourseOrganizer;
import courseSequencer.helper.Helper;
import courseSequencer.util.DataStructures;

public interface CourseSequencerStateI {
    public void registerCourseAttempt(String course,DataStructures dataObj,Helper helper,CourseSequencerStateI state,CourseOrganizer alternateContextClass);
    public void changeGroup(CourseSequencerStateI stateOne);
}
