

public boolean isStrobogrammatic(String num) {
	Map<Character, Character> map = new HashMap<Character, Character>();
	
// 	把符合Strobogrammatic的数字找出来，是有限的，放入map
	map.put('6', '9');
	map.put('9', '6');
	map.put('1', '1');
	map.put('8', '8');
	map.put('0', '0');

	int i = 0;
	int j = num.length() - 1;
	
// 	双指针两边向中间扫，看是否在map里，再比较是否相等
	while (i <= j) {
		if (map.get(num.charAt(i)) != null && map.get(num.charAt(i)) == num.charAt(j)) {
			i++;
			j--;
		} else
			return false;
	}
	
	return true;
}