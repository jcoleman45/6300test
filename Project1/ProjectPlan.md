# **Project Plan -- Team 26

##1 Introduction

```The introduction provides context for the project. Write a concise description of the software you will develop and its target users.```

The project involves development of a tool named "Average Sentence Length" for use by students in a university. Typically the students in the University write essays which have long and very wordy sentences. This tool would help the students improve their writing style by helping them count the average number of words in the sentences of their essays.

The application will be a Java language based executable that can be run from the command prompt. The application will take an ASCII text file that contains the essay as input, will parse all sentences of the essay and will output the average number of words considering all sentences. 

##2 Process Description

```Process description as a set of activities; for each activity, provide the following:```

```- Activity name (verb or verb phrase)```
```- Activity description (concise paragraph)```
```- Entrance criteria (inputs needed for the activity)```
```- Exit criteria (outputs produced by the activity and how you know it has been completed satisfactorily)```

The software development methodology planned to be used is the waterfall-process. Specifically, the following activities are planned for the complete execution of this project : 

**Plan Project:** This phase includes the overall planning of activities for the whole project such as regular project meetings to build the team and to get the activity updates, outline the whole process and define individual and team responsibilities etc... A project plan (current document) will be drafted by the project manager and approved by the team. The project plan will be tracked on an ongoing basis until the completion of the project. Metrics will be captured as and when necessary.

Entry Criteria

- Request for creation of a software application for use by university students
- Set of team members
- Instructor notes on what are the end deliverables required for the assignment (plan, requirements, design, code, documentation etc...)

Exit Criteria

- Finalized Project Plan document
- Agreed project roles for the individuals
- Agreed project execution methodology
- Agreed timelines for the execution of various activities
- Project plan to be uploaded to github repository

**Define Requirements:** The user requirements and system requirements will be identified during this phase. The Documentation lead will be responsible for the overall documentation with support from all team members with respect to review.

Entry Criteria

- Project plan
- Verbal requirements as specified in the conversation videos
- Instructor notes regarding requirements

Exit Criteria

- Detailed requirements specification (functional and non-functional)
- Requirements document review and approval by all team members
- Requirements questions if any to be posted to Laura (in T-Square) for more clarity
- Requirements specification to be uploaded to github repository

**Develop Software:** The software will be developed using Java technology. The code will be shared and managed using Github version control repository. An agreed design will be documented before starting coding. Intermediate code reviews will be performed before testing. The code shall be unit-tested by all development team members.

Entry Criteria

- Project plan
- Requirements specification

Exit Criteria

- Agreed documented application architecture/design
- Source code for the application including JUnit test cases (based on design).
- Approval of development completion by development lead
- Unit testing of source code using JUnit. Unit testing is performed to check critical code logic and also give a code coverage of 60% or above 
- Design document, working source code & unit tests shall be uploaded to github repository

**Verify software:** The software will be tested through various test cases using JUnit tool and also through manual testing. The QA manager will prepare test scenarios and test cases along with test input data like raw text files that contains the essays. This will include various input combinations like different delimiters etc... to verify each functionality. The QA manager will work with the development lead to fix defects and make sure all tests are passed. The code coverage details will also be validated. The defects will be classified as critical/major/minor/cosmetic.

Entry Criteria

- Project plan
- Requirements specification
- Architecture/Design document

Exit Criteria

- Agreed test cases (integration, system, unit etc...) that test each requirement. This will be part of "Test Cases" document.
- Sample test data preparation and agreement by the QA manager
- Test completion report
- Approval of test completion by QA manager
- No critical/major/minor defects.
- All artifacts will be uploaded to github repository

**Write User Manual:** Detailed user guides will be documented and released with the software. It will contain both usage guide and troubleshooting information for the software. The content will be written by the documentation lead and reviewed by all team members.

Entry Criteria

- Project plan
- Requirements specification
- Architecture/design document
- Test Cases document

Exit Criteria

- User manual document
- Review and agreement of user manual by all team members
- Approval from documentation lead
- All artifacts will be uploaded to github repository

##3 Team

```Describe the team and their roles (there may be more roles than there are team members)```

```- Team members' names```
```- Roles, with a short description of each role```
```- Table showing which team member(s) has which role(s)```

Project team structure is given below along with their roles and responsibilities:

###Project manager (Yuchun Qin)
The project manager are responsible for setting goals and tracking the whole progress. This role drafts the project plan. 

###Development lead (Cedric Meury)
The development lead writes the Java code for the Java Application, and manages merges of different branches.

###Documentation lead (ganesh.shivashankar)
The documentation lead manages the documentation systems and writes the requirements document and user manual.

###QA manager (Yue Li)
The QA manager will prepare test cases and write Junit code to tests/debugs the code and evaluates the quality of the application to meet all requirements.


##4 Estimates

```Provide estimates for the following metrics:```

```- Effort hours: total number of team-member hours you expect to spend on the project```
```- Lines of code: total number of lines of source code you expect to have in your final product```

We expect that this project should take a combined 25 team-member hours. In the final product, we expect 100 lines of code for the software, and 50 lines of code for testing.