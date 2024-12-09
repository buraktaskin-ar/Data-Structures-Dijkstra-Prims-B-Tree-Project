


package proje4.dijsktra;

import java.util.ArrayList;


public class Main {
	public static void main (String[] args) {
//		ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
//		nodeList.add (new WeightedNode ("A",0));
//		nodeList.add (new WeightedNode ("B",1));
//		nodeList.add (new WeightedNode ("C",2));
//		nodeList.add (new WeightedNode ("D",3));
//		nodeList.add (new WeightedNode ("E",4));
//		nodeList.add (new WeightedNode ("F",5));
//		nodeList.add (new WeightedNode ("G",6));
//
//
//		WeightedGraph newGraph = new WeightedGraph (nodeList);
//
//		newGraph.addWeightedEdge (0,1,2);
//		newGraph.addWeightedEdge (0,2,5);
//		newGraph.addWeightedEdge (1,2,6);
//		newGraph.addWeightedEdge (1,3,1);
//		newGraph.addWeightedEdge (1,4,3);
//		newGraph.addWeightedEdge (2,5,8);
//		newGraph.addWeightedEdge (3,4,9);
//		newGraph.addWeightedEdge (4,6,9);
//		newGraph.addWeightedEdge (5,6,7);
//		System.out.println ("Printing from source A: ");
//		newGraph.dijkstra (nodeList.get (0));


















//
//		ArrayList<WeightedNode> nodelist = new ArrayList<WeightedNode> ();
//
//		nodelist.add (new WeightedNode ("A"));
//		nodelist.add (new WeightedNode ("B"));
//		nodelist.add (new WeightedNode ("C"));
//		nodelist.add (new WeightedNode ("D"));
//
//		DisjointSet.makeSet (nodelist);
//		WeightedNode firstNode = nodelist.get (0);
//		WeightedNode secondNode = nodelist.get (1);
//		DisjointSet.union (firstNode,secondNode);
//		DisjointSet output = DisjointSet.findSet (secondNode);
//		output.printAllNodesofThisSet ();
//
	
	

		ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode> ();
		nodeList.add (new WeightedNode ("A"));
		nodeList.add (new WeightedNode ("B"));
		nodeList.add (new WeightedNode ("C"));
		nodeList.add (new WeightedNode ("D"));
		nodeList.add (new WeightedNode ("E"));
		Prims graph = new Prims (nodeList);
		graph.addWeightedUndirectedEdge (0,1,5);
		graph.addWeightedUndirectedEdge (0,2,13);
		graph.addWeightedUndirectedEdge (0,4,15);
		graph.addWeightedUndirectedEdge (1,2,10);
		graph.addWeightedUndirectedEdge (1,3,8);
		graph.addWeightedUndirectedEdge (2,3,6);
		graph.addWeightedUndirectedEdge (2,4,20);
		System.out.println ("Running prims algo on the graph");
		graph.prims (nodeList.get (4));

	
	
	}

	
	
	
	
	
}
