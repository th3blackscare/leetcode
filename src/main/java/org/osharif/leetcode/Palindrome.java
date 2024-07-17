package org.osharif.leetcode;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(122));
    }

    public static boolean isPalindrome(int s) {
        if(Integer.signum(s) == -1) return false;
        return s == reverse(s);
    }



    /*
    * first of all we need to get the last digit of a number so we do at with the modulus
    * after getting the last number with a modulus, then we store it in our reversed number variable,
    * and repeat it for every digit in our number, but we need to multiply our reversed number by 10 to add a new
    * location to store our new digit in the reversed number
    * then we divide the original number by 10 to remove the last digit or mathematically convert it to a fraction
    * and the fraction will be ignored because we store out number in an integer type.
     */
    private static int reverse(int number) {
        int reversedNumber = 0;
        int numberToReverse = Math.abs(number);

        while (numberToReverse > 0) {
            int mod = numberToReverse % 10;
            reversedNumber = reversedNumber * 10 + mod;
            numberToReverse /= 10;
        }
        System.out.println(reversedNumber);
        return number < 0 ? reversedNumber * -1 : reversedNumber;
    }
}
