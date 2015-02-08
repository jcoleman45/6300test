# **Requirements Document -- Team 26**

##1 User Requirements

Students of a university need a tool to calculate the average number of words in a sentence in their essays to improve 
their writing style. The software shall be designed for use by each of the students considering the fact the not all 
users are expert computer users. The application shall be known as `Average Sentence Length` and each student shall 
have a copy of this tool. The input file which contains the essay is a raw text file. To use the tool, the students 
are expected to pass the file path to the essay with some configuration parameters on the command-line 
and get the average number of words of the sentences as output. Adequate help documentation shall be provided along 
with troubleshooting information.

###1.1 User Characteristics

There will be about 270 college students who may use this application per semester. Their computer expertise varies from
no experience at all to being proficient users. Also there is no one type of computer that all students use and they 
have machines with varied operating systems.

###1.2 System's functionality

The users will identify the file-path to their essay (files are in raw text format) and use it as as a command-line
parameter. As part of the command-line parameters, they have the option to customize the minimum word length and sentence
delimiters that need to be used. If the users' input is not according to what the software expects, helpful error messages
shall be returned to help them use the tool effectively. If the command-line parameters are valid, the software returns 
the average number of words per sentence for the selected essay.

###1.3 User Interfaces

The users are required to have the Java Runtime Environment version 1.6 or 1.7 installed. The application is
run on the command-line using the `java` command. The input data shall be specified by passing a path to a (raw text format)
file on the command-line. The two customizations (sentence-separators and word-length) available are specified by command
line parameters. 

####1.3.1 Run the application

This is a draft of the envisioned user interface (executed in the application directory):
 
````
java -cp . AverageSentenceLength [-d <delimiters>] [-l <min_length>] <file_path>
````

The option arguments are:

- **delimiters:** (optional) Specify a list of sentence delimiters - defaults to: `.?!`
- **min_length:** (optional) Specify minimum word length (inclusive) - defaults to: `3`

####1.3.2 Output

The software shall return the average number of words per sentence, rounded down to the nearest integer. The output 
shall be returned as follows:

````
Average number of words per sentence in the file - <file> : <number>
````

Valid and helpful error messages are displayed on the command line if there is an error condition while
running the program or if the input commands are wrongly entered.

##2 System Requirements

This software should be an application running using the Java Runtime Environment version 1.6 or 1.7. It is developed
to analyze the average words of sentences in a raw text file with default encoding. It should have a main method and contain 
a command line without other options. The code must be written in Java and must use standard Java libraries. All code in
this program that is not the part of JDK, should be included as source code with the program.
 
###2.1 Functional Requirements

####2.1.1 Command-line interface

#####2.1.1.1 Delimiters (must have)
A flag `-d` shall be used to specify the sentence separators. The default value is: `.?!`

#####2.1.1.2 Minimum word length (must have)
A flag `-l` shall be used to specify an inclusive lower limit for word length. The default value is: `3`

#####2.1.1.3 File path (must have)
The `file path` shall be specified by the user as the single command-line argument or after the delimiters and minimum word length.

####2.1.3 Output (must have)
The software shall return the average number of words per sentence, rounded down to the nearest integer.

###2.2 Non-Functional Requirements

Some of the requirements listed here are quite technical and would better fit into a design document; however
they were explicitly mentioned by one group of stake-holders (instructors).

####2.2.1 Compilation

#####2.2.1.1 Programming Language (must have)
The software must be written in Java, language level 1.6 or 1.7.

#####2.2.1.2 Third-party libraries (must have)
The software shall not make use of special/non-standard libraries. 
All code required to execute the program that is not part of the  standard JDK, shall be included as source 
code with the program.

#####2.2.1.3 Compilation (must have)
The source must compile with the `javac` command, without providing any compiler options.

####2.2.2 Execution

#####2.2.2.1 Runtime environment  (must have)
The application shall work on machine with a vanilla installation of Java 1.6 or Java 1.7.

#####2.2.2.2 Application Entry Point (must have)
The software is a Java application having a `main()` method.

#####2.2.2.3 Execution (must have)
The application shall be executable from the command prompt using the `java` command.

#####2.2.2.3 Usability (must have)
The application shall be easy to use and have user-friendly error messages rather than having error codes.

#####2.2.2.4 Documentation (must have)
The application shall be accompanied by a user manual that indicates how to use the tool, troubleshooting 
information and details around the various error messages.

#####2.2.2.5 Error messages (must have)
Reasonably friendly, helpful messages shall be returned in various error cases.

- Invalid file path
- Missing file name
- Invalid usage of command-line parameters
- Empty input file

#####2.2.2.6 Input file encoding (must have)
The application shall be able to handle normal text files with the default encoding.
