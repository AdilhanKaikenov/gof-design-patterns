We use this pattern to avoid binding the sender of the request to its receiver and this gives us the 
ability to process this request with several objects.

***

Цепочка обязанностей — это поведенческий паттерн проектирования, который позволяет передавать запросы 
последовательно по цепочке обработчиков. Каждый последующий обработчик решает, может ли он обработать 
запрос сам и стоит ли передавать запрос дальше по цепи.

Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers. 
Upon receiving a request, each handler decides either to process the request or to pass it to the next handler 
in the chain.