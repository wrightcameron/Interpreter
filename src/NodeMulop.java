public class NodeMulop extends Node {

    private String mulop;

    public NodeMulop(int pos, String mulop) {
	this.pos=pos;
	this.mulop=mulop;
    }

    public double op(double o1, double o2) throws EvalException {
	if (mulop.equals("*"))
	    return o1*o2;
	if (mulop.equals("/"))
	    return o1/o2;
	throw new EvalException(pos,"bogus addop: "+mulop);
    }
    
	@Override
    public int eval(Environment env) throws EvalException {
		throw new EvalException(pos,"cannot eval() node!");
    }
}
