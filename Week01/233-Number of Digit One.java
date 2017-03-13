痛点：有解释，英文的懒得看呀，哎，别地的中文又不完全一样，哎



http://www.cnblogs.com/grandyang/p/4629032.html


0, 1, 2, 3 ... 9 (1)

10, 11, 12, 13 ... 19 (1) + 10

20, 21, 22, 23 ... 29 (1)

...

90, 91, 92, 93 ... 99 (1)

100, 101, 102, 103 ... 109 (10 + 1)

110, 111, 112, 113 ... 119 (10 + 1) + 10

120, 121, 122, 123 ... 129 (10 + 1)

...

190, 191, 192, 193 ... 199 (10 + 1)



public int countDigitOne(int n) {
  int count = 0;
    
  for (long k = 1; k <= n; k *= 10) {
    long r = n / k;
    long m = n % k;
    // sum up the count of ones on every place k
    count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
//     System.out.println( "k:"+ k + "   r:"+ r + "   m:"+ m + "    count:" + count);
  }
    
  return count;
}

k:1   r:13   m:0    count:2
k:10   r:1   m:3    count:6



