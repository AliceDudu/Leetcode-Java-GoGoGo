public class Solution{
	public List<Integer> numIslands2(int m, int n, int[][] positions){
		List<Integer> res = new ArrayList<Integer>();
		
		int[] id = new int[m * n];
		int[] size = new int[m * n];
		
		UnionFind uf = new UnionFind(id, size);
		
		int count = 0;
		
		for ( int[] p : positions ){
			count++;
			int cur = p[0] * n + p[1];
			id[cur] = cur;
			size[cur] = 1;
			
			for ( int[] d : direction ){
				int i = p[0] + d[0];
				int j = p[1] + d[1];
				int next = i * n + j;
				
				if ( isValid(i, j, m, n, size) ){
					if ( !uf.isConnected(cur, next) ){
						uf.union(cur, next);
						count--;
					}
				}
			}
			res.add(count);
		}
		return res;
	}
	
	class UnionFind{
		private int[] id;
		private int[] size;
		
		public UnionFind( int[] id, int[] size ){
			this.id = id;
			this.size = size;
		}
		
		public int find( int i ){
			while ( i != id(i) ){
				id[i] = id[id[i]];
				i = id[i];
			}
			return i;
		}
		
		public boolean isConnected( int p, int q ){
			return find(p) == find(q);
		}
		
		public void union(int p, int q){
			int i = find(p);
			int j = find(q);
			
			if ( i == j ){
				return;
			}
			
			if ( size[i] < size[j] ){
				id[i] = id[j];
				size[j] += size[i];
			}else{
				id[j] = id[i];
				size[i] += size[j];
			}
		}
	}
	
	public boolean isValid( int i, int j, int m, int n, int[] size ){
		return i >= 0 && i < m && j >= 0 && j < n && size[i * n + j] != 0;
	}
	
	
	
	
}