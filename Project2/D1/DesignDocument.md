# Design Document

This document describes the architecture and design of the 'Payment and Rewards Management System for Mobile Stalls 
for Android' by capturing the details through UML diagrams such as component, deployment and class diagrams.

The document also captures the design constraints and assumptions.

**Author**: **Team26**

## 1 Design Considerations

*The subsections below describe the issues that need to be addressed or resolved prior to or while completing the
design, as well as issues that may influence the design process.*

### 1.1 Assumptions

*Describe any assumption, background, or dependencies of the software, its use, the operational environment, or
significant project issues.*

- It is assumed that the stall manager has a latest Android device to use the application. 
- Assumption is that the stall manager user is familiar with the Android OS and in using Android apps. 
- No specific user manual is provided with the application other than making the app user interfaces to be intuitive
for easier navigation. It is assumed that the user is aware of the complete set of requirements.
- Library classes such as Date, Currency etc... are not shown in the design. More preference is given to the usage
of standard Java library classes instead of custom implementations.
- This design document does not document the screenshots used. If time permits, they will be captured as part of 
user manual documentation.
- No automated test cases are implemented or code coverage is checked. Manual testing is conducted and only if
time permits, automated testing is implemented.

### 1.2 Constraints

*Describe any constraints on the system that have a significant impact on the design of the system.*

- This system is only supported for Android phones or tablets and the user interface is optimized for Android phones.
- The credit card scanner service and payment processing service (both external components) are assumed to be available
to the system. And hence these are not explicitly implemented. A external library is planned to be used here.
- The email functionality is not fully implemented/tested in the first iteration of the application. Only a stub
is implemented and if time permits, email functionality is integrated.
- The credit card information is not stored for each user explicitly. As and when a transaction is processed, the 
credit card details are associated for that transaction.

### 1.3 System Environment

*Describe the hardware and software that the system must operate in and interact with.*

- Eclipse IDE with an android simulator/android device is used to develop and test the application
- Eclipse Kepler or above is used for application development and JDK 1.6 or above is used
- The Payment and Rewards Management Android application is targetted for Android API versions between 16 and 19

## 2 Architectural Design

*The architecture provides the high-level design view of a system and provides a basis for more detailed design work.
These subsections describe the top-level components of the system you are building and their relationships.*

### 2.1 Component Diagram

*This section should provide and describe a diagram that shows the various components and how they are connected. This
diagram shows the logical/functional components of the system, where each component represents a cluster of related
functionality. In the case of simple systems, where there is a single component, this diagram may be unnecessary; in
these cases, simply state so and concisely state why.*

A high level application component diagram is given below that shows the various application components, their interfaces
and the interaction between them.

![Class Diagram Image](Images/componentdiagram.png)

- The complexities regarding `E-Mail service`, `Credit card scanner` and `Payment-Processing Provider` services are 
hidden as they are not explicity implemented in this system. 


### 2.2 Deployment Diagram

*This section should describe how the different components will be deployed on actual hardware devices. Similar to the
previous subsection, this diagram may be unnecessary for simple systems; in these cases, simply state so and concisely
state why.*

- TO BE ADDED - 

## 3 Low-Level Design

*Describe the low-level design for each of the system components identified in the previous section. For each component,
you should provide details in the following UML diagrams to show its internal structure.*

The main components associated with the application are desribed below

- Customer, Transaction and Reward classes
	- A class diagram is specified in section 3.1 that describes the individual entities, attributes, method and their
	relationships.
- E-Mail service
	- The email service utility class is used to encapsulate the functionality of sending emails. It typically uses
	the Android email utility library functions to send emails. 
	- The actual sending of emails is an optional implementation and for the initial version, only a stub is provided.
	- The basic attributes need for sending the email includes an `email-id`, `subject` and `email-content`.
- Credit Card Scanner service
	- This component is not elaborated and it is assumed that a library or external service is available that performs
	the scanning of the credit card
	- The external service returns the `card holder name`, `credit card number`, `expiration date` and `security
	code` after scanning the credit card
- Payment Processing Provider service
	- This component is also not elaborated and it assumed that a library or external service is available.
	- This service processes the payment on the credit card for the specified amount and returns a TRUE or FALSE
	based on the success/failure of completing the credit card transaction. If successful, the exact time of the 
	transaction is returned and if failure, an error code/error message is returned for the calling method.
- Note : Data architecture (E-R diagrams, SQL Lite details) are not described in detail

### 3.1 Class Diagram

*In the case of an OO design, the internal structure of a software component would typically be expressed as a UML class
diagram that represents the static class structure for the component and their relationships.*

The class diagram for the payment and rewards management system is given below. Note that this diagram only captures the
main entities that relate to the requirements. Implementation level classes like the Android library classes, config 
classes and entities are not captured in this diagram. This diagram will be updated as and when the application is
implemented to keep it up to date.

![Class Diagram Image](Images/teamdesign.png)

- The `CustomerManager` and `PaymentManager` classes are implemented to separate the complex functionalities (separation
of concern).
- A `Discount` base is implemented so that there is scope for additional type of discounts to be added in future.
Currently only the absolute discount and gold member discounts are available.
- The processed discounts are tied to transactions.
- The implementation level attributes (ex - lists etc...) are not shown in the class diagram.