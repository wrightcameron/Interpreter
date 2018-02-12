
public class NodeStmt extends Node {

	public NodeAssn assn;

	public NodeStmt(NodeAssn assn) {
		this.assn = assn;
	}

	public int eval(Environment env) throws EvalException {
		// TODO Do this.
		return 0;
	}
}
