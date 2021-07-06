public class TheThird_SevenTasks {

    public static void main(String[] args) {
        System.out.println(Expression(2f, 3f, 5f, 2.5f));
        System.out.println(CheckSumm(7, 5));
        CheckFigures( 0);
        System.out.println(CheckNegativeFigures(-5));
        HelloName("Андрей");
    }

    public static float Expression(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean CheckSumm(int a, int b) {
        return (a + b) >= 10 & (a + b) <= 20;
    }

    public static void CheckFigures(int a){
        if (a >= 0) System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }

    public static boolean CheckNegativeFigures(int a){
        return a < 0;
    }

    public static void HelloName(String name){
        System.out.println("Привет, " + name + "!");
    }
}
