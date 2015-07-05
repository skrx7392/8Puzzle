/*
 * Created on Sep 12, 2004
 *
 */
package aima.search.demos;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.search.eightpuzzle.EightPuzzleBoard;
import aima.search.eightpuzzle.EightPuzzleGoalTest;
import aima.search.eightpuzzle.EightPuzzleSuccessorFunction;
import aima.search.eightpuzzle.EvaluationFunction8Puzzle;
import aima.search.eightpuzzle.ManhattanHeuristicFunction;
import aima.search.framework.EvaluationFunction;
import aima.search.framework.GraphSearch;
import aima.search.framework.Node;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.RecursiveBestFirstSearch;
import aima.util.FileRead;
import aima.util.ToArray;


/**
 * @author Ravi Mohan
 * 
 */

public class EightPuzzleDemo {
	//static EightPuzzleBoard boardWithThreeMoveSolution = new EightPuzzleBoard(
		//	new int[] { 1, 2, 5, 3, 4, 0, 6, 7, 8 });;

	static EightPuzzleBoard newPuzzle = new EightPuzzleBoard(new int[] { 1, 4, 2,
			7, 5, 8, 3, 0, 6 });

	
	//static EightPuzzleBoard extreme = new EightPuzzleBoard(new int[] { 0, 8, 7,
			//6, 5, 4, 3, 2, 1 });

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<ArrayList<Integer>> initMultiList = FileRead.Matrix("8PuzzleInput.txt");
		int[][]init2DList = ToArray.to2DArray(initMultiList);
		int[] initList = ToArray.toArray(init2DList);
		newPuzzle = new EightPuzzleBoard(ToArray.toArray(init2DList));
		//eightPuzzleDLSDemo();
		//eightPuzzleIDLSDemo();
		//eightPuzzleGreedyBestFirstDemo();
		//eightPuzzleGreedyBestFirstManhattanDemo();
		//eightPuzzleAStarDemo();
		//eightPuzzleAStarManhattanDemo();
		//eightPuzzleSimulatedAnnealingDemo();
		boolean solvable = isSolvable(initList);
		if(solvable){
			eightPuzzleRBFSDemo();
		}
		else {
			System.out.println("The Puzzle cannot be solved!");
			System.exit(0);
		}
		
	}

/*	private static void eightPuzzleDLSDemo() {
		System.out.println("\nEightPuzzleDemo recursive DLS -->");
		try {
			Problem problem = new Problem(random1,
					new EightPuzzleSuccessorFunction(),
					new EightPuzzleGoalTest());
			Search search = new DepthLimitedSearch(9);
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void eightPuzzleIDLSDemo() {
		System.out.println("\nEightPuzzleDemo Iterative DLS -->");
		try {
			Problem problem = new Problem(random1,
					new EightPuzzleSuccessorFunction(),
					new EightPuzzleGoalTest());
			Search search = new IterativeDeepeningSearch();
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void eightPuzzleGreedyBestFirstDemo() {
		System.out
				.println("\nEightPuzzleDemo Greedy Best First Search (MisplacedTileHeursitic)-->");
		try {
			Problem problem = new Problem(boardWithThreeMoveSolution,
					new EightPuzzleSuccessorFunction(),
					new EightPuzzleGoalTest(),
					new MisplacedTilleHeuristicFunction());
			Search search = new GreedyBestFirstSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void eightPuzzleGreedyBestFirstManhattanDemo() {
		System.out
				.println("\nEightPuzzleDemo Greedy Best First Search (ManhattanHeursitic)-->");
		try {
			Problem problem = new Problem(boardWithThreeMoveSolution,
					new EightPuzzleSuccessorFunction(),
					new EightPuzzleGoalTest(), new ManhattanHeuristicFunction());
			Search search = new GreedyBestFirstSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void eightPuzzleAStarDemo() {
		System.out
				.println("\nEightPuzzleDemo AStar Search (MisplacedTileHeursitic)-->");
		try {
			Problem problem = new Problem(random1,
					new EightPuzzleSuccessorFunction(),
					new EightPuzzleGoalTest(),
					new MisplacedTilleHeuristicFunction());
			Search search = new AStarSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void eightPuzzleSimulatedAnnealingDemo() {
		System.out.println("\nEightPuzzleDemo Simulated Annealing  Search -->");
		try {
			Problem problem = new Problem(random1,
					new EightPuzzleSuccessorFunction(),
					new EightPuzzleGoalTest(), new ManhattanHeuristicFunction());
			SimulatedAnnealingSearch search = new SimulatedAnnealingSearch();
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			System.out.println("Search Outcome=" + search.getOutcome());
			System.out.println("Final State=\n" + search.getLastSearchState());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void eightPuzzleAStarManhattanDemo() {
		System.out
				.println("\nEightPuzzleDemo AStar Search (ManhattanHeursitic)-->");
		try {
			Problem problem = new Problem(random1,
					new EightPuzzleSuccessorFunction(),
					new EightPuzzleGoalTest(), new ManhattanHeuristicFunction());
			Search search = new AStarSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	private static void eightPuzzleRBFSDemo(){
		System.out.println("RBFS Implementation of Eight Puzzle Solver");
		try{
			Problem problem = new Problem(newPuzzle,new EightPuzzleSuccessorFunction(),new EightPuzzleGoalTest(),new ManhattanHeuristicFunction());
			Search search = new RecursiveBestFirstSearch(new EvaluationFunction8Puzzle());
			SearchAgent agent = new SearchAgent(problem,search);
			//printActions(agent.getActions());
			System.out.println();
			printBoard(agent.getActions(), newPuzzle);
			printInstrumentation(agent.getInstrumentation());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void printInstrumentation(Properties properties) {
		Iterator keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}

	private static void printActions(List actions) {
		for (int i = 0; i < actions.size(); i++) {
			String action = (String) actions.get(i);
			System.out.println(action);
		}
	}
	
	private static void printBoard(List actions, EightPuzzleBoard p){

		for(int i = 0; i<actions.size();i++)
		{
			String action = (String)actions.get(i);
			if(action.equals("Left")){
				p.moveGapLeft();
				System.out.println(p);
				System.out.println();
			}
			if(action.equals("Right")){
				p.moveGapRight();
				System.out.println(p);
				System.out.println();
			}
			if(action.equals("Up")){
				p.moveGapUp();
				System.out.println(p);
				System.out.println();
			}
			if(action.equals("Down")){
				p.moveGapDown();
				System.out.println(p);
				System.out.println();
			}
		}
	}
	
	public static boolean isSolvable(int[] p) {
		boolean solvable = false;
		int inversions = 0;
		
		for(int i=0; i<p.length-1; i++) {
			for(int j=i+1; j<p.length; j++) {
				if(p[i] > p[j]) {
					inversions++;
				}
			}
			if(p[i] == 0 && i%2 == 1) {
				inversions++;
			}
		}
		if(inversions % 2 == 0){
			solvable=true;
		}
		return solvable;
	}

}