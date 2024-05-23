package studentCoursesMgmt.util;

import java.util.List;

public interface Student {
    int getStudentID();

    List<String> getPreferences();

    List<String> getCoursesAssigned();

    double getSatisfactionRating();

    void assignCourse(String course);
}
