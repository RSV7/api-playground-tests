# sergei-radkevich
API testing

**To run tests we need to set up**
- Install Node.js
- Clone BestBuyAPI Playground project git clone https://github.com/bestbuy/api-playground/
- Go to api-playground folder in terminal
- execute command **npm install**
- execute command **npm start**

**Preconditions**

1. make sure you have oracle-java(environment variables etc.)
2. make sure you have Apache Maven(environment variables etc.)
3. open terminal
4. clone current project
5. go to **api-playground-tests** folder

**Running**

- to run execute ***mvn test*** command in **api-playground-tests** folder in terminal

**Dependencies**
- testng to run test using TestNG
- rest-assured to executed the Requests






**Plan for automation**

Test cases for automation product/stores/services/categories

**1. Smoke tests** - that all pages responses 200

**2. Critical paths**
- Get all items - validate answer
- Get particular item - validate answer
- Create item - validate answer
- Delete item - validate answer
- Update item atributte - validate answer

**3. Not critical paths**
- Get all items and sort by price - validate answer
- Get all items and sort by name - validate answer
- Get all items and skip some number in the result - validate answer
- Get all items, but only show the name and price in the result - validate answer
- Delete items less than or equal to price - validate answer

**4. Negative cases**
- Get all items and sort by empty type of sorting - validate answer
- Get all items and with empty skip value - validate answer
- Get all items and with empty limit value - validate answer
- Add item with invalid data - validate answer
- Update item with invallid attribute - validate answer
- Delete item with invalid id - validate answer

**Next steps**
1. Separate data and logic (class Strings is ad-hock solution)
2. Can use config for that, to read data from config file
3. Automate POST, DELETE and PATCH scenarios
4. Automate negative scenarios
5. Parallelization with TestNg
