import java.util.*;
import java.lang.String;
import org.antlr.v4.runtime.tree.ParseTreeListener;
class Listener extends LittleBaseListener{
    
    Stack<SymbolTable> stt = new Stack <SymbolTable>(); //symbol table tree
    SymbolTable root;
    int count = 0;
    //need to make stack to push new scopes on?
    public Listener(){
        root = new SymbolTable("GLOBAL", null);
        root = setScope("GLOBAL");
        stt.push(root);
    }
    @Override public void enterProgram(LittleParser.ProgramContext ctx) { 
        SymbolTable new_table = new SymbolTable("Global");
        stt.addTable(new_table);
    }
	
	@Override public void exitProgram(LittleParser.ProgramContext ctx) { 
        stt.pop();
    }
	
    @Override public void enterId(LittleParser.IdContext ctx) {

     }
	
	@Override public void exitId(LittleParser.IdContext ctx) {
        //stt.pop();
     }
	
	@Override public void enterPgm_body(LittleParser.Pgm_bodyContext ctx) { 
        SymbolTable new_table = new SymbolTable(ctx.id().getText(), stt.peek());
        stt.addTable(new_table);
    }
	
	@Override public void exitPgm_body(LittleParser.Pgm_bodyContext ctx) {
        stt.pop();
     }
	
	@Override public void enterDecl(LittleParser.DeclContext ctx) {

     }
	
	@Override public void exitDecl(LittleParser.DeclContext ctx) {
        //stt.pop();
     }
	
    @Override public void enterVar_type(LittleParser.Var_typeContext ctx) { 

    }
	
	@Override public void exitVar_type(LittleParser.Var_typeContext ctx) {
        //stt.pop();
     }
	
    @Override
    public void enterFunc_decl(LittleParser.Func_declContext ctx){
        //operate on symbol table here, ie add new scope
        SymbolTable new_table = new SymbolTable(ctx.id().getText(), stt.peek());
        stt.peek().addTable(new_table);
        stt.push(new_table);
    }

    @Override
    public void exitFunc_decl(LittleParser.Func_declContext ctx){
        stt.pop();
    }
    @Override public void enterFunc_body(LittleParser.Func_bodyContext ctx) {
        SymbolTable new_table = new SymbolTable(ctx.id().getText(), stt.peek());
        stt.peek().addTable(new_table);
        stt.push(new_table);
     }
	
	@Override public void exitFunc_body(LittleParser.Func_bodyContext ctx) {
        stt.pop();
     }
	
    @Override public void enterAssign_expr(LittleParser.Assign_exprContext ctx) {
        String name = ctx.id().getText();
        String value = ctx.getText();
        //temp for testing
        try
        {
            if (root.getData(name).type == null)
            {
                //lookup table?
            }
            else
            {
                String type = root.getData(name).type;
                stt.peek().addSymbol(new TokenData(type, name, value));
            }
        }catch(Exception e)
        {
            System.out.println("YOUR FAVORITE NULL");
            //Empty StackNotation
        }
        

    }
    @Override public void exitAssign_expr(LittleParser.Assign_exprContext ctx) { 
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
    @Override
    public void exitVar_decl(LittleParser.Var_declContext ctx){
        stt.pop();
    }
	public SymbolTable getSymbolTable(){
        return root;
    }
    public SymbolTable setScope(String name){
        SymbolTable out;
        if(name != null){
            out = new SymbolTable(name, null);
            stt.push(out);
            //count++;
            return out;
        }
        out = new SymbolTable("BLOCK" + Integer.toString(count), stt.peek());
        stt.peek().addTable(out);
        stt.push(out);
        //count++;
        return out;
        
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
    @Override public void enterReturn_stmt(LittleParser.Return_stmtContext ctx) { 

    }
	
	@Override public void exitReturn_stmt(LittleParser.Return_stmtContext ctx) { 
        //stt.pop();
    }
	
    @Override public void enterIf_stmt(LittleParser.If_stmtContext ctx) { 

    }
	
	@Override public void exitIf_stmt(LittleParser.If_stmtContext ctx) { 
        //stt.pop();
    }
	
    @Override public void enterElse_part(LittleParser.Else_partContext ctx) { 

    }
	
	@Override public void exitElse_part(LittleParser.Else_partContext ctx) {
        //stt.pop();
     }
	
    @Override public void enterWhile_stmt(LittleParser.While_stmtContext ctx) {

     }
	
	@Override public void exitWhile_stmt(LittleParser.While_stmtContext ctx) { 
        //stt.pop();
    }

	
}


