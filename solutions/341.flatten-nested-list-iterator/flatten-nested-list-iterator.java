/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    List<NestedInteger> nestedList;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                return true;
            }
            NestedInteger nestedInteger = stack.pop();
            List<NestedInteger> nestedList = nestedInteger.getList();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }
        return false;
    }
    
//     Solution 1: 
//     private Stack<ListIterator<NestedInteger>> lists;
//     public NestedIterator(List<NestedInteger> nestedList) {
//         lists = new Stack<>();
//         lists.push(nestedList.listIterator());
//     }

//     public Integer next() {
//         hasNext();
//         return lists.peek().next().getInteger();
//     }

//     public boolean hasNext() {
//         while (!lists.empty()) {
//             if (!lists.peek().hasNext()) {
//                 lists.pop();
//             } else {
//                 NestedInteger x = lists.peek().next();
//                 if (x.isInteger())
//                     return lists.peek().previous() == x;
//                 lists.push(x.getList().listIterator());
//             }
//         }
//         return false;
//     }
    

    
//     Solution 2:
//     NestedInteger nextInt;
//     Stack<Iterator<NestedInteger>> stack;

//     public NestedIterator(List<NestedInteger> nestedList) {
//         stack = new Stack<Iterator<NestedInteger>>();
//         stack.push(nestedList.iterator());
//     }

//     @Override
//     public Integer next() {
//         return nextInt != null ? nextInt.getInteger() : null; //Just in case
//     }

//     @Override
//     public boolean hasNext() {
//         while (!stack.isEmpty()) {
//             if (!stack.peek().hasNext()) stack.pop();
//             else if ((nextInt = stack.peek().next()).isInteger()) return true;
//             else stack.push(nextInt.getList().iterator());
//         }
//         return false;
//     }
    
    // Solution 3: Use Queue
//     public NestedIterator(List<NestedInteger> nestedList) {
//         make_queue(nestedList);
//     }

//     @Override
//     public Integer next() {
//         int t = queue.peek(); 
//         queue.poll();
//         return t; 
//     }

//     @Override
//     public boolean hasNext() {
//         return !queue.isEmpty();
//     }
    
//     Queue<Integer> queue = new LinkedList<>();
//     void make_queue(List<NestedInteger> nestedList) {
//         for (NestedInteger a : nestedList) {
//             if (a.isInteger()) queue.offer(a.getInteger());
//             else make_queue(a.getList());
//         }
//     }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */