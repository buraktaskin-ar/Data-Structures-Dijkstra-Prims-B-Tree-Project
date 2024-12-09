package graph_ds.adj.list;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	ArrayList<GraphNode> nodeList;

	public Graph(ArrayList<GraphNode> nodeList){
		this.nodeList = nodeList;

	}


	public void addUnDirectedEdge(int i, int j){
		GraphNode firstNode = nodeList.get(i);
		GraphNode secondNode = nodeList.get(j);
		firstNode.neighbors.add(secondNode);
		secondNode.neighbors.add(firstNode);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).name + ": ");
			for (int j =0; j < nodeList.get(i).neighbors.size(); j++) {
				if (j == nodeList.get(i).neighbors.size()-1 ) {
					s.append((nodeList.get(i).neighbors.get(j).name) );
				} else {
					s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
				}
			}
			s.append("\n");
		}
		return s.toString();
	}



	public void dfsVisit(GraphNode node){
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		GraphNode currentNode = queue.remove();
		System.out.print(currentNode.name + " ");
		for(GraphNode graphNode: currentNode.neighbors){
			if(!graphNode.isVisited){
				System.out.print(graphNode.name +" ");
				graphNode.isVisited = true;
				queue.add(graphNode);
				for(var gn: graphNode.neighbors){
					//System.out.println(gn.name);
				}
			}
		}
	}

	public void dfs(){
		for(var gNode: nodeList){
			if(!gNode.isVisited){
				dfsVisit(gNode);
			}

		}
	}


	public void bfsVisit(GraphNode node){
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(node);
		while(!stack.isEmpty()){
			GraphNode currentNode = stack.pop();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			for(GraphNode neighbour : node.neighbors){
				if(!neighbour.isVisited){
					stack.push(neighbour);
					neighbour.isVisited = true;
				}
			}

		}
	}
	public void bfs(){
		for (GraphNode graphNode: nodeList){
			if(!graphNode.isVisited){
				bfsVisit(graphNode);
			}
		}
	}

	public static void pathPrint(GraphNode node){
		if(node.parentNode != null){
			pathPrint (node.parentNode);
		}
		System.out.print (node.name + " ");
	}
	public void BFSForSSSPP(GraphNode node){
		LinkedList<GraphNode> queue = new LinkedList<GraphNode> ();
		queue.add (node);
		while(!queue.isEmpty ()){
			GraphNode currentNode = queue.remove (0);
			currentNode.isVisited = true;
			System.out.print ("Printing path for node: " + currentNode.name+": ");
			pathPrint (currentNode);
			System.out.println ();
			for(GraphNode neighbour: currentNode.neighbors){
				if( !neighbour.isVisited ){
					queue.add (neighbour);
					neighbour.isVisited = true;
					neighbour.parentNode = currentNode;
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	


























}
