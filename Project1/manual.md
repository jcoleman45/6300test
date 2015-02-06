# **Average Sentence Length User Manual -- Team 26**

##1 Overview
This user manual contains all essential information for the user to make full use of the `Average Sentence Length`
tool. `Average Sentence Length` is an application that counts the average number of words in the sentences of 
essays/text. Users can input their essay text files through the Java command line, and the application will return
the average number of words per sentence, rounded down to the nearest integer. Helping obtain the average length of
sentences in terms of the number of words will help improve the writing style of the essays.

##2 System Prerequisites 

- Windows / Mac OS X / Linux
- Java Runtime Environment (JRE) 1.6 or 1.7. No other third party libraries are required
- The `Average Sentence Length` application is installed in a folder within the user machine
- Essay text(s) should be normal text file(s) with default encoding

##3 System Capabilities

###3.1 Introduction
`Average Sentence Length` is a Java application that is run on the command line. As part of command-line parameters,
users have the option to customize the `minimum word length` and `sentence delimiters` that need to be used to evaluate
the essay. If the user input is not according to what the software expects, helpful error messages are returned. If 
the command is valid, the software returns the average number of words per sentence for the particular essay. 

###3.2 Running the application

The application is run on the command prompt and command usage is given below.

````
java -cp . edu.gatech.seclass.prj1.Main [-d <delimiters>] [-l <min_length>] <file_path>
````

| Command Argument               | Description                                                                         |
| ------------------------------ | ----------------------------------------------------------------------------------- |
| `java -cp`                     | Java command to run the application                                                 |
| `.`                            | Directory/Folder location of the application                                        |
| `edu.gatech.seclass.prj1.Main` | Application name                                                                    |
| `[-d <delimiters>]`            | *delimiters:* (optional) Specify a list of sentence delimiters - defaults to: `.?!` |
| `[-l <min_length>]`            | *min_length:* (optional) Specify minimum word length (inclusive) - defaults to: `3` |
| `<file_path>`                  | (mandatory) File name (includes folder path) that contains the text file            |

For optional arguments,

- `-d` : Sentence delimiters are specified without any spaces. Ex - `.;:`. This will override the default delimiters `.?!`
- `-l` : Value of `min_length` should be a valid integer greater than 0. This will override the default value of 3

###3.3 Examples

Few valid application execution examples are given below

````
java -cp . edu.gatech.seclass.prj1.Main InputEssay1.txt
````

````
java -cp C:\Tools\AppInstallationFolder edu.gatech.seclass.prj1.Main InputEssay2.txt
````

````
java -cp . edu.gatech.seclass.prj1.Main D:\Essays\Essay1.txt
````

````
java -cp . edu.gatech.seclass.prj1.Main \Users\User1\MyWork\EducationEssay.txt
````

````
java -cp . edu.gatech.seclass.prj1.Main -d #$: InputEssay3.txt
````

````
java -cp . edu.gatech.seclass.prj1.Main -l 4 InputEssay4.txt
````

````
java -cp . edu.gatech.seclass.prj1.Main -d +#; -l 2 InputEssay5.txt
````

````
java -cp . edu.gatech.seclass.prj1.Main -l 5 -d ,: InputEssay6.txt
````

````
java -cp . edu.gatech.seclass.prj1.Main InputEssay7.txt -d ?!. -l 4 
````

````
java -cp . edu.gatech.seclass.prj1.Main InputEssay8.txt -l 3 -d ,:! 
````

###3.4 Application Output

The software will return the average number of words per sentence, rounded down to the nearest integer. Sample outputs
are given below

````
Average number of words per sentence in the file - InputEssay7.txt : 7
````

````
Average number of words per sentence in the file - D:\Essays\Essay10.txt : 10
````

````
Average number of words per sentence in the file - \Users\User1\MyWork\ScienceEssay.txt : 8
````

##4 Troubleshooting

This section provides various error scenarios and possible solutions.

###4.1 `Java` command not recognized in the command prompt

