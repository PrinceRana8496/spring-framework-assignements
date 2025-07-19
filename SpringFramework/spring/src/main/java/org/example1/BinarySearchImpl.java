package org.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
    private SortAlgorithm sortAlgorithm;
    @Autowired
    BinarySearchImpl(SortAlgorithm sortAlgorithm)
    {
        this.sortAlgorithm=sortAlgorithm;
    }
    public int binarySearch(int[] numbers, int numberToSearchFor) {
        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        System.out.println(sortAlgorithm);
        // Search the array
        return 3;
    }

}







