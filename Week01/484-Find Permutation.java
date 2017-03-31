

public int[] findPermutation(String s) {
        // if next is D, go ahead to the next one
        // if next is I, give the minimum curt number
        // fill back the previous ones by plus 1
        int min = 1, n = s.length() + 1;
        int[] res = new int[n];
        
        for(int i = 0; i < n; i++){
            int curt = i;
            while(i < s.length() && s.charAt(i) == 'D') 
            	i++;
            for(int j = i; j >= curt; j--) 
            	res[j] = min++;
        }
        
        return res;
    }