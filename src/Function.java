public abstract class Function {

    protected int pos=0;
    protected String functionName;
    protected String argumentId;
    protected NodeExpr functionBody;

    public Function(String functionName,String argumentId,NodeExpr functionBody){
        this.functionName = functionName;
        this.argumentId = argumentId;
        this.functionBody = functionBody;
    }

    public double call(Environment env) throws EvalException {
        throw new EvalException(pos,"cannot eval() node!");
    }

}