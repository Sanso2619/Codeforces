import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class C1728_CF {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);

        int t=scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();

            HashMap<Long,Integer>map1=new HashMap<>();
            HashMap<Long,Integer>map2=new HashMap<>();

            for(int i=0;i<n;i++){
                long x=scn.nextLong();
                map1.put(x,map1.getOrDefault(x, 0)+1);
            }
            for(int i=0;i<n;i++){
                long x=scn.nextLong();
                map2.put(x,map2.getOrDefault(x, 0)+1);
            }
           
            for(long x: new ArrayList<>(map1.keySet())){
                if(map2.containsKey(x)){
                    int common=Math.min(map1.get(x),map2.get(x));
                    map1.put(x,map1.get(x)-common);
                    map2.put(x,map2.get(x)-common);

                    if(map1.get(x)==0)map1.remove(x);
                    if(map2.get(x)==0)map2.remove(x);
                }
            }
            long ans=0;

            HashMap<Long,Integer>temp1=new HashMap<>();
            for(long x:map1.keySet()){
                int freq=map1.get(x);

                if(x>=10){
                    ans+=freq;
                    long d=String.valueOf(x).length();
                    temp1.put(d,temp1.getOrDefault(d, 0)+freq);
                }else{
                    temp1.put(x,temp1.getOrDefault(x, 0)+freq);
                }
            }

            map1=temp1;

            HashMap<Long,Integer>temp2=new HashMap<>();
            for(long x:map2.keySet()){
                int freq=map2.get(x);

                if(x>=10){
                    ans+=freq;
                    long d=String.valueOf(x).length();
                    temp2.put(d,temp2.getOrDefault(d, 0)+freq);
                }else{
                    temp2.put(x,temp2.getOrDefault(x, 0)+freq);
                }
            }
            map2=temp2;

            for(long x:new ArrayList<>(map1.keySet())){
                if(map2.containsKey(x)){
                    int common=Math.min(map1.get(x),map2.get(x));
                    map1.put(x,map1.get(x)-common);
                    map2.put(x,map2.get(x)-common);

                    if(map1.get(x)==0)map1.remove(x);
                    if(map2.get(x)==0)map2.remove(x);
                }
            }

            for(long x:map1.keySet()){
                if(x>1){
                    ans+=map1.get(x);
                }
            }

            for(long x:map2.keySet()){
                if(x>1){
                    ans+=map2.get(x);
                }
            }
            System.out.println(ans);
        }
    }
}


// Transform all numbers >= 10.
//
// The operation allowed is:
//      x -> number of digits in x
//
// We don't process every occurrence separately.
// Since we are using a frequency map,
// one key represents all identical numbers.
//
// Example:
//
// map1
// 1000 -> 3
// 25   -> 2
// 7    -> 1
//
// represents the array:
// 1000 1000 1000 25 25 7
//
// Transform:
//
// 1000 (3 occurrences) -> 4 (3 occurrences)
// 25   (2 occurrences) -> 2 (2 occurrences)
// 7 is already a single digit, so keep it as it is.
//
// Result:
//
// temp1
// 4 -> 3
// 2 -> 2
// 7 -> 1
//
// We create a NEW HashMap because we cannot change the keys
// of the same HashMap while iterating over it.
// Also, multiple numbers can transform into the same digit,
// so we merge their frequencies using getOrDefault().
//
// Each occurrence of a number >= 10 requires one operation,
// therefore answer increases by its frequency.

/*
A: 2 9 3
B: 1 100 9

Cancel 9

A: 2 3
B: 1 100

100 → 3      (ans = 1)

A: 2 3
B: 1 3

Cancel 3

A: 2
B: 1

2 → 1        (ans = 2)

Final answer = 2

 */