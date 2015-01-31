# **Requirements Document -- Team 26**

##1 User Requirements

Students of a university need a tool to calculate the average number of words in a sentence in their essays to improve 
their writing style. The software shall be designed for use by each of the students considering the fact the not all 
users are expert computer users. The application shall be known as `Average Sentence Length` and each student shall 
have a copy of this tool. The input file which contains the essay is a raw text file. To use the tool, the students 
are expected to pass the file path to the essay with some configuration / customization parameters on the command-line 
and get the average number of words of the sentences as output. Adequate help documentation shall be provided along 
with troubleshooting information.

###1.1 User Characteristics

> General characteristics of the intended users of the product, including educational level, experience, and technical
> expertise.

There will be about 270 college students who may use this application per semester. Their computer expertise varies from
no experience at all to being proficient users. Also there is no one type of computer that all students use and they 
have machines with varied operating systems.

###1.2 System's functionality

> Requirements written from the point of view of end users, usually expressed in narrative form.

The users will identify the file-path to their essay (files are in raw text format) and use it as as a command-line 
parameter. As part of the command-line parameters, they have the option to customize the minimum word length and sentence
delimiters that need to be used. If the users' input is not according to what the software expects, helpful error messages
shall be returned to help them use the tool effectively. If the command-line parameters are valid, the software returns 
the average number of words per sentence for the selected essay.

###1.3 User Interfaces

> Interfaces between the software product and its users; that is, how the users will interact with the system.

The users are required to have the Java Runtime Environment installed, with a version of 1.6 / 1.7. The application is 
run on the command-line using the `java` command. The input data shall be specified by passing a path to a (raw text format)
file on the command-line. The two customizations (sentence-separators and word-length) available are specified by command-
line parameters. 

This is a draft of the envisioned user interfaces:
 
````
java -jar AverageSentenceLength.jar [-d <delimiters>] [-l <min_length>] <file_path>
````

The option arguments are:

- **delimiters:** (optional) Specify sentence delimiters - defaults to: `.` `?` `!`
- **min_length:** (optional) Specify minimum word length (inclusive) - defaults to: `3`

The software shall return the average number of words per sentence, rounded down to the nearest integer. Output shall be 
something like

````
Average number of words per sentence in the file - <file> : <number>
````

````
Valid and helpful error messages are displayed on the command line if there is an error condition while 
running the program or if the input commands are wrongly entered.
````

##2 System Requirements

> These subsections contain all the software requirements at a level of detail sufficient to enable
> designers/developers to design/develop a system that satisfies those requirements, and testers to test that the 
> system satisfies those requirements. This part of the document should provide a numbered (possibly hierarchical) list 
> of simple, complete, and consistent functional and non-functional requirements.

This software should be an application running with Java 1.6 or a later version 1.7. It is developed to analyze the 
average words of sentences in an ASCII format file. It should have a main method and contain a command line without other options. The code must be written in Java and must use standard Java libraries. All code in this program that is not the 
part of JDK, should be included as source code with the program.
 
###2.1 Functional Requirements

####2.1.1 Command-line interface

#####2.1.1.1 File path

The `file path` shall be specified by the user as the single command-line argument.

#####2.1.1.2 Delimiters

A flag `-d` shall be used to specify the sentence separators. Periods, question marks, exclamation points, semicolons 
and colons are default delimiters. Comma is not to be used as a default sentence delimiter.

#####2.1.1.3 Minimum word length

A flag `-l` shall be used to specify a lower limit for word length. This application shall only count words greater than 
or equal to 3 characters by default unless specified otherwise by the `-l` option.

#####2.1.1.4 Error messages
Reasonably friendly, helpful messages shall be returned in various error cases:

- Invalid file path
- File inaccessible
- Invalid usage of command-line parameters
- Invalid file extension
- Java runtime not installed or not configured correctly
- Empty input file

####2.1.2 Input file format
The file shall be in ASCII format.

####2.1.3 Output
The software shall return the average number of words per sentence, rounded down to the nearest integer.

###2.2 Non-Functional Requirements

####2.2.1 Compilation

#####2.2.1.1 Programming Language
The software must be written in Java, language level 1.6 or 1.7.

#####2.2.1.2 Third-party libraries
The software shall not make use of special/non-standard libraries. 
All code required to execute the program that is not part of the  standard JDK, shall be included as source 
code with the program.

#####2.2.1.3 Compilation
The source shall must compile with the `javac` command; without providing any compiler options.

####2.2.2 Execution

#####2.2.2.1 Runtime environment 
The application shall work on machine with a vanilla installation of Java 1.6 or Java 1.7.

#####2.2.2.2 Application Entry Point
The software is a Java application having a main() method.

#####2.2.2.3 Execution
The application shall be executable from the command prompt using the `java` command.

#####2.2.2.3 Usability
The application shall be easy to use and have user-friendly error messages rather than having error codes

#####2.2.2.4 Documentation
The application shall be accompanied by help documentation that indicates how to use the tool, troubleshooting 
information and details around the various error messages.