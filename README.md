# codingInterview_prep
frequently asked coding questions with solution


# Custom Sorting (Integer.compare(a,b))
## Integer.compare(a[0], b[0])
```java
int[][] intervals = {{1,3},{8,10},{2,6},{15,18}};
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); 
```

## comparator in lambda
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
```java
LinkedList<int[]> merged = new LinkedList<>();
```

# 2D array iteration
```java
for (int[] interval : intervals) {
        if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
            merged.add(interval);
        }
        else {
            merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }
}

```
# Collection.toArray() return Array from linkedlist
```java
 return merged.toArray(new int[merged.size()][]);
 ```
# Convert all keys of map to int array (mapToInt & toArray)
```java

        Integer[] uniqueNumber = map.keySet().toArray(Integer[] :: new); // convert object array to INteger array
        int[] uniqueNumber = map.keySet().stream().mapToInt(Integer::intValue).toArray();
```

# Convert set to list 
```java
  Set<List<Integer>> set = new HashSet<>();
  return set.stream().collect(Collectors.toList());  
  //OR
  List<List<Integer>> list = new ArrayList<>(set); // pass in constructor
  // OR
  List<List<Integer>> list = new ArrayList<>(set);
  list.addAll(set);
```


# deep copy vs shallow copy
```java
 public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());
    
    for (int currentNumber : nums) {
      int n = subsets.size();
      for (int i = 0; i < n; i++) {
        List<Integer> set = new ArrayList<>(subsets.get(i)); // deep copy
        //List<Integer> set = subsets.get(i); // shallow copy
        set.add(currentNumber);
        subsets.add(set);
      }
    }
    return subsets;
  }

```
