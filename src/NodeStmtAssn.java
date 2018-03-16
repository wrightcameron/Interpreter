// (C) 2013 Jim Buffenbarger
// All rights reserved.

public class NodeStmtAssn extends NodeStmt {

    private NodeAssn assn;

    public NodeStmtAssn(NodeAssn assn) {
	this.assn=assn;
    }

    public int eval(Environment env) throws EvalException {
	return assn.eval(env);
    }

}
