

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int buffPtr = 0;
    private int buffCnt = 0;
    
//     buff用来装4个字符的临时数组，可以不满
    private char[] buff = new char[4];
    
//     buf是用来装这n个数的
//     所以，read和read4这俩函数，读进来一个空字符串组，是用来装字符的，而不是从它们里面读字符
    public int read(char[] buf, int n) {
        int ptr = 0;
        
//         ptr就是最后的结果，即 number of n characters can be read from the file
        while (ptr < n) {
        
            if (buffPtr == 0) {
//             	buffCnt就是之前读到的个数，小于等于4
                buffCnt = read4(buff);
            }
            
//             buffCnt == 0说明没有东西可以读了
            if (buffCnt == 0) 
            	break;
            
//             第一次假设buffCnt＝4，	uffPtr=0，
            while (ptr < n && buffPtr < buffCnt) {
//             	把buff里面的四个一个一个放进buf里面
                buf[ptr++] = buff[buffPtr++];
            }
            
//             已经从buff里面都读完了，buffptr就更新为0，下一次再从buff的头读取里面的字符
            if (buffPtr >= buffCnt) 
            	buffPtr = 0;
        }
        
        return ptr;
    }
}