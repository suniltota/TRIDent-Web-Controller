#TRIDent-Web-Controller
This project defines the code for authentication and following services:

01. Closing Disclosure: JSON to UCD and vice versa.(Repo: TRIDent-CD) 
02. Closing Disclosure: PDF Generation.(Repo: TransformX-Service-UCD-ClosingDisclosurePdf) 
03. Loan Estimate: JSON to UCD and vice versa.(Repo: TRIDent-LE) 
04. Loan Estimate: PDF Generation.(Repo: TransformX-Service-UCD-LoanEstimatePdf) 
05. Calculations for projected payments.(Repo: TransformX-Service-UCD-CalculatePayments) 
06. UCD from templates: CSV and Text.(Repo: TransformX-Service-UCD-ConvertTemplate) 
07. UCD XML generation from super XML.(Repo: TransformX-Service-UCD-Trim)

Before building this service, we need to clone the following repos and build them.
	TransformX-Service-UCD-Trim
	TransformX-Service-UCD-LoanEstimatePdf
	TransformX-Service-UCD-ClosingDisclosurePdf
	TransformX-Service-UCD-ConvertTemplate
	TransformX-Service-UCD-CalculatePayments
	TRIDent-LE
	TRIDent-CD

After building the above services, each independently. Continue to build this service.

*failing to build one or more above services will fail this service while building*


This service runs on port :9020

To run the server ,enter into project folder and run

mvn spring-boot:run (or) java -jar *location of the jar file*

The above line will start the server at port 9020

If you want to change the port .Please start th server as mentioned below 

syntax : java -jar *location of the jar file* --server.port= *server port number*
 
example: java -jar target/trident.war --server.port=9090

API to login(/login) with input as parameters username and password

syntax : *server address with port*/login; method :POST; Header: Content-Type:application/json
Body: username:admin&&password:123456

example: http://localhost:9020/login ; method: POST; Header: Content-Type:application/json
Body: username:admin&&password:123456
