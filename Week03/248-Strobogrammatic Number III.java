


按low和high的位数去填充c数组
填充方法就是从c的两边向中间，填充pairs里的东西
夹击填充时用到了dfs，即一路到底填完一个pair引领时的c，再去填下一个
填完一个c后，要看它是否在区间内，在就count＋1，不在就忽略

// 对称的这几对数字
private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

public int strobogrammaticInRange(String low, String high) {
// 	计数
    int[] count = {0};
    
//     上下边界的长度 len，即几位数
//     用数组c来存这个相应位数，要填充它，相当于path
    for (int len = low.length(); len <= high.length(); len++) {
        char[] c = new char[len];
        
//          0, len - 1,是从两边开始向中间填充c
        dfs(low, high, c, 0, len - 1, count);
    }
    
    return count[0];
}

public void dfs(String low, String high , char[] c, int left, int right, int[] count) {
    
//     left大于right，说明填充完c了
    if (left > right) {
        String s = new String(c);
//         如果这个填充好的数字，不在low和high之间，就忽略它
        if ((s.length() == low.length() && s.compareTo(low) < 0) || 
            (s.length() == high.length() && s.compareTo(high) > 0)) {
            return;
        }
//         如果在区间内，就count＋1
        count[0]++;
        return;
    }
    
//     c的每一对位置上，数字是可以重复的，所以每一次套用，都是从pairs的头开始遍历
    for (char[] p : pairs) {
    	
        c[left] = p[0];
        c[right] = p[1];
//         不要第一位是0的
        if (c.length != 1 && c[0] == '0') {
            continue;
        }
//         left＝right，相当于到了中间的一位，它必需得是变换前后相等的，即同一个
        if (left == right && p[0] != p[1]) {
            continue;
        }
        
//         填充完两个位置后，更新角标，向中间移动
        dfs(low, high, c, left + 1, right - 1, count);
    }
    
}