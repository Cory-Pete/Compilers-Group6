import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import org.antlr.v4.runtime.*;

public class Driver {
	public static void main(String[] args) throws IOException {
		PrintWriter writer = new PrintWriter("group6.output", "UTF-8"); //this is used to print to output file
		String returnS;
		// LittleLexer lexer = null;
		File input = new File(args[0]);
		LittleLexer lexer = new LittleLexer(CharStreams.fromFileName(args[0]));
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		// LittleLexer lexer = new LittleLexer(CharStreams.fromFileName("../Step1/inputs/sqrt.micro"));
		LittleParser parser = new LittleParser(tokenStream);
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(new ParseTreeListener(), parser.program());
		if(parser.getNumberOfSyntaxErrors() > 0)
		{
			returnS = "Accepted";
		}
		else{
			returnS = "Not Accepted";
		}
		writer.close();
	}
}