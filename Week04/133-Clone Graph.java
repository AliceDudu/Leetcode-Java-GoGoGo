

所有节点值不同，所以我们可以使用哈希表来对应节点值和新生成的节点
图的遍历的两大基本方法是深度优先搜索DFS和广度优先搜索BFS

public class Solution{
	public HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
	
	public UndirectedGraphNode cloneGraph( UndirectedGraphNode node ){
		return clone(node);
	}
	
	public UndirectedGraphNode clone( UndirectedGraphNode node ){
		if ( node == null ){
			return null;
		}
		
		if ( map.containsKey(node.label) ){
			return map.get(node.label);
		}
		
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		
		map.put(clone.label, clone);
		
		for ( UndirectedGraphNode neighbor : node.neighbors ){
			clone.neighbors.add(clone(neighbor));
		}
		
		return clone;
	}
}