# Text Based OOP Search Engine

In this project I implemented inverted index method used in search engines. It reads thousands of documents and indexed data using hash table data structure.
After the indexing operation you can use search function to find a keyword and you get result in seconds. You can see the documents in which the keyword appears.

SSF and PAF Methods are used to generate hashcode from keywords. These classes implements an interface so that hash table class is loosely coupled to these classes. It doesn't have to know what kind of method should it use to generate hash code. It just implement required method parametrically.

Separated chaining, linear probing and double hashing methods are used for collision problems.

I also used factory design pattern, singleton pattern, polymorphism, interfaces and abstract classes for modularity.
