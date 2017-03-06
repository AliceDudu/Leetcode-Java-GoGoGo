

用二分法找到了 第一个比新区间的start要大的start所在的区间角标
找到后，记录一下这个角标的前一个区间
再用一次二分法，找到第一个比新区间的end要大的end所在的区间角标
找到后，记录一下这个角标代表的区间
得到了两个区间后，再判断一下，与新区间的关系，看如何合并交集，
新区间分别与pre和next比较首尾，判断相交关系，改变相应的start或end
再判断更新后的 pre 和 next是否相交，相交的话，更新一个start，并删掉另外一个区间


public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		int n = intervals.size();
		if (n == 0) {
			intervals.add(newInterval);
			return intervals;
		}

		int low = 0, high = n - 1, mid = 0;
		int temp, target = newInterval.start;
		while (low <= high) {
			mid = (low + high) / 2;
			temp = intervals.get(mid).start;
			if (temp == target)
				break;
			if (temp < target)
				low = mid + 1;
			else
				high = mid - 1;
		}

		// insIdx = the index where new interval to be inserted
// 		用二分法找到了 第一个比新区间的start要大的start所在的区间角标
		int insIdx = (low <= high) ? mid : low;
// 		找到后，记录一下这个角标的前一个区间
		Interval pre = (insIdx == 0) ? null : intervals.get(insIdx - 1);
		// 0<=insIdx<=n, pre=[insIdx-1], pre.start<new.start

		low = insIdx;
		high = n - 1;
		target = newInterval.end;
		while (low <= high) {
			mid = (low + high) / 2;
			temp = intervals.get(mid).end;
			if (temp == target)
				break;
			if (temp < target)
				low = mid + 1;
			else
				high = mid - 1;
		}

		// nxtIdx= the next index after the inserted new interval
// 		再用一次二分法，找到第一个比新区间的end要大的end所在的区间角标
		int nxtIdx = (low <= high) ? mid : low;
// 		找到后，记录一下这个角标代表的区间
		Interval nxt = (nxtIdx == n) ? null : intervals.get(nxtIdx);
		// insIdx<=nxtIdx<=n, nxt=[nxtIdx], nxt.end>=new.end

		// [0]...[insIdx-1] <--> [insIdx]...[nxtIdx-1] <--> [nxtIdx]...[n]
// 		把两个区间的中间部分删掉
		intervals.subList(insIdx, nxtIdx).clear();

		// check whether newInterval can be merged with pre or nxt
		boolean isMerged = false, isMerged2 = false;
		
// 		得到了两个区间后，再判断一下，与新区间的关系，看如何合并交集，
// 		新区间分别与pre和next比较首尾，判断相交关系，改变相应的start或end
		if (insIdx > 0 && pre.end >= newInterval.start) {
			pre.end = Math.max(pre.end, newInterval.end);
			isMerged = true;
		}

		if (nxtIdx < n && newInterval.end >= nxt.start) {
			nxt.start = Math.min(nxt.start, newInterval.start);
			isMerged2 = isMerged;
			isMerged = true;
		}

		if (!isMerged) {
			intervals.add(insIdx, newInterval);
			return intervals;
		}

		// merged with pre or nxt or both, deal with the both case
// 		再判断更新后的 pre 和 next是否相交，相交的话，更新一个start，并删掉另外一个区间
		if (isMerged2 && pre.end >= nxt.start) {
			nxt.start = pre.start; // pre.start < new.start, nxt.start;
			intervals.remove(insIdx - 1); // remove pre
		}

		return intervals;
	}