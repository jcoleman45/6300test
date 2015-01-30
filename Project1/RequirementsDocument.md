# **Requirements Document -- Team 26**

##1 User Requirements

This software is designed for use by students of a university who would like to calculate the average number of words 
of their essays. The users will have access to our application "AverageSentenceLength". They expect to pass the file
path to the essay in raw text format and some configuration parameters on the command-line and get the average
number of words as output.

###1.1 User Characteristics

> General characteristics of the intended users of the product, including educational level, experience, and technical
> expertise.

There will be about 270 college students who may use this application per semester. Their computer expertise varies from
no experience at all to being proficient programmers.

###1.2 System's functionality

> Requirements written from the point of view of end users, usually expressed in narrative form.

The users will identify the path to their essay in raw text format and use it as as a command-line parameter. As part
of the command-line parameters, they have the option to customize the minimum word length and sentence delimiters to be
used. If the users' input is not according to what the software expects, helpful error messages should be returned to
help them use the tool correctly. If the command-line parameters are valid, the software returns the average number of
words per sentence.

###1.3 User Interfaces

> Interfaces between the software product and its users; that is, how the users will interact with the system.

The users are required to have the Java Runtime Environment installed, with a version of at least 1.6. They will 
run the software on the command-line using the `java` command. The input data will be specified by passing a path to a
file in raw text format on the command-line. The two customizations available are specified by command-line parameters 
as well.

This is a draft of the envisioned user interface:
 
````
java -jar AverageSentenceLength.jar [-d <delimiters>] [-l <min_length>] <file_path>
````

The option arguments are:
- **delimiters:** (optional) Specify sentence delimiters - defaults to: .?!
- **min_length:** (optional) Specify minimum word length (inclusive) - defaults to: 3

The software will return the average number of words per sentence, rounded down to the nearest integer.

##2 System Requirements

> These subsections contain all the software requirements at a level of detail sufficient to enable
> designers/developers to design/develop a system that satisfies those requirements, and testers to test that the system
> satisfies those requirements. This part of the document should provide a numbered (possibly hierarchical) list of
> simple, complete, and consistent functional and non-functional requirements.

This software should be an application running with Java 1.6 or a later version. It is developed to analyze the average
words of sentences in ASCII format file. It should have a main method and contain a command line without other options.
The code must be written in Java and must use standard Java libraries. All code in this program that is not the part of
JDK, should be included as source code with the program.
 
###2.1 Functional Requirements

####2.1.1 Command-line interface

#####2.1.1.1 File path

The file path is specified by the user as the single command-line argument.

#####2.1.1.2 Delimiters

A flag `-d` will be used to specify the punctuation of a raw text. Periods, question marks, exclamation points,
semicolons, and colons are default delimiters. Comma is not to be used as a default sentence delimiter.

#####2.1.1.3 Minimum word length

A flag `-l` will be used to specify a lower limit for word length. This application will only count words greater than or
equal to 3 characters.

#####2.1.1.4 Error messages
Reasonably friendly, helpful messages should be returned in various error cases:
- Invalid file path
- File inaccessible
- Invalid usage of command-line parameters

####2.1.2 Input file format
The file should be ASCII format.

####2.1.3 Output
The software returns the average number of words per sentence, rounded down to the nearest integer.

###2.2 Non-Functional Requirements

####2.2.1 Compilation

#####2.2.1.1 Programming Language
The software must be written in Java, language level 1.6 or 1.7.

#####2.2.1.2 Third-party libraries
The software must not make use of non-standard libraries. If non-JDK code is used anyhow, it must be included
as source code.

#####2.2.1.3 Compilation
The source code must compile with the `javac` command; without providing any compiler options.

####2.2.2 Execution

#####2.2.2.1 Runtime environment 
The application works on machine with a vanilla installation of Java 1.6 or Java 1.7.

#####2.2.2.2 Application Entry Point
The software is an application having a main method.

#####2.2.2.3 Execution
It should be executable from the command line using the `java` command.

#####2.2.2.3 Usability
The application should be easy to use and friendly to users.
