
# Summary of Clean Code Chapter 2: Meaningful Names
___

## Contents
- [Use Intention-Revealing Names](#use-intention-revealing-names)
- [Avoid Disinformation](#avoid-disinformation)
- [Make Meaningful Distinctions](#make-meaningful-distinctions)
- [Use Pronounceable names](#use-pronounceable-names)
- [Use Searchable Names](#use-searchable-names)
- [Avoid Encodings](#avoid-encodings)
- [Avoid Mental Mapping](#avoid-mental-mapping)
- [Class names](#class-names)
- [Method Names](#method-names)
- [Don't Be Cute](#don-t-be-cute)
- [Pick One Word per Concept](#pick-one-word-per-concept)
- [Dont' pun](#dont--pun)
- [Use Solution Domain Names](#use-solution-domain-names)
- [Use Problem Domain Names](#use-problem-domain-names)
- [Add Meaningful Context](#add-meaningful-context)
- [Dont' Add gratuitous Context](#dont--add-gratuitous-context)



### Use Intention-Revealing Names
* Choosing good names takes time but saves more than it takes
* Change names when you find better names.
* If a name requires a comment, then the name does not reveal its intent
* Choosing names that reveal intent can make it much easier to understand

### Avoid Disinformation
* Programmers must avoid leaving false clues that obscure the meaning of code.
* Do not refer to a grouping of accounts as an ```accountList``` unless it’s actually a List. (```accountGroup``` or ```bunchOfAccounts``` or just plain accounts would be better.)
* Spelling similar concepts similarly is information. Using inconsistent spellings is disinformation.

### Make Meaningful Distinctions
* If names must be different, then they should also mean something different.
* Number-series naming ```(a1, a2, .. aN)``` is the opposite of intentional naming.
* Noise words are redundant. (Ex: The word ```variable``` should never appear in a variable
name.)

### Use Pronounceable names
* Programming is a social activity. Let's see 2 examples below
```
class DtaRcrd102 {
    private Date genymdhms;
    private Date modymdhms;
    private final String pszqint = "102";
    /* ... */
};
```
with these names, programmers can be seen stupid sometimes.
```
class Customer {
    private Date generationTimestamp;
    private Date modificationTimestamp;;
    private final String recordId = "102";
    /* ... */
};
```
now we can make intelligent conversation.

### Use Searchable Names
* Single-letter names and numeric constants have a particular problem in that they are not
easy to locate across a body of text
```
for (int j=0; j<34; j++) {
    s += (t[j]*4)/5;
}
```
to
```
int realDaysPerIdealDay = 4;
const int WORK_DAYS_PER_WEEK = 5;
int sum = 0;
for (int j=0; j < NUMBER_OF_TASKS; j++) {
    int realTaskDays = taskEstimate[j] * realDaysPerIdealDay;
    int realTaskWeeks = (realdays / WORK_DAYS_PER_WEEK);
    sum += realTaskWeeks;
}
```
* The intentionally named code makes for a longer function,but consider how much easier it will be to find ```WORK_DAYS_PER_WEEK``` than to find all the places where 5 was used and filter the list down to just the instances with the intended meaning.


### Avoid Encodings
* Encoding type or scope information into names simply adds an extra burden of deciphering.
#### * Hungarian Natation(HN)
* HN was considered to be pretty important back in the Windows C API, when everything was an integer handle or a long pointer or a void pointer, or one of several implementations of “string” (with different uses and attributes).
* Nowadays HN and other forms of type encoding are simply impediments. (name not changed when type changed!)
#### * Member Prefixes
* Nowdays we don't need to prefix member variables with m prifix anymore.
* The more we read the code, the less we see the prefixes. Eventually the prefixes become unseen clutter and a marker of older code.
#### * Interfaces and Implementations
* I prefer to leave interfaces unadorned like ```ShapeFactoryImp``` not ```IShapeFactory```. Because I don't think user should know about interface or implementations.

### Avoid Mental Mapping
* Readers shouldn’t have to mentally translate your names into other names they already know. 
* Professional understands that clarity is king. Professionals use their powers for good
and write code that others can understand. 

### Class names
* Classes and objects should have noun or noun phrase names

### Method Names
* Methods should have verb or verb phrase names

### Don't Be Cute
* Choose clarity over entertainment value. Cuteness in code often appears in the form of colloquialisms or slang. However it should not block meanings.

### Pick One Word per Concept
* Pick one word for one abstract concept and stick with it.
* The function names have to stand alone, and they have to be consistent in order for you to pick the correct method without any additional exploration.
* A consistent lexicon is a great boon to the programmers who must use your code.

### Dont' pun
* Avoid using the same word for two purposes.
*  Let’s say we have many classes where add will create a new value by adding or concatenating two existing values.
* Now let’s say we are writing a new class that has a method that puts its single parameter into a collection.
* ``` insert``` or ```append``` can be subtituted in this case

### Use Solution Domain Names
* Choosing technical names for those things is usually the most appropriate course.

### Use Problem Domain Names
* Separating solution and problem domain concepts is part of the job of a good programmer and designer.

### Add Meaningful Context
* You need to place names in context for your reader by enclosing them in well-named classes, functions, or namespaces.

### Dont' Add gratuitous Context
* Shorter names are generally better than longer ones, so long as they are clear
* Add no more context to a name than is necessary.
