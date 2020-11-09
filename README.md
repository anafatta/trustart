# Trustart

###Implementation

I used an outside-in methodology to implement the functionality using IDD (Interaction Driven Design).
I defined three different actions:

1) ConnectToRepository:  Open a github connection to the mitre repository.
2) RetrieveFile: Passing a path (folder+nameFile) retrieves a String with the json information.
3) FindWords: Use the DetectPatternAttackThree implementation which implement the findPattern method.

###Second Step

It would be necessary to use for example Vert.x to expose rest endpoints to call each action.

###Question Five

If it is only necessary, for example, to use a github repository implementation, we can scale with a queue to handle a large number of requests (AWS SQS),
and horizontally with a series of microservices or k8s pods to process the queued data.
But if the application is scaled with different repositories, we can use Apache Kafka and depending on the producer that generate the stream we can annotate it with a topic and process it with different consumers.
