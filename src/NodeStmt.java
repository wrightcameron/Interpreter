public class NodeStmt extends Node {

	private NodeAssn assn;

	public NodeStmt(NodeAssn assn) {
		this.assn = assn;
	}
	
	@Override
	public int eval(Environment env) throws EvalException {
		return this.assn.eval(env);
	}

}
