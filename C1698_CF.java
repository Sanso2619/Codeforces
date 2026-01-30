import java.util.*;

public class C1698_CF {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int t=scn.nextInt();
        while(t-->0){
            int n=scn.nextInt();   
            ArrayList<Long>pos=new ArrayList<>();
            ArrayList<Long>neg=new ArrayList<>();
            long zero=0;

            for(int i=0;i<n;i++){
                long x=scn.nextLong();
                if(x>0)pos.add(x);
                else if(x<0)neg.add(x);
                else if(x==0)zero++;
            }

            if (pos.size() >= 3 || neg.size() >= 3) {
                System.out.println("NO");
                continue;
            }

            Collections.sort(pos);
            Collections.sort(neg);

            ArrayList<Long>all=new ArrayList<>();

            for(int i=pos.size()-1;i>=0 && i>=pos.size()-2;i--){
                all.add(pos.get(i));
            }
            for(int i=0;i<neg.size() && i<2;i++){
                all.add(neg.get(i));
            }

            if(zero>=1)all.add(0L);
            if(zero>=2)all.add(0L);

            HashSet<Long>set=new HashSet<>(all);
            int m=all.size();
            boolean ans=true;
            for(int i=0;i<m;i++){
                for(int j=i+1;j<m;j++){
                    for(int k=j+1;k<m;k++){
                        long sum=all.get(i)+all.get(j)+all.get(k);
                        if(!set.contains(sum)){
                            ans=false;
                            break;
                        }
                    }
                }
            }
            System.out.println(ans?"YES":"NO");
        }
    }
}
/*
Problem: Check if an array is 3SUM-closed.
Definition:
For every triplet (i < j < k), the value a[i] + a[j] + a[k]
must exist somewhere in the array.

Key Observations:
1) If there are ≥ 3 positive numbers:
   - Taking the three largest positives gives a sum larger than any element.
   - That sum cannot exist in the array → NOT 3SUM-closed.

2) If there are ≥ 3 negative numbers:
   - Taking the three smallest negatives gives a sum smaller than any element.
   - That sum cannot exist in the array → NOT 3SUM-closed.

3) Zero does not change sums:
   - More than 2 zeroes add no new information.
   - We only need to keep at most 2 zeroes.

Therefore:
- If positives ≥ 3 or negatives ≥ 3 → answer is NO immediately.
- Otherwise, the array can be reduced to at most:
  2 positives + 2 negatives + 2 zeroes = 6 elements.

Algorithm:
1) Count positives, negatives, and zeroes.
2) If positives ≥ 3 or negatives ≥ 3 → print NO.
3) Keep:
   - the 2 largest positives
   - the 2 smallest negatives
   - at most 2 zeroes
4) Brute-force all triplets in this reduced array.
5) Check whether each triplet sum exists using a HashSet.

Complexity:
- O(n) to read and filter the array
- O(1) to check all triplets (at most 6 elements)

Overall Time Complexity: O(n)
*/
