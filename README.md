Very simple implementation of key-value storage. The tokens are words in the documents.
For simplicity each document separated on words just by space. 

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

GET /search/{queryString}

The queryString parameter should contains topics separated by space

```
curl -d "test1" -X GET  http://localhost:5050/search/test1%20test2
```