## Copy Hell

Comparison of different deep and shallow copy algorithms.
In order for the shallow copy to suffice in most cases the class has to contain only references to immutable objects and primitive fields.<br/><br/>
A "good way" to introduce mess to your project is to try copying an instance of `Collection` parametrized by another subtype of the `Collection` interface, eg. `List<List<String>>`.<br/><br/>
Here a well-thought deep cloning algorithm must come into play.
