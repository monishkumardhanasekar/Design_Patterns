package studentCoursesMgmt.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	public void writeResult(CourseAssignmentResult result, FileWriter fileWriter) {
        Map<Integer, List<String>> assignedCoursesMap = result.getAssignedCourseMap();
        Map<Integer, Integer> satisfactionRatings = result.getSatisfactionRatings();

        //Once you have done this now you have a map with assigned Courses for each student
        //We can use this map to write to output file & also caluclate satisfaction score


        // course capacities


        // writing


        try  {
            for (Map.Entry<Integer, List<String>> entry : assignedCoursesMap.entrySet()) {
                StringBuilder stringToWrite = new StringBuilder();
                int studentId = entry.getKey();
                stringToWrite.append(studentId + ":");
                List<String> assignedCourses = entry.getValue();
                stringToWrite.append(String.join(",", assignedCourses));
                stringToWrite.append("::");
                if (satisfactionRatings.containsKey(studentId)) {
                    int satisfactionRating = satisfactionRatings.get(studentId);
                    stringToWrite.append("SatisfactionRating=" + satisfactionRating);
                }
                fileWriter.write(stringToWrite.toString());
                fileWriter.write(System.lineSeparator());
            }
            double averageSatisFactionRating = satisfactionRatings.values().stream().mapToInt(Integer::intValue).average().getAsDouble();
            //<student1_id>:<course_1>,<course_2>,<course_3>::SatisfactionRating=<value>
            fileWriter.write("AverageSatisfactionRating=" + averageSatisFactionRating);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
