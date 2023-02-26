# Code Sharing Platform

## Description
Code Sharing Platform is a platform which people can submit new Codes and check latest codes and get specific code. it also shows the time and view restrictions and the date of the code submission, you can get specific code by their id in HTML format or JSON fromat. people can also get latest 10 codes or latest codes (which codes are less than 10) in JSON or HTML format. at the same time you can post code that takes JSON object. This project involves the server developement using Spring boot, and use some basic funtions of web programming language such as HTML, CSS to create the HTML interface and uses H2 database which makes no data get lost, when there is restriction triggered the data will be deleted from database.

### Examples
Get: /code/new
![Image text](https://github.com/Xiaochen-Hua/Simple_Code_Sharing_Platform/tree/master/img/GETNEW.png)

Post: api/code/new
![Image text](https://github.com/Xiaochen-Hua/Simple_Code_Sharing_Platform/tree/master/img/POST.png)

Get: /code/{id}
![Image text](https://github.com/Xiaochen-Hua/Simple_Code_Sharing_Platform/tree/master/img/GETID.png)

Get: /code/latest
![Image text](https://github.com/Xiaochen-Hua/Simple_Code_Sharing_Platform/tree/master/img/GETLATEST.png)
