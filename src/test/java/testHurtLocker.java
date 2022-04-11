import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class testHurtLocker {

    @Test
    public void getStringTest() throws Exception {
       // List<String> shopping = new ArrayList<>();
        String firstString = JerksonParser.getStringFromResult((new Main()).readRawDataToString());
        Assert.assertEquals("naMe", firstString);
    }

   // @Test
//    public void getKeyValuePairsTest() throws Exception {
//        String keyValuePairsString = JerksonParser.getKeyValuePairs((new Main()).readRawDataToString());
//        Assert.assertEquals("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016",keyValuePairsString);
//    }

   // @Test
//    public void getFirstGrocItem() throws Exception {
//        String keyValuePairsString = JerksonParser.getFirstGrocItem((new Main()).readRawDataToString());
//        Assert.assertEquals("Milk",keyValuePairsString);
//    }

}
