


public class NodeBoolExpr extends Node{

	private NodeExpr firstExpr;
	private NodeRelop relop;
	private NodeExpr secondExpr;
	
	public NodeBoolExpr(NodeExpr firstExpr, NodeRelop relop, NodeExpr secondExpr) {
		this.firstExpr = firstExpr;
		this.relop = relop;
		this.secondExpr = secondExpr;
	}
	
	public double eval(Environment env) throws EvalException {
		return relop.op(firstExpr.eval(env), secondExpr.eval(env));
	}

}
