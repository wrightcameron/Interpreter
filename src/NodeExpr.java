// (C) 2013 Jim Buffenbarger
// All rights reserved.

public class NodeExpr extends Node {

	private NodeTerm term;
	private NodeAddop addop;
	private NodeExpr expr;

	public NodeExpr(NodeTerm term, NodeAddop addop, NodeExpr expr) {
		this.term=term;
		this.addop=addop;
		this.expr=expr;
	}

	public void append(NodeExpr expr) {
		if (this.expr==null) {
			this.addop=expr.addop;
			this.expr=expr;
			expr.addop=null;
		} else
			this.expr.append(expr);
	}

	public double eval(Environment env) throws EvalException {
		return expr==null
				? term.eval(env)
				: addop.op(expr.eval(env),term.eval(env));
	}

}
