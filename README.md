# Personal Budget
Project is a home budget management tool to control your personal expenses and incomes

## Table of Contents
* [Technologies Used](#technologies-used)
* [Features](#features)



## Technologies Used

- Spring Boot Framework 2 
- Hibernate 5.4.6
- Thymeleaf - version 3.0
- MySQL - version 8.0.25 
- Lombock - version 1.5
- Opencsv 4.6 
- Bootstrap 5

## Features
Import transactions:
- Import of CSV formatted financial transactions from the banks. Currently supports only ING Bank.
- Excluding of duplicates
- Confirmation of successful upload of CSV data and displaying in the report quantity information for found/recognised of new and previously added transactions, execution time of CSV data processing.


Аnalytics:
- Returns a list of transactions
- View of details of each transaction
- Displaying of each transaction details
- Sum up of income and expenses by specific filters
- Possibility of set a category and subcategory for each transaction
- Filter by:
  - categories
  - subcategories
  - date range 
- Search engine shows records containing a special string.

Categories and subcategories:
-  CRUD functionality
