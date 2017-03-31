


public boolean isConvex(List<List<Integer>> points) {
        int size = points.size();
        if(size == 3) return true;
        int start = 0;
        int preOrien = 0;
        while(preOrien == 0)
            preOrien = orientation(points.get(start), points.get(start+1), points.get(start++ +2)); //find first angle
        for(int i=start;i<size;i++){
            int orien = orientation(points.get(i), points.get((i+1)%size), points.get((i+2)%size));
            if(orien != preOrien && orien != 0) return false; // if orientations are different, return false
            if(orien != 0) preOrien = orien;
        }
        return true;
    }
    private int orientation(List<Integer> p1, List<Integer> p2, List<Integer> p3){ 
        //credits to http://www.geeksforgeeks.org/orientation-3-ordered-points/
        int val = (p2.get(1) - p1.get(1)) * (p3.get(0) - p2.get(0)) -
                  (p2.get(0) - p1.get(0)) * (p3.get(1) - p2.get(1));
        if(val == 0) return 0; //linear
        return val > 0? 1:2; //clock/ counterclock
    }