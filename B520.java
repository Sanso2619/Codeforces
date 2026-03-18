
import java.util.*;

public class B520 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n =scn.nextInt();
        int m=scn.nextInt();

        Queue<Integer> q = new java.util.LinkedList<>();
        boolean vis[]=new boolean[100000];
        int steps=0;

        q.add(n);
        vis[n]=true;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
               
             int node=q.poll();
            if(node==m){
                System.out.println(steps);
                return;
            }
            int next1=node*2;
            if(next1<vis.length && !vis[next1]){
                vis[next1]=true;
                q.add(next1);
            }
            int next2=node-1;
            if(next2>=0 && !vis[next2]){
                vis[next2]=true;
                q.add(next2);
            }
            }
            steps++;
            
        }
    }
}
