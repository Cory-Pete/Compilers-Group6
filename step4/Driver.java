import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

		//Get the root table
		// SymbolTable root = listener.getRoot();

		// ASTNode root = listener.getRootAST();
		ArrayList<ASTNode> roots = listener.getRoots();
		//root.generateCode();
		// MakeIRList a = new MakeIRList();
		MakeIRList.start(roots);

		ArrayList<IRNode> node = MakeIRList.getIRNodes();

		
		// for(IRNode n : node){
		// 	//System.out.println(n.getThreeAC());
		// 	//System.out.println(";" + n.operator + " " +  " " + n.id);
		// }
		PrintWriter writer = null;
		//use PrintWriter to output results to Sagen_Matthew.txt
		try {
			writer = new PrintWriter("step4/new_Tiny.c", "UTF-8");	
		} 
		catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();	
		}
		
		System.out.println(";Tiny code");
		writer.println(";Tny code");
		// listener.printResults(root);//print var declarations
		IRNode n = new IRNode();
		n.makeAssebly(node);
		// IRNode t = new IRNode("h");
		// t.makeAssebly(node);
		//Print entire tree from root
		
		
	}
}      