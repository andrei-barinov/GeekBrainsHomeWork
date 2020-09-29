import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static int SIZE = 0;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        int i, j;
        do{
            System.out.println("Введите размер поля в формате X Y, при этом X=Y :");
            i = sc.nextInt();
            j = sc.nextInt();
        }while (i != j || i < 3 || j < 3);
        SIZE = i;
        do{
            initMap(); //Формирование пустого поля
            printMap();//Распечатка пустого поля на экран
            while(true){
                humanTurn(); //Ход человека
                printMap(); //Распечатка поля на экран с учетом хода сделанного человеком
                if(checkWin(DOT_X)){ //Проверка на победу
                    System.out.println("Победил человек");
                    break;
                }
                if(isMapFull()){ //Проверка на ничью
                    System.out.println("Ничья");
                    break;
                }
                aiTurn();// Ход компьютера
                printMap();//Распечатка поля на экран с учетом хода сделанного компьютером
                if(checkWin(DOT_O)){ //Проверка на победу
                    System.out.println("Победил Искуственный Интелект");
                    break;
                }
                if(isMapFull()){ //Проверка на ничью
                    System.out.println("Ничья");
                    break;
                }

            }
            System.out.println("Игра закончена");
            break;
        }while (true);
    }

    public static boolean checkWin(char symb){

        //Блок проверяет выигрышную комбинацию на одной из строк
        int sum_1 = 1;
        for (int i=0; i < SIZE ; i++ ){
            for (int j=1; j<SIZE ; j++ ){
                if (map[i][j] == map[i][j-1] && map[i][j] == symb && map[i][0] == symb && map[i][SIZE-1] == symb){
                    sum_1 += 1;
                }
            }
        }
        if(sum_1 == SIZE) return true;

        int sum_2 = 1; //Блок проверяет выигрышную комбинацию на одном из столбцов
        for (int i=1; i < SIZE ; i++ ){
            for (int j=0; j<SIZE ; j++ ){
                if (map[i][j] == map[i-1][j] && map[i][j] == symb && map[0][j] == symb && map[SIZE-1][j] == symb){
                    sum_2 += 1;
                }
            }
        }
        if(sum_2 == SIZE) return true;

        int sum_3= 1; //Блок проверяет выигрышную комбинацию на диагонали, выходящей из точки map[1][1]

        for (int i=1; i < SIZE ; i++ ){
            for (int j=1; j<SIZE ; j++ ){
                if ((i == j) && (map[i][j] == map[i-1][j-1] && map[i][j] == symb && map[0][0]==symb && map[SIZE-1][SIZE-1] == symb)){
                    sum_3 += 1;
                }
            }
        }
        if(sum_3 == SIZE) return true;


        int sum_4 = 1;//Блок проверяет выигрышную комбинацию на диагонали, выходящей из точки map[1][5]
        for (int i=1; i < SIZE ; i++ ){
            for (int j=0; j<SIZE-1 ; j++ ){
                if ((i + j) == ((i-1)+(j+1)) && map[i][j] == map[i-1][j+1] && map[i][j] == symb && map[SIZE-1][0] == symb && map[0][SIZE-1] == symb){
                    sum_4 += 1;
                }
            }
        }
        if(sum_4 == SIZE) return true;


        else return false;
    }

    public static boolean isMapFull(){ //Проверяет, заполнен ли массив полностью
        for(int i=0; i < SIZE; i++){
            for(int j=0; j < SIZE; j++){
                if(map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn(){//Ход компьютера
        int x, y;
        do{
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        }while (!isCellValid(x, y));//Условие проверяет свободна ли ячейка с вводимыми координатами и существует ли такая ячейка
        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;//Поместить в ячейку с координатами х, у символ О
    }


    public static void humanTurn(){//Ход человека
        int x, y;
        do{
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt()-1;
            y = sc.nextInt()-1;
        }while (!isCellValid(x, y)); //Условие проверяет свободна ли ячейка с вводимыми координатами и существует ли такая ячейка
        map[y][x] = DOT_X; //Поместить в ячейку с координатами х, у символ Х
    }

    public static boolean isCellValid(int x, int y){ //Проверка ячейки, свободна или занята
        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;//Проверяет, существует ли ячейка с такими координатами
        if(map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap(){ // Инициализация пустого массива
        map= new char[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap(){ //Распечатка массива
        for(int i=0; i <= SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i < SIZE; i++){
            System.out.print((i + 1) + " ");
            for(int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}