// (C) 2013 Jim Buffenbarger
// All rights reserved.

public class NodeAddop extends Node {

	protected String addop;

    public NodeAddop(int pos, String addop) {
	this.pos=pos;
	this.addop=addop;
    }

    public double op(double o1, double o2) throws EvalException {
	if (addop.equals("+"))
	    return o1+o2;
	if (addop.equals("-"))
	    return o1-o2;
	throw new EvalException(pos,"bogus addop: "+addop);
    }
    
	@Override
    public int eval(Environment env) throws EvalException {
		throw new EvalException(pos,"cannot eval() node!");
    }

}