import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {

		System.out.println("Игра \"Угадай число\"");
		System.out.println();
    	GuessNumber();

		System.out.println("Игра \"Угадай слово\"");
		System.out.println();
    	GuessWord();

    }

    public static void GuessNumber(){
		Scanner in = new Scanner(System.in);
		int b = 1;
		do{
			int number = (int) (Math.random() * 9);
			int count = 0;
			System.out.println("Введите число от 0 до 9");
			while (count < 3){
				CountAttemps(count);
				int a = in.nextInt();
				if (a == number){
					System.out.println("Вы угадали!!!");
					break;
				}
				else if(a < number) System.out.println("Вы ввели слишком маленькое число");
				else System.out.println("Вы ввели слишком большое число");
				count++;
				if(count >= 3){
					System.out.println("Вы проиграли(((" + "\n" + "Правильный ответ: " + number);
					break;
				}
			}
			System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
			b = in.nextInt();
		}while (b != 0);
	}

	public static void CountAttemps (int count){
		if(count != 2) System.out.println("У Вас есть " + (3 - count) + " попытки" );
		else System.out.println("У Вас осталась одна попытка" );
	}

    public static void GuessWord(){
		String [] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
		int n, i;
		String word = words[(int) (Math.random()*(words.length - 1))];
		Scanner in = new Scanner(System.in);

		do{
			System.out.println("Введите слово:");
			String NewWord = in.nextLine();
			if(NewWord.equals(word)){
				System.out.println("Поздравляю! Вы угадали!!!");
				break;
			}
			else {
				int lenWord = word.length();
				int lenNewWord = NewWord.length();
				if(lenWord < lenNewWord) n = lenWord;
				else n = lenNewWord;
			}
			String s = "";
			for(i = 0; i < n; i++){
				if((word.charAt(i))==(NewWord.charAt(i))) s += word.charAt(i);
				else s += "#";
			}
			for (i = 0; i < 15 - n; i ++){
				s += "#";
			}
			System.out.println(s);

		}while (true);
	}
}
