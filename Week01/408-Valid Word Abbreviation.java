

c遍历abbr
遇到数字时，用num来记录，预备会有二位数等情况
idx是c此时对应在word里的位置
如果没遇到数字，就比较当前的char和word的相应位置的char是否一样
遇到字母后，数字的记忆num就要归零，同时idx先移动到下一位


public boolean validWordAbbreviation(String word, String abbr) {
        if(word == null || abbr == null) 
        	return false;
        
        int num = 0;
        int idx = 0;
        
        for( char c: abbr.toCharArray() ){
        
//         	corner case
            if(c == '0' && num == 0) 
            	return false;
            
//             遇到数字时，用num来记录预备会有二位数等情况
            if(c >= '0' && c <= '9'){
                num = num * 10 + (c - '0');
                
//             如果没遇到数字，就比较当前的char和word的相应位置的char是否一样 
            }else{
                idx += num;
                
                if(idx >= word.length() || c != word.charAt(idx)) 
                	return false;
                
//                 遇到字母后，数字的记忆num就要归零，同时idx先移动到下一位	
                num = 0;
                idx++;
            }
        }
        
        return idx + num == word.length() ? true : false;
    }
