import java.util.*;

public class C1077_CF {
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        long arr[]=new long[n];
        long sum=0;

        HashMap<Long,Integer>map=new HashMap<>();

        for(int i=0;i<n;i++){
            arr[i]=scn.nextLong();
            sum+=arr[i];
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            long rem=sum-arr[i];

            if(rem%2!=0)continue;
            long need=rem/2;

            map.put(arr[i],map.get(arr[i])-1);

            if(map.getOrDefault(need,0)>0){
                list.add(i+1);
            }
            map.put(arr[i],map.get(arr[i])+1);
        }

        System.out.println(list.size());
        for(int x:list){
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// IMPORTANT:
// Use long for sum and `need`.
// Casting (remainingSum / 2) to int causes overflow for large values,
// leading to wrong HashMap lookups and WA on CF.
// If sum is long → map keys must be long too.





/*

o(n3) soln:-

import java.util.*;

public class C1077_CF {
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int arr[]=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){arr[i]=scn.nextInt(); sum+=arr[i];}

        ArrayList<Integer>list=new ArrayList<>();
        for(int x:arr){
            list.add(x);
        }
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            int curr=sum-arr[i];
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                int x=curr-arr[j];
                if(list.contains(x) && x!=arr[i]){
                    set.add(i+1);
                }
            }
        }
        if(set.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(set.size());
            for(int s:set){
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }
}
 */