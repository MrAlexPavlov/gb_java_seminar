import java.util.ArrayList;
import java.util.Random;

/**
На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
И вывести Доску.
Пример вывода доски 8x8

0x000000
0000x000
00x00000
 */
public class hw03 {
    public static int[][] matrix;
    public static void main(String[] args) {
        int queen = 0;
        // Пытаемся расставить ферьзей на шахматной доске так, что бы они не били друг друга
        while (queen!=8){
            queen = fillChessBoard();
        }

        System.out.printf("Queens: %d\n",queen);
        showMatrix();  
    }

    public static int fillChessBoard() {
        // задаем шахматную доску
        matrix = new int[8][8];
        int j, queen = 0;
        // Берем за основу логику, что на одной линни(строки матрицы)
        // может находиться только одна фигура ферзя
        for (int i = 0; i < matrix.length; i++) {
            // вытаскиваем случайное место из строки матрицы куда будем ставить ферзя
            // из всех возможных на этой срочке
            j = randomEmpty(i);
            // если мест нет, то решения на этой доске у нас уже не будет
            if (j == -1) return queen;
            // Если есть куда поствить ферзя то его туда ставим 
            queen +=1 ;
            matrix[i][j] = 1;
            // Отмечаем на оставшейся части матрицы куда ставить ферзя уже нельзя. 
            // битые поля по вертикали
            fillCol(i+1, j);
            // битые поля по обеим диаганалям
            fillDiag(i+1, j);
        }

        return queen;
    }

    private static int randomEmpty(int row) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random rnd = new Random();
        // Перебираем строку матрицы и ище все 0, эквивалент не битого поля
        // Наполняем список со значениями пустых мест в строке
        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i]==0) arr.add(i);
        }
        // Если нет пустых строк возвращаем -1
        if (arr.size()==0) return -1;
        // В ином случае, индекс случайного пустого поля
        return arr.get( rnd.nextInt(0,arr.size()) );
    }

    // Метод заполнения пометками битых фигурой столбцов
    public static void fillCol(int row, int col) {
        if (row>matrix.length) return;
        for (int i = row; i < matrix.length; i++) {
            matrix[i][col] = 2;
        }
    }
    
    // Метод заполнения пометками битых фигурой обеих диаганалей 
    public static void fillDiag(int row, int col) {
        if (row>matrix.length) return;
        int ng_col = col;
        for (int i = row; i < matrix.length; i++) {
            if (col+1 < matrix.length) col += 1;
            if (ng_col-1 >= 0) ng_col -= 1;
            
            matrix[i][ng_col] = 3;
            matrix[i][col] = 3;
        }
    }

    public static void showMatrix() {
        String x = "0";
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==1) x = "x";
                if (matrix[i][j]!=1) x = "0";
                System.out.printf(" %s",x);
            }
            System.out.print(" ]\n");
        }
        
    }

}
