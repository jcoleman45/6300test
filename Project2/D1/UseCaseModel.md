# Use Case Model

*This is the template for your use case model. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: \<Team26\>

## 1 Use Case Diagram

*This section should contain a use case diagram with all the actors and use cases for the system, suitably connected.*

## 2 Use Case Descriptions

*For each use case in the use case diagram, this section should contain a description, with the following elements:*

- *Requirements: High-level description of what the use case must allow the user to do.*
- *Pre-conditions: Conditions that must be true before the use case is run.*
- *Post-conditions Conditions that must be true once the use case is run.*
- *Scenarios: Sequence of events that characterize the use case. This part may include multiple scenarios, for normal, alternate, and exceptional event sequences. These scenarios may be expressed as a list of steps in natural language or as sequence diagrams.*

### 2.1 UC1: ADD CUSTOMER
- Requirements: This use case allow stall manager to add a new customer.

- Pre-conditions: Stall manager already logged onto the system. Customer provided his/her personal information.

- Post-conditions: Customer information is added.

- Scenarios:Stall manager got the customer information. Stall manager added customer to application and saved information to database. 

### 2.2 UC2: EDIT CUSTOMER
- Requirements: This use case allow stall manager to edit customer's account information.

- Pre-conditions: Stall manager already logged onto the system. The customer information is already loaded.

- Post-conditions: The database for customer is updated.

- Scenarios:Stall manager looked up customer information, selected the correct customer, edited information, and saved to database. 

### 2.3 UC3: GET TRANSACTION HISTORY
- Requirements: This use case allow stall manager to view any customer's transaction history.

- Pre-conditions: Stall manager already logged onto the system. The customer is not new. The customer information is already loaded.

- Post-conditions: None.

- Scenarios: Stall manager selects transaction history and the system displays a list of purchases with detail (date, amount, whether discounts were applied ,which ones).
- 
### 2.4 UC4: SEND EMAIL
- Requirements:

- Pre-conditions: 

- Post-conditions:

- Scenarios:

### 2.5 UC5: APPLY DISCOUNT
- Requirements: 

- Pre-conditions: 

- Post-conditions:

- Scenarios:

### 2.6 UC6: MAKE TRANSCATION
- Requirements: 

- Pre-conditions: 

- Post-conditions:

- Scenarios: