// (C) 2013 Jim Buffenbarger
// All rights reserved.

public class Parser {

	private Scanner scanner;

	private void match(String s) throws SyntaxException {
		scanner.match(new Token(s));
	}

	private Token curr() throws SyntaxException {
		return scanner.curr();
	}

	private int pos() {
		return scanner.pos();
	}

	private NodeRelop parseRelop() throws SyntaxException {
		if (curr().equals(new Token("<"))) {
			match("<");
			return new NodeRelop(pos(), "<");
		}
		if (curr().equals(new Token("<="))) {
			match("<=");
			return new NodeRelop(pos(), "<=");
		}
		if (curr().equals(new Token(">"))) {
			match(">");
			return new NodeRelop(pos(), ">");
		}
		if (curr().equals(new Token(">="))) {
			match(">=");
			return new NodeRelop(pos(), ">=");
		}
		if (curr().equals(new Token("<>"))) {
			match("<>");
			return new NodeRelop(pos(), "<>");
		}
		if (curr().equals(new Token("=="))) {
			match("==");
			return new NodeRelop(pos(), "==");
		}
		return null;
	}

	private NodeMulop parseMulop() throws SyntaxException {
		if (curr().equals(new Token("*"))) {
			match("*");
			return new NodeMulop(pos(), "*");
		}
		if (curr().equals(new Token("/"))) {
			match("/");
			return new NodeMulop(pos(), "/");
		}
		return null;
	}

	private NodeAddop parseAddop() throws SyntaxException {
		if (curr().equals(new Token("+"))) {
			match("+");
			return new NodeAddop(pos(), "+");
		}
		if (curr().equals(new Token("-"))) {
			match("-");
			return new NodeAddop(pos(), "-");
		}
		return null;
	}

	private NodeBoolExpr parseBoolExpr() throws SyntaxException {
		NodeExpr firstExpr = parseExpr();
		NodeRelop relop = parseRelop();
		NodeExpr secondExpr = parseExpr();
		return new NodeBoolExpr(firstExpr, relop, secondExpr);
	}

	private NodeFact parseFact() throws SyntaxException {
		if (curr().equals(new Token("("))) {
			match("(");
			NodeExpr expr = parseExpr();
			match(")");
			return new NodeFactExpr(expr);
		}
		if (curr().equals(new Token("-"))) {
			match("-");
			NodeFact fact = parseFact();
			return new NodeFactFact(fact);
		}
		if (curr().equals(new Token("id"))) {
			Token id = curr();
			match("id");
			return new NodeFactId(pos(), id.lex());
		}
		Token num = curr();
		match("num");
		return new NodeFactNum(num.lex());
	}

	private NodeTerm parseTerm() throws SyntaxException {
		NodeFact fact = parseFact();
		NodeMulop mulop = parseMulop();
		if (mulop == null)
			return new NodeTerm(fact, null, null);
		NodeTerm subterm = parseTerm();
		return new NodeTerm(fact, mulop, subterm);
	}

	private NodeExpr parseExpr() throws SyntaxException {
		NodeTerm term = parseTerm();
		NodeAddop addop = parseAddop();
		if (addop == null)
			return new NodeExpr(term, null, null);
		NodeExpr subexpr = parseExpr();
		return new NodeExpr(term, addop, subexpr);
	}

	private NodeAssn parseAssn() throws SyntaxException {
		Token id = curr();
		match("id");
		match("=");
		NodeExpr expr = parseExpr();
		NodeAssn assn = new NodeAssn(id.lex(), expr);
		return assn;
	}
	
	private NodeRd parseRd() throws SyntaxException {
		//TODO Do I need to find the Id, this is a read so it should be from the command line.
		match("rd");
		return new NodeRd();
	}

	private NodeWr parseWr() throws SyntaxException {
		match("wr");
		NodeExpr expr = parseExpr();
		NodeWr wr = new NodeWr(expr);
		return wr;
	}
	
	private NodeIf parseIf() throws SyntaxException {
		match("if");
		NodeBoolExpr boolExpr = parseBoolExpr();
		match("then");
		NodeStmt stmt = parseStmt();
		NodeStmt elseStmt = null;
		if (curr().equals(new Token("else"))){
			match("else");
			 elseStmt = parseStmt();
		}
		return new NodeIf(boolExpr,stmt,elseStmt);
		
	}
	
	private NodeWhile parseWhile() throws SyntaxException {
		match("while");
		NodeBoolExpr boolExpr = parseBoolExpr();
		match("do");
		NodeStmt stmt = parseStmt();
		return new NodeWhile(boolExpr,stmt);
	}
	
	private NodeBegin parseBegin() throws SyntaxException {
		match("begin");
		NodeBlock nodeBlock = parseBlock();
		match("end");
		return new NodeBegin(nodeBlock);
	}

	private NodeStmt parseStmt() throws SyntaxException {

		if (curr().equals(new Token("id"))) {
			NodeAssn assn = parseAssn();
			return new NodeStmtAssn(assn);
		}
		if (curr().equals(new Token("rd"))) {
			NodeRd rd = parseRd();
			return new NodeStmtRd(rd);
		}
		if (curr().equals(new Token("wr"))) {
			NodeWr wr = parseWr();
			return new NodeStmtWr(wr);
		}
		if (curr().equals(new Token("if"))) {
			NodeIf nif = parseIf();
			return new NodeStmtIf(nif);
		}
		if (curr().equals(new Token("while"))) {
			NodeWhile nwhile = parseWhile();
			return new NodeStmtWhile(nwhile);
		}
		if (curr().equals(new Token("begin"))) {
			NodeBegin begin = parseBegin();
			return new NodeStmtBegin(begin);
		}
		return null;
	}

	private NodeBlock parseBlock() throws SyntaxException {
		NodeStmt stmt = parseStmt();
		NodeBlock rest = null;
		if (curr().equals(new Token(";"))) {
			match(";");
			rest = parseBlock();
		}
		NodeBlock block = new NodeBlock(stmt, rest);
		return block;

	}
	
	private NodeProg parseProg() throws SyntaxException {
		NodeBlock block = parseBlock();
		return new NodeProg(block);
	}

	public Node parse(String program) throws SyntaxException {
		scanner = new Scanner(program);
		scanner.next();
		return parseProg();
	}

}
