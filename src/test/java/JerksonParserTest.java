import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class JerksonParserTest {

@Test
    public void testStringLength() {
        String x = "milk";
        int y = JerksonParser.stringLength(x);
        Assert.assertEquals(4,y);
    }

    @Test
    public void createObjectFromStringTest() throws Exception {
        //String firstString = JerksonParser((new Main()).readRawDataToString());
        List<String> groceries = JerksonParser.getJerksonStrings((new Main()).readRawDataToString());
        Grocery test = new Grocery("Milk","3.23","Food","1/25/2016");
        Grocery actual = JerksonParser.createObjectFromString(groceries.get(0));
        System.out.println(actual.toString());
        Assert.assertEquals(test,actual);

    }
}