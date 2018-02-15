public class NodeExpr extends Node {
	
	protected NodeTerm term;
	protected NodeAddop addop;
	protected NodeExpr subexpr;
	
	public NodeExpr(NodeTerm term, NodeAddop addop, NodeExpr subexpr) {
		this.term = term;
		this.addop = addop;
		this.subexpr = subexpr;
	}

	@Override
	public int eval(Environment env) throws EvalException {
		int r = this.term.eval(env);
		
		if (addop != null) {
			r = (int) this.addop.op(r, this.subexpr.eval(env));
			//r = this.block.eval(env);
		}
		
		return r;
	}

}
