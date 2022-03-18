# DemoCrud
*********************************************************
In order to CREATE  token :
*********************************************************
Method = POST,
URL    = http://localhost:8080/authenticate

Json for request :

{
    "username":"javainuse",
    "password":"password"
}

As this is one demo, there is no real user creation, 
it is hardcoded and crypted user name and password 
for demo purpose.
**********************************************************
In order to use token please use heder parameter ,
KEY = Authorization, Value = Bearer <your token go here>
**********************************************************
