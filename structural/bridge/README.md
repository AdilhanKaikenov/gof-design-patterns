Separate the abstraction from its implementation so that we can change both independently.

An example of a problem:  

![bridge](https://raw.githubusercontent.com/AdilhanKaikenov/gof-design-patterns/master/structural/bridge/etc/Bridge.jpg)

If in the future it will be necessary to add the Tractor interface, 
then for each model (Audi, Mercedes, Toyota) it will be necessary to create a separate implementation class, 
or if we need to add a new model and the number of classes will begin to increase rapidly.

```java 
interface Car {}
interface Track {}
interface Bike {}

class AudiCar implements Car {}
class AudiTrack implements Track {}
class AudiBike implements Bike {}

class MercedesCar implements Car {}
class MercedesTrack implements Track {}
class MercedesBike implements Bike {}

class ToyotaCar implements Car {}
class ToyotaTrack implements Track {}
class ToyotaBike implements Bike {}

```

![bridge-uml](https://raw.githubusercontent.com/AdilhanKaikenov/gof-design-patterns/master/structural/bridge/etc/Bridge-UML.jpg)
