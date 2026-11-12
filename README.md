# orangehrm



## Convention 

### Properties data File
- Folder & File Name: 

  - Folder environment =>Contains environment properties file 
  - {enviromentName}.properties => Test data of specifc enviroment (e.g: dev.properties) 
  - common.properties => common test data across all enviroment 


  - Folder language =>Contains language properties file
  - {language}.properties => Test data of specifc language (e.g: dev.properties)
  - Note: prefix {language} must be equal system property value of -Dlanguage (e.g )
- Key Name:
  - lower case 
  - each word
  - separator of each word is underscore (_)