/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    // DFS
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        // Use map to store whether a node has been copied before
        Map<UndirectedGraphNode, UndirectedGraphNode> lookUp = new HashMap<>();
        return cloneGraph(node, lookUp);
    }
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> lookUp) {
        if (node == null) {
            return null;
        }
        if (lookUp.containsKey(node)) {
            return lookUp.get(node);
        }
        UndirectedGraphNode copiedNode = new UndirectedGraphNode(node.label);
        lookUp.put(node, copiedNode);
        for (UndirectedGraphNode neighbor: node.neighbors) {
            copiedNode.neighbors.add(cloneGraph(neighbor, lookUp));
        }
        return copiedNode;
    }
    
    // BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        UndirectedGraphNode copiedNode = new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode, UndirectedGraphNode> lookUp = new HashMap<>();
        lookUp.put(node, copiedNode);
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode parentNode = queue.pop();
            for (UndirectedGraphNode neighbor: parentNode.neighbors) {
                if (!lookUp.containsKey(neighbor)) {
                    UndirectedGraphNode copiedNode2 = new UndirectedGraphNode(neighbor.label);
                    lookUp.put(neighbor, copiedNode2);
                    queue.add(neighbor);
                }
                lookUp.get(parentNode).neighbors.add(lookUp.get(neighbor)); //add neighbor to new created nodes
            }
        }
        return copiedNode;
    }
}