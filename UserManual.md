## Initializing the app

First, compile the java files using command 'javac Main.java Info.java Connector.java' inside 'src' directory. Then, run the app using command 'java Main'. If you are using Visual Studio Code, clone the repository as in and run.

## Scenarios and Commands 

Upon initialization, a message detailing the permissible commands will be displayed in the lobby:

    1) '-register' will prompt you for your info (email then username then password) then attempt to register your account in the database.

    2) '-signin' will prompt you for your username and password then attempt to sign you in by verifying your credentials in the database.
    
    3) '-quit' used to exit the program at any stage of operations, with the exception of the "Signed in" state, in which you'll have to sign out first.

Once signed in, any input will result in the message '<< User Activity >>', with the exception of '-signout' which will return you to the lobby.

## Software Environment

The app was made using Visual Studio Code in Java Runtime JDK 17.0.1.12 (Eclipse Temurin Hotspot).

The database was made using MySQL Workbench 8.0 CE and the server run locally using MySQL Server. The JDBC driver is MySQL Connector (Platform Independent, Architecture Independent) ver.8.0.27 for Java (jar file in 'src' folder).

Check 'scrnshot' folder to visualize operations.