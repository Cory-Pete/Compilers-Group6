import java.util.*;
import java.lang.String;
import org.antlr.v4.runtime.tree.ParseTreeListener;
class Listener extends LittleBaseListener{
    
    Stack<SymbolTable> stt = new Stack <SymbolTable>(); //symbol table tree
    ArrayList<ASTNode> astRootNodes = new ArrayList<ASTNode>();
    int label = 0;
    int maxLabel = 0;
    
    SymbolTable root;

    ASTNode curRoot;
    ASTNode curChild;
    String cond;
    
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
        ASTNode temp = new ASTNode("EXIT", label);
        label--;
        astRootNodes.add(temp);
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
        ASTNode temp = new ASTNode("EXIT", maxLabel);
        maxLabel ++;
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
        ASTNode temp = new ASTNode("EXIT", label);
    }
    public SymbolTable getRoot(){
        return root;
    }
    @Override public void enterPrimary(LittleParser.PrimaryContext ctx) { 
        String idname = ctx.getText();
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
    
    @Override public void enterExpr(LittleParser.ExprContext ctx) {
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
    }

    @Override public void enterExpr_prefix(LittleParser.Expr_prefixContext ctx) {
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
        String name = ctx.getText();
        ASTNode temp = new ASTNode(name);
        curChild.addChild(temp);
        temp.setParent(curChild);
    }
	
	@Override public void enterMulop(LittleParser.MulopContext ctx) { 
        String name = ctx.getText();
        ASTNode temp = new ASTNode(name);
        curChild.addChild(temp);
        temp.setParent(curChild);
    }
	
    @Override public void enterAssign_expr(LittleParser.Assign_exprContext ctx) {
        String name = ctx.getText();
        String id = name.split(":")[0];
        ASTNode temp;
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
        if(idname.equals("main"))
        {
            ASTNode main = new ASTNode("LABEL", idname);
            astRootNodes.add(main);
        }
    }
	
	@Override public void enterFactor(LittleParser.FactorContext ctx) {
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

        ASTNode temp = new ASTNode();
        curChild.addChild(temp);
        temp.setParent(curChild);
        curChild = temp;
    }
	
	@Override public void exitPostfix_expr(LittleParser.Postfix_exprContext ctx) {
        if(ctx.getText() == ""){
            return;
        }

        ArrayList<ASTNode> children = curChild.getChildren();
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
        if(r.getChildren() != null){
            ArrayList<SymbolTable> children = r.getChildren();
            for(int i = 0; i < children.size(); i++){
                if(children.get(i).visited == false){
                    children.get(i).setVisited();
                    if(children.get(i).table != null){
                        children.get(i).getData();
                    }
                    printResults(children.get(i));
                }
            }
        }
        else{
            return;
        }
    }
	@Override public void enterWrite_stmt(LittleParser.Write_stmtContext ctx) {
        for(String ids : ctx.id_list().getText().split(",")){
            TokenData id = stt.peek().lookUp(ids);
            if(id != null){
                ASTNode temp = new ASTNode(id.type, "WRITE", id.name);
                astRootNodes.add(temp);
            }
            else{
                ASTNode temp = new ASTNode("STRING", "WRITE", ids);
                astRootNodes.add(temp);
            }
        }
    }

	@Override public void exitWrite_stmt(LittleParser.Write_stmtContext ctx) {}

	@Override public void enterCond(LittleParser.CondContext ctx) {
        label = maxLabel;
        label++;
        maxLabel++;
    }

	@Override public void exitCond(LittleParser.CondContext ctx) {
        String[] vars = ctx.getText().split(cond);
        String type = stt.peek().lookUp(vars[0]).type;
        ASTNode temp = new ASTNode(vars[0], cond, vars[1], type, label);
        astRootNodes.add(temp);
    }
}

