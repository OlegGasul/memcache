Very simple implementation of key-value storage. 

## Getting Started

*To run this app, you need Java 8

Check this project out, cd into the directory and run:

    ./gradlew run

This will start the ratpack app. In your browser go to <http://localhost:5050>.

## IDEA integration

The Ratpack Gradle plugin has special support for [IntelliJ IDEA](http://www.jetbrains.com/idea/download/). To open the project in IDEA, run:

    ./gradlew idea

In the “Run” menu, you will find a run configuration for launching the Ratpack app from within your IDE. Hot reloading
is supported in this mode. See `src/main/groovy/groovywebconsole/ReloadingThing.groovy` for details.

## Working with API

### Setting data by key
POST /data/{key}
Body should contains data

### Retrieving data by key
GET /data/{key}

### Searching documents

POST /search
Body should contains tokens separated by comma (for example: "word1 word2" should find all documents contain both words)