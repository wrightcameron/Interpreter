package interpreter.node;
import interpreter.Environment;
import interpreter.EvalException;

// (C) 2013 Jim Buffenbarger
// All rights reserved.

public class NodeFactNum extends NodeFact {

    private String num;

    public NodeFactNum(String num) {
	this.num=num;
    }

    public double eval(Environment env) throws EvalException {
	return Integer.parseInt(num);
    }

}
