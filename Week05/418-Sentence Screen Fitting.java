

看这个例子，可以发现，每一行都是从一个单词开始的，这些单词都是从sentence里取得
每一行就是装到不能装下完整单词后，就另起一行
另起一行时起点可以由前一行的起点＋长度来记录
a-bcd- 
e-a---
bcd-e-

所以，可以遍历sentence的每个单词，以每个单词做一个头起一行，来看它可以在这一行中装到多远
然后只需要一个int[] nextIndex来存：若以i为起点时，当它装到极限时，下一行该是谁起头
然后用int[] words来存每个单词起头时，可以装下多少个单词

最后统计时，就是从0起头时，这一行存了多少个word，
那么下一行呢，累加，
就得到一共装了多少个单词，而且这些单词是自带循环顺序的
所以累加结果wordCount / sentence.length 就得到了循环了多少遍了

public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
//         可以遍历sentence的每个单词，以每个单词做一个头起一行，来看它可以在这一行中装到多远
        int[] words = new int[sentence.length];
//         然后只需要一个int[] nextIndex来存：若以i为起点时，当它装到极限时，下一行该是谁起头
        int[] nextIndex = new int[sentence.length];
        
        words[0] = 0;
        
        for (int i = 0,len = 0,j = 0; i < sentence.length; i++){
//         	以i开头时，先处理一下
            if (i > 0){
                //remove previous word and space
// 			len是跟着i更新的，即这一行若是以单词i开头可以走到多远
// 			所以i变到下一个的时候，len要减去前一个单词
// 			同时j记录的就是从i开头的话，下一个单词该是谁了
// 			words i记录的就是这个len里装了多少单词，所以更新的时候也要减去前一个
                len = len - sentence[i - 1].length() - 1;
                j = nextIndex[i - 1];
                words[i] = words[i-1] -1;
            }
           
//            计算以i开头可以走到多远
//         i＝0，在填充第0行时   
//         len就是看这一行能填充到什么位置，填充的方式就是一个单词后面加一个减号
//         j就是在遍历单词，只不过因为会循环遍历，所以用取余符号
            while(len + sentence[j].length() <= cols){
                len = len + sentence[j].length() + 1;
                words[i]++;
                j = (j + 1) % sentence.length;
            }
            
//             i＝0时，填充完第一行时，下一个正要填但是不够长的单词角标
// 			即这个len里够不到的下一个单词是谁，那么下一次就要接着它
            nextIndex[i] = j;
        }
        
        int wordCount = 0;
        
//         累加看row col一共装了多少单词
        for (int i=0, j =0; i < rows; i++){
//         j＝0因为是从第一个单词开始填充的
// 	         words[j]是这一行，开头的这个单词在内，所引领的单词的个数
// 			nextIndex[j]就是上一行的引领字母所引领到的位置
            wordCount += words[j];
            j = nextIndex[j];
        }
        
        return wordCount / sentence.length;
    }
}


