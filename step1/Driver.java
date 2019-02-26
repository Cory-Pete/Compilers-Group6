import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.*;

public class Driver {
	public static void main(String[] args) throws IOException {
		PrintWriter writer = new PrintWriter("group6.output", "UTF-8"); //this is used to print to output file
		// LittleLexer lexer = null;
		LittleLexer lexer = new LittleLexer(CharStreams.fromFileName(args[0]));
		CommonTokenStream tokenStream = new CommonTokenStream(Lexer);
		// LittleLexer lexer = new LittleLexer(CharStreams.fromFileName("../Step1/inputs/sqrt.micro"));
		LittleParser p = new LittleParser();
		Vocabulary voc = lexer.getVocabulary();
		//tok.getType != EOF
		Token token = lexer.nextToken();
		while(token.getType() != token.EOF) {
			System.out.println("Token Type: " + voc.getSymbolicName(token.getType()));
			writer.write("Token Type: " + voc.getSymbolicName(token.getType()) + "\n");
			System.out.println("Value: " + token.getText());
			writer.write("Value: " + token.getText() + "\n");
			token = lexer.nextToken();
		}	
		writer.close();
	}
}