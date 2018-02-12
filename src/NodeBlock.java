
public class NodeBlock extends Node {

	public NodeStmt stmt;
	public NodeBlock block;

	public NodeBlock(NodeStmt stmt, NodeBlock block) {
		this.stmt = stmt;
		this.block = block;
	}

	public NodeBlock(NodeStmt stmt) {
		this.stmt = stmt;
	}

	public int eval(Environment env) throws EvalException {
		// TODO Do this.
		return 0;
	}
}
