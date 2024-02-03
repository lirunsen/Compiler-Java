package compiler;

public class Compiler {

	public static void main(String[] args) {
		Lexer lexer = new Lexer();
//		lexer.runLexer();
//		BasicParser basicParser = new BasicParser(lexer);
		ImprovedParser improvedParser = new ImprovedParser(lexer);
		improvedParser.statements();
	}
}
