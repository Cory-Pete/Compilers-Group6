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
>>>>>>> b1445ddc6a31f0a5e69f9338bd555ab289fb1036