Java Runtime Environment may not be installed or is corrupted. For more information on how to install JRE (1.6/1.7), 
please refer to the Java documentation [here](http://docs.oracle.com/javase/8/). Post installation, the setup needs to 
be validated as given below.

#####4.1.1 Windows
The JRE executable command `Java` needs to be available in the `System Path` environment variable to enable running 
of the application from any folder within the user machine. Please refer to Microsoft Windows documentation on how to 
add an EXE to the `system path` environment variable if not present already.

#####4.1.2 Mac/Linux
The `Java` command will be available in the `command line` if the JRE is installed correctly. 

###4.2 Invalid usage of Command Line parameters

There are various errors that may be encountered if the application execution command is not specified correctly. The 
list of such error scenarios is given below for quick reference.

#####4.2.1 Missing delimiters
In the command line arguments, `-d` option is specified; but the actual delimiters are missing.

> ***`Could not start calculation: Missing delimiters`***
> 
> `Usage: java -cp . edu.gatech.seclass.prj1.Main [-d <delimiters>] [-l <min_length>] <file_path>`
> 
> `  delimiters: (optional) Specify a list of sentence delimiters - defaults to: .?!`
> 
> `  min_length: (optional) Specify minimum word length (inclusive) - defaults to: 3. Should be greater than 0`

#####4.2.2 Missing minimum word length
In the command line arguments, `-l` option is specified; but the `min_length` value is missing.

> ***`Could not start calculation: Missing min_length`***
> 
> `Usage: java -cp . edu.gatech.seclass.prj1.Main [-d <delimiters>] [-l <min_length>] <file_path>`
> 
> `  delimiters: (optional) Specify a list of sentence delimiters - defaults to: .?!`
> 
> `  min_length: (optional) Specify minimum word length (inclusive) - defaults to: 3. Should be greater than 0`

#####4.2.3 Invalid minimum word length
In the command line arguments, `-l` option is specified; but the `min_length` value is not a valid number.

> ***`Could not start calculation: Invalid min_length: <user specified min_length value>`***
> 
> `Usage: java -cp . edu.gatech.seclass.prj1.Main [-d <delimiters>] [-l <min_length>] <file_path>`
> 
> `  delimiters: (optional) Specify a list of sentence delimiters - defaults to: .?!`
> 
> `  min_length: (optional) Specify minimum word length (inclusive) - defaults to: 3. Should be greater than 0`

#####4.2.4 Minimum word length less than or equal to zero
In the command line arguments, `-l` option is specified; but the `min_length` value is less than or equal to zero.

> ***`Could not start calculation: min_length should be greater than 0`***
> 
> `Usage: java -cp . edu.gatech.seclass.prj1.Main [-d <delimiters>] [-l <min_length>] <file_path>`
> 
> `  delimiters: (optional) Specify a list of sentence delimiters - defaults to: .?!`
> 
> `  min_length: (optional) Specify minimum word length (inclusive) - defaults to: 3. Should be greater than 0`

#####4.2.5 Missing `<file_path>` argument
In the command line arguments, the file name (`<file_path>`) is not specified.

> ***`Could not start calculation: Missing filename`***
> 
> `Usage: java -cp . edu.gatech.seclass.prj1.Main [-d <delimiters>] [-l <min_length>] <file_path>`
> 
> `  delimiters: (optional) Specify a list of sentence delimiters - defaults to: .?!`
> 
> `  min_length: (optional) Specify minimum word length (inclusive) - defaults to: 3. Should be greater than 0`

###4.3 Input text file issues

Essay text file does not exist or wrong folder path is specified.

> ***`Could not start calculation: Specified file does not exist OR wrong filename`***
> 
> `Usage: java -cp . edu.gatech.seclass.prj1.Main [-d <delimiters>] [-l <min_length>] <file_path>`
> 
> `  delimiters: (optional) Specify a list of sentence delimiters - defaults to: .?!`
> 
> `  min_length: (optional) Specify minimum word length (inclusive) - defaults to: 3. Should be greater than 0`

If there are any issues in accessing the essay text file (Ex - insufficient security permissions, file Locked etc...),
a Java IO exception stack trace is given so that the appropriate issue is reported. 

> ***`Could not start calculation: Error reading text file`***

> [Java IO Exception - Stack Trace]
> 
> `Usage: java -cp . edu.gatech.seclass.prj1.Main [-d <delimiters>] [-l <min_length>] <file_path>`
> 
> `  delimiters: (optional) Specify a list of sentence delimiters - defaults to: .?!`
> 
> `  min_length: (optional) Specify minimum word length (inclusive) - defaults to: 3. Should be greater than 0`

##5 Technical Support
For more technical support, please get it touch with the support team. The team contacts are give below

| Name         | Email               |
|--------------|---------------------|
| Yuchun Qin   | yqin47@gatech.edu   |
| Ganesh S     | ganesh30@gatech.edu |
| Cedric Meury | cedric@meury.com    |
| Yue Li       | liyue2011@gmail.com |
