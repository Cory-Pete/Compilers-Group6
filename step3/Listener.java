class Listener extends LittleBaseListener{
    
    SymbolTable st = new SymbolTable();
    //need to make stack to push new scopes on?

    @Override
    public void enterFunc_decl(LittleParser.Func_declContext ctx){
        //operate on symbol table here, ie add new scope
        SymbolTable new_table = new SymbolTable(ctx.id().getText(), scopeTracker.peek());
        scopeTracker.peek().addTable(new_table);
        scopeTracker.push(new_table);
    }

    @Override
    public void exitFunc_decl(LittleParser.Func_declContext ctx){
        //operate on symbol table here, exit scope?
    }

    @Override public void enterAssign_expr(LittleParser.Assign_exprContext ctx) {
        System.out.println(ctx);
        st.add(ctx);
    }
    @Override public void exitAssign_expr(LittleParser.Assign_exprContext ctx) { 
	
    }
	public SymbolTable getSymbolTable(){
        return st;
    }
}

