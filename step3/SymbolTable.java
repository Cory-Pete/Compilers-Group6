import java.util.*;

public class SymbolTable {

    public int id, count;
    public String scope;
    public String value = null;
    public SymbolTable parent = null;
    public boolean visited = false;
    public String type = null;


    ArrayList<SymbolTable> children = null;
    Stack<LittleParser.Func_declContext> stack = new Stack<LittleParser.Func_declContext>();
    //Hashtable<Integer, TokenData> table = null;
    ArrayList<TokenData> table = null;

    public SymbolTable(String scope, SymbolTable parent){
        this.scope = scope;
        id = 0;
        this.count = 0;
        //table = new Hashtable<Integer, TokenData>();
        this.parent = parent;
    }
    public void addScope(LittleParser.Func_declContext ctx) {
        stack.push(ctx);
    }

    public void popStack(){
        stack.pop();
    }

    public void addTable(SymbolTable st){
        if(children == null){
            children = new ArrayList<SymbolTable>();
        }
        children.add(st);
    }

    public void addSymbol(TokenData data){
        if(table == null){
            table = new ArrayList<TokenData>();
        }
        for(int i = 0; i < table.size(); i++){
            if(table.get(i).name.equals(data.name)){
                System.out.println("DECLARATION ERROR " + data.name);
                System.exit(0);
            }
        }
        table.add(data);
        //id++;
    }
    public void getData(){
        if(table != null){
            for(int i = 0; i < table.size(); i++){
                if(table.get(i).data != ""){
                    System.out.println("name " + table.get(i).name + " type " + table.get(i).type + " value " + table.get(i).data);
                }
                else{
                    System.out.println("name " + table.get(i).name + " type " + table.get(i).type);
                }
            }
        }
    }
    public ArrayList<SymbolTable> getChildren(){
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
    public void setParent(SymbolTable s){
        parent = s;
    }
    public SymbolTable getParent(){
        return parent;
    }
    public String getName(){
        return scope;
    }
    public String getValue(){
        return value;
    }
    public void setVisited(){
        visited = true;
    }
    public boolean visited(){
        return visited;
    }
    public String getType(){
        return type;
    }
}




