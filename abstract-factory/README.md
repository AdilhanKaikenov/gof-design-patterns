Abstract Factory is a creational design pattern that lets you produce families of related objects without 
specifying their concrete classes.

The Abstract Factory pattern suggests identifying common interfaces for individual products that make up a family.

![abstract-factory-01](https://raw.githubusercontent.com/AdilhanKaikenov/gof-design-patterns/master/abstract-factory/etc/abstract-factory-01.png)

For each variant of a product family, we create a separate factory class based on the AbstractFactory interface. 
A factory is a class that returns products of a particular kind. For example, the ModernFurnitureFactory can 
only create ModernChair, ModernSofa and ModernCoffeeTable objects.