package LeetCode.Easy;

public class RotatedDigits {
//    X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is
//    different from X.  Each digit must be rotated - we cannot choose to leave it alone.
//
//    A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate
//    to each other (on this case they are rotated in a different direction, in other words 2 or 5 gets mirrored);
//    6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
//
//    Now given a positive number N, how many numbers X from 1 to N are good?
//
//    Example:
//    Input: 10
//    Output: 4
//    Explanation:
//    There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
//    Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
//            Note:
//
//    N  will be in range [1, 10000].

    public boolean isGoodNumber(int n) {
        String nString = String.valueOf(n);
        char[] chN = nString.toCharArray();

        for (int i = 0; i < chN.length; i++) {
            if (chN[i] == '0' || chN[i] == '1' || chN[i] == '8') {
                continue;
            }

            if (chN[i] == '2') {
                chN[i] = '5';
            }
            else if (chN[i] == '5') {
                chN[i] = '2';
            }
            else if (chN[i] == '6') {
                chN[i] = '9';
            }
            else if (chN[i] == '9') {
                chN[i] = '6';
            } else
                return false;
        }
        if (Integer.parseInt(String.valueOf(chN)) == n) {
            return false;
        }
        return true;
    }
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 0; i <= N; i++) {
            if (isGoodNumber(i)) {
                count++;
            }
        }
        return count;
    }

    public int rotatedDigits1(int N)
    {
        int ans=0;
        for(int i=1;i<=N;i++)
        {
            ans+=check(i);
        }
        return ans;
    }
    int check(int n)
    {
        boolean flag=false;
        while(n!=0)
        {
            int a=n%10;
            if(a==2 || a==5 || a==6 || a==9) flag=true;
            if(a==3 || a==4 || a==7) return 0;
            n=n/10;
        }
        return flag?1:0;
    }

    public static void main(String[] args) {
        RotatedDigits res = new RotatedDigits();
        int N1 = 10;
        int N2 = 2;
        System.out.println(res.rotatedDigits(N1));
        System.out.println(res.rotatedDigits(N2));
    }
}
