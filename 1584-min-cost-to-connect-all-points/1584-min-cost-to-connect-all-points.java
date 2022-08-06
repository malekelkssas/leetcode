import java.util.Arrays;

 class Solution {
    public static int minCostConnectPoints(int[][] points) {
    	//System.out.println("?");
    	UnionFind gra = new UnionFind(points.length);
    	Edge[] edgeList = new Edge[(points.length*points.length)-points.length];
    	int solu=0;
    	int edge=0;
    	for(int i=0;i<points.length;i++)
    	{

    		for(int j=0;j<points.length;j++)
    		{
    			if(i==j)
        			continue;
    			Edge tmp = new Edge(i,j,manhattan_distance(points[i][0], points[j][0], points[i][1], points[j][1]));
    			edgeList[edge++] = tmp;
    		}
    	}
    	MST_Kruskal m = new MST_Kruskal();
    	m.edgeList = edgeList;
    	m.V = points.length;
    	//System.out.println(Arrays.toString(edgeList));
    	return m.kruskal();
    	
    }
    public static int manhattan_distance(int x1,int x2,int y1,int y2)
    {
    	return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
//    public static void main(String [] args)
//    {
//    System.out.println(minCostConnectPoints(new int [][] {{0,0},{1,1},{1,0},{-1,1}}));
//    // {{3,12},{-2,5},{-4,1}}  {{0,0},{2,2},{3,10},{5,2},{7,0}}  {{0,0},{1,1},{1,0},{-1,1}}
//    }
    private static class UnionFind {  // another name DSU
		int[] p, rank, setSize;
		int numSets;
		// rank means the size of tree
		// numSets means the number of forests
		// p means parents the parent of i'th is p[i]
		public UnionFind(int N) 
		{
			p = new int[numSets = N];
			rank = new int[N];
			setSize = new int[N];
			for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
		}

		public int findSet(int i) {
			// it find the parents and make path compresion
			return p[i] == i ? i : (p[i] = findSet(p[i]));
			}

		public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

		public boolean unionSet(int i, int j) 
		{ 
			if (isSameSet(i, j)) 
				return false;
			numSets--; 
			int x = findSet(i), y = findSet(j);
			if(rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
			else
			{	p[x] = y; setSize[y] += setSize[x];
				if(rank[x] == rank[y]) rank[y]++; 
			}
			return true;
		}

		public int numDisjointSets() { return numSets; }

		public int sizeOfSet(int i) { return setSize[findSet(i)]; }
	}
	 
	private static class Edge implements Comparable<Edge>
		{
			int u, v, w;

			Edge(int a, int b, int c) {	u = a; v = b; w = c; }

			public int compareTo(Edge e) { return w - e.w; }
			
			public String toString() {return "first: "+u+"  second: "+v+" edge: "+ w;}
		}

	private static  class MST_Kruskal {

		static Edge[] edgeList;
		static int V;
		// V means the number of nodes
		
		static int kruskal()		//O(E log E)
		{
			int mst = 0;
			Arrays.sort(edgeList);
			UnionFind uf = new UnionFind(V);

			for(Edge e: edgeList)
				if(uf.unionSet(e.u, e.v))
					mst += e.w;
			return mst;
		} 
	}
}