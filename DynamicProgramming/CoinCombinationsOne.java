import java.util.*;
public class CoinCombinationsOne{
    public static long solve(int amount,int coins[],int n,long mod){
         if(amount==0){
            return 1;
         }
         long ways = 0;
         for(int coin : coins){
              if(coin<=amount){
                   ways = (ways + solve(amount-coin,coins,n,mod))%mod;
              }
         }
   
         return (ways) % mod ;
    }
    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int x = sc.nextInt();
       long mod = 1000000007;
       int coins[]= new int [n];
       for(int i = 0;i<n;i++){
          coins[i] = sc.nextInt();
       }
      // long result = solve(x,coins,n,mod);
      
      int dp[] = new int [x+1];
      dp[0]=1;
      for(int i = 1 ;i<=x;i++){
         long ways = 0;
         for(int coin : coins){
             if(coin<=i){
                ways = (ways + dp[i-coin]); 
                if(ways >= mod ){
                   ways -= mod;
                }            
             }
         }
         dp[i]=(int)ways;
      }
       System.out.println(dp[x]);
   }
}
