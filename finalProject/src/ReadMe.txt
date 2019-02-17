
***************
AUTHOR details
***************

E/15/138 - IRFAN M.M.M
E/15/021 - ASLAM M.M.M
Group No - 021
last update on Feb 17th 2019


*********************************************************
Requirements for Using the CPU simulator
*********************************************************
-should have the instruction file with headers
-it should include the details such as
 *instructions in the required format
 *address to store the instructions in the memory
 *address -from where to start the instruction and  the end as well



**********************************************************************************
Design of the ISA used in the simulator ,and only these instructions are supported
**********************************************************************************


            //load immediate
            "LI R1 10",//r1=10
            "LI R2 20",//r2=20

            //basic arithmetic operations
            "ADD R3 R1 R2",//r3=r1+r2
            "MUL R3 R3 R3",//r3=r3*r3
            "SUB R5 R3 R2",// r5=r3-r2
            "DIV R4 R3 R1",//r4=r3/r1 (integer division)

            //add or sub immediate
            "SUBI R5 R4 10", // r5=r4-10
            "ADDI R5 R5 10 ",//r5=r5+10

            //logical instructions
            "SLL R7 R1 R6",  // r7=r1>>r6 (shift left by r6)
            "SRL R8 R7 R6", //r8=r7<<r6 (shift right by r6)
            "SLT R9 R7 R6", //r9=1 if (r7 < r6)
            "AND R1 R1 R2" ,//bitwise and r1=r1 & r2 ,same format for all other instructions like
            /*
            * bitwise or -> OR R1 R3 R2
            * bitwise xor -> XOR R1 R3 R2
            * bitwise nor -> NOR R1 R3 R2
            * */

            //branch instructions
            "BEQ R5 R4 10", //go to address 10 if r5==r4
            "BGT R5 R4 10", //go to address 10 if r5>r4

            //Jump instructions
            "J 10", //go to address 10
            "JAL R5 R4 10", //Link and jump to 10 (note r31 will store the link address to come back)
            "JR R5" //go to address in r5


*********************************************************
Instructions for Using the CPU simulator
*********************************************************

1st of all

specify the instruction file path instead of "SHOULD GIVE THE PATH" in OS.java main method
include necessary information in header file (start , end , set of instructions)

** Compile and run OS.java

	To compile	: javac OS.java
	To run		: java OS
    NOTE		: should have specified the instruction file path in main method before compiling


*********************************************************
About the Register file used in CPU
*********************************************************

-it has 32 registers
-r0 is 0 always and its read only
-other registers can be used for read and write
-r31 is used for saving the program counter address when jump and link instruction happens
-r31 can also be said as link register

*********************************************************
About the RAM used in CPU
*********************************************************

-it can store 32 bit values
-the size of the RAM in MB is given when creating an RAM object
-addresses used here are byte addresses
-we can both read and write to RAM
-as of now its just used as a data memory

*********************************************************
About the Instruction memory used in CPU
*********************************************************

-the size of the instruction memory in MB is given when creating an object
-addresses used here are byte addresses
-we can only read instructions
-OS will load the instructions to the memory
-as of now its just used as a data memory

*********************************************************
About the OS
*********************************************************

-the OS will have a cpu mentioned above
-it has special privileges for loading instructions and executing programs in a range

as future improvements

-we can implement a system call function such as printf in OS
-so that the run time can request a system call and OS can handle the request and take over the control of CPU