# javafx-text-to-speech
Application for reading text.
Demonstrates the use of FreeTTS library and JavaFX

## Build
gradlew build

## Run
java -jar build/libs/javafx-text-to-speech-1.0.jar


Follow this to create executables:

Maven
Follow these steps to create a JavaFX non-modular project and use the Maven tools to build it and run it.

Alternatively, you can download a similar project from here.

Make sure you have the Maven Integration for Eclipse m2e plugin installed, but Eclipse 2019-03 already ships by default the latest version.

Create a Maven project

Create a File -> New -> Project... -> Maven -> Maven project.

Create a Maven project The first time you will need to add the JavaFX archetypes:

Select Add Archetypes... and type: org.openjfx for the group id,  javafx-archetype-simple or javafx-archetype-fxml for the artifact id, and 0.0.1 for the version.

Add JavaFX archetypes Type org.openjfx in the filter field and select the archetype, between javafx-archetype-fxml or javafx-archetype-simple, based on the use of FXML or not in your project.

JavaFX Maven archetypes Provide the groupId, like org.openjfx, the artifactId, like hellofx.

You can edit the javafx-version property, and set it to 12.0.1.

JavaFX FXML archetype When the project opens, select the JDK 12 for the project (File -> Properties -> Java Build Path -> Libraries).

Set JDK For a non-modular project, you can remove the module-info.java file.


Now install Scene Builder (https://gluonhq.com/products/scene-builder/) to work with fxml files.

Follow this guide to understand how fxml works: https://code.makery.ch/it/library/javafx-tutorial/part1/


Now to create an executable jar use this:

https://stackoverflow.com/questions/31273829/javafx-8-how-to-build-exe-with-maven-inno

https://github.com/javafx-maven-plugin/javafx-maven-plugin

In a few words this is what I did:


Add this to your pom.xml within to your build-plugin:


```
<plugin>
    <groupId>com.zenjava</groupId>
    <artifactId>javafx-maven-plugin</artifactId>
    <version>8.8.3</version>
    <configuration>
        <mainClass>your.package.with.Launcher</mainClass>
    </configuration>
</plugin>
```
To create your executable file with JavaFX-magic, call mvn jfx:jar. The jar-file will be placed at target/jfx/app.
