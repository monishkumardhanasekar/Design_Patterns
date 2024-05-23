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

ACADEMIC HONESTY STATEMENT:

"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating I will have to sign an official form that I have cheated and that this form will be stored in my official university record. I also understand that I will receive a grade of 0 for the involved assignment for my first offense and that I will receive a grade of F for the course for any additional offense.""

Date: 20.10.2023