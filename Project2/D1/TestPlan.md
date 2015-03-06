# Test Plan

*This is the template for your test plan. The parts in italics are concise explanations of what should go in the
corresponding sections and should not appear in the final document.*

**Author**: \<yli801\>

The purpose of this test plan is to define testing strategies to include all the functional and non-functional
requirements; techniques used to select test cases and ensure coverage; bug tracking procedures and lastly list test cases at each test levels.

## 1 Testing Strategy

### 1.1 Overall strategy

*This section should provide details about your unit-, integration-, system-, and regression-testing strategies.
In particular, it should discuss which activities you will perform as part of your testing process, and who will
perform such activities.*

#### 1.1.1 Unit Testing Strategy

Unit testing will first be performed to ensure the functionality of each modules individually. Each method of each
classes willed be tested to ensure it behaves exactly as expected. Unit test cases will be prepared by the QA manager
based on the requirement specifications and executed by application developers during software construction phase.
Thus any faulty module can be fixed immediately rather than let it exist and then cause some major issue in the
integration phase.


#### 1.1.2 Integration Testing Strategy

Integration testing confirms that each piece of the application interacts as designed and that all functionality is
working. Integration testing includes interactions between all layers of an application, including interfaces to other
applications, as a complete end-to-end test of the functionality. Integration test cases will be prepared and executed
by QA manager and should cover all possible interactions or paths between each modules. Other team members will review
the test cases to make sure the functional coverage.


#### 1.1.3 System Testing Strategy

The purpose of system testing is to make sure that the software system developed complies with the definition of the
software requirements. QA manager will be preparing test cases that cover all scenarios for the requirements and these
will also be reviewed by other team members.

#### 1.1.4 Regression Testing Strategy

Regression testing is to make sure that the software behaves well after code revision. Retesting for fixed bugs will be
done by QA manager and resolved by respective developer.Not only test cases that focused on the changed software
components should be retested, other modules should also be checked cause defects may propagated to other modules. 


### 1.2 Test Selection

*Here you should discuss how you are going to select your test cases, that is, which black-box and/or white-box
techniques you will use. If you plan to use different techniques at different testing levels (e.g., unit and system),
you should clarify that.*

### 1.3 Adequacy Criterion

*Define how you are going to assess the quality of your test cases. Typically, this involves some form of functional or
structural coverage. If you plan to use different techniques at different testing levels (e.g., unit and system), you
should clarify that.*

### 1.4 Bug Tracking

*Describe how bugs and enhancement requests will be tracked.*

### 1.5 Technology

*Describe any testing technology you intend to use or build (e.g., JUnit, Selenium).*

## 2 Test Cases

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test
case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual
result (to be filled later), pass/fail information (to be filled later), and any additional information you think is
relevant.*

| Purposes | Steps | Expected Result | Actual Result | Pass/Fail |
|-------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|---------------|-----------|
| SystemMain -> CustomerManagement | In system main, click manage customers button | go to customer management page |  |  |
| SystemMain -> PaymentManagement | In system main, click manage payments button | go to payment management page |  |  |
| Customer management -> Customer via add customer | In customer management, select add customer; input customer info and confirm | go to customer page with the newly created customer |  |  |
| Customer management -> Customer via edit customer | In customer management, select edit customer; edit customer info and confirm | go to customer page with edited customer information |  |  |
| Customer management -> Customer via get customer | In customer management, select get customer; input customer info and confirm | go to customer page of the requested customer |  |  |
| Customer management will not add duplicate customer | In customer management, select add customer; input customer info of an old customer and confirm | show "Customer already exist" and not create a duplicate sutomer |  |  |
| Getcustomer show error if no customer is found | In customer management, select get customer; input customer info and confirm | return no matched customer found |  |  |
| Payment management -> Transaction via listPayments | In payment management, select list payment; input customer info and confirm | show history of all transactions of the customer |  |  |
| Payment management -> Transaction via processPayment | In payment management, select process payment; input customer info, payment amount | go to transaction page of the new transaction showing correct date, amount and rewardsApplied |  |  |
| Payment management show error if no customer is found | In payment management, select process payment; input customer info, payment amount | return error (customer not found) |  |  |
| Payment management show null for a customer without transaction records | In payment management, select list payment; input customer info and confirm | return no matched customer found |  |  |