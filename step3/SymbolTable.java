import java.util.*;
public class SymbolTable {

    ArrayList<LittleParser.Assign_exprContext> list = new ArrayList<LittleParser.Assign_exprContext>();
    public void addScope() {
    }

    public void addSymbol() {
    }

    public void add(LittleParser.Assign_exprContext ctx){
        list.add(ctx);
    }
    public ArrayList<LittleParser.Assign_exprContext> getList(){
        return list;
    }
}