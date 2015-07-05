package aima.search.eightpuzzle;

import aima.search.framework.EvaluationFunction;
import aima.search.framework.Node;
import aima.search.framework.Problem;

public class EvaluationFunction8Puzzle implements EvaluationFunction {

	@Override
	public Double getValue(Problem p, Node n) {
		return new Double(n.getPathCost()
				+ p.getHeuristicFunction().getHeuristicValue(n.getState()));
	}

}
