import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class Driver {
	public static void main(String[] args) throws IOException {
		String returnS;
		LittleLexer lexer = new LittleLexer(CharStreams.fromFileName(args[0]));
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		LittleParser parser = new LittleParser(tokenStream);
		ParseTreeWalker walker = new ParseTreeWalker();
		Listener listener = new Listener();
		walker.walk(listener, parser.program());
		for(LittleParser.Assign_exprContext ctx : h){
			System.out.println(ctx.getText());
		}
	}
}      