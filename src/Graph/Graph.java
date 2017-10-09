package Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {
	private class Edge {
		Vertex One;
		Vertex Two;

		Edge(Vertex one, Vertex two) {
			this.One = one;
			this.Two = two;
		}
	}

	private class Vertex {
		String Name;
		HashMap<Vertex, Edge> Neighbours;

		Vertex(String name) {
			this.Name = name;
			Neighbours = new HashMap<>();
		}

		@Override
		public boolean equals(Object other) {
			Vertex ov = (Vertex) other;
			return this.Name.equals(ov.Name);
		}

		@Override
		public int hashCode() {
			return this.Name.hashCode();
		}
	}

	private HashMap<String, Vertex> Vertices;

	public Graph() {
		this.Vertices = new HashMap<>();

	}

	private Vertex getVertex(String name) {
		return this.Vertices.get(name);
	}

	public boolean containsVertex(String name) {
		return Vertices.containsKey(name);
	}

	public int numVertices() {
		return this.Vertices.size();
	}

	public void addVertex(String name) {
		if (containsVertex(name)) {
			return;
		} else {
			Vertex TA = new Vertex(name);
			this.Vertices.put(name, TA);
		}
	}

	public void removeVertex(String name) {
		if (!containsVertex(name)) {
			return;
		} else {
			Vertex vtx = getVertex(name);
			Set<Vertex> nbrSet = vtx.Neighbours.keySet();
			for (Vertex nbr : nbrSet) {
				nbr.Neighbours.remove(vtx);
			}
			this.Vertices.remove(name);
		}
	}

	public boolean containsEdge(String v1, String v2) {
		Vertex vx1 = getVertex(v1);
		Vertex vx2 = getVertex(v2);
		if (vx1 == null || vx2 == null) {
			return false;
		} else {
			return vx1.Neighbours.containsKey(vx2);
		}
	}

	public int numEdges() {
		int rv = 0;
		Collection<Vertex> vertices = this.Vertices.values();
		for (Vertex vtx : vertices) {
			Set<Vertex> nbrs = vtx.Neighbours.keySet();
			for (Vertex nbr : nbrs) {
				rv++;
			}
		}
		return rv;
	}

	public void addEdge(String v1, String v2) {
		Vertex vx1 = getVertex(v1);
		Vertex vx2 = getVertex(v2);
		if (vx1 == null || vx2 == null || this.containsEdge(v1, v2)) {
			return;
		} else {
			Edge eg = new Edge(vx1, vx2);
			vx1.Neighbours.put(vx2, eg);
			vx2.Neighbours.put(vx1, eg);
		}
	}

	public void removeEdge(String v1, String v2) {
		Vertex vx1 = getVertex(v1);
		Vertex vx2 = getVertex(v2);
		if (vx1 == null || vx2 == null || !this.containsEdge(v1, v2)) {
			return;
		} else {
			vx1.Neighbours.remove(vx2);
			vx2.Neighbours.remove(vx1);

		}
	}

	public void display() {
		Set<Map.Entry<String, Vertex>> entries = this.Vertices.entrySet();
		for (Map.Entry<String, Vertex> entry : entries) {
			Vertex now = entry.getValue();
			String tp = now.Name + " -> ";
			
			Set<Vertex> nbrs = now.Neighbours.keySet();
			for (Vertex nbr : nbrs) {
				tp +=  nbr.Name + ", ";
			}
			System.out.println(tp + "END");
		}

	}

	public boolean pathBetween(String v1, String v2) {
		Vertex vx1 = getVertex(v1);
		Vertex vx2 = getVertex(v2);
		if (vx1 == null || vx2 == null) {
			return false;
		}
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		return pathBetween(v1, v2, visited);
	}

	private boolean pathBetween(String v1, String v2, HashMap<Vertex, Boolean> visited) {
		Vertex vx1 = getVertex(v1);
		Vertex vx2 = getVertex(v2);
		visited.put(vx1, true);

		if (vx1.Neighbours.containsKey(vx2)) {
			return true;
		}
		Set<Vertex> nbrs = vx1.Neighbours.keySet();
		for (Vertex nbr : nbrs) {
			if (visited.containsKey(nbr)) {
			} else {
				if (pathBetween(nbr.Name, v2, visited))
					return true;
			}
		}
		return false;
	}

	public boolean pathBetweenLO(String v1, String v2) {
		Vertex vx1 = getVertex(v1);
		Vertex vx2 = getVertex(v2);
		if (vx1 == null || vx2 == null) {
			return false;
		}
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		return pathBetweenLO(v1, v2, visited);
	}

	private boolean pathBetweenLO(String v1, String v2, HashMap<Vertex, Boolean> visited) {
		LinkedList<Vertex> queue = new LinkedList<>();
		Vertex vx1 = getVertex(v1);
		Vertex vx2 = getVertex(v2);
		queue.addLast(vx1);
		while (!queue.isEmpty()) {
			Vertex now = queue.removeFirst();
			visited.put(now, true);
			if (now.Neighbours.containsKey(vx2)) {
				return true;
			}
			Set<Vertex> nbrs = now.Neighbours.keySet();
			for (Vertex nbr : nbrs) {
				if (visited.containsKey(nbr)) {

				} else {
					queue.addLast(nbr);
				}

			}
		}
		return false;
	}

	public boolean pathBetweenI(String v1, String v2) {
		Vertex vx1 = getVertex(v1);
		Vertex vx2 = getVertex(v2);
		if (vx1 == null || vx2 == null) {
			return false;
		}
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		return pathBetweenI(v1, v2, visited);
	}

	private boolean pathBetweenI(String v1, String v2, HashMap<Vertex, Boolean> visited) {
		LinkedList<Vertex> stack = new LinkedList<>();
		Vertex vx1 = getVertex(v1);
		Vertex vx2 = getVertex(v2);
		stack.addFirst(vx1);
		while (!stack.isEmpty()) {
			Vertex now = stack.removeFirst();
			visited.put(now, true);
			if (now.Neighbours.containsKey(vx2)) {
				return true;
			}
			Set<Vertex> nbrs = now.Neighbours.keySet();
			for (Vertex nbr : nbrs) {
				if (!visited.containsKey(nbr)) {
					stack.addFirst(nbr);
				}

			}
		}
		return false;
	}

	public void DFT() {
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();
		Collection<Vertex> vtxs = this.Vertices.values();

		for (Vertex vtx : vtxs) {
			if (!visited.containsKey(vtx)) {
				stack.addFirst(vtx);
				visited.put(vtx, true);
			}

			while (!stack.isEmpty()) {
				Vertex now = stack.removeFirst();
				visited.put(now, null);
				System.out.println(now.Name);
				Set<Vertex> nbrs = now.Neighbours.keySet();
				for (Vertex nbr : nbrs) {
					if (!visited.containsKey(nbr)) {
						visited.put(nbr, null);
						stack.addFirst(nbr);
					}

				}
			}
		}
		return;
	}

	public void BFT() {
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		Collection<Vertex> vtxs = this.Vertices.values();

		for (Vertex vtx : vtxs) {
			if (!visited.containsKey(vtx)) {
				queue.addLast(vtx);
				visited.put(vtx, true);
			}

			while (!queue.isEmpty()) {
				Vertex now = queue.removeFirst();
				visited.put(now, null);
				System.out.println(now.Name);
				Set<Vertex> nbrs = now.Neighbours.keySet();
				for (Vertex nbr : nbrs) {
					if (!visited.containsKey(nbr)) {
						visited.put(nbr, null);
						queue.addLast(nbr);
					}

				}
			}
		}
		return;
	}

	public boolean isConnected() {
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		Vertex[] vtxs = new Vertex[Vertices.size()];
		Vertices.values().toArray(vtxs);
		queue.addLast(vtxs[0]);
		while (!queue.isEmpty()) {
			Vertex now = queue.removeFirst();
			visited.put(now, null);
			Set<Vertex> nbrs = now.Neighbours.keySet();
			for (Vertex nbr : nbrs) {
				if (!visited.containsKey(nbr)) {
					visited.put(nbr, null);
					queue.addLast(nbr);
				}
			}
		}
		return visited.size() == vtxs.length;
	}

	public ArrayList<ArrayList<String>> returnConnected() {

		ArrayList<ArrayList<String>> components = new ArrayList<>();
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		Vertex[] vtxs = new Vertex[Vertices.size()];
		Vertices.values().toArray(vtxs);
		queue.addLast(vtxs[0]);
		visited.put(vtxs[0], null);
		for (Vertex vtx : vtxs) {
			if (!visited.containsKey(vtx)) {
				ArrayList arr = new ArrayList<>();
				queue.addLast(vtx);
				visited.put(vtx, true);

				while (!queue.isEmpty()) {
					Vertex now = queue.removeFirst();
					arr.add(now.Name);
					visited.put(now, null);
					Set<Vertex> nbrs = now.Neighbours.keySet();
					for (Vertex nbr : nbrs) {
						if (!visited.containsKey(nbr)) {
							visited.put(nbr, null);
							queue.addLast(nbr);
						}

					}
				}
				components.add(arr);

			}
		}
		return components;
	}

	public boolean isBipartite() {

		HashMap<Vertex, Boolean> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();
		Collection<Vertex> vtxs = this.Vertices.values();

		for (Vertex vtx : vtxs) {
			if (!visited.containsKey(vtx)) {
				stack.addFirst(vtx);
				visited.put(vtx, true);

				while (!stack.isEmpty()) {
					Vertex now = stack.removeFirst();
					Set<Vertex> nbrs = now.Neighbours.keySet();
					for (Vertex nbr : nbrs) {
						Boolean adjval = visited.get(now);
						if (!visited.containsKey(nbr)) {
							visited.put(nbr, !adjval);
							stack.addFirst(nbr);
						} else {
							if (adjval == visited.get(nbr)) {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}

	public boolean isAcyclic() {

		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();
		Collection<Vertex> vtxs = this.Vertices.values();

		for (Vertex vtx : vtxs) {
			if (!visited.containsKey(vtx)) {
				stack.addFirst(vtx);
				visited.put(vtx, null);

				while (!stack.isEmpty()) {
					Vertex now = stack.removeFirst();
					Set<Vertex> nbrs = now.Neighbours.keySet();
					for (Vertex nbr : nbrs) {
						if (!visited.containsKey(nbr)) {
							visited.put(nbr, now);
							stack.addFirst(nbr);
							
						} else {
							if (visited.get(nbr) == now||visited.get(now)==nbr) {
								continue;
							} else {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
}
