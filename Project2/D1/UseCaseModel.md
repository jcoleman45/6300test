# Use Case Model



**Author**: \<Team26\>

## 1 Use Case Diagram
A use case diagram is given below that shows the various actors, use cases and the interaction between them.

![Class Diagram Image](Images/usecasediagram.png)


## 2 Use Case Descriptions

Use case descriptions are given below that describe each use case' requirements, pre-conditions, post-conditions, and scenarios that characterize each use case.
### 2.1 UC1: ADD CUSTOMER
- Requirements: This use case allow stall manager to add a new customer.

- Pre-conditions: The application is running. Customer provided his/her personal information.

- Post-conditions: Customer information is added.

- Scenarios:Stall manager gets the customer information. Stall manager add customer to application and saves information
to database. 

### 2.2 UC2: EDIT CUSTOMER
- Requirements: This use case allows stall manager to edit customer's account information.

- Pre-conditions: The application is running. The customer information is already loaded.

- Post-conditions: The database for customer is updated.

- Scenarios: Stall manager looks up customer information, selects the correct customer, edits information, and saves to
database. 

### 2.3 UC3: GET TRANSACTION HISTORY
- Requirements: This use case allows stall manager to view any customer's transaction history.

- Pre-conditions: The application is running. The customer is not new. The customer information is
already loaded.

- Post-conditions: None.
- Scenarios: Stall manager selects transaction history and the system displays a list of purchases with detail (date,
amount, whether discounts were applied and which ones).


### 2.4 UC4: SEND DOLLAR REWARD EMAIL
- Requirements: In this use case, system could send email to customers for 10 dollars rewards.

- Pre-conditions: The customer's information is in the data base. System is connected with an email service software.
Single transaction is $100 or more.
- Post-conditions: Email is send. The $10 dollar reward is added in the customer's account for future purchase.

- Scenarios: Customer spent $100 or more in a single purchase.Then he or she gets a $10 discount towards a future
purchase as a reward. System sends an email to the customer.

### 2.6 UC6: SEND GOLD STATUS EMAIL
- Requirements: In this use case, system could send email to customer who reached gold status.

- Pre-conditions: The customer's information is in the data-base. The customer's total purchase in a calendar >=$1000.
System is connected with an email service software. 

- Post-conditions: The customers status updates to "Gold". System send an email to the customer. The customer could get
5% discount on every purchase.

- Scenarios: Customers who spend $1000 or more in a calendar year achieve "gold" status, which entitles them to a 5%
discount for life and on every purchase. The change of status is effective immediately after reaching the specified
threshold. 

### 2.7 UC7: PERFORM TRANSACTION WITHOUT DISCOUNT
- Requirements: In this use case, system could make transaction without discount.

- Pre-conditions: Customer bought products. The customer is not gold status. The customer has no money discount in his
account. System is connected with credit-card scanning and payment processing softwares. 

- Post-conditions: System processes the transaction. Transaction history is updated. The customer's calendar purchase
is updated.
 
- Scenarios: Customer scans his/her credit card, and payment is completed without any discount.

### 2.8 UC8: PERFORM TRANSACTION WITH 5% DISCOUNT
- Requirements: In this use case, system could make transaction with 5% discount.

- Pre-conditions: Customer buys products. The customer's status is gold. System is connected with credit-card scanning
and payment processing softwares.

- Post-conditions: The 5% discount is applied in final transaction. Transaction history is updated. The customer's
calendar purchase is updated.

- Scenarios: Gold customer scans his/her credit card, and payment is completed with 5% discount.

### 2.9 UC9: PERFORM TRANSACTION WITH MONEY DISCOUNT
- Requirements: In this use case, system could make transaction with 5% discount.

- Pre-conditions: Customer buys products. The customer's status is not gold. The customer has money reward in his/her
account. System is connected with credit-card scanning and payment processing softwares.

- Post-conditions: Money discount is applied in final transaction. Transaction history is updated. The customer's
calendar purchase is updated. Money discount balance is updated.

- Scenarios: Customer scans his/her credit card, and payment is completed with money discount.

### 2.10 UC10: PERFORM TRANSACTION WITH 5% DISCOUNT & MONEY DISCOUNT
- Requirements: In this use case, system could make transaction with 5% discount and money discount.

- Pre-conditions: Customer buys products. The customer's status is gold. Customer has money reward in his/her account.
System is connected with credit-card scanning and payment processing softwares.

- Post-conditions: 5% discount is applied first, and then money discount is applied in final transaction. Transaction
history is updated. The customer's calendar purchase is updated. Money discount balance is updated.

- Scenarios: Customer scans his/her credit card, and payment is completed with 5% discount and money discount.

