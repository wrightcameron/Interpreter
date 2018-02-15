public class NodeFact extends Node {

	protected String id;
	protected String num;
	protected NodeExpr expr;
	
	public NodeFact(String id,String num,NodeExpr expr) {
		this.id = id;
		this.num = num;
		this.expr = expr;
	}

	@Override
	public int eval(Environment env) throws EvalException {
		int r = -1;
		if(id != null){
			r = env.get(pos, id);
		}else if(num != null){
			r = Integer.parseInt(num);
			
		}else if(expr != null){
			r = expr.eval(env);
		}
		return r;
	}
}
