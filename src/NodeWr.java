
public class NodeWr extends Node{

	protected NodeExpr expr;
	
	public NodeWr(NodeExpr expr) {
		this.expr = expr;
	}

	@Override
	public int eval(Environment env) throws EvalException {
		int r = this.expr.eval(env);
		System.out.println(r);
		return 0;
	}
}
