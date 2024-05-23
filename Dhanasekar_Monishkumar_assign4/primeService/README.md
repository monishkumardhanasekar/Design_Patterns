# Dhanasekar_Monishkumar_assign4

-----------------------------------------------------------------------
----------------------------------------------------------------------- 
# Team members FullName: 
Monish Kumar Dhanasekar 


-----------------------------------------------------------------------
## Instruction to compile:
####Command: ant -buildfile primeService/src/build.xml all
####Description: Compiles your code 

-----------------------------------------------------------------------

## Instruction to run:
####Command for server: ant -buildfile primeService/src/build.xml run -Darg0=server -Darg1=8080
####Command for client:ant -buildfile primeService/src/build.xml run -Darg0=client -Darg1=8080 -Darg2=127.0.0.1
####Format for client: ant -buildfile primeService/src/build.xml run -Darg0=<mode> -Darg1=<port number> -Darg2=<local host> 
####Format for server: ant -buildfile primeService/src/build.xml run -Darg0=<mode> -Darg1=<port number>
-----------------------------------------------------------------------
## Instruction to clean:
####Command: ant -buildfile primeService/src/build.xml clean
####Description: It cleans up all the .class files

-----------------------------------------------------------------------
# Justification for choice of data structure:
Used Hashmap for storing Queries (String- client name, Integer- query value).
For storing each client query as a key and value pair, Hashmap would be the best choice for this.

-----------------------------------------------------------------------
# Design pattern used: 
Used Singleton Pattern for Debug class.

-----------------------------------------------------------------------
# Citations for external material 

No code snippets used from external material.
-----------------------------------------------------------------------

-----------------------------------------------------------------------
### Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating I will have to sign an official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a grade of 0 for the involved assignment for my first offense and that I will receive a grade of F for the course for any additional offense.""

Date: 12/03/2023
-----------------------------------------------------------------------