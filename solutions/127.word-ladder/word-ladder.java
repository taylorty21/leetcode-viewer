class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Use queue to help BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        // Make dictionary
        Set<String> dict = new HashSet<>(wordList);
        int level = 1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String tmp = queue.poll();
                for (int j = 0; j < tmp.length(); j++) {
                    char[] chars = tmp.toCharArray();
                    // Modify str's each character (so word distance is 1)
                    for(char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String word = new String(chars);

                        if (word.equals(endWord) && dict.contains(word)) return level + 1; 
                        // Put the word into the queue and remove it from the dict
                        if(dict.remove(word)) {
                            queue.add(word);
                        }
                    }
                }
            }
            // Found the end word
            level++;
        }
       
        return 0;
    }
}