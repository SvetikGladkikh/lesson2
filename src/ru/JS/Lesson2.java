
public class  Lesson2 {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private static final int CYCLES = 100;

    public static void main(String[] argv) {
        int[][] grid = new int[HEIGHT][WIDTH];
        int[][] temp = new int[HEIGHT][WIDTH];

        int row;
        int col;
        for (row = 0; row < HEIGHT; row++) {
            for (col = 0; col < WIDTH; col++) {
                grid[row][col] = 0;
            }
        }

        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][2] = 1;
        grid[2][1] = 1;
        grid[2][2] = 1;

        int i;
        int x;
        int y;
        int neighbours;

        for (i = 0; i < CYCLES; i++) {
            for (row = 0; row < HEIGHT; row++) {
                for (col = 0; col < WIDTH; col++) {
                    temp[row][col] = 0;
                }
            }

            for (row = 0; row < HEIGHT; row++) {
                for (col = 0; col < WIDTH; col++) {
                    neighbours = 0;

                    for (y = -1; y < 2; y++) {
                        for (x = -1; x < 2; x++) {
                            if ((x != 0 || y != 0) && grid[(row + y + HEIGHT) % HEIGHT][(col + x + WIDTH) % WIDTH] == 1) {
                                neighbours++;
                            }
                        }
                    }

                    //System.out.println(row + " " + col + " " + neighbours);

                    if (grid[row][col] == 1) {
                        if (neighbours < 2 || neighbours > 3) {
                            temp[row][col] = 0;
                        } else {
                            temp[row][col] = 1;
                        }
                    } else if (grid[row][col] == 0) {
                        if (neighbours == 3) {
                            temp[row][col] = 1;
                        } else {
                            temp[row][col] = 0;
                        }
                    }
                }
            }

            StringBuilder out = new StringBuilder();

            for (row = 0; row < HEIGHT; row++) {
                for (col = 0; col < WIDTH; col++) {
                    grid[row][col] = temp[row][col];
                    out.append(grid[row][col] + " ");
                }

                out.append("\n");
            }

            System.out.println(out);
            System.out.println("\n");
        }
    }
}

