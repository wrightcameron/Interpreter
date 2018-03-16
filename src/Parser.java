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

    private NodeMulop parseMulop() throws SyntaxException {
	if (curr().equals(new Token("*"))) {
	    match("*");
	    return new NodeMulop(pos(),"*");
	}
	if (curr().equals(new Token("/"))) {
	    match("/");
	    return new NodeMulop(pos(),"/");
	}
	return null;
    }


    private NodeAddop parseAddop() throws SyntaxException {
	if (curr().equals(new Token("+"))) {
	    match("+");
	    return new NodeAddop(pos(),"+");
	}
	if (curr().equals(new Token("-"))) {
	    match("-");
	    return new NodeAddop(pos(),"-");
	}
	return null;
    }

    private NodeFact parseFact() throws SyntaxException {
	if (curr().equals(new Token("("))) {
	    match("(");
	    NodeExpr expr=parseExpr();
	    match(")");
	    return new NodeFactExpr(expr);
	}
	if (curr().equals(new Token("-"))) {
	    match("-");
	    NodeFact fact=parseFact();
	    return new NodeFactFact(fact);
	}
	if (curr().equals(new Token("id"))) {
	    Token id=curr();
	    match("id");
	    return new NodeFactId(pos(),id.lex());
	}
	Token num=curr();
	match("num");
	return new NodeFactNum(num.lex());
    }

    private NodeTerm parseTerm() throws SyntaxException {
	NodeFact fact=parseFact();
	NodeMulop mulop=parseMulop();
	if (mulop==null)
	    return new NodeTerm(fact,null,null);
	NodeTerm subterm=parseTerm();
	return new NodeTerm(fact,mulop,subterm);
    }

    private NodeExpr parseExpr() throws SyntaxException {
	NodeTerm term=parseTerm();
	NodeAddop addop=parseAddop();
	if (addop==null)
	    return new NodeExpr(term,null,null);
	NodeExpr subexpr=parseExpr();
	return new NodeExpr(term,addop,subexpr);
    }

    private NodeAssn parseAssn() throws SyntaxException {
	Token id=curr();
	match("id");
	match("=");
	NodeExpr expr=parseExpr();
	NodeAssn assn=new NodeAssn(id.lex(),expr);
	return assn;
    }

    private NodeWr parseWr() throws SyntaxException {
	match("wr");
	NodeExpr expr=parseExpr();
	NodeWr wr=new NodeWr(expr);
	return wr;
    }

    private NodeStmt parseStmt() throws SyntaxException {

		if (curr().equals(new Token("id"))) {
		    NodeAssn assn=parseAssn();
		    return new NodeStmtAssn(assn);
		}
		if (curr().equals(new Token("wr"))) {
		    NodeWr wr=parseWr();
		    return new NodeStmtWr(wr);
		}
		return null;
    }

    private NodeBlock parseBlock() throws SyntaxException {
	NodeStmt stmt=parseStmt();
	NodeBlock rest=null;
	if (curr().equals(new Token(";"))) {
	    match(";");
	    rest=parseBlock();
	}
	NodeBlock block=new NodeBlock(stmt,rest);
	return block;

    }
    

    public Node parse(String program) throws SyntaxException {
	scanner=new Scanner(program);
	scanner.next();
	return parseBlock();
    }

}
