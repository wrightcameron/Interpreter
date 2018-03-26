package interpreter;

// (C) 2013 Jim Buffenbarger
// All rights reserved.

import interpreter.node.Node;
import interpreter.node.NodeExpr;

import java.util.*;

public class Environment {

    private Map<String, Double> valMap;
    private Map<String, NodeExpr> funcMap;

    public Environment() {
        valMap = new HashMap<String, Double>();
        funcMap = new HashMap<String, NodeExpr>();
    }

    public double put(String var, double val) {
        valMap.put(var, val);
        return val;
    }

    public double get(int pos, String var) throws EvalException {
        if (valMap.containsKey(var))
            return valMap.get(var);
        throw new EvalException(pos, "undefined variable: " + var);
    }

    public NodeExpr put(String func, NodeExpr expr) {
        funcMap.put(func, expr);
        return expr;
    }

    public NodeExpr call(int pos, String func) throws EvalException {
        if (funcMap.containsKey(func))
            return funcMap.get(func);
        throw new EvalException(pos, "undefined variable: " + func);
    }

}
