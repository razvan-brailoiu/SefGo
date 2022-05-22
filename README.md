# SefGo

# Our hybrid work employee scheduler app:
## This app lets you: (when logged in as a normal employee)
-> log in\
-> pick the dates in which you are coming to office in the next month\
-> see who else is coming in each day (maybe you want -or not- to meet the others)\

## This app lets you (when logged in as a system admin)
-> log in\
-> manage normal employees' accounts (add a new one, change password, delete, view all)\
-> generate a monthly report to see who comes in each day at work\

# Technology used
-> Java & Java FX version 18\
-> Maven as a build system\
-> Nitrite as database\

# How to run
-> clone the repository\
-> run: mvn clean install\
-> then you can either run: mvn javafx:run\
-> or you can execute the jar file as: java --module-path "pathToJavaFxLibrary" --add-modules javafx.controls,javafx.fxml -jar .\maven-example.jar



