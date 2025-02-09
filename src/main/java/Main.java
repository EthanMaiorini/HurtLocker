import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

//    public static String getStringFromResult(String readRawDataToString) {
//        int x =0;
//        String result = "";
//        String patternString = "[':',';','@','^','*','%']";
//        Pattern pattern = Pattern.compile(patternString);
//        Matcher matcher = pattern.matcher(readRawDataToString);
//        if(matcher.find())
//           x = matcher.start();
//        for (int i = 0; i< x;i++){
//            result += readRawDataToString.charAt(i);
//        }
//        return result;
//    }

//    public static String getKeyValuePairs(String readRawDataToString){
//        int x =0;
//        String result = "";
//        String patternString = "##";
//        Pattern pattern = Pattern.compile(patternString);
//        Matcher matcher = pattern.matcher(readRawDataToString);
//        if(matcher.find())
//            x = matcher.start();
//        for (int i = 0; i< x;i++){
//            result += readRawDataToString.charAt(i);
//        }
//        return result;
//    }

    public static String readRawDataToString() throws Exception{
        ClassLoader classLoader = Main.class.getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }



    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        GroceryList groceryList = new GroceryList();
        List<String> groceries = new ArrayList<>();
        groceries = JerksonParser.getJerksonStrings(output);
        for(String s : groceries){
            groceryList.put(JerksonParser.createObjectFromString(s));
        }
        System.out.println(groceryList);
        groceryList.sortbyName();
        groceryList.getGroceryList();


    }
}
