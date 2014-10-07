aconex-coding-challenge
=======================

Exercise project given by Aconex

Choice of project
=======================
GEDCOM parser is chosen as the project because :
1.This could be achieved using Java's rich IO libraries. Other projects might have required external libraries or database. 
2.After doing tasking and planning, found it appropriate for the time lines given.

## User Story :##
1. As a user I want to convert my GEDCOM file to XML.
Tasking:
A) Identify the problem statement and design.[6 hours]
B) Writing test cases and unit tests for the solution.[10 hours]
C) Writing classes and Developing methods to satisfy the test cases.[18 hours]
D) Testing the application [6 hours].

Design and Approach
=======================

## Packages : ##
- main.java.com.Gedcom.api : Contains GedcomRequest class and GedcomInterface class
- main.java.com.Gedcom.impl : Contains an abstract Node class, XMLWriter which extends Node class, implementation class for GedcomInterface GedcomImpl and the Executor class. 
  Node and XML parser contains logic to convert an input string to xml tag and GedcomImpl contains the business logic to parse a text file to XML using the helper classes Node and XMLParser.
  Executor is the main class which executes the core logic to convert a text file into xml.
- test.java.com.Gedcom - Contains the test class TestGedcomParser.
- resources.input - Contains the input files
- resources.output - Contains output and expected output files.


## Coding Best Practices : ##

- TDD approach followed. 
- OOP concepts applied as and when required
- Other regular best Java practices

How to run tests?
=======================
1. Download and install Maven (For reference:: http://maven.apache.org/download.cgi)
2. Verify maven installation : c:\> mvn --version
3. Extract the project folder.
4. Go to the project folder and run the following command from command prompt :
                 mvn clean package
				 
		C:\Users\Richa\Desktop\GedcomParser>mvn clean package
		[INFO] Scanning for projects...
		[INFO]
		[INFO] ------------------------------------------------------------------------
		[INFO] Building GedcomParser 1.0
		[INFO] ------------------------------------------------------------------------
		[INFO]
		[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ GedcomParser ---
		[INFO] Deleting C:\Users\Richa\Desktop\GedcomParser\target
		[INFO]
		[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ GedcomPars
		er ---
		[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources,
		i.e. build is platform dependent!
		[INFO] Copying 23 resources
		[INFO]
		[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ GedcomParser --
		-
		[INFO] Changes detected - recompiling the module!
		[WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. b
		uild is platform dependent!
		[INFO] Compiling 6 source files to C:\Users\Richa\Desktop\GedcomParser\target\cl
		asses
		[INFO]
		[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ Ge
		dcomParser ---
		[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources,
		i.e. build is platform dependent!
		[INFO] skip non existing resourceDirectory C:\Users\Richa\Desktop\GedcomParser\s
		rc\test\resources
		[INFO]
		[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ GedcomP
		arser ---
		[INFO] Changes detected - recompiling the module!
		[WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. b
		uild is platform dependent!
		[INFO] Compiling 1 source file to C:\Users\Richa\Desktop\GedcomParser\target\tes
		t-classes
		[INFO]
		[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ GedcomParser ---
		[INFO] Surefire report directory: C:\Users\Richa\Desktop\GedcomParser\target\sur
		efire-reports

		-------------------------------------------------------
		 T E S T S
		-------------------------------------------------------
		Running test.java.com.Gedcom.TestGedcomParser
		TestGedcomParser :: Running testJunkData()
		src/resources/output/junk_output.xml
		TestGedcomParser :: Running testWhiteSpaces()
		src/resources/output/whitespace_output.xml
		TestGedcomParser :: Running testSpacesBetweenLines()
		src/resources/output/spaces_between_lines_output.xml
		TestGedcomParser :: Running testNullInput()
		src/resources/output/input_file_empty.xml
		TestGedcomParser :: Running testInputFile()
		src/resources/output/input_file_missing.xml
		Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.124 sec

		Results :

		Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

		[INFO]
		[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ GedcomParser ---
		[INFO] Building jar: C:\Users\Richa\Desktop\GedcomParser\target\GedcomParser-1.0
		.jar
		[INFO] ------------------------------------------------------------------------
		[INFO] BUILD SUCCESS
		[INFO] ------------------------------------------------------------------------
		[INFO] Total time: 5.562 s
		[INFO] Finished at: 2014-10-07T00:51:43+05:30
		[INFO] Final Memory: 13M/310M

5. Go to */target/classes folder and run the following command to execute the main class :
             java main.java.com.Gedcom.impl.Executor
			 
	    C:\Users\Richa\Desktop\GedcomParser\target\classes>java main.java.com.Gedcom.impl.Executor
		###############GEDCOM XML CONVERTOR###############
		/C:/Users/Richa/Desktop/GedcomParser/target/classes/resources/output/GEDCOM_Parser_Challenge_Output.xml
		################GEDCOM SUCCESSFUULY CONVERTED TO XML###############
		##Output file path## :: /C:/Users/Richa/Desktop/GedcomParser/target/classes/resources/output/GEDCOM_Parser_Challenge_Output.xml
		Executing completed. Time taken = 464 ms
		
	Input file path : GedcomParser/target/classes/resources/input/GEDCOM_Parser_Challenge_sample_data.txt
	The output can be verified in GedcomParser/target/classes/resources/output/GEDCOM_Parser_Challenge_Output.xml

Alternatively, any IDE can be used for executing.
  - Extract the project folder at some location
  - Create a new java project in eclipse or any IDE and import the project folder.
  - Add junit jar in the project folder to build path.
  - Run TestGedcomParser.java to run all the testcases
  - Run Executor.java to execute the core logic to convert text file to xml.


