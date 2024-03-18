We have a recipe in which we want to migrate a class usage of several library versions (class shifted packages) to a single usage of latest version. 
Refaster recipes look perfect for this as we can specify `Refaster.anyOf` to specify multiple similar but slightly different method calls.

We did not find any examples of non java SE usages with refaster. 

1. Publish libs project to maven local
2. Run `DownloadRecipeDependencies` from root project
3. Run `MigrateUnitTest` present in root project

See how this fails?

4. Look at generated `MigrateRecipe.java`. 
![Screenshot 2024-03-16 at 18.52.45.png](Screenshot%202024-03-16%20at%2018.52.45.png)
5. Notice how these Matchers do not `find` correctly
6. This is because `JavaTemplateSemanticallyEqual`'s try catch block has an exception.
![Screenshot 2024-03-18 at 09.12.30.png](Screenshot%202024-03-18%20at%2009.12.30.png)
