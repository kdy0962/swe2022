package lesson4;

import lesson4.sample.Imported;

public class ImportTest {
    //정적 임포트까지 내려가지 않는다!
    static public void main(String[] arg){
        System.out.println(lesson4.sample.Imported.getText());
        System.out.println(Imported.getText());
        StaticInnerClass.Class2 c = new StaticInnerClass.Class2();
    }
}
