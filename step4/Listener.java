import java.util.*;
import java.lang.String;
import org.antlr.v4.runtime.tree.ParseTreeListener;
class Listener extends LittleBaseListener{
    
    Stack<SymbolTable> stt = new Stack <SymbolTable>(); //symbol table tree
    ArrayList<ASTNode> astRootNodes = new ArrayList<ASTNode>();
    //Stack<ASTNode> astNodes = new Stack<ASTNode>();
    SymbolTable root;

    // Queue<ASTNOde> rootNodes;
    ASTNode curRoot;
    ASTNode curChild;
    
    int scope;
    //need to make stack to push new scopes on?
    public Listener(){
        scope = 1;
        //make root table, and push to stack.
        root = new SymbolTable("GLOBAL", null);
        stt.push(root);
    }
    //Creates global symbol table as root of our tree
    @Override
    public void enterProgram(LittleParser.ProgramContext ctx) { 
        SymbolTable root = new SymbolTable("GLOBAL", null);
        curChild = new ASTNode();
        curRoot = new ASTNode();
        stt.peek().addTable(root);
        stt.push(root);
    }
	
    @Override
    public void exitProgram(LittleParser.ProgramContext ctx) { 
       stt.pop();
       for(int i = 0; i < astRootNodes.size()-1; i++){
           astRootNodes.get(i).setRoot(astRootNodes.get(i+1));
       }
       curRoot = astRootNodes.get(0);
    }
	
    @Override
    public void enterFunc_decl(LittleParser.Func_declContext ctx){
        //if the type is not null, add the table to the stack and set the previous table as its parent.
        if(ctx.any_type() != null){
            SymbolTable new_table = new SymbolTable(ctx.id().getText(), stt.peek());
            stt.peek().addTable(new_table);
            new_table.setParent(stt.peek());
            stt.push(new_table);
        }
    }

    @Override
    public void exitFunc_decl(LittleParser.Func_declContext ctx){
        stt.pop();
    }

    @Override
    public void enterVar_decl(LittleParser.Var_declContext ctx)
    {  
        //get data from a variable declaration, and create new symbol with this info
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
        //get data from string declaration
        String type = "STRING";
        String name = ctx.id().getText();
        String value = ctx.getText().split("=")[1];
        value = value.split(";")[0];
        stt.peek().addSymbol(new TokenData(type, name, value));
    }

    @Override
    public void enterParam_decl(LittleParser.Param_declContext ctx)
    {
        String type = ctx.var_type().getText();
        String paramID = ctx.id().getText();
        stt.peek().addSymbol(new TokenData(type, paramID));
    }
    
    //Enter if statement block, creates new scope by making new symbol table
    @Override
    public void enterIf_stmt(LittleParser.If_stmtContext ctx) { 
        if (ctx.cond() != null) {
            SymbolTable new_table = new SymbolTable("BLOCK " + scope++, stt.peek());
            stt.peek().addTable(new_table);
            new_table.setParent(stt.peek());
            stt.push(new_table);
        }
    }
	
    @Override
    public void exitIf_stmt(LittleParser.If_stmtContext ctx) { 
        stt.pop();
    }
    
    //Enter else statement block, creates new scope by making new symbol table
    @Override
    public void enterElse_part(LittleParser.Else_partContext ctx) { 
        if(ctx.decl() != null){
            SymbolTable new_table = new SymbolTable("BLOCK " + scope++, stt.peek());
            stt.peek().addTable(new_table);
            new_table.setParent(stt.peek());
            stt.push(new_table);
            
        }
    }
	
    @Override
    public void exitElse_part(LittleParser.Else_partContext ctx) {
        stt.pop();
     }
    
    //Enter while statement block, creates new scope by making new symbol table
    @Override
    public void enterWhile_stmt(LittleParser.While_stmtContext ctx) {
            if(ctx.cond() != null){
                SymbolTable new_table = new SymbolTable("BLOCK " + scope++, stt.peek());
                stt.peek().addTable(new_table);
                new_table.setParent(stt.peek());
                stt.push(new_table);
            }
    }
	
