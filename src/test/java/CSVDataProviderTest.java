import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;
import org.testng.annotations.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class CSVDataProviderTest extends BaseTest {

    @DataProvider(name = "getCredentialsData")
    // Method to read the data from .csv file and return it as array
    public Object[][] getData() throws Exception {
        // path to csv file that is located under resources folder
        Reader reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "/src/test/resources/credentials.csv"));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> records = csvReader.readAll();
        Object[][] array = null;
        for (int i = 0; i < records.size(); i++) {

            Object[] row = records.get(i);
            if (Objects.isNull(array)) {
                array = new Object[records.size()][row.length];
            }
            array[i][0] = row[0];
            array[i][1] = row[1];
        }
        return array;
    }

    @Test(dataProvider = "getCredentialsData")
    // test that uses data from csv file
    public void negativeLoginTests(String email, String password) {
        login(email, password);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
