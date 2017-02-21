/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { 
 			start = s; 
 			end = e; 
 		}
 * }
 */
 
 先将intervals按start点升序排序
 如果区间2与区间1不重合，则直接将区间2放入res中
 如果有相交区域，则把区间1的end改为2的end，同时res里的end也会被修改了

public class Solution {
    public List<Interval> merge( List<Interval> intervals ){
    
    	// Sort by ascending starting point using an anonymous Comparator
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });

        List<Interval> ret = new ArrayList<>();
        Interval prev = null;
        
        for( Interval inter : intervals ){
            if ( prev == null || inter.start > prev.end ){
                ret.add(inter);
                prev = inter;
            }else if( inter.end > prev.end ){	//--
                // Modify the element already in list
                prev.end = inter.end;
            }
        }
        
        return ret;
    }
}




public class Solution {

    public List<Interval> merge( List<Interval> intervals ){
    
    	if( intervals.size() <= 1 ){
	        return intervals;
	    }
    
    	// Sort by ascending starting point using an anonymous Comparator
    	intervals.sort( (i1, i2) -> Integer.compare(i1.start, i2.start) );
    
    	List<Interval> result = new LinkedList<Interval>();
    	int start = intervals.get(0).start;
    	int end = intervals.get(0).end;
    
    	for( Interval interval : intervals ){
        	if( interval.start <= end ){ // Overlapping intervals, move the end if needed
	            end = Math.max(end, interval.end);
	        }else{                     // Disjoint intervals, add the previous one and reset bounds
            	result.add(new Interval(start, end));
            	start = interval.start;
            	end = interval.end;
        	}
    	}
    
    	// Add the last interval
    	result.add(new Interval(start, end));
    	return result;
	}
}

