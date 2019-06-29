Creating a custom repository
=============================================

In order to truly understand the simplicy of spring Data JPA,
we must take a trip to a not so distant past andlearn ho concrete 
repositories were create before Spring Data JPA was released.


Creating a custom repository in the old school way.
=======================================================

Traditionally, the creation of concrete repositories has been a process that 
includes six steps.  The re as follows:


1. Create a base class that provides  property mappings for its subclasses.
2. Create a generic repository interface that declares the methods shared by all 
   repositories.  typically these methods provide CRUD operations for our entities

3. Create a generic repository.
4. Create an entity class 
5. Create an entity specific repo interface
6. Create an entity specific concrete repo


First, we have to create an abstract base class that is extended by each
entity class.

We can create this class by following these steps: