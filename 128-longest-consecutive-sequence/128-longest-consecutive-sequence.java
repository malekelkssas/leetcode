import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

 class Solution {
	  public static  int longestConsecutive(int[] nums) {
	        HashSet<Integer> nodoub = new HashSet<>();
	        
	        for(int i:nums)
	        	nodoub.add(i);
	        UnionFind m = new UnionFind(nodoub);
	        for(int i:nodoub)
	        {
	        	if(nodoub.contains(i-1)) 
	        		m.unionSet(i, i-1);
	        	
	        	if(nodoub.contains(i+1)) 
	        		m.unionSet(i, i+1); 
	        }
	        int max = 0;
	        for(int i:nodoub) {
	        	try {
	        	max = Math.max(max, m.sizeOfSet(i));
	        	}
	        	catch(Exception e)
	        	{
	        		
	        	}
	        }
	        return max;
	    }
//    public static void main(String [] args)
//    {
//    System.out.println(longestConsecutive(new int [] {0,3,7,2,5,8,4,6,0,1}));
//    // {100,4,200,1,3,2}
//   
//    }
    private static class UnionFind {  // another name DSU
		HashMap<Integer,Integer> p, rank, setSize;
		int numSets;
		// rank means the size of tree
		// numSets means the number of forests
		// p means parents the parent of i'th is p[i]
		public UnionFind(HashSet<Integer> N) 
		{
			p = new HashMap<>();
			rank = new HashMap<>();
			setSize = new HashMap<>();
			for (int i :N) {  p.put(i, i); setSize.put(i, 1); rank.put(i, 0); }
		}

		public void make_set(int v) {
		    p.put(v, v);
		}
		
		public int findSet(int i) {
			// it find the parents and make path compresion
			return p.get(i) == i ? i : (p.replace(i, findSet(p.get(i)))); 
			
			}

		public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

		public boolean unionSet(int i, int j) 
		{ 
			if (isSameSet(i, j)) 
				return false;
			numSets--; 
			int x = findSet(i), y = findSet(j);
			if(rank.get(x) > rank.get(y)) { p.replace(y, x); setSize.replace(x, setSize.get(x)+setSize.get(y)); }
			else
			{	p.replace(x, y); setSize.replace(y, setSize.get(x)+setSize.get(y));;
				if(rank.get(x) == rank.get(y)) rank.replace(y, rank.get(y)+1); 
			}
			return true;
		}

		public int numDisjointSets() { return numSets; }

		public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
	}
	 
	private static class Edge implements Comparable<Edge>
		{
			int u, v, w;

			Edge(int a, int b, int c) {	u = a; v = b; w = c; }

			public int compareTo(Edge e) { return w - e.w; }
			
			public String toString() {return "first: "+u+"  second: "+v+" edge: "+ w;}
		}


}