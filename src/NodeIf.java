
public class NodeIf extends Node {

	private NodeBoolExpr boolExpr;
	private NodeStmt stmt;
	private NodeStmt elseStmt;

	public NodeIf(NodeBoolExpr boolExpr, NodeStmt stmt, NodeStmt elseStmt) {
		this.boolExpr = boolExpr;
		this.stmt = stmt;
		this.elseStmt = elseStmt;
	}

	public double eval(Environment env) throws EvalException {
		//What do I return if the logic for the first if statement is false.
		if (elseStmt == null) {
			if (checkCondition(env)) {
				return stmt.eval(env);
			}
		} else {
			if (checkCondition(env)) {
				return stmt.eval(env);
			} else {
				return elseStmt.eval(env);
			}
		}
		return 0;
	}

	private boolean checkCondition(Environment env) throws EvalException {
		boolean conditional = false;
		if (boolExpr.eval(env) == 1) {
			conditional = true;
		}
		return conditional;
	}
}
