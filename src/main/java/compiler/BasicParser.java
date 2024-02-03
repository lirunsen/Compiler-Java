package compiler;

public class BasicParser {
    private Lexer lexer;
    private boolean isLegalStatement = true;
    
    public BasicParser(Lexer lexer) {
    	this.lexer = lexer;
    }

	/**
	 * Check if the input is legal based on the grammar rules.
	 */
	public void statements() {
    	/*
    	 * statements -> expression ; | expression ; statements
    	 */
    	
    	expression();
    	
    	if (lexer.match(Lexer.SEMI)) {
    		lexer.advance(); 
    	}
    	else {
    		isLegalStatement = false;
    		System.out.println("line: " + lexer.yylineno + " Missing semicolon");
    		return;
    	}
    	
    	if (lexer.match(Lexer.EOI) != true) {
    		statements();
    	}
    	
    	if (isLegalStatement) {
    		System.out.println("The statement is legal");
    	}
    }
    
    private void expression() {
    	/*
    	 * expression -> term expression'
    	 */
    	term();
    	expr_prime(); //expression'
    }
    
    private void expr_prime() {
    	/*
    	 * expression' -> PLUS/MINUS term expression' | ''
    	 */
    	if (lexer.match(Lexer.PLUS) || lexer.match(Lexer.MINUS)) {
    		lexer.advance();
    		term();
    		expr_prime();
    	}
    	else if (lexer.match(Lexer.UNKNOWN_SYMBOL)) {
    		isLegalStatement = false;
    		System.out.println("unknow symbol: " + lexer.yytext);
    		return;
    	}
    	else {
    		return;
    	}
    }
    
    private void term() {
    	/*
    	 * term -> factor term'
    	 */
    	factor();
    	term_prime(); //term'
    }
    
    private void term_prime() {
    	/*
    	 * term' -> *or/ factor term' | ''
    	 */
    	if (lexer.match(Lexer.TIMES) || lexer.match(Lexer.DIVIDE)) {
    		lexer.advance();
    		factor();
    		term_prime();
    	}
    	else {
    		return;
    	}
    }
    
    private void factor() {
    	/*
    	 * factor -> NUM_OR_ID | LP expression RP
    	 */
    	
    	if (lexer.match(Lexer.NUM_OR_ID)) {
    		lexer.advance();
    	}
    	else if (lexer.match(Lexer.LP)){
    		lexer.advance();
    		expression();
    		if (lexer.match(Lexer.RP)) {
    			lexer.advance();
    		}
    		else {
    			isLegalStatement = false;
    			System.out.println("line: " + lexer.yylineno + " Missing )");
    			return;
    		}
    	}
    	else {
    		isLegalStatement = false;
    		System.out.println("illegal statements");
    		return;
    	}
    }
}
