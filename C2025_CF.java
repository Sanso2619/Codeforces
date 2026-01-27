
import java.util.*;

public class C2025_CF {
    public static void main(String[]args){
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();

        while(t-->0){
            int n=scn.nextInt();
            int k=scn.nextInt();

            int arr[]=new int[n];
            for(int i=0;i<n;i++)arr[i]=scn.nextInt();

            Arrays.sort(arr);

            HashMap<Integer,Integer>freq=new HashMap<>();
            for (int x : arr) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            List<Integer>list=new ArrayList<>(freq.keySet());
            Collections.sort(list);

            int left=0;
            int sum=0;
            int ans=0;
            for(int right=0;right<list.size();right++){
                if(right>0 && (list.get(right)!=list.get(right-1)+1)){
                    sum=0;
                    left=right;
                }
                sum+=freq.get(list.get(right));

                while(right-left+1>k){
                    sum-=freq.get(list.get(left));
                    left++;
                }
                ans=Math.max(ans,sum);
            }
            System.out.println(ans);
        }
    }
}


/*Count frequency of each value.

1.Sort distinct values.

2.Use a sliding window on sorted values:

3.Reset window when values are not consecutive.

4.Shrink window if size exceeds k.

Track maximum sum of frequencies.

 */