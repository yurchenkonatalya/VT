package by.epamtc.LAB1.javaFundamentals.task8.util;

public class Logic {

    public static void printIndexes(double masA[], double masB[]) {
        for (int i = 0; i < masB.length; i++) {
            System.out.println(binarySearch(masA, 0, masA.length - 1, masB[i]));
        }
    }

    static double binarySearch(double[] arr, int l, int r, double sElem) {
        int m = -1;
        if (sElem <= arr[l])
            return l;
        if (sElem >= arr[r])
            return r;
        while (l <= r) {
            m = (l + r) / 2;
            //System.out.println("l="+l+"r="+r+"m="+m);
            if (sElem >= arr[m] && sElem < arr[m + 1])
                return m + 1;
            if (sElem < arr[m])
                r = m - 1;
            if (sElem > arr[m])
                l = m + 1;
        }
        return m;
    }

}
