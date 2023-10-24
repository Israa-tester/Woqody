import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;

public class RunnerMultiSuites {

    public static void main(String []args){

        List<String> xmlFiles = new ArrayList<String>();
        xmlFiles.add("./TestOrgs.xml");
        xmlFiles.add("./TestVehicle.xml");
        xmlFiles.add("./TestEmployee.xml");
        xmlFiles.add("./TestOffersDeals.xml");
        xmlFiles.add("./TestAds.xml");

        TestNG testNg = new TestNG();
        testNg.setTestSuites(xmlFiles);
        testNg.run();

    }
}
