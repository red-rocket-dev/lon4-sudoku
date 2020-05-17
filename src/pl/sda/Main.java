package pl.sda;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /* Sprawdzenie rozwiązania sudoku
         * https://miro.medium.com/max/1400/1*B87VusyxVmV0WOdUybWKpg.png
         */
        /* 5 3 4      6 7 8      9 1 2
         * 6 7 2      1 9 5      3 4 8
         * 1 9 8      3 4 2      5 6 7
         *
         * 8 5 9      7 6 1      4 2 3
         * 4 2 6      8 5 3      7 9 1
         * 7 1 3      9 2 4      8 5 6
         *
         * 9 6 1      5 3 7      2 8 4
         * 2 8 7      4 1 9      6 3 5
         * 3 4 5      2 8 6      1 7 9
         */
        // Jak sprawdzić czy sudoku zostało rozwiązane poprawnie?
        // * unikalne liczby w poziomie OK
        // * unikalne w pionie
        // * unikalne w kwadracie 3 x 3
        // * suma w kwadracie 3x3 = 45 OK


        int[] test = {1,2,3,4};

        int[] test1 = new int[4];
        test1[0] = 1;
        test1[1] = 2;
        test1[2] = 3;
        test1[3] = 4;

        int[][] test2 = new int[3][];
        test2[0] = test;

        int[][] test3 = {test, null, null};
        int[][] test4 = {{1,2,3,4}, null, null};
        //System.out.println(Arrays.toString(test2));
        //System.out.println(Arrays.toString(test3));
        //System.out.println(Arrays.toString(test4));



        //System.out.println(test.length);

        int[][] sudokuBoard =
                {
                        {5, 3, 4, 6, 7, 8, 9, 1, 2},
                        {6, 7, 2, 1, 9, 5, 3, 4, 8},
                        {1, 9, 8, 3, 4, 2, 5, 6, 7},

                        {8, 5, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 5, 3, 7, 9, 1},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},

                        {9, 6, 1, 5, 3, 7, 2, 8, 4},
                        {2, 8, 7, 4, 1, 9, 6, 3, 5},
                        {3, 4, 5, 2, 8, 6, 1, 7, 9}
                };

        for(int i = 0; i < sudokuBoard.length; i ++) {
            for(int j = 0; j < sudokuBoard[i].length; j ++) {
                System.out.print(sudokuBoard[i][j]+" ");
            }
            System.out.println();
        }
        //sprawdzenie linii:
        for(int i = 0; i < sudokuBoard.length; i ++) {
            Integer[] alreadyOccuredArray = new Integer[9];
            int alreadyOccuredCounter = 0; //ile mam miejsc wypelnionych w alreadyOccuredArray
            for(int j = 0; j < sudokuBoard[i].length; j ++) {
                int currentProcessingValue = sudokuBoard[i][j];
                if (isValuePresentInArray(alreadyOccuredArray, alreadyOccuredCounter, currentProcessingValue))
                    return; //albo
                alreadyOccuredArray[alreadyOccuredCounter] = currentProcessingValue;
                alreadyOccuredCounter ++;
                System.out.print(sudokuBoard[i][j]+" ");
            }
            System.out.println();
        }
        //sprawdzanie sumy kwadratu
        int[][] boardSums = new int[3][3];

        String[][] testSum = {
                {"1","2","3"},
                {"4","5", "6"},
                {"7","8", "9"}
        };

        for(int i = 0; i < sudokuBoard.length; i ++) {
            for(int j = 0; j < sudokuBoard[i].length; j ++) {
                int squareXNumber = j / 3;
                int squareYNumber = i / 3;
                System.out.print(testSum[squareXNumber][squareYNumber]);
                boardSums[squareXNumber][squareYNumber] += sudokuBoard[i][j];
                /*System.out.print(squareXNumber);
                System.out.print(",");
                System.out.print(squareYNumber);
                System.out.print(" ");*/


                //System.out.print(sudokuBoard[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();






    }

    private static boolean isValuePresentInArray(Integer[] occuredArray, int occuredArrayRealLength, int lookingFor) {
        for(int occuredIndex = 0; occuredIndex < occuredArrayRealLength; occuredIndex++ ) {
            Integer occured = occuredArray[occuredIndex];
            if(occured.equals(lookingFor)) {
                System.out.println("To nie sudoku!");
                System.exit(1);
                return true;
            }
        }
        return false;
    }
}
