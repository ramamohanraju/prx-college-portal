# prx-college-portal
College portal service : Backend

Data model:
![Alt text](data-model.png?raw=true "Data model")

Tech stack:
- Java
- Springboot
- Swagger
- H2 db(using just to keep it simple to run project)

Urls:
- Swagger: http://localhost:8080/swagger-ui
- H2-ui: http://localhost:8080/h2-ui

Things to implement further:
- Use postgres db
- Interfaces for services and DAOs
- Authentication using auth0 or ocka
- I could accept the file as multipart file type and blob type in the database but, currently I am using url as content
 upload to avoid using db to store videos and webinars
- Implement content storage such as s3 or minio to upload videos and webinars
- More unit tests
- Better exception handling

