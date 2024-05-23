package studentCoursesMgmt.util;

import java.util.List;

interface Course {
    String getCourseName();

    int getCapacity();

    int getClassTiming();

    List<Student> getStudentsEnrolled();

    boolean enrollStudent(Student student);
}