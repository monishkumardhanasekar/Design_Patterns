package courseSequencer.driver;

import courseSequencer.context.CourseOrganizer;
import courseSequencer.util.DataStructures;
import courseSequencer.util.FileProcessor;
import courseSequencer.util.Results;
import courseSequencer.scheduler.CoursePlanner;

public class Driver {
    public static void main(String[] args) {
     if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}") ) {
			System.err.println("Error: Program accepts only 2 arguments");
			System.exit(0);
		}

		try {
			CourseOrganizer alternateContextClass = new CourseOrganizer();
            FileProcessor processor = new FileProcessor();
            CoursePlanner scheduler = new CoursePlanner();
            DataStructures dataObj = new DataStructures();
            scheduler.createSchedule(alternateContextClass,processor,dataObj,args[0]);
            Results.writeOutput(processor, args[1],dataObj);
        } catch (Exception e) {
			System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
