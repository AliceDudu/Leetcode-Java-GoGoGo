

有向图的遍历
边的遍历

首先把图建立起来，通过邻接链表来建立
从节点JFK开始遍历，只要当前节点映射的multiset里有节点，我们取出这个节点，将其在multiset里删掉，
然后继续递归遍历这个节点
等图中所有的multiset中都没有节点的时候，我们把当前节点存入结果中，然后再一层层回溯回去，
将当前节点都存入结果，那么最后我们结果中存的顺序和我们需要的相反的，我们最后再翻转一下即可

public class Solution{
	Map<String, PriorityQueue<String>> flights;
	LinkedList<String> path;

	public List<String> findItinerary( String[][] tickets ){
		flights = new HashMap<>();
		path = new LinkedList<>();
		
		for ( String[] ticket : tickets ){
			flights.putIfAbsent(ticket[0], new PriorityQueue<>());
			flights.get(ticket[0]).add(ticket[1]);
		}
		
		dfs("JFK");
		
		return path;
	}
	
	public void dfs( String departure ){
		PriorityQueue<String> arrivals = flights.get(departure);
		
		while ( arrivals != null && !arrivals.isEmpty() ){
			dfs(arrivals.poll());
		}
		
		path.addFirst(departure);
	}
}