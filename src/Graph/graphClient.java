package Graph;

public class graphClient {

	public static void main(String[] args) {
Graph gr = new Graph();
gr.addVertex("A");
gr.addVertex("B");
gr.addVertex("C");
gr.addVertex("D");
gr.addVertex("E");
gr.addVertex("F");
gr.addVertex("G");
gr.addEdge("A", "B");
gr.addEdge("B", "C");
gr.addEdge("C", "D");
gr.addEdge("D", "A");
gr.addEdge("D", "E");
gr.addEdge("E", "F");
gr.addEdge("F", "G");
gr.addEdge("G", "E");
gr.display();
//System.out.println(gr.pathBetween("A", "G"));
//System.out.println(gr.pathBetweenI("A", "G"));
//System.out.println(gr.pathBetweenLO("A", "G"));
//gr.BFT();
//gr.DFT();
//System.out.println(gr.isConnected());
//System.out.println(gr.returnConnected());
//System.out.println(gr.isBipartite());
//gr.display();
System.out.println(gr.isAcyclic());
	}

}
