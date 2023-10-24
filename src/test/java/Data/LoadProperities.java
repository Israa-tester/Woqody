package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperities {
    public static Properties userData= LoadProperities(System.getProperty("user.dir")+"\\src\\main\\java\\Properities\\UserData.properities");

    private  static Properties LoadProperities(String path){

        Properties pro = new Properties();
        //stream for reading file
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
        }catch (FileNotFoundException e){
            System.out.println("Error occur: "+ e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occur: "+ e.getMessage());
        } catch (NullPointerException e){
            System.out.println("Error occur: "+ e.getMessage());
        }
        return pro;
    }

}
