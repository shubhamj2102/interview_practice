package practice.dsa.category_with_the_highest_average_price;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Assuming you have a list of Store objects, where each store has a category and price.
 * How would you find the category with the highest average price among the stores using Java Streams?
 *
 */

public class Solution {

    public String getCategoryWithHighestAvgSal(List<Store> stores){

       var res= stores.stream().collect(Collectors.groupingBy(store->store.category(),Collectors.averagingDouble(store->store.price()))).entrySet().stream().max(Comparator.comparing(e->e.getValue())).map(e->e.getKey()).stream().findFirst().get();
       return res;
    }
}
