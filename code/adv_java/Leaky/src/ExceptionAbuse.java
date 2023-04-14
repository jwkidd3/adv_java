
class Employee {

    int salary;

    public int getSalary() {
        return salary;
    }

    public void doSomething() {
    }
}

public class ExceptionAbuse {

    public static void main(String[] args) {

        long startTime, endTime;

        Employee[] employees = new Employee[10000];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee();
        }

        startTime = System.nanoTime();
        try {
            int i = 0;
            while (true) {
                employees[i++].doSomething();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // ..
        }

        endTime = System.nanoTime();

        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        for (int i = 0; i < employees.length; i++) {
            employees[i].doSomething();
        }

        endTime = System.nanoTime();

        System.out.println(endTime - startTime);
    }
}
