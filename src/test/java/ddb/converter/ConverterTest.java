/**
 * 
 */
package ddb.converter;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author tatsunori_nishikori
 *
 */
public class ConverterTest {

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        Converter converter = new Converter();
        String dataFilePath = ConverterTest.class.getClassLoader()
                .getResource("ddb/converter/sample_ddb.json").getPath();
        try {
            JSONArray ddbData = Converter.ddbJSONFileReader(dataFilePath);
            System.out.println(ddbData);
            assert ddbData.length() > 0;
            JSONObject row = ddbData.getJSONObject(0);
            String sql = Converter.createInsertQuery("tb_user_list", row);
            assert sql.indexOf("INSERT") > -1;
            // DBDriver driver = new DBDriver("mysql", "localhost", "3306",
            // "ddb_sample", "ddb_sample", "ddb_sample");
            // driver.execute(sql);
        } catch (IOException e) {
            e.printStackTrace();
            // } catch (ClassNotFoundException e) {
            // e.printStackTrace();
            // } catch (SQLException e) {
            // e.printStackTrace();
        }
    }

}
