# README.MD
The company ACME offers their employees the flexibility to work the hours they want. But due to some external circumstances they need to know what employees have been at the office within the same time frame
The goal of this exercise is to output a table containing pairs of employees and how often they have coincided in the office.

Input: the name of an employee and the schedule they worked, indicating the time and hours. This should be a .txt file with at least five sets of data. You can include the data from our examples below:

Example 1:

INPUT
RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00- 21:00
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
ANDRES=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00

OUTPUT:
ASTRID-RENE: 2
ASTRID-ANDRES: 3
RENE-ANDRES: 2


Example 2:

INPUT:
RENE=MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU20:00-21:00
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00

OUTPUT:
RENE-ASTRID: 3

## Content
This proyect has two branches: develop1 and develop2. **develop1** contains the tests of the repositories and **develop2** contains the test of the use cases.
Este repositorio contiene la resolución del ejercicio de frecuencias de los empleados.

## Explanation
For the solution of the exercise, the Java programming language was used, together with the object-oriented paradigm.
In which the principle of encapsulation and inheritance was applied (To create my own exception in file handling).
In addition, the solution was modularized in different packages:
- files: Contains the text files of the string strings that are processed to analyze the frequency
- services: Contains the logic for handling files as well as carrying out the process for calculating frequencies.
- commons: Contains auxiliary methods and its own exceptions.
- test: It has a class together with JUnit to test the operation of the proposed solution.

# IDE
- Eclipse Neon.3 Release (4.6.3)

# Programming language
- Java

# Tests
- JUnit library version: JUnit 4 (org.junit_4.12.0.v201504281640)

### Notes
If you do not have JUnit, you must follow these steps:
* Right click on the project.
* We select Properties.
* We choose Java Build Path.
* We select the Libraries tab.
* We click on the Add Library button.
* In the dialog box we select JUnit.
* We click on accept.

## how to run the program locally?
Once the repository is cloned.
* Open Neon Eclipse.
* We select or create a Workspace.
* Once inside the workspace, we click on File.
* We select the option Open Projects From File System.
* In the dialog box that appears, we must navigate to the directory where the cloned project is located.
* We finish.

Una vez abierto el proyecto ingresamos al paquete test
* Damos clic derecho en la clase TestCalcularFrecuencias.
* Seleccionamos Rus as.
* Finalmente damos clic en JUnit Test.

## Preview
Here is an image with the test carried out in JUnit of the correct functioning of the exercise.
* Part 1
![](/code.png)
* Part 2
![](/test.png)

