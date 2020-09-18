Factory Method is a creational design pattern that provides an interface for creating objects 
in a superclass, but allows subclasses to alter the type of objects that will be created.

The idea is that there is some kind of abstract class or interface that returns an object 
(we do not know which one), which object to return we define in the implementation classes.

The Factory Method pattern suggests that you replace direct object construction calls 
(using the new operator) with calls to a special factory method. 

![factory-method-01](https://raw.githubusercontent.com/AdilhanKaikenov/gof-design-patterns/master/factory-method/etc/factory-method-01.png)

For this system to work, all returned objects must have a common interface. 
Subclasses will be able to produce objects of different classes following the same interface.

![factory-method-02](https://raw.githubusercontent.com/AdilhanKaikenov/gof-design-patterns/master/factory-method/etc/factory-method-02.png)

Use the Factory Method pattern when:

* Class cannot anticipate the class of objects it must create.
* Class wants its subclasses to specify the objects it creates.
* Classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.