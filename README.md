# codingInterview_prep
frequently asked coding questions with solution


# Custom Sorting
```java
int[][] intervals = {{1,3},{8,10},{2,6},{15,18}};
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
```

```java
Arrays.sort(intervals, (a, b) -> {
  int comp = a[0]-b[0];
  if(comp==0){
    comp = a[1]-b[1];
  }
  return comp;
});
```


# LinkedList
LinkedList<int[]> merged = new LinkedList<>();

```java
for (int[] interval : intervals) {
       // if the list of merged intervals is empty or if the current
        // interval does not overlap with the previous, simply append it.
        if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
            merged.add(interval);
        }
        // otherwise, there is overlap, so we merge the current and previous
        // intervals.
        else {
            merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }
}

```
# return element
```java
 return merged.toArray(new int[merged.size()][]);
 ```
