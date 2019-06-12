import java.util.HashSet;

public class PrefectRectangle {
    public static boolean isPrefectRectangle(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int Left = Integer.MAX_VALUE;
        int Right = Integer.MIN_VALUE;
        int Up = Integer.MIN_VALUE;
        int Down = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        int area = 0;
        for (int[] rectangle : matrix) {
            Left = Math.min(rectangle[0], Left);
            Down = Math.min(rectangle[1], Down);
            Right = Math.max(rectangle[2], Right);
            Up = Math.max(rectangle[3], Up);
            area = area + (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
            String leftDown = rectangle[0] + "_" + rectangle[1];
            String leftUp = rectangle[0] + "_" + rectangle[3];
            String rightDown = rectangle[2] + "_" + rectangle[1];
            String rightUp = rectangle[2] + "_" + rectangle[3];
            if (!set.add(leftDown)) {
                set.remove(leftDown);
            }
            if (!set.add(leftUp)) {
                set.remove(leftUp);
            }
            if (!set.add(rightDown)) {
                set.remove(rightDown);
            }
            if (!set.add(leftUp)) {
                set.remove(leftUp);
            }
        }
        if (!set.contains(Left + "_" + Down) || !set.contains(Left + "_" + Up) || !set.contains(Right + "_" + Down) || !set.contains(Right + "_" + Up) || set.size() != 4) {
            return false;
        }
        return area == (Right - Left) * (Up - Down);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 3, 3},
                {3, 1, 4, 2},
                {1, 3, 2, 4},
                {3, 2, 4, 4},
        };
        System.out.println(isPrefectRectangle(matrix));
    }
}