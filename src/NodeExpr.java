public class NodeExpr extends Node {
	
	private NodeTerm term;
	private NodeAddop addop;
	private NodeExpr subexpr;
	
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
