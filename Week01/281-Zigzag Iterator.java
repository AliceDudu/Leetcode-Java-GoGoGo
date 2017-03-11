
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 	定义个i，它的第一个row，col位置
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 	当前row是否在行数范围内，是的话
 * while (i.hasNext()) 
 	先拿到当前row col的值，然后走到下一个有值的位置
 * v[f()] = i.next();
 */
 
public class ZigzagIterator {
    List<List<Integer>> list;
    int[] len;
    int row;
    int col;
    int listSize;
    
//     将v1 v2看成一个matrix，先取到第一个valid的位置
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<>();
        
        list.add(v1);
        list.add(v2);
        
        listSize = list.size();
        
//         用来记录两个list的size
        len = new int[2];        
        len[0] = list.get(0).size();
        len[1] = list.get(1).size();
        
        row = 0;
        col = 0;
        
//         col >= list.get(row).size() 说明在当前col下，这个row里面没有元素在这个位置了，
//         所以row要一直向下走，走到底后，col就可以另起一列了
        while (row < listSize && col >= list.get(row).size()) {
            row++;
        }
    }

// 	取到当前row col的值，并且将row col移动到下一个valid的位置
    public int next() {
//     	取到一个元素row col后，row下移
        int ret = list.get(row).get(col);
        row++;
        
        while (row < listSize && col >= list.get(row).size()) {
            row++;
        }
        
//         所以row要一直向下走，走到底后，row角标已经＝＝listSize时，col就可以另起一列了
//         如果row在当前col是有元素的，那就停在这里，等着取这个值就可以了
        if (row == listSize) {
            row = 0;
            col++;
            
            while (row < listSize && col >= list.get(row).size()) {
                row++;
            }
        }
        
        return ret;
    }

// 	是否有下一行
    public boolean hasNext() {
        return row < listSize;
    }
}