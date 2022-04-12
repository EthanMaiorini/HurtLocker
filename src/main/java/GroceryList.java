import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryList {
    public List<Grocery> groceryList = new ArrayList<>();
    ArrayList<Grocery> milk = new ArrayList<>();
    ArrayList<Grocery> cookies = new ArrayList<>();
    ArrayList<Grocery> bread = new ArrayList<>();
    ArrayList<Grocery> apples = new ArrayList<>();
    int errorCount = 0;




    void GroceryList(){
        groceryList = new ArrayList<>();
    }

    public void sortbyName() {
        // pattern = "[c,C][o,O,0][o,O,0][k,K][i,I][e,E,3][s,S,5]"
        String patternString = "[c,C][o,O,0][o,O,0][k,K][i,I][e,E,3][s,S,5]";
        String patternString1 = "[m,M][i,I][l,L][k,K]";
        String patternString2 = "[b,B][r,R][e,E][a,A][d,D]";
        String patternString3 = "[a,A][p,P][p,P][l,L][e,E][s,S]";
        String patternString0 = "Error";
        Pattern pattern = Pattern.compile(patternString);
        Pattern pattern0 = Pattern.compile(patternString0);
        Pattern pattern1 = Pattern.compile(patternString1);
        Pattern pattern2 = Pattern.compile(patternString2);
        Pattern pattern3 = Pattern.compile(patternString3);
        for (Grocery g : groceryList) {
            Matcher matcher = pattern.matcher(g.getName());
            Matcher matcher0 = pattern0.matcher(g.getName());
            Matcher matcher1 = pattern1.matcher(g.getName());
            Matcher matcher2 = pattern2.matcher(g.getName());
            Matcher matcher3 = pattern3.matcher(g.getName());
            Matcher matcherPrice = pattern0.matcher(g.getPrice());
            if((matcherPrice.find())||(matcher0.find())){
                errorCount++;
            }else if(matcher.find()) {
                cookies.add(g);
            }else if (matcher1.find()){
                milk.add(g);
            }else if (matcher2.find()){
                bread.add(g);
            }else if (matcher3.find()){
                apples.add(g);
            }
        }
        //System.out.println(cookies);
       // System.out.println(milk);
        //System.out.println(bread);
        //System.out.println(apples);
       // System.out.println(errorCount);

    }

    public static String sortNamesbyPrice(ArrayList<Grocery> generic, String name){
        int x =0;
        int y =0;
        String out2 = "";
        String price2 = "\n";
        String price = generic.get(0).getPrice();
        for(Grocery g : generic){
            if(g.getPrice().equals(price)){
                x++;
            }else price2 = g.getPrice();
        }
        y = generic.size() - x;
        String out = "Name: "+name+"                      Seen: "+generic.size()+"\n";
        String doubleLine = "================                ================\n";
        String prices = "Price: "+ price+"                     Seen: "+x+"\n";
        String singleLine = "----------------                ----------------\n";
        if(y>0) {
            out2 = "Price: " + price2 + "                     Seen: " + y+"\n";
        }
        return out+doubleLine+prices+singleLine+out2;
    }

    public void getGroceryList(){
        //print like output.txt
        String result = sortNamesbyPrice(milk,"Milk")+"\n";
        result += sortNamesbyPrice(bread,"Bread")+"\n";
        result+= sortNamesbyPrice(cookies,"Cookies")+"\n";
        result += sortNamesbyPrice(apples,"Apples")+"\n";
        System.out.println(result);
    }

    public void put(Grocery g){
        groceryList.add(g);
    }

    @Override
    public String toString() {
        String output = "";
        for(Grocery g : groceryList)
            output += g.toString()+"\n";
        return output;
    }
}

