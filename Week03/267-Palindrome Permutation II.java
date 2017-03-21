


位运算
i & 1 ＝＝ 1 说明i是奇数，否则为偶数
http://blog.csdn.net/morewindows/article/details/7354571




private List<String> list = new ArrayList<>();

public List<String> generatePalindromes(String s) {
    int numOdds = 0; // How many characters that have odd number of count
    int[] map = new int[256]; // Map from character to its frequency
    
    for (char c: s.toCharArray()) {
        map[c]++;
//         map[c]为奇数时，numOdds + 1
        numOdds = (map[c] & 1) == 1 ? numOdds + 1 : numOdds - 1;
    }
    
//     字母为偶数个时，就变为0
//     存在一个字母是奇数时，等于1
//     当存在两个字母是奇数个时，这个数字就大于1，此时无法构成回文
    if (numOdds > 1)   
    	return list;
    
//     如果有奇数个，那这个字母就放在中间
    String mid = "";
//     一半的长度
    int length = 0;
    
    for (int i = 0; i < 256; i++) {
        if (map[i] > 0) {
//         	这个唯一的奇数个字母，必需在中间
            if ((map[i] & 1) == 1) { // Char with odd count will be in the middle
                mid = "" + (char)i;
                map[i]--;
            }
            
            map[i] /= 2; // Cut in half since we only generate half string
            length += map[i]; // The length of half string
        }
    }
    
//     根据len和map生成一半的str，再加上mid，成为最终的str
    generatePalindromesHelper(map, length, "", mid);
    
    return list;
}

private void generatePalindromesHelper(int[] map, int length, String s, String mid) {

// 	当长度等于len时，就加到list里
    if (s.length() == length) {
    
        StringBuilder reverse = new StringBuilder(s).reverse(); // Second half
        list.add(s + mid + reverse);
        
        return;
    }
    
    
    for (int i = 0; i < 256; i++) { // backtracking just like permutation
    
        if (map[i] > 0) {
            map[i]--;
//             把i上这个字母加到s里，跳出来的时候，map i再更新回来
            generatePalindromesHelper(map, length, s + (char)i, mid);
            map[i]++;
        } 
        
    }
}