package com.zys.leetcode;

/**
 * 计算素数个数
 * 素数: 只能被自身和1整除，0和1除外
 */
public class Prime {

    //暴力算法
    public static int violence(int n){
        int count = 0;
        for (int i = 2; i < n; i++){
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    private static boolean isPrime(int x){
        for (int i = 2; i * i <= x; i++){
            if (x % i == 0){
                return false;
            }
        }
        System.out.println(x);
        return true;
    }

    //埃氏筛选法
    public static int eratosthenes(int n){
        int count = 0;
        //true: 是合数; false: 是素数
        boolean[] isNotPrime = new boolean[n];//boolean[]默认未false
        for (int i = 2; i < n; i++){
            if (!isNotPrime[i]){
                count++;
                for (int j = i * i; j < n; j += i){
                    isNotPrime[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("暴力算法总共" + Prime.violence(100) + "素数");
        System.out.println("埃氏筛选法总共" + Prime.eratosthenes(100) + "素数");
    }

}
