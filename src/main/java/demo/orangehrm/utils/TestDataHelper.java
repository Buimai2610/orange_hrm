package demo.orangehrm.utils;

import demo.orangehrm.pages.BasePage;

import java.util.Properties;

public class TestDataHelper {
    private final static  String dataLocation = "src/test/resources/data/";
    private final static  String languageDatalocation = String.format("%s%s", dataLocation, "language/");
    private final static  String enviromentDatalocation = String.format("%s%s", dataLocation, "enviroment/");

    private final static Properties dataProperties = new Properties();
    public static String getDataOf (String dataKey){
        if(dataProperties.isEmpty()){
            TestDataHelper testDataHelper = new TestDataHelper();
            testDataHelper.loadEnviromentTestData();
            testDataHelper.loadLanguageTestData();
        }
 //       String result = dataProperties.getProperty(dataKey);
 //       return result = result ==null ? dataKey : result;
       return dataProperties.getProperty(dataKey);
    }
    public  void loadEnviromentTestData(){
        String filePath;
        String commonFilePath = enviromentDatalocation + "common.properties";
        String testEnv = System.getProperty("testEnv", "production");
        switch (testEnv){
            case "dev":
                filePath = enviromentDatalocation + "dev.properties";
                break;
            case "staging":
                filePath = enviromentDatalocation + "staging.properties";
                break;
            case "production":
                filePath = enviromentDatalocation + "production.properties";
                break;
            default:
                throw  new RuntimeException(String.format("Unsupport test enviroment %s", testEnv));
        }
        Properties commonProperties =new  FileUtil().readPropertiesFile(commonFilePath);
        Properties specificEnvProperties =new  FileUtil().readPropertiesFile(filePath);
        dataProperties.putAll(commonProperties);
        dataProperties.putAll(specificEnvProperties);
        Log.info(TestDataHelper.class, "test Data of enviroment", "\n", commonProperties );


    }
    public  void loadLanguageTestData (){
        String testedLanguage = BasePage.testedLanguage;
      //  String testedLanguage = System.getProperty("language", "english");
        String filePath = languageDatalocation + testedLanguage + ".properties";
        Properties specificLanguage =new  FileUtil().readPropertiesFile(filePath);
        dataProperties.putAll(specificLanguage);
        Log.info(TestDataHelper.class, "Test data of language", "\n", specificLanguage);


    }
}
