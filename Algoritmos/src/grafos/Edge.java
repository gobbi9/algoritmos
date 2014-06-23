package grafos;

//possivel uso excessivo de memória
public class Edge {
	private Vertex[] nodes;
	//metodo equals deve retorar true para (a,b) e (b,a) por ex
	public Edge(Vertex[] vs){
		nodes = vs.clone();
	}
	
	public Edge(Vertex a, Vertex b){
		nodes = new Vertex[2];
		nodes[0] = a;
		nodes[1] = b;
	}
	
	private Vertex[] inverse(){
		Vertex[] inverted = nodes.clone();
		Vertex temp = inverted[0].clone();
		inverted[0] = inverted[1].clone();
		inverted[1] = temp;
		return inverted;
	}
	
	public boolean equals(Object obj) {
		Edge e = (Edge) obj;
		if (this.nodes[0].equals(e.nodes[0]) && this.nodes[1].equals(e.nodes[1]))
			return true;
		e = new Edge(inverse());
		if (this.nodes[0].equals(e.nodes[0]) && this.nodes[1].equals(e.nodes[1]))
			return true;
		
		return false;
	}
	public Edge clone(){
		return new Edge(nodes);
	}
	
	public String toString(){
		return String.format("(%s, %s)", nodes[0].toString(), nodes[1].toString());
	}
}
