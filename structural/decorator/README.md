Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these 
objects inside special wrapper objects that contain the behaviors.

“Wrapper” is the alternative nickname for the Decorator pattern that clearly expresses the main idea of the pattern. 
A wrapper is an object that can be linked with some target object. The wrapper contains the same set of methods as the 
target and delegates to it all requests it receives. However, the wrapper may alter the result by doing something either 
before or after it passes the request to the target.

When does a simple wrapper become the real decorator? As I mentioned, the wrapper implements the same interface as 
the wrapped object. That’s why from the client’s perspective these objects are identical. Make the wrapper’s reference 
field accept any object that follows that interface. This will let you cover an object in multiple wrappers, adding 
the combined behavior of all the wrappers to it.

***

Декоратор — это структурный паттерн проектирования, который позволяет динамически добавлять объектам новую функциональность, 
оборачивая их в полезные «обёртки».

Декоратор имеет альтернативное название — обёртка. Оно более точно описывает суть паттерна: вы помещаете целевой объект в 
другой объект-обёртку, который запускает базовое поведение объекта, а затем добавляет к результату что-то своё.

Оба объекта имеют общий интерфейс, поэтому для пользователя нет никакой разницы, с каким объектом работать — чистым или обёрнутым. 
Вы можете использовать несколько разных обёрток одновременно — результат будет иметь объединённое поведение всех обёрток сразу.