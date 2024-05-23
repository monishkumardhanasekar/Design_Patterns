# cs542-fall-23-assign3-monishkumardhanasekar

-----------------------------------------------------------------------
----------------------------------------------------------------------- 
# FullName: 
Monish Kumar Dhanasekar 

----------------------------------------------------------------------- 
# Number of slack days used in this assignment: 2
# Total number of slack days left: 1 (Used 1 slack day for assignment 2 but it wasn't considered from your side, if its not considered then the remaining is 2 slack days)

-----------------------------------------------------------------------
## Instruction to compile:
####Command: ant -buildfile studentCourseSequencer/src/build.xml all
####Description: Compiles your code 

-----------------------------------------------------------------------

## Instruction to run:
####Command: ant -buildfile studentCourseSequencer/src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=errorlog.txt
####Format: ant -buildfile studentCourseSequencer/src/build.xml run -Darg0=<input_file.txt> -Darg1=<output_file.txt> -Darg2=<errorLog_file.txt> 

-----------------------------------------------------------------------
## Instruction to clean:
####Command: ant -buildfile studentCourseSequencer/src/build.xml clean
####Description: It cleans up all the .class files

-----------------------------------------------------------------------
# Justification for choice of data structure:
To store courses to store the courses and then used Queue to store waitlist

-----------------------------------------------------------------------

# Algorithm used to remove waitlist:
Read each course from the input file.
If any group's waitlist is not empty, dequeue and register courses from those waitlists.
If all waitlists are empty, register the current course from the input file.
If the prerequisites of the current course are not registered, enqueue the course.
Once the prerequisites are completed, register the enqueued course.

-----------------------------------------------------------------------
#Note: Debug_level is not used for this assignment.
-----------------------------------------------------------------------
# Citations for external material 

No code snippets used from external material.
-----------------------------------------------------------------------

-----------------------------------------------------------------------
### Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating I will have to sign an official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a grade of 0 for the involved assignment for my first offense and that I will receive a grade of F for the course for any additional offense.""

Date: 11/16/2023
-----------------------------------------------------------------------

