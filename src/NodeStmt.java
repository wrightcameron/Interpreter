public class NodeStmt extends Node {

	protected NodeAssn assn;
	protected NodeWr wr;

	public NodeStmt(NodeAssn assn,NodeWr wr) {
		this.assn = assn;
		this.wr = wr;
	}

	@Override
	public int eval(Environment env) throws EvalException {
		
		if(assn != null){
			return this.assn.eval(env);
		}else if(wr != null){
			return this.wr.eval(env);
		}
		return -1;
	}

}
