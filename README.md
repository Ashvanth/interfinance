# interfinance

This is a spring boot application , which has a json file "shorting.json" in resouce folder
By starting the application , all the values in the json file is insterted into a H2 in memory database which can be accessed with below URL

http://localhost:8080/h2-console/

1) http://localhost:8080/shortings/listFromApi -- Consumes all the results as JSON from https://ssr.finanstilsynet.no/api/v2/instruments

2) http://localhost:8080/shortings/allShortings -- Fetches all the values from the above API from a H2 in memory database.

3) http://localhost:8080/shortings/listByISIN/(ISIN) -- gives only the result of the provided ISIN value