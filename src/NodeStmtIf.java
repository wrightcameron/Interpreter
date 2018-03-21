


public class NodeStmtIf extends NodeStmt {
	
	private NodeIf nif;
	
	public NodeStmtIf(NodeIf nif) {
		this.nif = nif;
	}
	
	public double eval(Environment env) throws EvalException {
		return nif.eval(env);
	}
}
