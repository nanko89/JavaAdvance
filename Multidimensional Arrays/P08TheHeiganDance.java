package Exercise;

import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playerHealth = 18500;
        int playerRow = 7;
        int playerCol = 7;
        double bossHealth = 3000000;
        String lastSpell = "";
        boolean isCloud = false;
        double damagePerTurn = Double.parseDouble(scanner.nextLine());


        while (playerHealth > 0 && bossHealth > 0) {
            bossHealth -= damagePerTurn;
            if (bossHealth <= 0) {
                break;
            }
            if (isCloud) {
                playerHealth -= 3500;
                isCloud = false;
                if (playerHealth <= 0) {
                    break;
                }
            }

            String[] input = scanner.nextLine().split(" ");
            String currentSpell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);


            boolean[][] chamber = new boolean[15][15];
            fillMatrix(chamber, row, col);

            if (chamber[playerRow][playerCol]) {
                if (isRowValid(chamber, playerRow - 1) && !chamber[playerRow - 1][playerCol]) {
                    playerRow--; // move up
                } else if (isColValid(chamber, playerCol + 1) && !chamber[playerRow][playerCol + 1]) {
                    playerCol++; // move right
                } else if (isRowValid(chamber, playerRow + 1) && !chamber[playerRow + 1][playerCol]) {
                    playerRow++; // move down
                } else if (isColValid(chamber, playerCol - 1) && !chamber[playerRow][playerCol - 1]) {
                    playerCol--; // move left
                }

                if (chamber[playerRow][playerCol]) {
                    if (currentSpell.equals("Cloud")) {
                        isCloud = true;
                        playerHealth -= 3500;
                        lastSpell = "Plague Cloud";

                    } else if (currentSpell.equals("Eruption")) {
                        playerHealth -= 6000;
                        lastSpell = currentSpell;
                    }

                }
            }


        }

        if (bossHealth <= 0){
            System.out.println("Heigan: Defeated!");
        }else {
            System.out.printf("Heigan: %.2f%n", bossHealth);
        }
        if (playerHealth <= 0){
            System.out.println("Player: Killed by " + lastSpell);
        }else {
            System.out.printf("Player: %d%n", playerHealth);
        }
        System.out.printf("Final position: %d,  %d%n",playerRow,playerCol);

    }

    private static boolean isRowValid(boolean[][] chamber, int playerRow) {
        return playerRow >= 0 && playerRow < chamber[playerRow].length;
    }

    private static boolean isColValid(boolean[][] chamber, int playerCol) {
        return playerCol >= 0 && playerCol < chamber.length;
    }

    private static void fillMatrix(boolean[][] chamber, int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            if (i >= 0 && i < chamber.length) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (j >= 0 && j < chamber.length) {
                        chamber[i][j] = true;
                    }
                }
            }
        }
    }
}
