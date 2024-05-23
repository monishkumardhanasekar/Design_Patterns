package studentCoursesMgmt.util;

import java.util.ArrayList;
import java.util.List;

class CourseImpl implements Course {
    private final String courseName;
    private final int capacity;
    private final int classTiming;
    private final List<Student> studentsEnrolled;

    public CourseImpl(String courseName, int capacity, int classTiming) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.classTiming = classTiming;
        this.studentsEnrolled = new ArrayList<>();
    }


    // Implement methods from the Course interface
    public String getCourseName() {
        return courseName;
    }


    public int getCapacity() {
        return capacity;
    }


    public int getClassTiming() {
        return classTiming;
    }


    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }


    public boolean enrollStudent(Student student) {
        if (studentsEnrolled.size() < capacity) {
            studentsEnrolled.add(student);
            student.assignCourse(courseName);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CourseImpl{" +
                "courseName='" + courseName + '\'' +
                ", capacity=" + capacity +
                ", classTiming=" + classTiming +
                ", studentsEnrolled=" + studentsEnrolled +
                '}';
    }
}