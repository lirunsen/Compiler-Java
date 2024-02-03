package compiler;

public class ImprovedParser {

    private Lexer lexer;
    public boolean isLegalStatement = true;
    
    public ImprovedParser(Lexer lexer) {
    	this.lexer = lexer;
    }
    
    public void statements() {
    	/*
    	 * statements -> expression ; | expression ; statements
    	 */
   
    	while (lexer.match(Lexer.EOI) != true) {
    		expression();
    		
    		if (lexer.match(Lexer.SEMI)) {
    			lexer.advance();
    		}
    		else {
    			isLegalStatement = false;
    			System.out.println("line: " + lexer.yylineno + " Missing semicolon");
    		}
    	}
    
    	
    	if (isLegalStatement) {
    		System.out.println("The statement is legal");
    	}
    }
    
    private void expression() {
    	/*
    	 * expression -> term expression'
    	 * expression -> PLUS/MINUS term expression' | ''
    	 */
    	term();
    	while (lexer.match(Lexer.PLUS) || lexer.match(Lexer.MINUS)) {
    		lexer.advance();
    		term();
    	}
    	
    	if (lexer.match(Lexer.UNKNOWN_SYMBOL)) {
    		isLegalStatement = false;
    		System.out.println("unknow symbol: " + lexer.yytext);
    		return;
    	}
    	else {
    		return;
    	}
    }
    
    
    /*
     * 
    private void expr_prime() {
    	
    	if (lexer.match(Lexer.PLUS)|| lexer.match(Lexer.MINUS)) {
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
    */
    
    private void term() {
    	factor ();
    	
    	/*
    	 * Convert the recursive calls of term_prime into a loop
    	 * term' -> *or/ factor term' | ''
    	 */
    	
    	while (lexer.match(Lexer.TIMES) || lexer.match(Lexer.DIVIDE)) {
    		lexer.advance();
    		factor();
    	}
    }
    
    /*
     *
    private void term_prime() {
    	
    	if (lexer.match(Lexer.TIMES)|| lexer.match(Lexer.DIVIDE)) {
    		lexer.advance();
    		factor();
    		term_prime();
    	}
    	else {
    	
    		return;
    	}
    }
    */
    
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
