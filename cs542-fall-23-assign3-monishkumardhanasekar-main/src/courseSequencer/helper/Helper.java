package courseSequencer.helper;

import java.util.HashMap;
import java.util.Map;

import courseSequencer.context.CourseOrganizer;
import courseSequencer.state.CourseSequencerStateI;
import courseSequencer.util.DataStructures;
import courseSequencer.waitList.Queue;

public class Helper {
    
	public HashMap<String,Boolean> getCurrentStateGroup(String stateName, DataStructures dataObj){
        HashMap<String,Boolean> temp = null;
        switch (stateName) {
            case "State One":
                temp= dataObj.groupOneCourseStatusMap;
                break;
            case "State Two":
                temp= dataObj.groupTwoCourseStatusMap;
                break;
            case "State Three":
                temp= dataObj.groupThreeCourseStatusMap;
                break;
            case "State Four":
                temp= dataObj.groupFourCourseStatusMap;
                break;
            case "State Five":
                temp= dataObj.groupFiveCourseStatusMap;
                break;
        }
        return temp;
    }
	
    public void registerCourse(String course, DataStructures dataObj,CourseSequencerStateI state, CourseOrganizer alternateContextClass){
        if((!isRegistered(course, dataObj.isGroupOneRegistrationComplete, dataObj.groupOneCourseStatusMap, dataObj.waitlistGroupOne, dataObj, state,alternateContextClass, 1)) && (dataObj.semCourseCount<3) ){
            if((!isRegistered(course, dataObj.isGroupTwoRegistrationComplete, dataObj.groupTwoCourseStatusMap, dataObj.waitlistGroupTwo, dataObj, state,alternateContextClass, 2)) && (dataObj.semCourseCount<3) ){
                if((!isRegistered(course, dataObj.isGroupThreeRegistrationComplete, dataObj.groupThreeCourseStatusMap, dataObj.waitlistGroupThree, dataObj, state,alternateContextClass, 3)) && (dataObj.semCourseCount<3) ){
                    if((!isRegistered(course, dataObj.isGroupFourRegistrationComplete, dataObj.groupFourCourseStatusMap, dataObj.waitlistGroupFour, dataObj, state,alternateContextClass, 4)) && (dataObj.semCourseCount<3) ){
                        if((!isRegistered(course, dataObj.isGroupFiveRegistrationComplete, dataObj.groupFiveCourseStatusMap, dataObj.waitlistGroupFive, dataObj, state,alternateContextClass, 5)) && (dataObj.semCourseCount<3) ){
                
                        }
                    }
                }
            }
        }
        if(dataObj.semCourseCount>2){
            dataObj.semester++;
            dataObj.semCourseCount=0;
            dataObj.isGroupOneRegistrationComplete=false;
            dataObj.isGroupTwoRegistrationComplete=false;
            dataObj.isGroupThreeRegistrationComplete=false;
            dataObj.isGroupFourRegistrationComplete=false;
            dataObj.isGroupFiveRegistrationComplete=false;
        }
    }
	
	 public String isQueueEmpty(Queue waitList){
        return waitList.dequeue();
    }
    
	public boolean isRegistered(String course, boolean isGroupReg, HashMap<String,Boolean> groupCourses, Queue waitList, DataStructures dataObj, CourseSequencerStateI state,CourseOrganizer alternateContextClass,int groupNum){
        if(groupCourses.containsKey(course)){
            if(!isGroupReg){
                dataObj.output.append(course+" ");
                dataObj.semCourseCount++;
                dataObj.totalCourseRegistered++;
                fixGroupReg(groupNum,dataObj);
                groupCourses.put(course,true);
                int stateChangeNum = compareTrueValues(getCurrentStateGroup(state.toString(),dataObj),dataObj.groupOneCourseStatusMap, dataObj.groupTwoCourseStatusMap, dataObj.groupThreeCourseStatusMap, dataObj.groupFourCourseStatusMap, dataObj.groupFiveCourseStatusMap);      
                if(stateChangeNum!=0){
                    changeStateGroup(alternateContextClass, stateChangeNum, state,dataObj);
                }
                return true;
            }
            else{
                waitList.enqueue(course);
                return false;
            }
        }
        else{
            return false;
        }
    }
	
