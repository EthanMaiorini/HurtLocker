import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerksonParser {
    public static List<String> groceries = new ArrayList<>();
    public String stringToBeParsed;
    public static int currentCursor = 0;
    public static List<Grocery> shoppingList = new ArrayList<>();


    public static String getStringFromResult(String readRawDataToString) {
        int x =0;
        String result = "";
        String patternString = "[':',';','@','^','*','%','!']";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(readRawDataToString);
        if(matcher.find())
            x = matcher.start();
        for (int i = 0; i< x;i++){
            result += readRawDataToString.charAt(i);
        }
        return result;
    }

    public static List<String> getJerksonStrings(String readRawDataToString){
        int x;
        String result = "";
        String patternString = "##";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(readRawDataToString);
            while (matcher.find()){
                x = matcher.start();
            for (int i = currentCursor; i <x; i++) {
                result += readRawDataToString.charAt(i);
            }
            x += 2;
                //System.out.println(result);
            currentCursor = x;
            groceries.add(result);
            result = "";
        }
        return groceries;
    }


//    public static String getFirstGrocItem(String readRawDataToString) {
//        String a = getJerksonStrings(readRawDataToString);
//        String s = getStringFromResult(a);
//        String result = "";
//        for (int i = stringLength(s)+1; i< stringLength(a);i++){
//            result += readRawDataToString.charAt(i);
//
//        }
//
//        return getStringFromResult(result);
//    }

    public static int stringLength(String str){
        int x =0;
        str += '\0';
        while(str.charAt(x) != '\0')
            x++;
        return x;
    }


    public static Grocery createObjectFromString(String s) {
        Grocery item = new Grocery();
        String patternString = "[n,N][a,A][m,M][e,E]";
        String name = getObject(patternString,s);
        if(stringLength(name) == 0) {
            item.setName("Error");
        } else item.setName(name);
        String patternString1 = "[p,P][r,R][i,I][c,C][e,E]";
        String price = getObject(patternString1,s);
        if(stringLength(price) == 0) {
            item.setPrice("Error");
        } else item.setPrice(price);
        String patternString2 = "[t,T][y,Y][p,P][e,E]";
        String type = getObject(patternString2,s);
        item.setType(type);
        String patternString3 = "[e,E][x,X][p,P][i,I][r,R][a,A][T,t][i,I][o,O][n,N]";
        String expiration = getObject(patternString3,s);
        item.setExpiration(expiration);
        return item;
    }

        public static String getObject(String patt, String str){
            int x =0;
            String result = "";
            Pattern pattern = Pattern.compile(patt);
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                x = matcher.end();
            }
            for (int i = x + 1; i < stringLength(str); i++) {
                result += str.charAt(i);
            }
            if (patt.equals("[e,E][x,X][p,P][i,I][r,R][a,A][T,t][i,I][o,O][n,N]"))
                return result;
            result = getStringFromResult(result);

        return result;
        }
}
