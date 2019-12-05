/*
    Aufgabe 3) Rekursion mit eindimensionalen Arrays
*/
import java.util.Arrays;

public class Aufgabe3 {

    private static int getMaxPairSum(int[] workArray, int start, int end) {
        int thisPairSum = workArray[start]+workArray[start +1];
        if (end-start==1) return thisPairSum;
        int nextPairSum = getMaxPairSum(workArray,start+1,end);
        if (thisPairSum>nextPairSum) return thisPairSum;
        else return nextPairSum;
    }

    private static int countValuesWithSmallerNeighbors(int[] workArray, int index) {
        if (index==workArray.length-2) {
            if (workArray[index] > workArray[index + 1] && workArray[index] > workArray[index - 1]) return 1;
        }
        if (workArray[index] > workArray[index + 1] && workArray[index] > workArray[index - 1]) return 1+countValuesWithSmallerNeighbors(workArray,index+1);
        return countValuesWithSmallerNeighbors(workArray,index+1);
    }


    private static int[] getArrayWithNegativeValues(int[] workArray, int index) {
        int[] thisArray=workArray.clone();
        if (thisArray[index]>0) thisArray[index]=0;
        if (index==thisArray.length-1) return thisArray;
        return getArrayWithNegativeValues(thisArray,index+1);
    }

    private static boolean containsValue(int[] workArray, int value) {
        int[] firstHalf = Arrays.copyOfRange(workArray, 0, workArray.length/2);
        int[] secondHalf = Arrays.copyOfRange(workArray, workArray.length/2, workArray.length);
        if (workArray.length==1){
            if (workArray[0]==value)return true;
            else return false;
        }
        boolean firstValue = containsValue(firstHalf,value);
        boolean secondValue = containsValue(secondHalf,value);
        if (firstValue==true||secondValue==true) return true;
        return false;
    }
    
    public static void main(String[] args) {
        int[] array1 = {3, 1, 7, 9, 4, 10, 5, 3};
        System.out.println(getMaxPairSum(array1, 0, array1.length - 1));
        System.out.println(getMaxPairSum(array1, 4, array1.length - 1));
        System.out.println(getMaxPairSum(array1, 1, 3));
        System.out.println(getMaxPairSum(array1, 0, 2));
        System.out.println(getMaxPairSum(array1, 0, 1));
        System.out.println();

        int[] array2 = {3, 9, 7, 19, 8, 10, 6, 3, 11, 5};
        System.out.println(countValuesWithSmallerNeighbors(array2, 1));
        System.out.println(countValuesWithSmallerNeighbors(array2, 4));
        System.out.println(countValuesWithSmallerNeighbors(array2, 6));
        System.out.println(countValuesWithSmallerNeighbors(array2, 8));
        System.out.println();

        int[] array3 = {5, -3, 7, -15, 20, -5, 0, 14, 3, -2, -8};
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(getArrayWithNegativeValues(array3, 0)));
        System.out.println(Arrays.toString(getArrayWithNegativeValues(array3, 10)));
        System.out.println(Arrays.toString(getArrayWithNegativeValues(array3, 8)));
        System.out.println(Arrays.toString(getArrayWithNegativeValues(array3, 4)));
        System.out.println();

        int[] array4 = {2, 4, 7, 10, -10, 4, 0, 0, 27, 11, 4, 6};
        System.out.println(containsValue(array4, 11));
        System.out.println(containsValue(array4, 2));
        System.out.println(containsValue(array4, 25));
        System.out.println(containsValue(array4, 0));
        System.out.println(containsValue(array4, 14));
        System.out.println(containsValue(array4, 6));
        
      
        assert(getMaxPairSum(array1, 0, array1.length - 1) == 16);
        assert(getMaxPairSum(array1, 4, array1.length - 1) == 15);
        assert(getMaxPairSum(array1, 1, 3) == 16);
        assert(getMaxPairSum(array1, 0, 2) == 8);
        assert(getMaxPairSum(array1, 0, 1) == 4);
        
        assert(countValuesWithSmallerNeighbors(array2, 1) == 4);
        assert(countValuesWithSmallerNeighbors(array2, 4) == 2);
        assert(countValuesWithSmallerNeighbors(array2, 6) == 1);
        assert(countValuesWithSmallerNeighbors(array2, 8) == 1);

        assert (Arrays.equals(getArrayWithNegativeValues(array3, 0), new int[]{0, -3, 0, -15, 0, -5, 0, 0, 0, -2, -8}) == true);
        assert (Arrays.equals(getArrayWithNegativeValues(array3, 10), new int[]{5, -3, 7, -15, 20, -5, 0, 14, 3, -2, -8}) == true);
        assert (Arrays.equals(getArrayWithNegativeValues(array3, 8), new int[]{5, -3, 7, -15, 20, -5, 0, 14, 0, -2, -8}) == true);
        assert (Arrays.equals(getArrayWithNegativeValues(array3, 4), new int[]{5, -3, 7, -15, 0, -5, 0, 0, 0, -2, -8}) == true);

        assert (containsValue(array4, 11) == true);
        assert (containsValue(array4, 2) == true);
        assert (containsValue(array4, 25) == false);
        assert (containsValue(array4, 0) == true);
        assert (containsValue(array4, 14) == false);
        assert (containsValue(array4, 6) == true);
    }
}


/*
1. Wie könnte containsValue(...) optimiert werden, wenn die Vorbedingung ist, dass workArray aufsteigend sortiert ist?
Rekursive implementierung einer binären Suche, sprich immer nur eine rekursion starten je nach dem ob der value größer oder kleiner ist als das mittlere element des arrays.
 */