	public void assistCourseRegister(String course, DataStructures dataObj, CourseSequencerStateI state,CourseOrganizer alternateContextClass){
        if((dataObj.totalRegistrationsGroupOne>1) && (dataObj.totalRegistrationsGroupTwo>1) && (dataObj.totalRegistrationsGroupThree>1) && (dataObj.totalRegistrationsGroupFour>1) && (dataObj.totalRegistrationsGroupFive>1) && (dataObj.totalCourseRegistered>9) ){
            dataObj.isGraduated=true;                
        }
        if(!dataObj.isGraduated){

            if((!dataObj.waitlistGroupOne.isEmpty()) && (!dataObj.isGroupOneRegistrationComplete)){
                String gOneDequeuedCourse = isQueueEmpty(dataObj.waitlistGroupOne);
                registerCourse(gOneDequeuedCourse, dataObj, state, alternateContextClass);
            }
            
            if((!dataObj.waitlistGroupTwo.isEmpty()) && (!dataObj.isGroupTwoRegistrationComplete)){
                String gTwoDequeuedCourse = isQueueEmpty(dataObj.waitlistGroupTwo);
                registerCourse(gTwoDequeuedCourse, dataObj, state, alternateContextClass);
            }
            
            if((!dataObj.waitlistGroupThree.isEmpty()) && (!dataObj.isGroupThreeRegistrationComplete)){
                String gThreeDequeuedCourse = isQueueEmpty(dataObj.waitlistGroupThree);
                registerCourse(gThreeDequeuedCourse, dataObj, state, alternateContextClass);
            }
            
            if((!dataObj.waitlistGroupFour.isEmpty()) && (!dataObj.isGroupFourRegistrationComplete)){
                String gFourDequeuedCourse = isQueueEmpty(dataObj.waitlistGroupFour);
                registerCourse(gFourDequeuedCourse, dataObj, state, alternateContextClass);
            }
            
            if((!dataObj.waitlistGroupFive.isEmpty()) && (!dataObj.isGroupFiveRegistrationComplete)){
                String gFiveDequeuedCourse = isQueueEmpty(dataObj.waitlistGroupFive);
                registerCourse(gFiveDequeuedCourse, dataObj, state, alternateContextClass);
            }
            registerCourse(course, dataObj, state, alternateContextClass);
        }
    }
	
	public void fixGroupReg(int groupNum, DataStructures dataObj){
        switch (groupNum) {
            case 1:
                dataObj.isGroupOneRegistrationComplete=true;
                dataObj.totalRegistrationsGroupOne++;
                break;
            case 2:
                dataObj.isGroupTwoRegistrationComplete=true;
                dataObj.totalRegistrationsGroupTwo++;
                break;
            case 3:
                dataObj.isGroupThreeRegistrationComplete=true;
                dataObj.totalRegistrationsGroupThree++;
                break;
            case 4:
                dataObj.isGroupFourRegistrationComplete=true;
                dataObj.totalRegistrationsGroupFour++;
                break;
            case 5:
                dataObj.isGroupFiveRegistrationComplete=true;
                dataObj.totalRegistrationsGroupFive++;
                break;
        }
    }
	
    public void changeStateGroup(CourseOrganizer alternateContextClass, int groupNum, CourseSequencerStateI state,DataStructures dataObj){
        switch (groupNum) {
            case 1:
                state.changeGroup(alternateContextClass.getStateOne());
                dataObj.stateChangeCount++;
                break;
            case 2:
                state.changeGroup(alternateContextClass.getStateTwo());
                dataObj.stateChangeCount++;
                break;
            case 3:
                state.changeGroup(alternateContextClass.getStateThree());
                dataObj.stateChangeCount++;
                break;
            case 4:
                state.changeGroup(alternateContextClass.getStateFour());
                dataObj.stateChangeCount++;
                break;
            case 5:
                state.changeGroup(alternateContextClass.getStateFive());
                dataObj.stateChangeCount++;
                break;
        }
    }
    
    public static int compareTrueValues(HashMap<String, Boolean> currentMap,HashMap<String, Boolean>... maps ) {
        int mostTrueMapNumber = -1;
        int maxCount = 0;
        int currentrealCount = countTrueValues(currentMap); 
		int i = 0;
		while (i < maps.length) {
		int realCount = countTrueValues(maps[i]);

			if (realCount > maxCount) {
				maxCount = realCount;
				mostTrueMapNumber = i + 1;
			}
			i++;
		}
        if(maxCount>currentrealCount){
            return mostTrueMapNumber;
        }
        else{
            return 0;
        }
    }

    
	public static int countTrueValues(HashMap<String, Boolean> map) {
        int realCount = 0;

        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                realCount++;
            }
        }
        return realCount;
    }
}
