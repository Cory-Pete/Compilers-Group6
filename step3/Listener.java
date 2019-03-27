class Listener extends LittleBaseListener
{
    SymbolTable st = new SymbolTable();

    @Override
    public void enterFunc_decl(LittleParser.Func_declContext ctx){
        //operate on symbol table here
    }

    @Override
    public void exitFunc_decl(LittleParser.Func_declContext ctx){
        //operate on symbol table here
    }

    @Override public void enterAssign_expr(LittleParser.Assign_exprContext ctx) { 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
        System.out.println(ctx);
    }
    @Override public void exitAssign_expr(LittleParser.Assign_exprContext ctx) { 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    }
	
}

