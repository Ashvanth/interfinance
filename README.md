## Spring Boot JSON Demo

1) This is a springboot applicaion which is using h2 database on startup 
2) clone this repo , maven build and run as spring boot application (spring-boot:run)
3) Source Json file downloaded from https://ssr.finanstilsynet.no/api/v2/instruments/export-json and is placed inside resource folder as "Shortings.json"
4) Once application is started, check the h2 database population http://localhost:8080/h2-console - JDBC URL - jdbc:h2:mem:users
5) http://localhost:8080//shortings/listFromApi - this URL will return the whole result from API - https://ssr.finanstilsynet.no/api/v2/instruments
6) http://localhost:8080//shortings/listByISIN/DK0060945467 - URL to consume ISIN value as path variable and return results 
7) http://localhost:8080//shortings/allShortings - URL to return all the values from Database 

TO BE DONE 

1) endpoints are only parent table values, this is to be fixed to return child entity values
2) endpoint to include data parameter to be included 
3) logic to find the same result with DB or entity to be implemented 
