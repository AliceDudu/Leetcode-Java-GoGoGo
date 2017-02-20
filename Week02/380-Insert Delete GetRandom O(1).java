

哈希表用来建立每个数字和其在数组中的位置之间的映射
insert：不存在的话，我们将其插入到数组的末尾，然后建立数字和其位置的映射
remove：将要删除的数字和hash表的最后一个数字调换个位置，然后修改对应的哈希表中的值
random：只要随机生成一个位置，返回该位置上的数字即可

import java.util.Random;

public class RandomizedSet {
    
    private HashMap<Integer, Integer> keyMap = null;
    private HashMap<Integer, Integer> valueMap = null;
    int count;

    /** Initialize your data structure here. */
    public RandomizedSet(){
        keyMap = new HashMap<Integer, Integer>();
        valueMap = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert( int val ){
        if( keyMap.containsKey(val) ){
            return false;
        }else{
            keyMap.put(val, count);
            valueMap.put(count, val);
            count = keyMap.size();
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove( int val ){
        if( !keyMap.containsKey(val) ){
            return false;
        }else{
            int valueKey = keyMap.get(val);
            
            keyMap.remove(val);
            
            if( valueKey != valueMap.size() - 1 ){
                valueMap.put(valueKey, valueMap.get(valueMap.size() - 1));
                keyMap.put(valueMap.get(valueMap.size() - 1), valueKey);
                valueMap.remove(valueMap.size() - 1);
            }else{
                valueMap.remove(valueKey);
            }
            count = keyMap.size();
            
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom(){
        Random random = new Random();
        int n = random.nextInt(keyMap.size());
        return valueMap.get(n);
    }
}