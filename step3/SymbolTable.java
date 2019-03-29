import java.util.*;

public class SymbolTable {

    ArrayList<LittleParser.Assign_exprContext> list = new ArrayList<LittleParser.Assign_exprContext>();
    Stack<LittleParser.Func_declContext> stack = new Stack<LittleParser.Func_declContext>();

    public void addScope(LittleParser.Func_declContext ctx) {
        stack.push(ctx);
    }

    public void popStack(){
        stack.pop();
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