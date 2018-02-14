public class NodeBlock extends Node {

	private NodeStmt stmt;
	private NodeBlock block;

	public NodeBlock(NodeStmt stmt, NodeBlock block) {
		this.stmt = stmt;
		this.block = block;
	}
	
	@Override
	public int eval(Environment env) throws EvalException {
		int r = this.stmt.eval(env);
		
		if (block != null) {
			r = this.block.eval(env);
		}
		
		return r;
	}

}