public class NodeFactFuncCall extends NodeFact {

    private FuncCall func;

    public NodeFactFuncCall(FuncCall func) {
        this.func = func;
    }

    public double eval(Environment env) throws EvalException {
        return func.call(env);
    }

}