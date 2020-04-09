import java.util.*;
class RandomizedCollection {

    /** Initialize your data structure here. */
    HashMap<Integer,Set<Integer>> map;
    List<Integer> list ; 
    java.util.Random rand = new java.util.Random();
    public RandomizedCollection() {
        map =new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(!map.containsKey(val)){
            map.put(val,new LinkedHashSet<>());
        }
    
        int idx = list.size();
        list.add(val);
        map.get(val).add(idx);
        
        return map.get(val).size()==1 ? true :false;
        
      
    }
    
   
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        
    if(!map.containsKey(val)|| map.get(val).size()==0) return false;
        
        int idxRem= map.get(val).iterator().next();
        
        map.get(val).remove(idxRem);
        
        int last_idx=list.size()-1;
        int lastVal = list.get(last_idx);
        
        map.get(lastVal).add(idxRem);
        map.get(lastVal).remove(last_idx);
       

        list.set(idxRem,lastVal);
        
        
        
        list.remove(last_idx);
        
        return true;
        
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        System.out.println(list.size());
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */