import java.util.*;

class Node {
    int row, col;
    boolean isWall;
    boolean isVisited;
    Node previous;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
        this.isWall = false;
        this.isVisited = false;
        this.previous = null;
    }

    @Override
    public String toString() {
        if (isWall) return "#";
        if (this.equals(PathfindingVisualizer.start)) return "S";
        if (this.equals(PathfindingVisualizer.end)) return "E";
        if (isVisited) return "*";
        return ".";
    }
}

public class PathfindingVisualizer {
    static final int ROWS = 10;
    static final int COLS = 10;
    static Node[][] grid = new Node[ROWS][COLS];
    static Node start;
    static Node end;

    public static void main(String[] args) {
        initGrid();

        Scanner scanner = new Scanner(System.in);

        // Get start and end points
        System.out.println("Set START point (row col): ");
        start = grid[scanner.nextInt()][scanner.nextInt()];

        System.out.println("Set END point (row col): ");
        end = grid[scanner.nextInt()][scanner.nextInt()];

        // Set walls
        System.out.println("Add WALLS. Enter -1 to stop.");
        while (true) {
            System.out.print("Wall at (row col): ");
            int r = scanner.nextInt();
            if (r == -1) break;
            int c = scanner.nextInt();
            grid[r][c].isWall = true;
        }

        System.out.println("\nInitial Grid:");
        printGrid();

        System.out.println("\nFinding path...");
        boolean found = bfs();

        if (found) {
            markPath();
            System.out.println("\nPath found:");
        } else {
            System.out.println("\nNo path found.");
        }

        printGrid();
    }

    // BFS Algorithm
    private static boolean bfs() {
        Queue<Node> queue = new LinkedList<>();
        start.isVisited = true;
        queue.add(start);

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}}; // Up, Down, Left, Right

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.equals(end)) return true;

            for (int[] d : directions) {
                int newRow = current.row + d[0];
                int newCol = current.col + d[1];

                if (isValid(newRow, newCol)) {
                    Node neighbor = grid[newRow][newCol];

                    if (!neighbor.isVisited && !neighbor.isWall) {
                        neighbor.isVisited = true;
                        neighbor.previous = current;
                        queue.add(neighbor);
                    }
                }
            }
        }

        return false;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }

    private static void markPath() {
        Node current = end.previous;

        while (current != null && !current.equals(start)) {
            current.isVisited = true;
            current = current.previous;
        }
    }

    private static void initGrid() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                grid[r][c] = new Node(r, c);
            }
        }
    }

    private static void printGrid() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }
}
