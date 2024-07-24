package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {


    private static String environment=null;
    private static String filePath=null;
    private static Properties prop=null;

    public Environment(String environmentName){
        environment=environmentName.toLowerCase();
        filePath="../config/"+environment+".properties";
    }

    public  String getUsername(){
        String username=null;
        try{
            FileInputStream file=new FileInputStream(filePath);
            Properties properties=new Properties();
            properties.load(file);
           return username= properties.getProperty("username");
        }catch (Exception e){
            throw new RuntimeException("File Not Found : "+filePath);
        }
    }
    public  String getPassword(){
        String password=null;
        try{
            FileInputStream file=new FileInputStream(filePath);
            Properties properties=new Properties();
            properties.load(file);
            return password= properties.getProperty("password");
        }catch (Exception e){
            throw new RuntimeException("File Not Found : "+filePath);
        }
    }
    public String getUrl(){
        String url=null;
        FileInputStream file=null;
        try{
            file=new FileInputStream(filePath);
            Properties properties=new Properties();
            properties.load(file);
            return url= properties.getProperty("url");
        }catch (Exception e){
            throw new RuntimeException("File Not Found : "+filePath);
        }finally {
            try {
                file.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public String getPersonalNumber(){
        String personalNumber=null;
        FileInputStream file=null;
        try{
            file=new FileInputStream(filePath);
            Properties properties=new Properties();
            properties.load(file);
            return personalNumber= properties.getProperty("personalNumber");
        }catch (Exception e){
            throw new RuntimeException("File Not Found : "+filePath);
        }finally {
            try {
                file.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