    @Override
    public void exitWhile_stmt(LittleParser.While_stmtContext ctx) { 
        stt.pop();
    }
    public SymbolTable getRoot(){
        return root;
    }
    @Override public void enterPrimary(LittleParser.PrimaryContext ctx) { 
        String idname = ctx.getText();
        System.out.println(idname);
        // if(idname.equals("expr") || idname.equals("main"))
        // {
        //     return;
        // }
        ASTNode temp = new ASTNode(idname);
        TokenData id = stt.peek().lookUp(idname);
        System.out.println(idname);
        if(id != null || idname.equals("newline")){
            temp.setType(id.type);
            curChild.addChild(temp);
            System.out.println("ID FOUND");
        }
        else if(isInteger(idname))
        {
            curChild.addChild(temp);
            temp.setType("INT");
        }
        else{
            System.out.println("ID not found " + idname);
            // temp.setType(id.type);
            // curChild.addChild(temp);
        }
    }
    public static boolean isInteger(String s) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),10) < 0) return false;
        }
        return true;
    }
	
	@Override public void exitPrimary(LittleParser.PrimaryContext ctx) { 
        
    }
	
    
    @Override public void enterExpr(LittleParser.ExprContext ctx) {
        System.out.println("TEST: ENTER EXPR " + ctx.getText());
        if(curChild == null){
            curChild = new ASTNode();
        }
        else{
            // System.out.println("EnterExpr, child not null!");
        }
    }
	
	@Override public void exitExpr(LittleParser.ExprContext ctx) {
        ArrayList<ASTNode> children = curChild.getChildren();
        if(children.size() == 0){
            curChild = null;
            return;
        }
        else if (children.size() == 1){
            curRoot.setRightChild(children.get(0));
            curChild = null;
            return;
        }
        children.get(0).setRightChild(children.get(1));
        curRoot.setRightChild(children.get(0));
        curChild = null;
    }
    @Override public void enterAddop(LittleParser.AddopContext ctx) {
        System.out.println("ADDOP: " + ctx.getText());
        String name = ctx.getText();
        ASTNode temp = new ASTNode(name);
        curChild.addChild(temp);
        temp.setParent(curChild);
        curChild = temp; 
    }

	@Override public void exitAddop(LittleParser.AddopContext ctx) {}
	
	@Override public void enterMulop(LittleParser.MulopContext ctx) { 
        String name = ctx.getText();
    }
	
	@Override public void exitMulop(LittleParser.MulopContext ctx) { 

    }
	
    @Override public void enterAssign_stmt(LittleParser.Assign_stmtContext ctx) {
        String name = ctx.getText();
        System.out.println("Hello " + name);
        String id = name.split(":")[0];
        String ops = name.split("=")[1];
        ASTNode curRoot = new ASTNode();
        ASTNode temp = new ASTNode(id);
        astRootNodes.add(curRoot);
    }
	
	@Override public void exitAssign_stmt(LittleParser.Assign_stmtContext ctx) {
    }

    @Override public void enterId(LittleParser.IdContext ctx) { 
        // String idname = ctx.getText();
        // System.out.println(idname);
        // if(idname.equals("expr") || idname.equals("main"))
        // {
        //     return;
        // }
        // ASTNode temp = new ASTNode(idname);
        // TokenData id = stt.peek().lookUp(idname);
        // System.out.println(idname);
        // if(id != null || idname.equals("newline")){
        //     temp.setType(id.type);
        //     curChild.addChild(temp);
        //     System.out.println("ID FOUND");
        // }
        // else{
        //     System.out.println("ID not found " + idname);
        //     // temp.setType(id.type);
        //     // curChild.addChild(temp);
        // }
    }
	
	@Override public void exitId(LittleParser.IdContext ctx) {}
	

	
	@Override public void enterFactor(LittleParser.FactorContext ctx) {
        System.out.println("FACTOR " + ctx.getText());
        if(curChild == null){
            curChild = new ASTNode();
        }
        else{
            ASTNode temp = new ASTNode();
            curChild.addChild(temp);
            temp.setParent(curChild);
            curChild = temp;

        }
        String name = ctx.getText();
        
    }
	
	@Override public void exitFactor(LittleParser.FactorContext ctx) {
        ArrayList<ASTNode> children = curChild.getChildren();
        if(children.size() == 0){
            curChild = curChild.getParent();
            return;
        }
        else if (children.size() == 1){
            ASTNode temp = curChild.getParent();
            temp.removeChild(curChild);
            curChild = temp;
            curChild.addChild(children.get(0));
            return;
        }
        children.get(0).setLeftChild(children.get(1));
        curChild = curChild.getParent();
    }
	
	@Override public void enterFactor_prefix(LittleParser.Factor_prefixContext ctx) {
        System.out.println("Factor Prefix " + ctx.getText());
        String name = ctx.getText();
        if(name == "")
        {
            return;
        }
        ASTNode temp = new ASTNode();
        curChild.addChild(temp);
        temp.setParent(curChild);
        curChild = temp;
        
    
    }
	
	@Override public void exitFactor_prefix(LittleParser.Factor_prefixContext ctx) {
        ArrayList<ASTNode> children = curChild.getChildren();
        ASTNode temp;
        if(children.size() == 0){
            return;
        }
        if(children.size() == 2){
            ASTNode topChild = children.get(children.size()-1);
            topChild.setLeftChild(children.get(0));
            temp = curChild.getParent();
            temp.removeChild(curChild);
            curChild = temp;
            curChild.addChild(topChild);
        }
        else if(children.size() == 3)
        {
            children.get(1).setRightChild(children.get(0));
            children.get(1).setLeftChild(children.get(1).getChildren().get(0));
            children.get(2).setLeftChild(children.get(1));
            temp = curChild.getParent();
            temp.removeChild(curChild);
            curChild = temp;
            curChild.addChild(children.get(2));
        }
        
    }
	@Override public void enterExpr_prefix(LittleParser.Expr_prefixContext ctx) {
        System.out.println("--EXPR PREFIX-- " + ctx.getText());
        ASTNode c = new ASTNode();
        if(curChild == null){
            curChild = c;
        }
        else{
            curChild.addChild(c);
            c.setParent(curChild);
            curChild = c;
        }
        //ex: a+ b+ i+
       
    }
    @Override public void exitExpr_prefix(LittleParser.Expr_prefixContext ctx) {
        ArrayList<ASTNode> children = curChild.getChildren();
        if(children.size() == 0){
            return;
        }
        ASTNode temp;
        if(children.size() == 2){
            ASTNode topChild = children.get(1);
            topChild.setLeftChild(children.get(0));
            temp = curChild.getParent();
            temp.removeChild(curChild);
            curChild = temp;
            curChild.addChild(topChild);
        }
        else if(children.size() == 3){
            children.get(1).setRightChild(children.get(0));
            children.get(1).setLeftChild(children.get(1).getChildren().get(0));
            children.get(2).setLeftChild(children.get(1));
            temp = curChild.getParent();
            temp.removeChild(curChild);
            curChild = temp;
            curChild.addChild(children.get(2));
        }
        else if(children.size() == 1){
            temp = curChild.getParent();
            temp.removeChild(curChild);
            curChild = temp;
            curChild.addChild(children.get(0));
        }
    }
	@Override public void enterPostfix_expr(LittleParser.Postfix_exprContext ctx) {
        System.out.println("POSTFIX: " + ctx.getText());
        ASTNode temp = new ASTNode();
        curChild.addChild(temp);
        temp.setParent(curChild);
        curChild = temp;
        // System.out.println(curChild);
    }
	
	@Override public void exitPostfix_expr(LittleParser.Postfix_exprContext ctx) {
        // System.out.println(curChild);
        if(curChild.getChildren().size() == 0){
            return;
        }
        ASTNode child = curChild.getChildren().get(0);
        ASTNode temp = curChild.getParent();
        temp.removeChild(curChild);
        curChild = temp;
        curChild.addChild(child);
    }

    public ASTNode getRootAST()
    {
        return curRoot;
    }
    // Print all symbole tables starting from symbol table r in a readable format
    public void printResults(SymbolTable r){
        //while(r != null){
            if(r.getChildren() != null){
                ArrayList<SymbolTable> children = r.getChildren();
                for(int i = 0; i < children.size(); i++){
                    if(children.get(i).visited == false){
                        children.get(i).setVisited();
                        System.out.println("Symbol table " + children.get(i).getName());
                        if(children.get(i).table != null){
                            children.get(i).getData();
                        }
                        System.out.println();
                        printResults(children.get(i));
                    }
                }
            }
            else{
                return;
            }
    }
}


