package studentCoursesMgmt.util;

import java.util.ArrayList;
import java.util.List;

class StudentImpl implements Student {
    private final int studentID;
    private final List<String> preferences;
    private final List<String> coursesAssigned;
    private final double satisfactionRating;

    public StudentImpl(int studentID, List<String> preferences) {
        this.studentID = studentID;
        this.preferences = preferences;
        this.coursesAssigned = new ArrayList<>();
        this.satisfactionRating = 0.0;
    }

    // Implement methods from the Student interface

    public int getStudentID() {
        return studentID;
    }


    public List<String> getPreferences() {
        return preferences;
    }


    public List<String> getCoursesAssigned() {
        return coursesAssigned;
    }


    public double getSatisfactionRating() {
        return satisfactionRating;
    }


    public void assignCourse(String course) {
        coursesAssigned.add(course);
    }

    @Override
    public String toString() {
        return "StudentImpl{" +
                "studentID=" + studentID +
                ", preferences=" + preferences +
                ", coursesAssigned=" + coursesAssigned +
                ", satisfactionRating=" + satisfactionRating +
                '}';
    }
}