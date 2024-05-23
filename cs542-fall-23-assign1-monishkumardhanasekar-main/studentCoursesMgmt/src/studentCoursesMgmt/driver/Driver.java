package studentCoursesMgmt.driver;

import studentCoursesMgmt.util.*;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

	   if (args.length != 5) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);

		}
		System.out.println("0: " +args[0]);
		System.out.println("1: "+args[1]);
		System.out.println("2: "+args[2]);
		System.out.println("3: "+args[3]);
		System.out.println("4: "+args[4]);


		StudentCourseManager studentCourseManager = new StudentCourseManagerImpl();
		FileProcessor fileProcessor = new FileProcessor();
		BufferedReader coursePreferenceReader = fileProcessor.getFileReader(args[0]);
		BufferedReader courseInfoReader = fileProcessor.getFileReader(args[1]);
		FileWriter registrationresultsWriter = fileProcessor.getFileWriter(args[2]);
		FileWriter conflictFileWriter = fileProcessor.getFileWriter(args[3]);
		FileWriter erroLogWriter = fileProcessor.getFileWriter(args[4]);
        CourseAssignmentResult result = studentCourseManager.getCourseAssignment(courseInfoReader, coursePreferenceReader, conflictFileWriter, erroLogWriter);

        Results results = new Results();
        results.writeResult(result, registrationresultsWriter);
		try {
			conflictFileWriter.close();
			registrationresultsWriter.close();
			erroLogWriter.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}
