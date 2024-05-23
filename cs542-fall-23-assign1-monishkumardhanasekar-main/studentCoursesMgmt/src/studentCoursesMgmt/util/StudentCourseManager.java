package studentCoursesMgmt.util;

import java.io.BufferedReader;
import java.io.FileWriter;

public interface StudentCourseManager {
    CourseAssignmentResult getCourseAssignment(BufferedReader courseInfoReader, BufferedReader coursePreferenceReader, FileWriter conflictFileWriter, FileWriter errorLogFileWriter);
}