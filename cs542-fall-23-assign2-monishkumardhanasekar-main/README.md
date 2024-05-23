Full name: MONISH KUMAR DHANASEKAR

INSTRUCTIONS TO COMPILE 

ant -buildfile studentCoursesMgmt/src/build.xml clean
ant -buildfile studentCoursesMgmt/src/build.xml all


INSTRUCTIONS TO HOW RUN
 
ant -buildfile studentCoursesMgmt/src/build.xml run -Darg0=bstInput.txt -Darg1=bstOutput.txt -Darg2=errorLog.txt -Darg3=1 -Darg4=1


WHAT DATA STRUCTURES HAVE I USED

* List for Courses
* Map for building a class timing Map to fetch class time at O(1) time complexity
* LinkedHahMap  has been used to preserve the order of insertion for course preferences. We need the order to be preserved inorder to properly do FCFS  allotment of courses. Linked HashMap also has O(1) time complexity for insert & lookup

WHAT IS THE TIME COMPLEXITY 

We are Iterating through each student's course preferences, and for each preferred course, iterating through the list of all courses.
Time Complexity: O(N * M)

Where N is Number of Students
and M is number of Courses


Date: 20.10.2023
