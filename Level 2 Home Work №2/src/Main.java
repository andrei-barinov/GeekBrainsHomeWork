import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] arr = new String[0][0]; //Иницилизируем массив

        do {
            System.out.println("Введите количество строк в массиве: ");
            int a = sc.nextInt();
            System.out.println("Введите количество столбцов в массиве: ");
            int b = sc.nextInt();
            arr = new String[a][b];

            doCheckArr(arr); //Обработка исключения

        } while (!checkArr(arr));

        inputArr(arr); //Ввод массива

        System.out.println();

        printArr(arr); //Выводим массив в консоль

        System.out.println();

        while (!doCheckElement(arr)){
            doCheckDigit(arr); //Проверка элементов массива на приводимость к числовому типу
            System.out.println();
            correctArr(arr);
            System.out.println();
        }

        printArr(arr); //Вывод скоректированного массива в консоль
        System.out.println();
        sumArr(arr);

    }

    static void doCheckArr(String[][] arr){ //Проверка размера массива
        try{
            new ArrayCapacity().doCheckArray(arr);
        } catch (MyArraySizeException ex){
            ex.printStackTrace();
        }
    }

    static void doCheckDigit(String[][] arr){
        try{
            new ArrayCapacity().checkTypeOfValue(arr);
        } catch (MyArrayDataException ex){
            System.out.println(ex.getMessage());
            //ex.printStackTrace();
        }
    }

    static void sumArr(String[][] arr){ // Суммируем все элементы массива
        int s = 0;
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                int a = Integer.parseInt(arr[i][j]);
                s += a;
            }
        }
        System.out.println("Сумма всех элементов массива равна: " + s);
    }

    static boolean checkArr(String[][] arr){
        int SIZE = 4;
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr.length != SIZE || arr[i].length != SIZE) return false;
            }
        }
        return true;
    }

    static void inputArr(String[][] arr){ //Ввод значений массива
        System.out.println("Введите значения элементов массива: ");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("arr[" + i + "]" + "[" + j + "] = ");
                String str = sc.next();
                arr[i][j] = str;
            }
        }
    }

    static void printArr(String[][] arr){ // Вывод массива в консоль
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean doCheckElement(String[][] arr){ //Метод проверяет наличие нечисловых элементов в массиве
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                char[] b = arr[i][j].toCharArray();
                for(int k = 0; k < b.length; k++){
                    if (!Character.isDigit(b[k])) return false;
                }
            }
        }
        return true;
    }

    static String[][] correctArr(String[][] arr){ //Метод исправляет некорректно введенные значения элементов массива
        Scanner sc = new Scanner(System.in);
        boolean a = true;
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                if(a){
                    char[] b = arr[i][j].toCharArray();
                    for(int k = 0; k < b.length; k++){
                        if (!Character.isDigit(b[k])){
                            System.out.print("Введите правильное значение элемента arr[" + i + "][" + j + "] = ");
                            arr[i][j] = sc.next();
                            a = false;
                            break;
                        }
                    }
                }
                else break;
            }
        }
        return arr;
    }
}

