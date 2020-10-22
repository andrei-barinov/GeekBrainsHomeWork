public class Employee {
    private String FIO;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String FIO, String position, String email, String phone, int salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfoAboutEmployee(){
        System.out.println("ФИО: " + this.FIO + "\n" + "Должность: " + this.position + "\n" + "email адрес: " +
                this.email + "\n" + "Телефон: " + this.phone + "\n" + "Зарплата: " + this.salary + "\n" + "Возраст: "
                + this.age);
        System.out.println();
    }

    public int getAge() {
        return age;
    }
}
