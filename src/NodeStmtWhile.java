
public class NodeStmtWhile extends NodeStmt {

	private NodeWhile nwhile;
	
	public NodeStmtWhile(NodeWhile nwhile) {
		this.nwhile = nwhile;
	}
	
	public double eval(Environment env) throws EvalException {
		return nwhile.eval(env);
	}
}
