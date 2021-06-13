package learn.ds.arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Problem Statement:
 * When customers book an Airbnb the total price, which includes base price + service fee + cleaning fee. all these prices are in decimals. Write an algorithm to round each price such that the sum of the prices equals the round of the total sum of all decimal prices and minimize the rounding.
 * <p>
 * Given:
 * An array of numbers A = [x1, x2, ..., xn] and Target = Round(x1+x2+... +xn)
 * where x1, x2,..xn are different charges to customers like base price, service fee and so on.
 */

/**
 * Solution :
 * 1. Calculate Ceil and Floor for each given price.
 * 2. Calculate floorSum with all floor prices.
 * 3. Get difference d = target – floorSum. (this is the value we need to achieve by picking ceil values on prices)
 * 4. Create an array PriceWithDiff with each price with Ceil, floor, and difference of price with ceil value.
 * 5. Sort the array on the difference of price with ceil value. ( so that we can pick the ceil values with less rounding margin)
 * 6. Pick the first d ceil values from PriceWithDiff and pick the floor from the rest of the array. This will be our final result.
 * <p>
 * Time Complexity: O(NLogN),
 * <p>
 * Space Complexity: O(N)
 * <p>
 * Solution: https://algorithms.tutorialhorizon.com/round-price-problem/
 */
public class RoundingPrice {
    static List<Integer> roundPricesToMatchTarget(List<Float> prices, int target) {
        PriceWithDiff[] priceWithDiff = new PriceWithDiff[prices.size()];
        int floorSum = 0;
        int objectCount = 0;
        for (float price : prices) {
            int floor = (int) Math.floor(price);
            int ceil = (int) Math.ceil(price);
            floorSum += floor;
            priceWithDiff[objectCount] = new PriceWithDiff(ceil, floor, ceil - price);
            objectCount++;
        }
        int numberOfCeilValuesToPick = target - floorSum;

        /**
         * This will sort the priceWithDiff object array in asc order based on diff with ceil value.
         * we need to pick the first numberOfCeilValuesToPick values from priceWithDiff Object Array.
         */
        Arrays.sort(priceWithDiff, new Comparator<PriceWithDiff>() {
            @Override
            public int compare(PriceWithDiff n1, PriceWithDiff n2) {
                if (n1.diffWithCeil <= n2.diffWithCeil) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        List<Integer> res = new ArrayList<Integer>();
        int i=0;
        // pick first numberOfCeilValuesToPick ceil values from array
        for (; i < numberOfCeilValuesToPick; i++) {
            res.add(priceWithDiff[i].ceilPrice); //ceil
        }
        // Now target will be reached just by taking floor prices
        for(; i < priceWithDiff.length; i++) {
            res.add(priceWithDiff[i].floorPrice);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        List<Float> prices = new ArrayList<Float>();
        prices.add((float) 0.70);
        prices.add((float) 2.80);
        prices.add((float) 4.90);
        int target = 8;
        List<Integer> res = roundPricesToMatchTarget(prices, target);
        Collections.reverse(res);
        for (int a : res) {
            System.out.print(a + "-");
        }
    }

    // This call object will store ceil value, floor value and difference of error with ceil value.
    static class PriceWithDiff {
        int ceilPrice;
        int floorPrice;
        double diffWithCeil;

        public PriceWithDiff(int ceil, int floor, double c) {
            this.ceilPrice = ceil;
            this.floorPrice = floor;
            this.diffWithCeil = c;
        }

    }
}
