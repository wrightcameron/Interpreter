
public class NodeTerm extends Node {

	protected NodeFact fact;
	protected NodeMulop mulop;
	protected NodeTerm subterm;
	
	public NodeTerm(NodeFact fact, NodeMulop mulop, NodeTerm subterm) {
		this.fact = fact;
		this.mulop = mulop;
		this.subterm = subterm;
	}

	@Override 
	public int eval(Environment env) throws EvalException {
		int r = this.fact.eval(env);
		
		if (mulop != null) {
			r = (int) this.mulop.op(r, this.subterm.eval(env));
		}
		
		return r;
	}
}
