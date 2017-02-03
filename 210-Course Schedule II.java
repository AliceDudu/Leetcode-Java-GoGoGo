public class Solution{
	public int[] findOrder( int numCourses, int[][] prerequisites ){
		int[] incLinkCounts = new int[numCourses];	//?
		List<List<Integer>> adjs = new ArrayList<List<Integer>>(numCourses); //represent graph
		initialGraph(incLinkCounts, adjs, prerequisites);	//initial map
		return searchBFS(incLinkCounts, adjs);	//search graph
	}
	
	public void initialGraph( int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites ){
		int n = incLinkCounts.length;	//-1
		while ( n-- > 0 ){
			adjs.add(new ArrayList<>());	//build list
// 			n--;
		}
		
		for ( int[] edge : prerequisites ){		//initial graph
			incLinkCounts[edge[0]]++;		//?
			adjs.get(edge[1]).add(edge[0]);
		}
	}
	
	public int[] searchBFS( int[] incLinkCounts, List<List<Integer>> adjs ){
		int[] order = new int[incLinkCounts.length];	//course order
		Queue<Integer> toVisit = new ArrayDeque<>();
		
		for ( int i = 0; i < incLinkCounts.length; i++ ){
			if ( incLinkCounts[i] == 0 ){
				toVisit.offer(i);
			}
		}
		
		int visited = 0;
		
		while ( !toVisit.isEmpty() ){
			int from = toVisit.poll();	//read order
			order[visited++] = from;	//write order
			
			for ( int to : adjs.get(from) ){
				incLinkCounts[to]--;
				if ( incLinkCounts[to] == 0 ){
					toVisit.offer(to);
				}
			}
		}
		
		return visited == incLinkCounts.length ? order : new int[0];
		
	}
}