package studentCoursesMgmt.util;

import java.util.List;
import java.util.Map;

public class CourseAssignmentResult {
    public Map<Integer, List<String>> assignedCourseMap;
    public Map<Integer, Integer> satisfactionRatings;

    @Override
    public String toString() {
        return "CourseAssignmentResult{" +
                "assignedCourseMap=" + assignedCourseMap +
                ", satisfactionRatings=" + satisfactionRatings +
                '}';
    }

    public Map<Integer, List<String>> getAssignedCourseMap() {
        return assignedCourseMap;
    }

    public void setAssignedCourseMap(Map<Integer, List<String>> assignedCourseMap) {
        this.assignedCourseMap = assignedCourseMap;
    }

    public Map<Integer, Integer> getSatisfactionRatings() {
        return satisfactionRatings;
    }

    public void setSatisfactionRatings(Map<Integer, Integer> satisfactionRatings) {
        this.satisfactionRatings = satisfactionRatings;
    }
}
