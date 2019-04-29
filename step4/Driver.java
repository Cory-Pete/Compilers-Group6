import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Driver {
	
	public static void main(String[] args) throws IOException {
		String returnS;
		LittleLexer lexer = new LittleLexer(CharStreams.fromFileName(args[0]));
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		LittleParser parser = new LittleParser(tokenStream);
		ParseTreeWalker walker = new ParseTreeWalker();

		//Make object of our own class Listener with override methods from BaseLittleListener
		Listener listener = new Listener();
		walker.walk(listener, parser.program());

		
		ArrayList<ASTNode> roots = listener.getRoots();
	

		MakeIRList mlist = new MakeIRList();
		mlist.start(roots);
		ArrayList<IRNode> node = mlist.getIRNodes();

		System.out.println(";Tiny code");
		SymbolTable root = listener.getRoot();
		listener.printResults(root);
		IRNode n = new IRNode();
		n.makeAssebly(node);
		
	}
}      