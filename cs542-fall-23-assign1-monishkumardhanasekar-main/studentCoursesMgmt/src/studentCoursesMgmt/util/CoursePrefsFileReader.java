package studentCoursesMgmt.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class CoursePrefsFileReader {

    public Map<Integer, List<String>> getCoursePreferenceFromFile(BufferedReader fileReader) {
        LinkedHashMap<Integer, List<String>> coursePrefMap = new LinkedHashMap<>();
        try {
            String line;
            while ((line = fileReader.readLine()) != null) {
                //System.out.println(line);

                // Split the line into parts
                String[] parts = line.split(" ");

                // Check if there are at least 10 parts (student ID and 9 preferences)
                if (parts.length >= 10) {
                    int studentID = Integer.parseInt(parts[0]); // Assuming the first part is an integer
                    String[] preferences = new String[9];
                    List<String> coursePrefList = new ArrayList<>();

                    // Extract the first 9 preferences
                    coursePrefList.addAll(Arrays.asList(parts).subList(1, 10));
                    coursePrefMap.put(studentID, coursePrefList); // key as studentId and value as coursePrefList or Preferences


                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
            // System.out.println("Course Pref Map: " + Collections.singletonList(coursePrefMap));

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Collections.singletonList(coursePrefMap));
        return coursePrefMap;
    }
}
