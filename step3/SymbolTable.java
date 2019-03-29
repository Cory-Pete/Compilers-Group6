import java.util.*;

public class SymbolTable {

    int id, count;
    String scope;
    SymbolTable parent = null;

    ArrayList<LittleParser.Assign_exprContext> list = new ArrayList<LittleParser.Assign_exprContext>();
    ArrayList<SymbolTable> children;
    Stack<LittleParser.Func_declContext> stack = new Stack<LittleParser.Func_declContext>();
    Hashtable<Integer, TokenData> table;

    public SymbolTable(String scope, SymbolTable parent){
        this.scope = scope;
        id = 0;
        this.count = 0;
        table = new Hashtable<Integer, TokenData>();
        this.parent = parent;
    }
    public void addScope(LittleParser.Func_declContext ctx) {
        stack.push(ctx);
    }

    public void popStack(){
        stack.pop();
    }

    public void add(LittleParser.Assign_exprContext ctx){
        list.add(ctx);
    }
    public ArrayList<LittleParser.Assign_exprContext> getList(){
        return list;
    }

    public void addTable(SymbolTable st){
        if(children == null){
            children = new ArrayList<SymbolTable>();
        }
        children.add(st);
    }

    public void addSymbol(TokenData data){
        for(int i = 0; i < id; i++){
            if(table.get(i).name.equals(data.name)){
                System.out.println("doubleVar");
                return;
            }
        }
        table.put(id, data);
        id++;
    }
    public TokenData getData(String name){
        for(int i = 0; i < table.size(); i++){
            System.out.println(table.get(i).name);
            if(table.get(i).name.equals(name)){
                return table.get(i);
            }
        }
        if(this.parent != null){
            return this.parent.getData(name);
        }
        else{
            return null;
        }
    }
    public List<SymbolTable> getChildren(){
        return children;
    }
    public String getScope()
    {
        return this.scope;
    }

    public SymbolTable getTable()
    {
        return this;
    }
}




