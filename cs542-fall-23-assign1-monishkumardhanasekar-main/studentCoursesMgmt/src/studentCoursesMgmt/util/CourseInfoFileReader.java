package studentCoursesMgmt.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CourseInfoFileReader {

    public List<Course> getCourseList(BufferedReader fileReader) {
        List<Course> courseList = new ArrayList<>();
        try {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] parts = line.split(":");

                // Ensure there are exactly three parts (courseName, capacity, classTiming)
                if (parts.length == 3) {
                    String courseName = parts[0];
                    int capacity = Integer.parseInt(parts[1]);
                    int classTiming = Integer.parseInt(parts[2]);
                    courseList.add(new CourseImpl(courseName, capacity, classTiming));
                    if (capacity > 99 || capacity < 10) {
                        throw new InvalidFormatException("Invalid capacity: " + capacity);
                    }
                    if (classTiming > 99 || classTiming < 10) {
                        throw new InvalidFormatException("Invalid class timing: " + classTiming);
                    }

                    // Check for valid course name (A to I)
                    if (!courseName.matches("[A-I]")) {
                        throw new InvalidFormatException("Invalid course name: " + courseName);
                    }
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println(Collections.singletonList(courseList));
        return courseList;

    }
}
