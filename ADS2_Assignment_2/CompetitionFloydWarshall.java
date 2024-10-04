import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ï‚· Each contestant walks at a given estimated speed.
 *    ï‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */

public class CompetitionFloydWarshall {

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     */
	private int speedA;
	private int speedB;
	private int speedC;
	public int totalIntersections;
	public int totalStreets;
	private Map<Integer, ArrayList<Node>> adjacencyList;
    private Double[][] distances;
    
    CompetitionFloydWarshall (String filename, int sA, int sB, int sC){
    	totalIntersections = 0;
    	totalStreets = 0;
    	try {
    		File file = new File(filename);
    		Scanner scanner = new Scanner(file);
    		totalIntersections = scanner.nextInt();
    		adjacencyList = new HashMap<Integer, ArrayList<Node>>();
    		totalStreets = scanner.nextInt();
    		while(scanner.hasNextLine()) {
    			if (!scanner.hasNextInt()) {
    				break;
    			}
    			Integer v1 = scanner.nextInt();
    			Integer v2 = scanner.nextInt();
    			Double cost = scanner.nextDouble();
    			Node node = new Node(v2,cost);
    			if (!adjacencyList.containsKey(v1)) {
    				adjacencyList.put(v1, new ArrayList<Node>());
    			}	
    			if (!adjacencyList.containsKey(v2)) {
    				adjacencyList.put(v2, new ArrayList<Node>());
    			}		
    			ArrayList<Node> adj1 = adjacencyList.get(v1);
    			adj1.add(node);
    		}
    		scanner.close();
    	}
    	catch (IOException error){
    		System.out.println("Error encountered when opening file: ");
    		error.printStackTrace();
    	}
    	catch (NullPointerException error){
    		System.out.println("Error encountered when opening file: ");
    		error.printStackTrace();
    	}
    	this.speedA = sA;
    	this.speedB = sB;
    	this.speedC = sC;
    	distances = new Double[totalIntersections][totalIntersections];
    	for (int i = 0;i<totalIntersections; i++)
    		for (int j = 0;j<totalIntersections;j++) {
    			distances[i][j] = 0.0;
    		}
    }
    
    private class Node {
    	private int label;
    	private double cost;
    	public Node (int label, double cost) {
    		this.label = label;
    		this.cost = cost;
    	}
    	public double getCost() {
    		return cost;
    	}
    	public int getLabel() {
    		return label;
    	}
    }

    /**
    * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){
    	if ((speedA < 50) || (speedA > 100) || (speedB < 50) || (speedB > 100) || (speedC < 50) || (speedC > 100)) {
    		return -1;
    	}
    	if (adjacencyList.size() == 0){
    		return -1;
    	}
    	FW();
    	Double max = 0.0;
        for (int i = 0; i < distances.length; i++) {
        	for (int j = 0; j < distances.length; j++) {
        		if (max < distances[i][j]) {
        			max = distances[i][j];
        		}
        	}
        }
        if (max == Double.POSITIVE_INFINITY) {
        	return -1;
        }
        else {
        	max = max * 1000;
        	int minSpeed = Math.min(speedA, speedB);
        	minSpeed = Math.min(minSpeed, speedC);
        	Double time = max / Double.valueOf(minSpeed);
        	return (int)(Math.ceil(time));
        }
    }
    
    public void FW() {
    	for (int i = 0;i<totalIntersections; i++) {
    		for (int j = 0;j<totalIntersections;j++) {
    			if (i == j) {
    				distances[i][j] = 0.0;
    			} else {
    				distances[i][j] = Double.POSITIVE_INFINITY;
    			}
    		}
    	}
    	for(Integer v : adjacencyList.keySet()) {
    		for (Node n : adjacencyList.get(v)) {
    			distances[v][n.getLabel()]= n.getCost();
    		}
    	}
    	for (int k = 0; k <totalIntersections; k++) {
    		for (int i = 0;i < totalIntersections; i++) {
    			for (int j = 0; j < totalIntersections; j++) {
    				if (distances[i][j] > (distances[k][j] + distances[i][k])) {
    					distances[i][j] = (distances[k][j] + distances[i][k]);
    				}
    			}
    		}
    	}
    }
}