# RestApiTest

http://localhost:8080/restapp/rest/api - rest endpoint.
POST request receive files from parameter named "files".
GET request send JSON respons wich contents name of row and the number of repetitions.

DB - MySql. File with DDL commands in root folder.

AS - WildFly. Folder org/mysql/main need to copy in modules folder (mysql jdbc connector).
standalone.xml - config file for WildFly (added new datasource and managed-executor-service properties).
