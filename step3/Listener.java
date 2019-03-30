import java.util.*;
import java.lang.String;
import org.antlr.v4.runtime.tree.ParseTreeListener;
class Listener extends LittleBaseListener{
    
    Stack<SymbolTable> stt = new Stack <SymbolTable>(); //symbol table tree
    SymbolTable root;
    int scope;
    //need to make stack to push new scopes on?
    public Listener(){
        scope = 0;
        root = new SymbolTable("GLOBAL", null);
        stt.push(root);
    }
    @Override public void enterProgram(LittleParser.ProgramContext ctx) { 
        SymbolTable new_table = new SymbolTable("Global", null);
        stt.peek().addTable(new_table);
        stt.push(new_table);
        new_table.setParent(stt.peek());
    }
	
	@Override public void exitProgram(LittleParser.ProgramContext ctx) { 
        stt.pop();
    }
	
    @Override public void enterVar_type(LittleParser.Var_typeContext ctx) { 
        if (ctx != null) {
            String declType = ctx.getText();
        }
    }
	
	@Override public void exitVar_type(LittleParser.Var_typeContext ctx) {
       
     }
	
    @Override
    public void enterFunc_decl(LittleParser.Func_declContext ctx){
        //operate on symbol table here, ie add new scope
        if(ctx.any_type() != null){
            SymbolTable new_table = new SymbolTable(ctx.id().getText(), stt.peek());
            stt.peek().addTable(new_table);
            stt.push(new_table);
            new_table.setParent(stt.peek());
        }
    }

    @Override
    public void exitFunc_decl(LittleParser.Func_declContext ctx){
        stt.pop();
    }

    @Override
    public void enterVar_decl(LittleParser.Var_declContext ctx)
    {
        String type = ctx.var_type().getText();
        String[] list = ctx.id_list().getText().split(",");
        for(int i = 0; i < list.length; i++)
        {
            stt.peek().addSymbol(new TokenData(type, list[i]));
        }
    }
   
	public SymbolTable getSymbolTable(){
        return root;
    }
    @Override
    public void enterString_decl(LittleParser.String_declContext ctx)
    {
        String type = "STRING";
        String name = ctx.id().getText();
        String value = ctx.getText();
        //System.out.println("name " + name + " type " + type + " value " + value);
        stt.peek().addSymbol(new TokenData(type, name, value));
    }

    @Override
    public void enterParam_decl(LittleParser.Param_declContext ctx)
    {
        String type = ctx.var_type().getText();
        String paramID = ctx.id().getText();
        stt.peek().addSymbol(new TokenData(type, paramID));
    }
	
    @Override public void enterIf_stmt(LittleParser.If_stmtContext ctx) { 
        if (ctx.cond() != null) {
            SymbolTable new_table = new SymbolTable("BLOCK " + scope++, stt.peek());
            stt.push(new_table);
            new_table.setParent(stt.peek());
        }
    }
	
	@Override public void exitIf_stmt(LittleParser.If_stmtContext ctx) { 
        stt.pop();
    }
	
    @Override public void enterElse_part(LittleParser.Else_partContext ctx) { 
        if(ctx.decl() != null){
            SymbolTable new_table = new SymbolTable("BLOCK " + scope++, stt.peek());
            stt.push(new_table);
            new_table.setParent(stt.peek());
        }
    }
	
	@Override public void exitElse_part(LittleParser.Else_partContext ctx) {
        stt.pop();
     }
	
    @Override public void enterWhile_stmt(LittleParser.While_stmtContext ctx) {
            if(ctx.cond() != null){
                SymbolTable new_table = new SymbolTable("BLOCK " + scope++, stt.peek());
                stt.push(new_table);
                new_table.setParent(stt.peek());
            }
    }
	
	@Override public void exitWhile_stmt(LittleParser.While_stmtContext ctx) { 
        stt.pop();
    }
    public SymbolTable getRoot(){
        return root;
    }
    public void printResults(SymbolTable r){
        while(r != null){
            if(r.getChildren() != null){
                ArrayList<SymbolTable> children = r.getChildren();
                for(int i = 0; i < children.size(); i++){
                    if(children.get(i).visited == false){
                        children.get(i).setVisited();
                        if(children.get(i).getValue() != null){
                            System.out.println("name " + children.get(i).getName() + " type " + children.get(i).getType() + " value " + children.get(i).getValue());
                        }
                        else{
                            System.out.println("name " + children.get(i).getName() + " type " + children.get(i).getType());
                        }
                        printResults(children.get(i));
                    }
                }
            }
            else{
                return;
            }
        }
    }
	
}


