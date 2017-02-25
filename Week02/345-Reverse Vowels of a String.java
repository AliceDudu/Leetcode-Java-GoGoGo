

set里存元音字母
用双指针从s的两头扫
当i和j同时到达元音字母时，交换二者
变换后更新i和j
如果i不是元音，i就继续向后走，直到找到一个元音
如果j不是元音，j就继续向前走，直到找到一个元音

public class Solution {
    public String reverseVowels(String s) {
        char[] list=s.toCharArray();
        
        Set<Character> set=new HashSet<>();
        
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        for(int i=0, j=list.length - 1; i < j; ){
//         	如果i不是元音，i就继续向后走，直到找到一个元音
            if( !set.contains(list[i]) ){
                i++;
                continue;
            }
            
//             如果j不是元音，j就继续向前走，直到找到一个元音
            if( !set.contains(list[j]) ){
                j--;
                continue;
            }
            
//             当i和j同时到达元音字母时，交换二者
            char temp = list[i];
            list[i]=list[j];
            list[j]=temp;
            
            i++;
            j--;
        }
        
        return String.valueOf(list);
    }
}