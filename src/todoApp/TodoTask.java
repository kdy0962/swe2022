package todoApp;

import java.util.Date;

public class TodoTask {
    //field - 이름, 완료여부, 완료날짜
    String taskName;
    boolean complete;
    Date deadline;

    //constructor
    public TodoTask(String taskName) {
        this.taskName = taskName;
    }
}
