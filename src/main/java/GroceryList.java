import java.util.ArrayList;
import java.util.List;

public class GroceryList {
    public List<Grocery> groceryList = new ArrayList<>();
    ArrayList<Grocery> milk;
    ArrayList<Grocery> cookies;
    ArrayList<Grocery> bread;
    ArrayList<Grocery> apples;
    int errorCount = 0;




    void GroceryList(){
        groceryList = new ArrayList<>();
    }

    public void sortbyName(){
        // pattern = "[c,C][o,O,0][o,O,0][k,K][i,I][e,E,3][s,S,5]"

    }

    public void sortNAmesbyPrice(){

    }

    public void getGroceryList(){
        //print like output.txt
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

