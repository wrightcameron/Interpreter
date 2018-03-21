package interpreter.node;
import interpreter.Environment;
import interpreter.EvalException;

public class NodeWhile extends Node {

	private NodeBoolExpr boolExpr;
	private  NodeStmt stmt;
	
	public NodeWhile(NodeBoolExpr boolExpr, NodeStmt stmt) {
		this.boolExpr = boolExpr;
		this.stmt = stmt;
	}
	
	public double eval(Environment env) throws EvalException {
		double val = 0;
		while(checkCondition(env)){
			val = stmt.eval(env);
		}
		return val;
	}
	
	private boolean checkCondition(Environment env) throws EvalException{
		boolean conditional = false;
		if (boolExpr.eval(env) == 1) {
			conditional = true;
		}
		return conditional;
	}
}
