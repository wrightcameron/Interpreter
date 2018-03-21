


public class NodeStmtRd extends NodeStmt {

	private NodeRd rd;
	
	public NodeStmtRd(NodeRd rd) {
		this.rd = rd;
	}

	public double eval(Environment env) throws EvalException {
		return rd.eval(env);
	}
}
