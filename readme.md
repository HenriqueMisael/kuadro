#kuadro
Open source customizable simple task manager 
##Docs
###Commit
The commit message **must be** in english. The pattern is the general implementation followed by a explanation of the changes of the specific commit.
```
The problem i am working with: the changes i have mad in this specific commit
```
```
Card type registration: creation of the entity and base repository
```
##Code
###Code style
The code style must respect some rules, depending the class in question, and some generic rules.
* There will be a line break after the class declaration
```
class ClassName extends SuperClass {

    private SomeType someField;
```
* The code must be wrote in english
* There will be one line break separating all the methods
* There will be no line break separating fields for general rule


####Controller classes
* Must have a constant named `PATH` that will be filled with the base route for its features.
* Must be annotated with `RestController` and `RequestMapping`, this one that may had the value to the `PATH` constant and consume/produces `APPLICATION_JSON_VALUE` 
* All its dependencies must not be annotated with `AutoWired`. The dependency injection will be made in a single constructor having all of them.
* There will be only dependency of the *service layer*
####Service classes
* Must be annotated with `Service` 
* All its dependencies must not be annotated with `AutoWired`. The dependency injection will be made in a single constructor having all of them.
* May depend on either other services classes, repositories and other components
####Component classes
* Must be annotated with `Component` 
* All its dependencies must not be annotated with `AutoWired`. The dependency injection will be made in a single constructor having all of them.
* There will be only dependency of other components and repositories
###UnitTest classes
* Must extend the UnitTest class or any of its abstract subclasses
* The mocks may respect a order of declaration, and had a line break separating the first level declaration order:
  * Components hierarchy
    * Repositories
    * Components
    * Services
  * Other models, requests, etc
  * The subject
* The subject must be initialized manually by the constructor, passing to it the mocks.
