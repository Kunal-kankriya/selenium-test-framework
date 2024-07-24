package utils;

import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelUtils {

    public ExcelUtils(String filePath){
        if(filePath!=null){
            try{
                FileInputStream file=new FileInputStream(filePath);
                WorkbookFactory.create(file);
            }catch (Exception e){

            }
        }

    }

}
