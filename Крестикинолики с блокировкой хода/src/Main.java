import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static int SIZE = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
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
    }

    public static boolean checkWin(char symb){

         //Блок проверяет горизонталь
        for (int i=0; i < map.length ; i++ ){
            if(map[i][0] == symb && map[i][1] == symb && map[i][2]==symb) return true;
        }

        //Блок проверяет вертикаль
        for (int i=0; i < map.length ; i++ ){
            if(map[0][i] == symb && map[1][i] == symb && map[2][i]==symb) return true;
        }

        //Блок проверяет диагональ выходящую из точки [0][0]
        for(int i=1; i < map.length; i++){
            for(int j = 1; j< map.length; j++){
                if(map[0][0] == symb && map[1][1] == symb && map[2][2] == symb ) return true;
            }
        }

        //Блок проверяет диагональ выходящую из точки [0][2]
        for(int i=1; i < map.length; i++){
            for(int j = 1; j< map.length; j++){
                if(map[0][2] == symb && map[1][1] == symb && map[2][0] == symb ) return true;
            }
        }

        return false;
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
