# DAOFAB-Assignment

Steps to run assignment project.

1. Clone this respository : git clone https://github.com/sanket-lathiya/DAOFAB-Assignment.git
2. Go to root directory of the project.
3. Build the project : mvn clean install
4. Run the project : java -jar ./target/daofab-0.0.1-SNAPSHOT.jar
5. Varify assignment tasks.

First Task Rest Api : GET : http://localhost:8080/daofab-api/v1/parent-transactions?page=0&size=3

Sample response :
[
    {
        "id": 1,
        "sender": "ABC",
        "receiver": "XYZ",
        "totalAmount": 200,
        "totalPaidAmount": 100
    },
    {
        "id": 2,
        "sender": "XYZ",
        "receiver": "MNP",
        "totalAmount": 100,
        "totalPaidAmount": 100
    },
    {
        "id": 3,
        "sender": "XYZ",
        "receiver": "MNP",
        "totalAmount": 300,
        "totalPaidAmount": 260
    }
]



Second Task Rest Api : GET : http://localhost:8080/daofab-api/v1/child-transactions/{parentId}

Sample response for parentId=1 :
[
    {
        "id": 1,
        "sender": "ABC",
        "receiver": "XYZ",
        "totalAmount": 200,
        "paidAmount": 10
    },
    {
        "id": 2,
        "sender": "ABC",
        "receiver": "XYZ",
        "totalAmount": 200,
        "paidAmount": 50
    },
    {
        "id": 3,
        "sender": "ABC",
        "receiver": "XYZ",
        "totalAmount": 200,
        "paidAmount": 40
    }
]



Author
Sanket Lathiya (sanketlathiya7@gmail.com)
