# CSX42: Assignment 1
## Name: Monish Kumar Dhanasekar

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesMgmt/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCoursesMgmt/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesMgmt/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile studentCoursesMgmt/src/build.xml run -Darg0=<input_file.txt> -Darg1=<delete_file.txt> -Darg2=<output1_file.txt> -Darg3=<output2_file.txt> -Darg4=<output3_file.txt>

## Replace <fileName.txt> with real file names. For example, if the files are available in the path,
## you can run it in the following manner:

ant -buildfile studentCoursesMgmt/src/build.xml run -Darg0=input_file.txt -Darg1=delete_file.txt -Darg2=output1_file.txt -Darg3=output2_file.txt -Darg4=output3_file.txt

Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Description:
Go to the project directory
cd /home/mdhanasekar/DP/Assignment1/cs542-fall-23-assign1-monishkumardhanasekar

INSTRUCTIONS TO COMPILE 


ant -buildfile studentCoursesMgmt/src/build.xml clean
ant -buildfile studentCoursesMgmt/src/build.xml all

INSTRUCTIONS TO HOW RUN


ant -buildfile studentCoursesMgmt/src/build.xml run -Darg0=coursePrefs.txt -Darg1=courseInfo.txt -Darg2=regResults.txt -Darg3=regConflicts.txt -Darg4=errorLog.txt


WHAT DATA STRUCTURES HAVE I USED

* List for Courses
* Map for building a class timing Map to fetch class time at O(1) time complexity
* LinkedHahMap  has been used to preserve the order of insertion for course preferences. We need the order to be preserved inorder to properly do FCFS  allotment of courses. Linked HashMap also has O(1) time complexity for insert & lookup

WHAT IS THE TIME COMPLEXITY 

We are Iterating through each student's course preferences, and for each preferred course, iterating through the list of all courses.
Time Complexity: O(N * M)

Where N is Number of Students
and M is number of Courses


-----------------------------------------------------------------------

Date: 29.09.2023


