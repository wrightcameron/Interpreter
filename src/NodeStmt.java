public class NodeStmt extends Node {

	private NodeAssn assn;
	private NodeWr wr;

	public NodeStmt(NodeAssn assn,NodeWr wr) {
		this.assn = assn;
		this.wr = wr;
	}

	@Override
	public int eval(Environment env) throws EvalException {
		return this.assn.eval(env);
	}

}
