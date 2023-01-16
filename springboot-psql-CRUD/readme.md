###### GET
Request url: localhost:8080/api/v1/students/

Response Body:
{
    "studentList": [
        {
            "id": 1,
            "name": "A"
        },
        {
            "id": 2,
            "name": "B"
        },
        {
            "id": 3,
            "name": "C"
        },
        {
            "id": 7,
            "name": "K"
        }
    ]
}


###### GET
Request url: localhost:8080/api/v1/students/{id}

Response Body:
{
  "success"
}



###### POST

Request url: localhost:8080/api/v1/students/{name}

Request Body:
{
  "name":"K
}

Response Body:
{
  "success"
}


