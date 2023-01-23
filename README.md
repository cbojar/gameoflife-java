# Conway's Game of Life in Java

An implementation of Conway's Game of Life in Java using a Swing GUI.

## How to build

Java 17+ and maven are required to build this application.

```
mvn pacakge
```

Outputs a JAR file in the `target/` directory.

## How to run

```
java -jar target/gameoflife-0.0.1-SNAPSHOT.jar
```

## How to play

On start, a random world is generated. At the bottom, there is a pause button to pause the game, and a slider to control
the speed of the game. Clicking in the game area adds new cells at the pointer position. From the top menu, the world
can be cleared, or a new world can be generated.
