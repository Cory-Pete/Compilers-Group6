class Listener extends LittleBaseListener
{
    SymbolTable st = new SymbolTable();

    @Override
    public void enterFunc_decl(LittleParser.Func_declContext ctx)
    {
        //operate on symbol table here
    }

    @Override
    public void exitFunc_decl(LittleParser.Func_declContext ctx)
    {
        //operate on symbol table here
    }
}

