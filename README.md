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

## Collections sort
```java
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,3,2));
// in place sorting
Collection.sort(list);
Collections.sort(list,Collections.reverseOrder());
Collections.sort(list , customComparator); 

OR
// you have to store in another list
List<Integer> out = list.stream().sorted().collect(Collectors.toList()); 
List<Integer> out = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
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

# Convert ArrayList to array 
```java
Integer[] array = numbersList.toArray(new Integer[0]);

String[] array = strList.toArray(new String[0]);
```
https://codeahoy.com/java/How-To-Convery-ArrayList-To-Array/ 
What’s with the weird-looking argument new Integer[0]? The reason it is there because the type of returned array is determined using this argument. In other words, the toArray(...) method uses the type of the argument, Integer to create another array of the same type, places all elements from ArrayList into the array in order and returns it.

There is something else about the behavior of toArray(...) method you must understand. Notice that we passed an empty array new Integer[0]. This was intentional because if we pass a non-empty array and it has enough room to fit all elements, ArrayList will use this array instead of creating a new one. So by passing an empty array (size 0), we’re forcing ArrayList to create a new array and return it. The returned array is not connected to ArrayList in any way, but keep in mind that it is a shallow copy of the elements of the ArrayList.

# Collection.toArray() return Array from linkedlist
```java
 return merged.toArray(new int[merged.size()][]);
 ```
# Convert all keys of map to int array (mapToInt & toArray)
```java
        int[] uniqueNumber = map.keySet().stream().mapToInt(Integer::intValue).toArray();
```

# toArray in java to convert collections to array 
```java
        Integer[] uniqueNumber = map.keySet().toArray(Integer[] :: new); // convert object array to INteger array
        Integer [] numArray = numList.stream().toArray( n -> new Integer[n]);
        
```

# Convert set to list 
```java
  Set<List<Integer>> set = new HashSet<>();
  return set.stream().collect(Collectors.toList());  
  //OR
  List<List<Integer>> list = new ArrayList<>(set); // pass in constructor
  // OR
  List<List<Integer>> list = new ArrayList<>();
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

# convert string to char stream 
```java 
String digits = "23"
Integer[] digitsArray = digits.chars()
        .mapToObj(i->Character.getNumericValue(i))
        .toArray(Integer[]::new);
```
