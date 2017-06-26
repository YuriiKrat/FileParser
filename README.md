# File Parser

## HOW TO RUN AND TEST

* Clone repository with `git clone https://github.com/YuriiKrat/FileParser.git` 
* Configure and deploy it with Tomcat Server 
* Import mysql dump file. Run `mysql -u <username> -p parse_result < dump.sql` in project root directory.
* Start Tomcat Server
* Use postman and send GET request to `http://localhost:8080/result`
* Attach files for parsing (there are test files `test` folder or you can choose yours) and attach them to request body as a form-data defining key as `files`. Then send POST request to `http://localhost:8080/upload`