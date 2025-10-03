# Streams Notes
Java Streams examples taken from Functional Programming in Java by Venkat Subramaniam

## Chapter 1. Change the way you think.
Discounted.java

The filter() method applied to the stream elements to 'match a predicate' e.g. boolean based condition.
The map() method applies the given function to each element of the collection (via the stream)
The reduce() is used to accumulate a result.

## Chapter 2. Using Collections
Imperative style vs Functional style.
Old style use external iterators. Mix how we do it with what we'd like to achieve. Explicitly control the iteration.
map() transforms and returns a collection of the transformation. We don't have to return a collection of what was passed e.g. we could return a numetric count of each in the collection.  




