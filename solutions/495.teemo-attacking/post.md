For each begin followed by t
If t is within previous duration [begin, begin + duration] then increase total by t - begin
If t in out of previous duration [begin, begin + duration] then increase total by duration
In both cases update begin to the new begin time t
```
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int begin = timeSeries[0], total = 0;
        for (int t : timeSeries) {
            total+= t < begin + duration ? t - begin : duration;
            begin = t;
        }   
        return total + duration;
    } 
```

