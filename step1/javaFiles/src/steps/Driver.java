package steps;

import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.*;
import steps.LittleLexer;

public class Driver {
	public static void main(String[] args) throws IOException {
		PrintWriter writer = new PrintWriter("src/steps/Sagen_Matthew.output", "UTF-8"); //this is used to print to output file
		LittleLexer lexer = new LittleLexer(CharStreams.fromFileName("../Step1/inputs/sqrt.micro"));
		Vocabulary voc = lexer.getVocabulary();
		//tok.getType != EOF
		Token token = null;
		while(lexer.nextToken().getType()!=token.EOF) {
			token = lexer.nextToken();
			System.out.println("Token Type:" + voc.getSymbolicName(token.getType()));
			System.out.println("Value: " + token.getText());
		}
		
		
		writer.close();
	}
	
	
}