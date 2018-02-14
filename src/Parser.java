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
		NodeAssn assn = parseAssn();
		return new NodeStmt(assn);
	}

	private NodeAssn parseAssn() throws SyntaxException {
		
		Token id = scanner.curr();
		
		match("id");
		match("=");
		
		Token num = scanner.curr();
		
		match("num");
		
		return new NodeAssn(id.lex(), Integer.parseInt(num.lex()));
	}

	private NodeExpr parseExpr() throws SyntaxException {
		NodeTerm term = parseTerm();
		NodeAddop addop = parseAddop();
		if (addop == null)
			return new NodeExpr(term, null, null);
		NodeExpr expr = parseExpr();
		expr.append(new NodeExpr(term, addop, null));
		return expr;
	}

	private NodeTerm parseTerm() throws SyntaxException {
		return null;
	}

	private NodeFact parseFact() throws SyntaxException {
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
