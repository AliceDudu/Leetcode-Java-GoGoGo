

//     负数
//     结果的整数部分加到str里，取余部分继续判断
//     如果小数结果存在循环的部分，说明每一次的余数也是重复出现的，因为分母是不变的
//     所以用map存
//     map存的是：key是产生小数的那个余数，value就是它产生循环小数的位置
//     最后小数会在一个数字上反复循环，在它相应的位置插入左括号，右括号

public String fractionToDecimal(int numerator, int denominator) {

    if ( denominator == 0 ){
    	return "";
    }
    	
    StringBuilder str = new StringBuilder();
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    
//     负数
    if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
        str.append('-');
    }
    
//     结果的整数部分加到str里，取余部分继续判断
    long num = Math.abs((long)numerator);
    long den = Math.abs((long)denominator);
    long n = num / den;
    long reminder = num % den;
    str.append(n);
    
    if (reminder == 0) 
    	return str.toString();
    else 
    	str.append('.');
    
//     如果小数结果存在循环的部分，说明每一次的余数也是重复出现的，因为分母是不变的
//     所以用map存
//     map存的是：key是产生小数的那个余数，value就是它产生循环小数的位置
    while( !map.containsKey(reminder) ) {
        map.put(reminder, str.length());
        
        n = reminder * 10 / den;
        reminder = reminder * 10 % den;
        
        if (reminder != 0 || reminder == 0 && !map.containsKey(reminder)) {
            str.append(n);
        }
    }
    
//     最后小数会在一个数字上反复循环，在它相应的位置插入左括号，右括号
    if ( reminder != 0 ) {
        str.insert(map.get(reminder), "(");
        str.append(')');            
    }
    
    return str.toString();
}