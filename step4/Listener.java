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
        stt.peek().addTable(root);
        stt.push(root);
    }
	
    @Override
    public void exitProgram(LittleParser.ProgramContext ctx) { 
       stt.pop();
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
       
    }
	
	@Override public void exitPrimary(LittleParser.PrimaryContext ctx) { 
        
    }
	
    
    @Override public void enterExpr(LittleParser.ExprContext ctx) {
        if(curChild == null){
            curChild = new ASTNode();
        }
        else{
            System.out.println("EnterExpr, child not null!");
        }
       // System.out.println(ctx.getText());
    }
	
	@Override public void exitExpr(LittleParser.ExprContext ctx) {
        ArrayList<ASTNode> children = curChild.getChildren();
        children[0].addRightChild(children[1]);
        root.setRightChild(children[0]);
    }
    @Override public void enterAddop(LittleParser.AddopContext ctx) {
        String name = ctx.getText();
        ASTNode temp = new ASTNode(name);
        curChild.addChildren(temp);
        temp.addParent(curChild);
        curChild = temp; 
    }

	@Override public void exitAddop(LittleParser.AddopContext ctx) {}
	
	@Override public void enterMulop(LittleParser.MulopContext ctx) { 
        String name = ctx.getText();
        // astRootNodes.get(0).setChild(new ASTNode(name), false);
    }
	
	@Override public void exitMulop(LittleParser.MulopContext ctx) { 

    }
	
    @Override public void enterAssign_stmt(LittleParser.Assign_stmtContext ctx) { 
        String name = ctx.getText();
        //System.out.println(name);
        // String middle = "=";
        String id = name.split(":")[0];
        String ops = name.split("=")[1];
        ASTNode curRoot = new ASTNode();
        ASTNode temp = new ASTNode(id);
        astRootNodes.add(curRoot);
        
        /*
        System.out.println("id: " + id);
        System.out.println("middle: " + middle);
        System.out.println("ops: " + ops);
        System.out.println();
        */
        // ASTNode n = new ASTNode(middle);
        // n.setRoot();//set = as a root
        // astRootNodes.add(n);
        // astRootNodes.get(0).setChild(new ASTNode(id), true);
    }
	
	@Override public void exitAssign_stmt(LittleParser.Assign_stmtContext ctx) {
    //   astRootNodes.remove(0);
    }

    @Override public void enterId(LittleParser.IdContext ctx) { 
        String idname = ctx.getText();
        ASTNode temp = new ASTNode(idname);
        TokenData id = lookup(idname);
        if(id != null){
            temp.setType(id.type);
            curChild.setChild(temp);
        }
        else{
            System.out.println("ID not found");
        }
        // if(astRootNodes.size() > 0 && astRootNodes(0).isRoot()){
        //     astRootNodes.get(0).setChild(temp, childFlag);
        //     if(childFlag == false){
        //         childFlag = true;
        //     }
        //     else{
        //         childFlag = false;
            // }
        // }
    }
	
	@Override public void exitId(LittleParser.IdContext ctx) {}
	

	
	@Override public void enterFactor(LittleParser.FactorContext ctx) {
        if(curChild == null){
            curChild = new ASTNode();
        }
        else{
            ASTNode temp = new ASTNode();
            curChild.addChildren(temp);
            temp.setParent(curChild);
            curChild = temp;

        }
        String name = ctx.getText();
        
    }
	
	@Override public void exitFactor(LittleParser.FactorContext ctx) {
        ArrayList<ASTNode> children = curChild.getChildren();
        children[0].setLeftChild(children[1]);
        curChild = curChild.getParent();
    }
	
	@Override public void enterFactor_prefix(LittleParser.Factor_prefixContext ctx) {
        String name = ctx.getText();
        if(name == "")
        {
            return;
        }
        ASTNode temp = new ASTNode();
        curChild.setChild(temp);
        temp.setParent(curChild);
        curChild = temp;
        
    
    }
	
	@Override public void exitFactor_prefix(LittleParser.Factor_prefixContext ctx) {
        ASTNode<ArrayList> children = curChild.getChildren();
        ASTNode topChild = children[children.size()-1];
        topChild.setLeftChild(children[0]);
        temp = curChild.getParent();
        temp.removeChild(curChild);
        curChild = temp;
        curChild.addChild(topChild);
        
    }
	@Override public void enterExpr_prefix(LittleParser.Expr_prefixContext ctx) {
        // String name = ctx.getText();
        // String value = name.split(name)[0];
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
        ASTNode topChild = children[children.size()-1];
        topChild.setLeftChild(children[0]);
        temp = curChild.getParent();
        temp.removeChild(curChild);
        curChild = temp;
        curChild.addChild(topChild);
    }
	@Override public void enterPostfix_expr(LittleParser.Postfix_exprContext ctx) {
        ASTNode temp = new ASTNode();
        curChild.setChild(temp);
        temp.setParent(curChild);
        curChild = temp;
        //("v: " + value);
        // astRootNodes.get(0).setChild(new ASTNode(value), true);
    }
	
	@Override public void exitPostfix_expr(LittleParser.Postfix_exprContext ctx) {
        ASTNode child = curChild.getChildren()[0];
        temp = curChild.getParent();
        temp.removeChild(curChild);
        curChild = temp;
        curChild.add(child);
    }
    //Print all symbole tables starting from symbol table r in a readable format
    // public void printResults(SymbolTable r){
    //     //while(r != null){
    //         if(r.getChildren() != null){
    //             ArrayList<SymbolTable> children = r.getChildren();
    //             for(int i = 0; i < children.size(); i++){
    //                 if(children.get(i).visited == false){
    //                     children.get(i).setVisited();
    //                     System.out.println("Symbol table " + children.get(i).getName());
    //                     if(children.get(i).table != null){
    //                         children.get(i).getData();
    //                     }
    //                     System.out.println();
    //                     printResults(children.get(i));
    //                 }
    //             }
    //         }
    //         else{
    //             return;
    //         }
    // }
}


