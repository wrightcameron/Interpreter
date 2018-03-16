
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
		if (elseStmt == null) {
			if (boolExpr.eval(env)){
				stmt.eval(env);
			}
		} else {
			if (boolExpr.eval(env)){
				stmt.eval(env);
			} else {
				elseStmt.eval(env);
			}
		}
	}
}
