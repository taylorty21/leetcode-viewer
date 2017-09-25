class Solution {
    public String countAndSay2(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            prev = curr;
            curr = new StringBuilder();       
            count = 1;
            say = prev.charAt(0);
            for (int j=1,len=prev.length();j<len;j++){
                if (prev.charAt(j) != say){
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                }
                else count++;
            }
            curr.append(count).append(say);
        }	       	        
        return curr.toString();
    }
    
    public String countAndSay(int n) {
        String start = "1";
        for(int t=2;t<=n;t++) {
            start = readNext(start);
        }
        return start;
    }
    private String readNext(String s) {
        StringBuilder result=new StringBuilder();
        int count = 0;
        char say = s.charAt(0);
        
        for(int d=0;d<s.length();d++) {
            if (s.charAt(d) == say)
                count++;
            else {
                result.append(count).append(say);
                say = s.charAt(d);
                count = 1;
            }
        }
        result.append(count).append(say);
        return result.toString();
    }
}