
// (C) 2013 Jim Buffenbarger
// All rights reserved.

import java.util.*;

public class Environment {

	private Map<String, Double> map;

	public Environment() {
		map = new HashMap<String, Double>();
	}

	public double put(String var, double val) {
		map.put(var, val);
		return val;
	}

	public Double get(int pos, String var) throws EvalException {
		if (map.containsKey(var))
			return map.get(var);
		throw new EvalException(pos, "undefined variable: " + var);
	}

}
