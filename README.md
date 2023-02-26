# Code Sharing Platform

## Description
Code Sharing Platform is a platform which people can submit new Codes and check latest codes and get specific code. it also shows the time and view restrictions and the date of the code submission, you can get specific code by their id in HTML format or JSON fromat. people can also get latest 10 codes or latest codes (which codes are less than 10) in JSON or HTML format. at the same time you can post code that takes JSON object. This project involves the server developement using Spring boot, and use some basic funtions of web programming language such as HTML, CSS to create the HTML interface and uses H2 database which makes no data get lost, when there is restriction triggered the data will be deleted from database.

### Examples
Get: /code/new

(get new code interface which can add restrictions to it)

![Alt text](img/GETNEW.png?raw=true "Create code")

Post: api/code/new

(post code to database and return the id of the code)

![Alt text](img/POST.png?raw=true "POST code")

Get: /code/{id}

(get specific code by their id)

![Alt text](img/GETID.png?raw=true "get id code")

Get: /code/latest

(get latest codes without the restrictions and ordered from latest post to earlier post)

![Alt text](img/GETLATEST.png?raw=true "get latest codes")
