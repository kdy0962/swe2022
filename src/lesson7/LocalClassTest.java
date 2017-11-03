package lesson7;

import java.util.Random;

public class LocalClassTest {
    static public void main(String[] args){
        IntSequence seq = randomInts(3,5);
        System.out.println(seq.next());
        System.out.println(seq.next());
        System.out.println(seq.next());
    }
    private static Random generator = new Random();
    public static IntSequence randomInts(int low, int high){
        return() -> low + generator.nextInt(high - low + 1);

    }
}
