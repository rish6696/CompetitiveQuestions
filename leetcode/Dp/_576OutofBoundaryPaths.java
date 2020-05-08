
public class _576OutofBoundaryPaths {
    public static void main(String[] args) {
        int m =2;
        int n =2;
        int N =4;

        System.out.println(findPaths(m, n, N, 0, 0));
    }

    public static  int findPaths(int m, int n, int N, int i, int j) {
        if (i == m || j == n || i < 0 || j < 0) return 1;
        if (N == 0) return 0;
        return findPaths(m, n, N - 1, i - 1, j)
            + findPaths(m, n, N - 1, i + 1, j)
            + findPaths(m, n, N - 1, i, j - 1)
            + findPaths(m, n, N - 1, i, j + 1);
            
        }

}