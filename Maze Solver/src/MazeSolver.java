import java.util.Scanner;

public class MazeSolver {
    static final int SIZE = 10;
    static char[][] maze = new char[SIZE][SIZE];
    static boolean[][] visited = new boolean[SIZE][SIZE];
    static int startRow, startCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("⚔️  Enter your 10-line maze below:");
        System.out.println("S = Start | E = End | # = Wall | . = Path");
        System.out.println("Paste all 10 lines (10 characters each, no spaces):");

        for (int i = 0; i < SIZE; i++) {
            String line = scanner.nextLine().trim();
            if (line.length() != SIZE) {
                System.out.println("⚠️ Each line must have exactly 10 characters. Try again.");
                i--;
                continue;
            }
            for (int j = 0; j < SIZE; j++) {
                maze[i][j] = line.charAt(j);
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        System.out.println("\n🗺️  Your Maze:");
        printMaze();

        System.out.println("\n🔍 Solving Maze...");
        boolean solved = dfs(startRow, startCol);

        if (solved) {
            System.out.println("\n✅ Path Found! Maze with '*' path:");
        } else {
            System.out.println("\n❌ No path found from S to E.");
        }

        printMaze();
    }

    private static boolean dfs(int r, int c) {
        if (!isValid(r, c) || visited[r][c] || maze[r][c] == '#') return false;
        if (maze[r][c] == 'E') return true;

        visited[r][c] = true;
        if (maze[r][c] != 'S') maze[r][c] = '*';

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            if (dfs(r + dr[d], c + dc[d])) return true;
        }

        if (maze[r][c] != 'S') maze[r][c] = '.';
        return false;
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < SIZE && c >= 0 && c < SIZE;
    }

    private static void printMaze() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                System.out.print(maze[r][c] + " ");
            }
            System.out.println();
        }
    }
}
