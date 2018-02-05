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
		NodeStmt stmt;
		NodeBlock block;
		if(scanner.curr().tok().equals(";")){
			stmt = parseStmt();
			match(";");
			block = parseBlock();
			return new NodeBlock(stmt, block);
		} else {
			stmt = parseStmt();
			return new NodeBlock(stmt);
		}
		/*
		NodeStmt stmt = parseStmt();
		return new NodeBlock(stmt);
		*/
		
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

	private void match(String s) throws SyntaxException {
		scanner.match(new Token(s));
	}

}