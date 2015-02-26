# ***Team 26 Project-2. Design Discussions***


## Individual Designs

#### Design-1
- Author : Cedic Meury
- Pros
	-	Hides complexities regarding ‘E-Mail Service’, ‘Credit Card Scanner’ and ‘Payment-Processing Provider’ correctly as per requirements. Simple design
	-	Captures entities (nouns), attributes (adjectives) and relations (verbs) correctly
- Cons
	-	CreditCard should be aggregated within Transaction (show aggregation line)
	-	Can create separate classes for Discounts/Rewards to support future expansions and to reduce complexity	
	-	Attribute holderName in CreditCard. Data type is having a typo. Should be ‘string’
 

#### Design-2
- Author : Ganesh S
- Pros
	-	Having CustomerManager and PaymentsManager results in separation of concern
	-	Having a separate EmailServer utility class
- Cons
	-	Discount can be split to have a base class with 2 child classes for each type of discount
	-	(Transaction – Amount) and (Discount – discountAmount) attributes can be double/Number
	-	CreditCardScanner and PaymentProcessingService should be components
	-	Remove ‘Email’ class as it encapsulates email functionality
	-	(Customer - Discount) multiplicity should be 0...2 (only 2 types of discounts - money, 5%)


#### Design-3
- Author : Yue Li
- Pros
	-	Having a separate utility class for Money. Can handle all complexities within this class
	-	Having a base class for ‘Reward’. This helps in future expansion to add more type of rewards
	-	Having Rewards within the transaction
- Cons
	-	TransactionList, Node and Transaction have been implemented like a linked list. This can be a simple relation using just 	a ‘list’ object and TransactionList, Node can be removed
	-	(Customer – Credit Card) relation should be a composition. Can be a temporary object for simplicity
	-	Does not capture ‘Email’ related attributes
	-	Also need a main application class that ties all the entities


#### Design-2
- Author : Yuchun Qin
- Pros
	-	The entities ‘Credit Card’, ‘Customer’ and their attributes are captured correctly
	-	The (Customer – RewardBalance) relation is correct
- Cons
	-	The functionalities (ex – ‘if’ conditions, add etc…) should not be shown in the relationships
	-	There should not be two relations between ‘Customer’ and ‘Transaction’
	-	‘Redeem’ and ‘Add’ can be operations in the entities rather than UML relation. And ‘10DollarReward’ can be a subclass of 	‘RewardBalance’
	-	Edit() operation in ‘Order’ may not be required. The ‘Order’ class can be removed
	-	Can show the components – CreditCardScanner and PaymentProcessingService


## Team Design

#### Main Commonalities and Differences

This section discusses the main commonalities and differences between this design and the individual ones, and justifies the main design decisions

- Do we need classes such as ‘Stall Manager’ / ‘System Main’ as in the individual class diagrams?
	-	We will definitely need a main class that ties all the child classes and has the overarching functionality. Maybe we can add Customer and Payment processor helper classes for having separation of concerns and to reduce complexity
	-	The Utility classes which are part of the standard Java/Android library need not be shown in the class diagrams. (Ex Money, Date, Time etc…)
- Email functionality is embedded in a utility class

#### Summary

This section summarizes the lessons learnt in the process of discussing the designs, in terms of design, team work etc…

- Understood the differences between aggregation and composition and this is depicted in the team design
- Elimination of classes available in the standard library
- The implementation level attributes are not shown in the design diagrams. Ex – Lists etc…
- The design is simplified to only include the requirements. Addition of domain knowledge and features can be done once the base application is ready
