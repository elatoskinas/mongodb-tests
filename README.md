# mongodb-tests
Some MongoDB Java Driver & Morphia testing to see how things work in MongoDB & Java.

# Classes of interest
## testModel
Contains a test model for a small database. Based on [Intermine's data model](https://github.com/intermine/intermine)

## abstractModel
A completely abstract model that is only used for demonstration purposes of the MongoDB Java Driver

## mongoTesting
Contains all the MongoDB Java testing functionality

### SimpleTests
Tests based on the MongoDB Java Driver. The rest are based on Morphia.

### LoadTestData
Loads test data into the "testdb" database based on the testModel.

### MappingTests
Test Java Object mapping to MongoDB using Morphia

### QueryingTests
Test Morphia querying
