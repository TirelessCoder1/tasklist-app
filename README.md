[mysql-schema.zip](https://github.com/TirelessCoder1/tasklist-app/files/8805798/mysql-schema.zip)
## tasklist-app
Task/TODO list application, using Java/Spring, Angular and MySQL



### Built With

* Java/Spring
* Gradle
* Hibernate
* MySql
* Angular
* Bootstrap
* Typescript

### Getting Started

Prerequisites:
* Java SE 11
* MySql 5.6
* Gradle 7.4.2 (can be installed with sdk)
* Angular 13
* Node.js 18

All needed packages/dependecies can be installed with npm or yarn


### Installation

	1. Clone the repo:
	git clone https://github.com/TirelessCoder1/tasklist-app.git
	2. Install NPM packages:
	npm install
	3. Import MySql schema (attached to the project)


### Usage

Note: By now only backend part is fully operational, so tests can be done with advanced REST client (I`ve been using the next one: https://install.advancedrestclient.com/install)

Tests:
* Get request - get task/category with http://localhost:<port>/task/all   or http://localhost:<port>/category/all
* Post request - add task/category with http://localhost:<port>/task/add or http://localhost:<port>/catgeory/add
* Put request - update task/category with http://localhost:<port>/task/update or http://localhost:<port>/category/update
* Delete request - delete task/category with http://localhost:<port>/task/delete or http://localhost:<port>/category/delete

The same tests are also available for priority and stat tables.


### TODO:
	1. Frontend part. Currently I am getting familiar with Angular and TS, so only a part of the planned functionality is completed
	2. Code improvements of backend part
