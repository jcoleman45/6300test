# **Requirements Document -- Team 26

##1 User Requirements

This software is designed for students in a university to analyze the average sentence length in their essays. The users will have access to our application "AverageSentenceLength". They could be able to get a file path to the essay they wish to be analyzed as a command line argument. The output should be the average sentence length.

###1.1 Software Interfaces

```List all the external systems with which the software product interacts. These are external systems/libraries that you have to interact with.```

The application works on machine with Vanilla installation of Java 1.6 or above version. It should be executable from the command line using Java command.

###1.2 User Interfaces

```Specify the logical characteristics of each interface between the software product and its users. This is a description of how the system will interact with its users.```

The user interface will be the command line interface using Java command without any other options.  

###1.3 User Characteristics

```Describe those general characteristics of the intended users of the product, including educational level, experience, and technical expertise.```

There will be about 270 collage students who may use this application. They are different level computer users from no tech experience users to experts.

##2 System Requirements

```These subsections contain all the software requirements at a level of detail sufficient to enable designers/developers to design/develop a system that satisfies those requirements, and testers to test that the system satisfies those requirements. This part of the document should provide a numbered (possibly hierarchical) list of simple, complete, and consistent functional and non-functional requirements.```

This software should be an application running with java 1.6 or a later version. It is developed to analyze the average words of sentences in ASCII format file. It should have a main method and contain a command line without other options. The code must be written in Java and must use standard Java libraries. All code in this program that is not the part of JDK, should be included as source code with the program.
 
###2.1 Functional Requirements
####2.1.1 - File path/fomat
The file path is specified by user and accessible to the system. The file should be ASCII format. A friendly message will help user if the file path or file format is not valid.

####2.1.2 - Delimiters
A flag -d will be used to specify the punctuation of a raw text. Periods, question marks, exclamation points, semicolons, and colons are default delimiters. Comma is not to be used as a default sentence delimiter.

####2.1.3 - Minimum word length
A flag -l will be used to specify a lower limit for word length. This application will only count words greater than or equal to 3 characters.

  
###2.2 Non-Functional Requirements
The application should be easy to use and friendly to users.