class Solution {

    static class Node {
        long count;
        long sum;

        Node(long count, long sum) {
            this.count = count;
            this.sum = sum;
        }
    }

    private char[] digits;
    private Node[][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n < 0) {
            return 0;
        }

        digits = String.valueOf(n).toCharArray();

        memo = new Node[digits.length + 1][11][11][4];

        return dfs(0, 10, 10, 0, true).sum;
    }

    private Node dfs(
            int pos,
            int prev2,
            int prev1,
            int len,
            boolean tight
    ) {

        if (pos == digits.length) {
            return new Node(1, 0);
        }

        if (!tight && memo[pos][prev2][prev1][Math.min(len, 3)] != null) {
            return memo[pos][prev2][prev1][Math.min(len, 3)];
        }

        int limit = tight ? digits[pos] - '0' : 9;

        long totalCount = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {

            boolean nextTight = tight && d == limit;

            if (len == 0 && d == 0) {

                Node child = dfs(
                        pos + 1,
                        10,
                        10,
                        0,
                        nextTight
                );

                totalCount += child.count;
                totalSum += child.sum;

                continue;
            }

            if (len == 0) {

                Node child = dfs(
                        pos + 1,
                        10,
                        d,
                        1,
                        nextTight
                );

                totalCount += child.count;
                totalSum += child.sum;

            } else if (len == 1) {

                Node child = dfs(
                        pos + 1,
                        prev1,
                        d,
                        2,
                        nextTight
                );

                totalCount += child.count;
                totalSum += child.sum;

            } else {

                int extra = 0;

                if ((prev2 < prev1 && prev1 > d)
                        || (prev2 > prev1 && prev1 < d)) {
                    extra = 1;
                }

                Node child = dfs(
                        pos + 1,
                        prev1,
                        d,
                        3,
                        nextTight
                );

                totalCount += child.count;
                totalSum += child.sum + child.count * extra;
            }
        }

        Node result = new Node(totalCount, totalSum);

        if (!tight) {
            memo[pos][prev2][prev1][Math.min(len, 3)] = result;
        }

        return result;
    }
}