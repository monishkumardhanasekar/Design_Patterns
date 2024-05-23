package courseSequencer.util;

import java.util.HashMap;

import courseSequencer.waitList.Queue;

public class DataStructures {
	public Queue waitlistGroupOne;
    public Queue waitlistGroupTwo;
    public Queue waitlistGroupThree;
    public Queue waitlistGroupFour;
    public Queue waitlistGroupFive;
	
    public int semester=1;
    public int semCourseCount=0;
    public int stateChangeCount=0;
    public int totalCourseRegistered=0;
    public boolean isGraduated= false;
	
    public HashMap<String,Boolean> groupOneCourseStatusMap;
    public HashMap<String,Boolean> groupTwoCourseStatusMap;
    public HashMap<String,Boolean> groupThreeCourseStatusMap;
    public HashMap<String,Boolean> groupFourCourseStatusMap;
    public HashMap<String,Boolean> groupFiveCourseStatusMap;

    public boolean isGroupOneRegistrationComplete;
    public boolean isGroupTwoRegistrationComplete;
    public boolean isGroupThreeRegistrationComplete;
    public boolean isGroupFourRegistrationComplete;
    public boolean isGroupFiveRegistrationComplete;

    public int totalRegistrationsGroupOne;
    public int totalRegistrationsGroupTwo;
    public int totalRegistrationsGroupThree;
    public int totalRegistrationsGroupFour;
    public int totalRegistrationsGroupFive;


    public StringBuilder output = new StringBuilder();

    public DataStructures(){
        this.setGroupCourses();

        waitlistGroupOne = new Queue();
        waitlistGroupTwo = new Queue();
        waitlistGroupThree = new Queue();
        waitlistGroupFour = new Queue();
        waitlistGroupFive= new Queue();

        isGroupOneRegistrationComplete = false;
        isGroupTwoRegistrationComplete = false;
        isGroupThreeRegistrationComplete = false;
        isGroupFourRegistrationComplete = false;
        isGroupFiveRegistrationComplete = false;
    }

    
    public void setGroupCourses(){
        groupOneCourseStatusMap = new HashMap<>();
        groupOneCourseStatusMap.put("A",false);
        groupOneCourseStatusMap.put("B",false);
        groupOneCourseStatusMap.put("C",false);
        groupOneCourseStatusMap.put("D",false);

        groupTwoCourseStatusMap = new HashMap<>();
        groupTwoCourseStatusMap.put("E",false);
        groupTwoCourseStatusMap.put("F",false);
        groupTwoCourseStatusMap.put("G",false);
        groupTwoCourseStatusMap.put("H",false);

        groupThreeCourseStatusMap = new HashMap<>();
        groupThreeCourseStatusMap.put("I",false);
        groupThreeCourseStatusMap.put("J",false);
        groupThreeCourseStatusMap.put("K",false);
        groupThreeCourseStatusMap.put("L",false);

        groupFourCourseStatusMap = new HashMap<>();
        groupFourCourseStatusMap.put("M",false);
        groupFourCourseStatusMap.put("N",false);
        groupFourCourseStatusMap.put("O",false);    
        groupFourCourseStatusMap.put("P",false);

        groupFiveCourseStatusMap = new HashMap<>();
        groupFiveCourseStatusMap.put("Q",false);
        groupFiveCourseStatusMap.put("R",false);
        groupFiveCourseStatusMap.put("S",false);
        groupFiveCourseStatusMap.put("T",false);
        groupFiveCourseStatusMap.put("U",false);
        groupFiveCourseStatusMap.put("V",false);
        groupFiveCourseStatusMap.put("W",false);
        groupFiveCourseStatusMap.put("X",false);
        groupFiveCourseStatusMap.put("Y",false);
        groupFiveCourseStatusMap.put("Z",false); 
    }


}
