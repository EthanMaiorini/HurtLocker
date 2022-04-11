import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static String getStringFromResult(String readRawDataToString) {
        int x =0;
        String result = "";
        String patternString = "[':',';','@','^','*','%']";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(readRawDataToString);
        if(matcher.find())
           x = matcher.start();
        for (int i = 0; i< x;i++){
            result += readRawDataToString.charAt(i);
        }
        return result;
    }

    public static String getKeyValuePairs(String readRawDataToString){
        int x =0;
        String result = "";
        String patternString = "##";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(readRawDataToString);
        if(matcher.find())
            x = matcher.start();
        for (int i = 0; i< x;i++){
            result += readRawDataToString.charAt(i);
        }
        return result;
    }

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }



    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
}
