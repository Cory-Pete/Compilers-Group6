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
        //if the type is not null, add the table to the stack and set the previous table as its parent
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
        ////System.out.println("ENTER VAR_DECL: " + ctx.getText());
        //get data from a variable declaration, and create new symbol with this info
        String type = ctx.var_type().getText();
        String[] list = ctx.id_list().getText().split(",");
        for(int i = 0; i < list.length; i++)
        {
            stt.peek().addSymbol(new TokenData(type, list[i]));
            // etAstRootNodes.add(new ASTNode(type, list[i]));
        }

    }
   
	public SymbolTable getSymbolTable(){
        return root;
    }
    @Override
    public void enterString_decl(LittleParser.String_declContext ctx)
    {
        //get data from string declaration
        ////System.out.println("ENTER STRING_DECL: " + ctx.getText());
        String type = "STRING";
        String name = ctx.id().getText();
        String value = ctx.getText().split("=")[1];
        value = value.split(";")[0];
        stt.peek().addSymbol(new TokenData(type, name, value));
    }

    @Override
    public void enterParam_decl(LittleParser.Param_declContext ctx)
    {
        ////System.out.println("ENTER Param_decl: " + ctx.getText());
        String type = ctx.var_type().getText();
        String paramID = ctx.id().getText();
        stt.peek().addSymbol(new TokenData(type, paramID));
    }
    
    //Enter if statement block, creates new scope by making new symbol table
    @Override
    public void enterIf_stmt(LittleParser.If_stmtContext ctx) {
        ////System.out.println("ENTER If_stmt: " + ctx.getText()); 
        if (ctx.cond() != null) {
            SymbolTable new_table = new SymbolTable("BLOCK " + scope++, stt.peek());
            stt.peek().addTable(new_table);
            new_table.setParent(stt.peek());
            stt.push(new_table);
        }
    }
	
    @Override
    public void exitIf_stmt(LittleParser.If_stmtContext ctx) { 
        ////System.out.println("exit If_stmt: " + ctx.getText());
        stt.pop();
    }
    
    //Enter else statement block, creates new scope by making new symbol table
    @Override
    public void enterElse_part(LittleParser.Else_partContext ctx) {
        ////System.out.println("ENTER Else_part: " + ctx.getText()); 
        if(ctx.decl() != null){
            SymbolTable new_table = new SymbolTable("BLOCK " + scope++, stt.peek());
            stt.peek().addTable(new_table);
            new_table.setParent(stt.peek());
            stt.push(new_table);
            
        }
    }
	
    @Override
    public void exitElse_part(LittleParser.Else_partContext ctx) {
        ////System.out.println("exit Else_part: " + ctx.getText());
        stt.pop();
     }
    
    //Enter while statement block, creates new scope by making new symbol table
    @Override
    public void enterWhile_stmt(LittleParser.While_stmtContext ctx) {
        ////System.out.println("ENTER WHILE_STMT: " + ctx.getText());
        if(ctx.cond() != null){
            SymbolTable new_table = new SymbolTable("BLOCK " + scope++, stt.peek());
            stt.peek().addTable(new_table);
            new_table.setParent(stt.peek());
            stt.push(new_table);
        }
    }
	
    @Override
    public void exitWhile_stmt(LittleParser.While_stmtContext ctx) { 
        ////System.out.println("exit While_stmt: " + ctx.getText());
        stt.pop();
    }
    public SymbolTable getRoot(){
        return root;
    }
    @Override public void enterPrimary(LittleParser.PrimaryContext ctx) { 
        String idname = ctx.getText();
        // System.out.println("ENTER PRIMARY");
        ASTNode temp;
        TokenData id = stt.peek().lookUp(idname);

        if(id != null){
            temp = new ASTNode(id.type, id.name);
            curChild.addChild(temp);
        }
        else{
            if(isInteger(idname))
            {
                temp = new ASTNode("INT", idname);
                curChild.addChild(temp);
            }
            else if(isFloat(idname))
            {
                temp = new ASTNode("FLOAT", idname);
                curChild.addChild(temp);
            }
            else if(idname == "newline"){
                temp = new ASTNode("STRING", "newline");
                curChild.addChild(temp);
            }
        }
    }
    public static boolean isInteger(String s) {
        return s.matches("-?\\d+");
    }

    public static boolean isFloat(String s) {
        return s.matches("-?\\d+(\\.\\d+)?");
    }
	
	@Override public void exitPrimary(LittleParser.PrimaryContext ctx) { 
        ////System.out.println("exit Primary: " + ctx.getText());
        
    }
	
    
    @Override public void enterExpr(LittleParser.ExprContext ctx) {
        //System.out.println("ENTER EXPR: " + ctx.getText());
        if(ctx.getText() == "")
        {
            return;
        }
        if(curChild == null){
            curChild = new ASTNode();
        }
        else{
            ASTNode temp = new ASTNode();
            curChild.addChild(temp);
            temp.setParent(curChild);
            curChild = temp;
        }
    }
	
	@Override public void exitExpr(LittleParser.ExprContext ctx) {
        //System.out.println("exit Expr: " + ctx.getText() + " " + curChild.getChildren().size());
        if(ctx.getText() == "")
        {
            return;
        }

        ArrayList<ASTNode> children = curChild.getChildren();
        if(children.size() == 1){
            curRoot.setRightChild(children.get(0));
        }  
        else{
            children.get(0).setRightChild(children.get(1));
            curRoot.setRightChild(children.get(0));
        }
        //curChild = null;
    }

    @Override public void enterExpr_prefix(LittleParser.Expr_prefixContext ctx) {
        //System.out.println("Enter Expr_prefix: " + ctx.getText());
        if(ctx.getText() == "")
        {
            return;
        }

        ASTNode temp = new ASTNode();
        curChild.addChild(temp);
        temp.setParent(curChild);
        curChild = temp;
    }
    @Override public void exitExpr_prefix(LittleParser.Expr_prefixContext ctx) {
        if(ctx.getText() == "")
        {
            return;
        }

        ArrayList<ASTNode> children = curChild.getChildren();
        //System.out.println("exit Expr_prefix: " + ctx.getText() + children.size());
        ASTNode temp;

        if(children.size() == 2){
            children.get(1).setLeftChild(children.get(0));
            temp = curChild.getParent();
            temp.removeChild(curChild);
            curChild = temp;
            curChild.addChild(children.get(1));
        }
        else if(children.size() == 3)
        {
            children.get(0).setRightChild(children.get(1));
            children.get(2).setLeftChild(children.get(0));
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

    @Override public void enterAddop(LittleParser.AddopContext ctx) {
        // System.out.println("ENTER Addop: " + ctx.getText());
        String name = ctx.getText();
        ASTNode temp = new ASTNode(name);
        curChild.addChild(temp);
        temp.setParent(curChild);
    }

	@Override public void exitAddop(LittleParser.AddopContext ctx) {
        //System.out.println("exit Addop: " + ctx.getText() + " " + curChild.getChildren().size());
    }
	
	@Override public void enterMulop(LittleParser.MulopContext ctx) { 
        // System.out.println("ENTER MULOP");
        String name = ctx.getText();
        ASTNode temp = new ASTNode(name);
        curChild.addChild(temp);
        temp.setParent(curChild);
    }
	
	@Override public void exitMulop(LittleParser.MulopContext ctx) {

        ////System.out.println("exit Mulop: " + ctx.getText());
    }
	
    @Override public void enterAssign_expr(LittleParser.Assign_exprContext ctx) {
        String name = ctx.getText();
        // System.out.println("ENTER Assign_stmt: " + ctx.getText());
        String id = name.split(":")[0];
        ASTNode temp;
        // String ops = name.split("=")[1];
        TokenData td = stt.peek().lookUp(id);
        if(td != null){
            curRoot = new ASTNode();
            temp = new ASTNode(td.type, id);
            astRootNodes.add(curRoot);
            curRoot.setLeftChild(temp);
        }
    }

    @Override public void enterId(LittleParser.IdContext ctx) { 
        String idname = ctx.getText();
        System.out.println("ENTER ID: " + ctx.getText());
        if(idname.equals("main"))
        {
            ASTNode main = new ASTNode("LABEL", idname);
            astRootNodes.add(main);
        }
    }
	
	@Override public void exitId(LittleParser.IdContext ctx) {
        //System.out.println("exit Id: " + ctx.getText());
    }
	

	
	@Override public void enterFactor(LittleParser.FactorContext ctx) {
        //System.out.println("ENTER FACTOR: " + ctx.getText());
        if(ctx.getText() == ""){
            return;
        }
        ASTNode temp = new ASTNode();
        curChild.addChild(temp);
        temp.setParent(curChild);
        curChild = temp;
    }
	
	@Override public void exitFactor(LittleParser.FactorContext ctx) {
        if(ctx.getText() == ""){
            return;
        }
        ArrayList<ASTNode> children = curChild.getChildren();
        // System.out.println("exit Factor: " + ctx.getText() +  " || " + children.size());

        ASTNode temp;

        if(children.size() == 0){
            temp = curChild.getParent();
            temp.removeChild(curChild);
            curChild = temp;
        }
        else if (children.size() == 1){
            temp = curChild.getParent();
            temp.removeChild(curChild);
            curChild = temp;
            curChild.addChild(children.get(0));
        }
        else{
            children.get(0).setRightChild(children.get(1));
            temp = curChild.getParent();
            temp.removeChild(curChild);
            curChild = temp;
            curChild.addChild(children.get(0));
        }
    }
	
	@Override public void enterFactor_prefix(LittleParser.Factor_prefixContext ctx) {
        // System.out.println("ENTER Factor_prefix " + ctx.getText());
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
        if(ctx.getText() == ""){
            return;
        }
        ArrayList<ASTNode> children = curChild.getChildren();
        // System.out.println("exit Factor_prefix: " + ctx.getText() + " || " + children.size());
        ASTNode temp;

        if(children.size() == 2){
            children.get(1).setLeftChild(children.get(0));
            temp = curChild.getParent();
            temp.removeChild(curChild);
            curChild = temp;
            curChild.addChild(children.get(1));
        }
        else if(children.size() == 3)
        {
            children.get(0).setRightChild(children.get(1));
            children.get(2).setLeftChild(children.get(0));
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
        if(ctx.getText() == "" || ctx.getText().equals("(a+b)"))
        {
            return;
        }
        System.out.println("Enter Postfix_expr: " + ctx.getText());

        ASTNode temp = new ASTNode();
        curChild.addChild(temp);
        temp.setParent(curChild);
        curChild = temp;
        System.out.println("ENTER POST FIX: " + curChild);
    }
	
	@Override public void exitPostfix_expr(LittleParser.Postfix_exprContext ctx) {
        // if(curChild == null && curChild.getParent() == null){
        //     return;
        // }
        if(ctx.getText() == ""){
            return;
        }
        System.out.println("EXIT POSTFIX: " + curChild + " " + ctx.getText());
        ArrayList<ASTNode> children = curChild.getChildren();
        //System.out.println("exit postfix 1st: " + ctx.getText() + curChild.getChildren().size());

        ASTNode temp = curChild.getParent();
        temp.removeChild(curChild);
        curChild = temp;
        curChild.addChild(children.get(0));
    }

    public ArrayList<ASTNode> getRoots()
    {
        return astRootNodes;
    }
    // Print all symbole tables starting from symbol table r in a readable format
    public void printResults(SymbolTable r){
        //while(r != null){
            if(r.getChildren() != null){
                ArrayList<SymbolTable> children = r.getChildren();
                for(int i = 0; i < children.size(); i++){
                    if(children.get(i).visited == false){
                        children.get(i).setVisited();
                        ////System.out.println("Symbol table " + children.get(i).getName());
                        if(children.get(i).table != null){
                            children.get(i).getData();
                        }
                        ////System.out.println();
                        printResults(children.get(i));
                    }
                }
            }
            else{
                return;
            }
    }
	@Override public void enterStr(LittleParser.StrContext ctx) {
        ////System.out.println("ENTER Str: " + ctx.getText());
    }

	@Override public void exitStr(LittleParser.StrContext ctx) {
        ////System.out.println("exit str: " + ctx.getText());
    }

	@Override public void exitVar_decl(LittleParser.Var_declContext ctx) { 
        ////System.out.println("exit var_decl: " + ctx.getText());
    }
	@Override public void enterVar_type(LittleParser.Var_typeContext ctx) {
        ////System.out.println("ENTER var_type: " + ctx.getText());
    }
	@Override public void exitVar_type(LittleParser.Var_typeContext ctx) {
        ////System.out.println("exit Var_type: " + ctx.getText());
    }
	@Override public void enterWrite_stmt(LittleParser.Write_stmtContext ctx) {
        ////System.out.println("ENTER Write_stmt: " + ctx.getText());
    }

	@Override public void exitWrite_stmt(LittleParser.Write_stmtContext ctx) {
        ////System.out.println("exit Write_stmt: " + ctx.getText());
    }

	@Override public void enterCond(LittleParser.CondContext ctx) {
        ////System.out.println("ENTER Cond: " + ctx.getText());
    }

	@Override public void exitCond(LittleParser.CondContext ctx) {
        ////System.out.println("exit Cond: " + ctx.getText());
    }

	@Override public void enterCompop(LittleParser.CompopContext ctx) {
        ////System.out.println("ENTER compop: " + ctx.getText());
    }

	@Override public void exitCompop(LittleParser.CompopContext ctx) {
        ////System.out.println("Exit Compop: " + ctx.getText());
    }
}

