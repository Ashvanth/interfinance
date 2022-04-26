## Spring Boot JSON Demo

1) This is a springboot application consuming an endpoint https://ssr.finanstilsynet.no/api/v2/instruments 
2) clone this repo , maven build and run as spring boot application (spring-boot:run) , incase of build or complailation failure , please include gson2.8.2.jar to the buildpath .
3) http://localhost:8080/shortings/fullShortings - this URL will return the whole result from the API .
6) http://localhost:8080/shortings/listByISIN/BMG9156K1018 - URL to consume ISIN value as path variable and return results including all the EVENTS of 
7) http://localhost:8080/shortings/BMG9156K1018/2022-04-04 - URL to return all the events for the given ISIN value and Date of events .

TO BE DONE 

1) Additionally there should be an option to limit the events based on a fromDate and toDate parameter.





