
![composite-01](https://raw.githubusercontent.com/AdilhanKaikenov/gof-design-patterns/master/composite/etc/Composite-UML-and-object-diagram.jpg)   

![composite-02](https://raw.githubusercontent.com/AdilhanKaikenov/gof-design-patterns/master/composite/etc/UML-class-diagram.jpg)

Component  
* is the abstraction for all components, including composite ones
* declares the interface for objects in the composition
* (optional) defines an interface for accessing a component's parent in the recursive structure, and implements it if that's appropriate
  
Leaf  
* represents leaf objects in the composition
* implements all Component methods  

Composite  
* represents a composite Component (component having children)
* implements methods to manipulate children
* implements all Component methods, generally by delegating them to its children