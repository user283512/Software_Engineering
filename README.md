# Create a new Maven project
1. Run the script `create_maven_project.sh`.
2. Enter the name of the project.
3. Warning: the archetype `maven-archetype-quickstart` is designed 
   to include JUnit 3 as the default testing framework.
   If you want to use Jupiter, you need to modify the `pom.xml` file.

# Useful Maven commands
1. Compile Java files: ```mvn compile```
2. Clean compiled files: ```mvn clean```
3. Run the application: ```mvn exec:java```
4. Run all tests: ```mvn test```