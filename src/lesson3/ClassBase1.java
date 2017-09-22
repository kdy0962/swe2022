package lesson3;

public class ClassBase1 {
    static public void main(String[] arg){

        Constructor c1 = new Constructor();
        System.out.println(c1.getName());
        System.out.println(c1.getFriend(0));
        Constructor c2 = new Constructor("kiwan");
        System.out.println(c2.getName());
        System.out.println(c1.getFriend(0));
        Constructor c3 = new Constructor("kiwan","Maeng");
        System.out.println(c3.getName());
        System.out.println(c1.getFriend(0));
    }
}
