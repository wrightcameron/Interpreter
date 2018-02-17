import java.util.*;

/*
 * This class is a recursive-descent parser,
 * modeled after the programming language's grammar.
 * It constructs and has-a Scanner for the program
 * being parsed.
*/
public class Parser {

	private Scanner scanner;

	/*
	 * Creates a new scanner for the string to be parsed. Returns the parsed
	 * statement Throws SyntaxException if the scanner class throws one.
	 * 
	 * @param program
	 */
	public Node parse(String program) throws SyntaxException {
		scanner = new Scanner(program);
		scanner.next();
		return parseBlock();
	}

	private NodeBlock parseBlock() throws SyntaxException {
		NodeStmt stmt = parseStmt();

		Token t = scanner.curr();

		NodeBlock block = null;
		if (";".equals(t.lex())) {
			match(";"); // consume the semicolon and move onto the next token
			block = parseBlock();
		}

		return new NodeBlock(stmt, block);
	}

	private NodeStmt parseStmt() throws SyntaxException {
		Token t = scanner.curr();
		NodeAssn assn = null;
		NodeWr wr = null;
		if ("wr".equals(t.tok())) {
			wr = parseWr();
		}else{
			assn = parseAssn();
		}
		return new NodeStmt(assn, wr);
	}
	
	private NodeWr parseWr() throws SyntaxException {
		Token wr = scanner.curr();
		match("wr");
		NodeExpr expr = parseExpr();
		return new NodeWr(expr);
		
	}

	private NodeAssn parseAssn() throws SyntaxException {

		Token id = scanner.curr();

		match("id");
		match("=");

		NodeExpr expr = parseExpr();

		return new NodeAssn(id.lex(), expr);
	}

	private NodeExpr parseExpr() throws SyntaxException {
		NodeTerm term = parseTerm();
		NodeAddop addop = parseAddop();
		if (addop == null)
			return new NodeExpr(term, null, null);
		NodeExpr subexpr = parseExpr();
		return new NodeExpr(term, addop, subexpr);
	}

	private NodeTerm parseTerm() throws SyntaxException {
		NodeFact fact = parseFact();
		NodeMulop mulop = parseMulop();
		if (mulop == null)
			return new NodeTerm(fact, null, null);
		NodeTerm subterm = parseTerm();
		return new NodeTerm(fact, mulop, subterm);
	}

	private NodeFact parseFact() throws SyntaxException {
		Token t = scanner.curr();
		NodeExpr expr;
		if ("id".equals(t.tok())) {
			match("id");
			return new NodeFact(t.lex(), null, null);
		} else if ("num".equals(t.tok())) {
			match("num");
			return new NodeFact(null, t.lex(), null);
		}else if("(".equals(t.tok())){
			match("(");
			expr = parseExpr();
			match(")");
			return new NodeFact(null, null, expr);
		}
		return null;
	}

	private NodeAddop parseAddop() throws SyntaxException {
		if (scanner.curr().equals(new Token("+"))) {
			match("+");
			return new NodeAddop(scanner.pos(), "+");
		}
		if (scanner.curr().equals(new Token("-"))) {
			match("-");
			return new NodeAddop(scanner.pos(), "-");
		}
		return null;
	}

	private NodeMulop parseMulop() throws SyntaxException {
		if (scanner.curr().equals(new Token("*"))) {
			match("*");
			return new NodeMulop(scanner.pos(), "*");
		}
		if (scanner.curr().equals(new Token("/"))) {
			match("/");
			return new NodeMulop(scanner.pos(), "*");
		}
		return null;
	}

	private void match(String s) throws SyntaxException {
		scanner.match(new Token(s));
	}

}
