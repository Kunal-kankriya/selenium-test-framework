package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class EnvConfig {

private static Properties properties;

    public static String getProperty(String property){
        String env=System.getProperty("env","qa");
        String pathString=System.getProperty("user.dir");
        Path path = Paths.get(pathString);
        Path parentPath = path.getParent();
        String parentPathString = parentPath.toString();
        String value="";
        if(env.equalsIgnoreCase("qa")){
           parentPathString =parentPathString+"\\src\\main\\resources\\qaConfig.properties";
        }else if(env.equalsIgnoreCase("dev")){
            parentPathString =parentPathString+"\\src\\main\\resources\\devConfig.properties";
        }
        try{
            FileInputStream fileInputStream=new FileInputStream(parentPathString);
            properties=new Properties();
            properties.load(fileInputStream);
           value= properties.getProperty(property);
        }catch (IOException e){

        }
        return value;
    }


}
