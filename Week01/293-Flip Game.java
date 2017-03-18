

就是i一步一步走
每次把它和下一位变成－
再加入到res中
再变回＋，继续走

public List<String> generatePossibleNextMoves(String s) {

	List<String> res = new ArrayList<String>();

	char chs[] = s.toCharArray(); 
	
	for (int i = 0; i < s.length() - 1; i++) {
	
		if (chs[i] == chs[i + 1] && chs[i] == '+') {
			chs[i] = chs[i + 1] = '-';
			
			res.add(String.valueOf(chs)); 
			   			
			chs[i] = chs[i + 1] = '+';    			
		}
		
	}   
	 	
	return res;
}