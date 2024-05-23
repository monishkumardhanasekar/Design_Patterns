package courseSequencer.scheduler;

import courseSequencer.context.CourseOrganizer;
import courseSequencer.util.InputReaderInterface;
import courseSequencer.util.DataStructures;
import courseSequencer.util.FileProcessor;

public class CoursePlanner {
    public void createSchedule(CourseOrganizer alternateContextClass,FileProcessor processor, DataStructures dataObj, String inputFile){
        processor.readFile(new InputReaderInterface() {
            @Override
            public void workLine(String line) {
                try{
                    int studentId;
                    String[] coursePreference;
                    String[] studentInfo = line.split(":");
                    if(studentInfo.length == 2)
                    {
                        studentId = Integer.parseInt(studentInfo[0]);     
                        System.out.print(studentId + ":");
                        dataObj.output.append(studentId+": ");
                        String trimmedString = studentInfo[1].replaceFirst("^\\s+", "");
                        coursePreference = trimmedString.split(" ");
                        if((coursePreference.length>0)&&(coursePreference.length<27)){
                            for (String course : coursePreference) {
                                System.out.println(course+ " ");
                                if(dataObj.isGraduated){
                                    System.out.println("Congrats for Completing the Course");
                                    break;
                                }
                                else{
                                     alternateContextClass.registerCourseAttempt(course,dataObj,alternateContextClass);
                                } 
                            }
                            dataObj.output.append("-- "+dataObj.semester+" "+dataObj.stateChangeCount);
                        }   
                        else{
                            System.exit(0); 
                        }                    
                    }
                    else{
                        System.exit(0); 
                    }
                }
                catch(Exception ex){
                    ex.getStackTrace();
                    System.exit(0);
                }
            }
        },inputFile);
    }
}
