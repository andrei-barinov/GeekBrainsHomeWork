public class Main {

    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Иванов Иван", "Программист", "ivanov@mail.ru", "+79567895432",
                2500, 26);
        empArray[1] = new Employee("Смирнов Вадим", "Водитель", "smirnov@mail.ru", "+79557897432",
                500, 34);
        empArray[2] = new Employee("Сидоров Николай", "Грузчик", "sidorov@mail.ru", "+79557997433",
                400, 45);
        empArray[3] = new Employee("Петров Владимир", "Учитель", "petrov@mail.ru", "+79347597537",
                700, 38);
        empArray[4] = new Employee("Романов Дмитрий", "Врач", "romanov@mail.ru", "+79245577638",
                1400, 47);

        for (int i = 0; i < empArray.length; i++){
            if(empArray[i].getAge() > 40) empArray[i].printInfoAboutEmployee();
        }
    }
}