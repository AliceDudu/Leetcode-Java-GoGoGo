

public boolean detectCapitalUse(String word) {
        if (word.length() < 2) 
        	return true;

//         全是大写	
        if (word.toUpperCase().equals(word)) 
        	return true;

// 		第一个字母无所谓大小，后面所有字母都得是小写        	
        if (word.substring(1).toLowerCase().equals(word.substring(1))) 
        	return true;
        
        return false;
}