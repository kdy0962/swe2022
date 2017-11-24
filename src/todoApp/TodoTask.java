package todoApp;

import java.util.Calendar;
import java.util.Date;

public class TodoTask {
    //field - 이름, 완료여부, 완료날짜
    String taskName;
    boolean complete;
    Date deadline;
    Date makingDate;
    Date noticeTime;


    //constructor
    public TodoTask(String taskName) {
        this.taskName = taskName;
        this.complete = false;
        this.deadline = null;
        this.makingDate = new Date();
        this.noticeTime = null;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setAlarm(Date noticeTime){
        this.noticeTime = noticeTime;
    }
    public boolean check(){
        if(noticeTime==null) return false;
        return true;
    }
    public void noticce(){
        if(check()&&this.noticeTime.before(new Date())){
            System.out.println("Oh!!!");
        }
    }
}
