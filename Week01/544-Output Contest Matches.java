public class Solution {
public String findContestMatch(int n) {
    
    LinkedList<String> llist= new LinkedList<>();
    
    for(int i=0;i<n;i++)
        llist.add(String.valueOf(i+1));

        LinkedList<String> slist=new LinkedList<>();
        
        while(llist.size()>1){
            String f=llist.pollFirst(), l=llist.pollLast();
            String pair="("+f+","+l+")";
            slist.add(pair);
            
            if(llist.size()==0){
                llist=slist;
                slist=new LinkedList<>();
            }
        }
        
        return llist.get(0);
    }
}