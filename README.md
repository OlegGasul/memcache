Very simple implementation of key-value storage. 

## Getting Started

*To run this app, you need Java 8

Check this project out, cd into the directory and run:

    ./gradlew run

This will start the ratpack app. In your browser go to <http://localhost:5050>.

## IDEA integration

The Ratpack Gradle plugin has special support for [IntelliJ IDEA](http://www.jetbrains.com/idea/download/). To open the project in IDEA, run:

    ./gradlew idea

## Working with API

### Setting data by key
POST /data/{key}

Body should contains data

```
curl -d "test1 test2" -X POST http://localhost:5050/data/key1
```

### Retrieving data by key
GET /data/{key}

```
curl http://localhost:5050/data/key1
```

### Searching documents

POST /search

Body should contains tokens separated by comma (for example: "word1 word2" should find all documents contain both words)

```
curl -d "test1" -X POST  http://localhost:5050/search
```