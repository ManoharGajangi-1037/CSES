import java.util.*;

public class Dice{
    //This is the memoization logic 
    public static long solve(int n,long dp[],long mod){
         if(n < 0 ){
             return 0;
         }
         if(n == 0){
              return 1;
         }
         if(dp[n]!=-1){
           return dp[n];
         }
         long sum = 0;
         for(int i = 1;i<=6;i++){
         sum += solve(n-i,dp,mod) % mod;
         }
         dp[n] = sum;
         return dp[n]%mod;
    }
    public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         long mod = 1000000007;
         int n = sc.nextInt();
         long dp[] = new long[n+1]; 
         dp[0] = 1;
         for(int i = 1;i<=n;i++){
            for(int j= 1;j<=6;j++){
                if(i-j>=0){
                   dp[i]=(dp[i]+dp[i-j])%mod;
                }
            }
         }
         System.out.println(dp[n]);      
    }
}
