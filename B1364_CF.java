import java.util.*;

public class B1364_CF {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t=scn.nextInt();

        while(t-->0){
            int n=scn.nextInt();
            int arr[]=new int[n];

            for(int i=0;i<n;i++){
                arr[i]=scn.nextInt();
            }

            ArrayList<Integer>list=new ArrayList<>();

            for(int i=0;i<n;i++){
                if(i==0 || i==n-1 || (arr[i-1]<arr[i] && arr[i]>arr[i+1]) || (arr[i]<arr[i-1] && arr[i]<arr[i+1])){
                    list.add(arr[i]);
                }
            }
            System.out.println(list.size());
            for(int i:list){
                System.out.print(i + " ");
            }
            System.out.println();

        }
    }
}

/*
Approach:
Keep only the elements that define the shape of the array.
The first and last elements are always included.
Any element that is a local maximum (peak) or local minimum (valley)
is necessary to preserve direction changes.
All other elements are redundant and can be removed.

Time Complexity: O(n) per test case
Space Complexity: O(n)
*/
