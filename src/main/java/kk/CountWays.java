// Program to find n-th stair
// using step size 1 or 2 or 3.


package kk;

public class CountWays {
    // Returns count of ways to reach
    // n-th stair using 1 or 2 or 3 steps.
    public static int findStep(int n) {
        if (n == 1 || n == 0)
            return 1;
        else if (n == 2)
            return 2;

        else
            return findStep(n - 3) +
                    findStep(n - 2) +
                    findStep(n - 1);
    }

    // Driver function
    public static void main(String argc[]) {
        int n = 4;
        System.out.println(findStep(n));
    }
}

