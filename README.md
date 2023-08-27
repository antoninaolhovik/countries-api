# Countries API
This API is the responsible for retrieving information about countries via a RESTful API. Countries API performs calls 
to a public [REST COUNTRIES](https://restcountries.com/) API and optimizing data collection by performing filtering rules 
and pagination functionality. It allows users to consume only necessary data in selected amounts.
Countries API allows sorting data to consume the data more seamlessly and effectively.
## Features

- Filter countries by country name
- Filter countries by country population (less than specified number in the millions of people)
- Sort countries by country name
- Limit numbers of records in response

## Run in local
Before running in local please ensure you have met the following requirements:
* Java Development Kit (JDK) 8 or later is installed.

## Run Locally

Clone the project
```bash
  git clone https://github.com/antoninaolhovik/countries-api.git
```

Go to the project directory

```bash
  cd countries-api
```

Build the project using Maven

```bash
  ./mvnw clean install
```

Run the application

```bash
  ./mvnw spring-boot:run
```
Once the application is running, open your web browser and navigate to http://localhost:8080 to access the application.

## Usage/Examples

* Get all countries without filters
```bash
curl -X 'GET' 'http://localhost:8080/api/countries'
```
* Get all countries without filters sorted ascending
```bash
curl -X 'GET' 'http://localhost:8080/api/countries?sort=ascend'
```
* Get all countries without filters sorted descending
```bash
curl -X 'GET' 'http://localhost:8080/api/countries?sort=descend'
```
* Get all countries without filters sorted and limited by numbers of records
```bash
curl -X 'GET' 'http://localhost:8080/api/countries?sort=ascend&pageSize=10'
```
* Get countries filtered by country name
```bash
curl -X 'GET' 'http://localhost:8080/api/countries?countryName=spa'
```
* Get countries filtered by country population (less than specified number in the millions of people)
```bash
curl -X 'GET' 'http://localhost:8080/api/countries?population=10' 
```
* Get countries filtered by country name and population (less than specified number in the millions of people)
```bash
curl -X 'GET' 'http://localhost:8080/api/countries?countryName=sp&population=50'
```
* Get countries filtered by country name limited by numbers of records
```bash
curl -X 'GET' 'http://localhost:8080/api/countries?countryName=st&pageSize=10'
```
* Get countries filtered by country population limited by numbers of records
```bash
curl -X 'GET' 'http://localhost:8080/api/countries?population=50&pageSize=10'
```
* Get countries filtered by country name, population, sorted and limited by numbers of records
```bash
curl -X 'GET' 'http://localhost:8080/api/countries?countryName=Ch&population=50&sort=ascend&pageSize=5'
```
