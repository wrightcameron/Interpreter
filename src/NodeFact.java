public class NodeFact extends Node {

	private Token id;
	private String num;
	private NodeExpr expr;
	
	public NodeFact(Token id,String num,NodeExpr expr) {
		this.id = id;
		this.num = num;
		this.expr = expr;
	}

	@Override
	public int eval(Environment env) throws EvalException {
		int r;
		if(id != null){
			r = env.get(, id);
		}else if(num != null){
			r = Integer.parseInt(num);
			
		}else if(expr != null){
			r = expr.eval(env);
		}
		return r;
	}
}
