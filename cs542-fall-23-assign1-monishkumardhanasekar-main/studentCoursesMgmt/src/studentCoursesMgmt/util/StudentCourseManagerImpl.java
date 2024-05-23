package studentCoursesMgmt.util;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class StudentCourseManagerImpl implements StudentCourseManager {

    public static final int MAX_SATISFACTION_POINT = 9;
    CourseAssignmentResult result = new CourseAssignmentResult();

    /**
     * Assigns courses to students based on their preferences and the availability and capacity of the courses.
     * Conflicts and capacity issues are logged to the provided FileWriter objects.
     *
     * @param courseInfoReader BufferedReader for reading course information.
     * @param coursePreferenceReader BufferedReader for reading students' course preferences.
     * @param conflictFileWriter FileWriter for writing any conflicts encountered during course assignment.
     * @param errorLogWriter FileWriter for logging any errors or capacity issues encountered.
     * @return CourseAssignmentResult object containing the assignment results and satisfaction ratings.
     *
     * @throws RuntimeException if an IOException occurs while writing to the conflict or error log files.
     *
     * @see CourseInfoFileReader
     * @see CoursePrefsFileReader
     * @see Student
     * @see Course
     */
    @Override
    public CourseAssignmentResult getCourseAssignment(BufferedReader courseInfoReader, BufferedReader coursePreferenceReader, FileWriter conflictFileWriter, FileWriter errorLogWriter)  {
        CourseInfoFileReader courseInfoFileReader = new CourseInfoFileReader();
        List<Course> courseList = courseInfoFileReader.getCourseList(courseInfoReader);
        Map<String, Integer> classTimingMap = getClassTimingMap(courseList);
        CoursePrefsFileReader coursePrefsFileReader = new CoursePrefsFileReader();
        Map<Integer, List<String>> coursePrefMap = coursePrefsFileReader.getCoursePreferenceFromFile(coursePreferenceReader);


        Map<Integer, List<String>> studentAssignedCourseMap = new HashMap<>();
        for (Map.Entry<Integer, List<String>> entry : coursePrefMap.entrySet()) {
            Integer studentID = entry.getKey();
            List<String> coursePrefList = entry.getValue();
            List<String> assignedCourses = new ArrayList<>();
            Student student = new StudentImpl(studentID, coursePrefList);
            //For Each courseId in coursePrefList
            for (String currentPrefCourseId : coursePrefList) {


                //if assignedCourses == 3 { break; }
                if (assignedCourses.size() == 3) {
                    break;
                }
                //Check if student has another assigned course in sametime using assignedCoursesList & courseTimingMap
                for(Course course: courseList) {
                    if(course.getCourseName().equals(currentPrefCourseId)) {
                        if(!hasConflict(classTimingMap.get(currentPrefCourseId), assignedCourses, classTimingMap)) {
                            if(!course.enrollStudent(student)) {
                                System.out.println("Student Id: " + studentID  + " has not been registered to course "+currentPrefCourseId+ " due to Capacity ");
                                try {
                                    errorLogWriter.write("Student Id: " + studentID  + " has not been registered to course "+currentPrefCourseId+ " due to Capacity ");
                                    errorLogWriter.write(System.lineSeparator());
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }

                            }
                            assignedCourses.add(currentPrefCourseId);
                            studentAssignedCourseMap.put(studentID, assignedCourses);
                        } else {
                            try {
                                System.out.println("Student Id: " + studentID  + " has Conflict for course " + currentPrefCourseId);
                                conflictFileWriter.write("Student Id: " + studentID  + "has Conflict for course" + currentPrefCourseId);
                                conflictFileWriter.write(System.lineSeparator());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }


            }
        }
        System.out.println(Collections.singletonList(studentAssignedCourseMap));
        Map<Integer, Integer> satisfactionRatings = getSatisFactionRatingMapForStudents(coursePrefMap, studentAssignedCourseMap);
        result.setSatisfactionRatings(satisfactionRatings);
        result.setAssignedCourseMap(studentAssignedCourseMap);
        return result;
    }

    private boolean hasConflict( int currentClassTiming, List<String> assignedCourses, Map<String, Integer> classTimingMap) {
        for (String course: assignedCourses) {
            if(classTimingMap.get(course) == currentClassTiming){
                return true;
            }
        }
        return false;
    }
    private Map<Integer, Integer> getSatisFactionRatingMapForStudents(Map<Integer, List<String>> coursePrefsMap, Map<Integer, List<String>> coursesAssignedMap) {
       //
        System.out.println("NEW MAAAAAAAAP: " + Collections.singletonList(coursesAssignedMap));
        Map<Integer, Integer> satisfactionRatingMap = new HashMap<>();
        for (Map.Entry<Integer, List<String>> entry : coursesAssignedMap.entrySet()) {
            Integer studentId = entry.getKey();
            List<String> assignedCoursesForStudent = coursesAssignedMap.get(studentId);
            List<String> coursePrefsForStudent = coursePrefsMap.get(studentId);
            int satisfactionPoints = 0;
            for (String courseId : assignedCoursesForStudent) {
                satisfactionPoints = satisfactionPoints + (MAX_SATISFACTION_POINT - coursePrefsForStudent.indexOf(courseId));
            }
            int satisfactionRating = satisfactionPoints / 3;
            satisfactionRatingMap.put(studentId, satisfactionRating);
        }
        System.out.println(Collections.singletonList(satisfactionRatingMap));
        return satisfactionRatingMap;
    }

    private Map<String, Integer> getClassTimingMap(List<Course> courseList) {
        return courseList.stream().collect(Collectors.toMap(Course::getCourseName, Course::getClassTiming));
    }
}
