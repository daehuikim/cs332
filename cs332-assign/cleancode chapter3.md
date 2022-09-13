
# Summary of Clean Code Chapter 3: Functions
___

## Contents
- [Small!](#small-)
- [Do One Thing](#do-one-thing)
- [One Level of Abstraction per Function](#one-level-of-abstraction-per-function)
- [Switch Statements](#switch-statements)
- [Use Descriptive names](#use-descriptive-names)
- [Function Arguments](#function-arguments)
- [Have No Side Effects](#have-no-side-effects)
- [Command Query Separation](#command-query-separation)
- [Prefer Exceptions to Returning Error Codes](#prefer-exceptions-to-returning-error-codes)
- [Don't Repeat Yourself](#don-t-repeat-yourself)
- [Structured Programming](#structured-programming)
- [How Do You Write Functions Like this?](#how-do-you-write-functions-like-this-)



### Small!
* The first rule of functions is that they should be small. The second rule of functions is that they should be smaller than that.
* Every functions should be short like in 5 lines. (Example below)
```
public static String renderPageWithSetupsAndTeardowns(
 PageData pageData, boolean isSuite) throws Exception {
 if (isTestPage(pageData))
 includeSetupAndTeardownPages(pageData, isSuite);
 return pageData.getHtml();
 }
```
#### * Blocks and Indenting
* the indent level of a function should not be greater than one or two.
* Not only does this(Blocks and Indenting) keep the enclosing function small, but it also adds documentary value

### Do One Thing
* **FUNCTIONS SHOULD DO ONE THING.**
* The reason we write functions is todecompose a larger concept into a set of steps at the next level of abstraction.
* Functions that do one thing cannot be reasonably divided into sections.

### One Level of Abstraction per Function
* Mixing levels of abstraction within a function is always confusing.
#### * Reading Code from Top to Bottom:The Stepdown Rule
* It is the key to keeping functions short and making sure they do “one thing.” Making the code read like a top-down set of TO paragraphs is an effective technique for keeping the abstraction level consistent.
### Switch Statements
* Even a ```switch``` statement with only two cases is larger than I’d like a single block or function to be. 
* How ever, we can't always avoid ```switch``` statements
* we shoyld make each ```switch``` statement buried in a low-level class and never repeated.

### Use Descriptive names
* Better descriptive names describes better what the functions does.
* Choosing good names for small functions that do one thing helps to use descriptive names.
* Don’t be afraid to make a name long. A long descriptive name is better than a short enigmatic name. 
* Don’t be afraid to spend time choosing a name. Be consistent in your names.

### Function Arguments
* The ideal number of arguments for a function is
zero.
* Three arguments (triadic) should be avoided where possible
* Arguments are hard. They take a lot of conceptual power.
* Arguments are even harder from a testing point of view


### Have No Side Effects
* Your function promises to do one thing, but it also does other hidden things. Sometimes it will make unexpected changes to the variables of its own class.
*  If your function must change the state of something, have it change the state of its owning object. 

### Command Query Separation
* Functions should either do something or answer something, but not both.
* The real solution is to separate the command from the query so that the ambiguity cannot occur.

### Prefer Exceptions to Returning Error Codes
* Returning error codes from command functions is a subtle violation of command query separation.
* . When you return an error code, you create the problem that the caller must deal with the error immediately.
* So it is better to extract the bodies of the ```try``` and ```catch``` blocks out into functions of their own.
* A function that handles errors should do nothing else.

### Don't Repeat Yourself
* Duplication may be the root of all evil in software.
* Many principles and practices have been created for the purpose of controlling or eliminating duplication.


### Structured Programming
* Dijkstra said that every function, and every block within a function, should have one entry and one exit.
* So if you keep your functions small, then the occasional multiple ```return```, ```break```, or ```continue``` statement does no harm and can sometimes even be more expressive than the single-entry, single-exit rule.

### How Do You Write Functions Like this?
* Writing software is like any other kind of writing.
* In the end, I wind up with functions that follow the rules I’ve laid down in this chapter. I don’t write them that way to start. I don’t think anyone could.