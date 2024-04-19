STEP 1: go to src-> main -> resources -> create application.properties file and paste following details



stripe.secretKey=sk_test_51P5BzfSIi0f8AwLtHm05rgczoLqdNs4Cs5dFYg487wQJr4rtie3sE1uJLQbyLowEe7dKk40TjlvD6mnaP9iZTkmV00l2CrlMO3



# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/stripepaygateway?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=test

# Hibernate properties
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update


# Server port
server.port=8080




#How To TEST PAYMENT GATEWAY
# Provide this link into Postman   http://localhost:8080/payments/initiate?productId=2
#  click on Send
# under Body you will get  some code like    pi_3P5EimSIi0f8AwLt0IYBKQa7
# Go to stripe Account - Dashboard you will see the   transaction record







STEP 2:  go to target folder-> classes folder -> create a file application.properties file and paste following details 
          {Note- you will get all these details when you register on Twilio website.}


stripe.secretKey=sk_test_51P5BzfSIi0f8AwLtHm05rgczoLqdNs4Cs5dFYg487wQJr4rtie3sE1uJLQbyLowEe7dKk40TjlvD6mnaP9iZTkmV00l2CrlMO3



# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/stripepaygateway?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=test

# Hibernate properties
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update


# Server port
server.port=8080
