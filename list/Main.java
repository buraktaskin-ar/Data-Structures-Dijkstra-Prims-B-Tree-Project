package graph_ds.adj.list;

import java.util.ArrayList;

public class Main {



	public static void main(String[] args) {


		ArrayList<GraphNode> graphNodeArrayList = new ArrayList<GraphNode>();
//
//		graphNodeArrayList.add(new GraphNode("A",0));
//		graphNodeArrayList.add(new GraphNode("B",1));
//		graphNodeArrayList.add(new GraphNode("C",2));
//		graphNodeArrayList.add(new GraphNode("D",3));
//		graphNodeArrayList.add(new GraphNode("E",4));

		Graph graph = new Graph(graphNodeArrayList);
//
//		graph.addUnDirectedEdge(0,1);
//		graph.addUnDirectedEdge(0,2);
//		graph.addUnDirectedEdge(0,3);
//		graph.addUnDirectedEdge(1,4);
//		graph.addUnDirectedEdge(2,3);
//		graph.addUnDirectedEdge(3,4);

//		System.out.println(graph.toString());

		//graph.dfs();
		//graph.bfs();
		
		
		graphNodeArrayList.add(new GraphNode("A",0));
		graphNodeArrayList.add(new GraphNode("B",1));
		graphNodeArrayList.add(new GraphNode("C",2));
		graphNodeArrayList.add(new GraphNode("D",3));
		graphNodeArrayList.add(new GraphNode("E",4));
		graphNodeArrayList.add(new GraphNode("F",5));
		graphNodeArrayList.add(new GraphNode("G",6));
		
		graph.addUnDirectedEdge(0,1);
		graph.addUnDirectedEdge(0,2);
		graph.addUnDirectedEdge(1,3);
		graph.addUnDirectedEdge(1,6);
		graph.addUnDirectedEdge(2,3);
		graph.addUnDirectedEdge(2,4);
		graph.addUnDirectedEdge(3,5);
		graph.addUnDirectedEdge(4,5);
		graph.addUnDirectedEdge(5,6);
		
		graph.BFSForSSSPP (graph.nodeList.get (0));
		
		
		
		
		
		


	}
























}
