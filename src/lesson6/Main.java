package lesson6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static class Run implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10000;i++) Main.doWork();
        }
    }
    static class Run2 implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<2000;i++) Main.doWork();
        }
    }
    static class LengthComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return o1.length()-o2.length();
        }
    }
    static class EmployeeComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.salary-o2.salary;
        }
    }

    static void doWork(){}

    static public void main(String[] args){
        Runnable task = new Run();
        Runnable task2= () ->{
            for(int i =0;i<2000;i++) doWork();
        };
        Runnable task2_old = new Run2();
        Comparator<String> comp1 = new LengthComparator();
        Comparator<String> comp2 = (f,s) ->f.length() - s.length();

        Employee me = new Employee(100), you = new Employee(200);
        Employee[] members = {me, you};
        Arrays.sort(members, new EmployeeComparator());

        Arrays.sort(members,(f,s)->f.salary-s.salary);
    }
}
