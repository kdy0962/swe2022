package todoApp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class TodoList{
    //TitleComparator, DeadlineComparator, MakingDateComparator, CompleteComparator
    static class TitleComparator implements Comparator<TodoTask>{
        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            return o1.taskName.compareToIgnoreCase(o2.taskName);
        }
    }
    static class DeadlineComparator implements Comparator<TodoTask>{
        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            if(o1.deadline.after(o2.deadline)) return 1;
            else return -1;
        }
    }
    static class MakingDateComparator implements Comparator<TodoTask>{
        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            if(o1.makingDate.after(o2.makingDate)) return 1;
            else return -1;
        }
    }
    static class CompleteComparator implements Comparator<TodoTask>{
        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            if(o1.complete&&!o2.complete) return 1;
            else if(!(o1.complete^o2.complete)) return 0;
            else return -1;
        }
    }
    //field - 이름, 정렬방향, 테마
    private String listName;
    private TodoTheme theme;
    private Sort sort;
    private boolean showComplete = true;

    public enum Sort {TITLE, DEADLINE, MAKINGDATE, COMPLETE, TODAY};

    ArrayList<TodoTask> taskList = new ArrayList<>();
    ArrayList<TodoTask> taskViewList = new ArrayList<>();

    //constructor
    public TodoList(String listName) {
        this.listName = listName;
        this.sort = Sort.valueOf("MAKINGDATE");
        this.theme = new TodoTheme();
    }
    //setter of fields
    public void setListName(String listName) {
        this.listName = listName;
    }

    public void printTasks(){
        for(TodoTask task : taskList){
            String completion = (task.complete) ? "- [0] " : "- [-] ";
            if(task.check()){
                System.out.println(completion+task.taskName+", "+task.deadline+", "+"알림");
            }else{
                System.out.println(completion+task.taskName+", "+task.deadline);
            }
        }
    }

    //addTask & deleteTask methods
    public ArrayList<TodoTask> addTask(String taskName){
        taskList.add(new TodoTask(taskName));
        return getTaskViewList();
    }

    public ArrayList<TodoTask> deleteTask(String taskName){
        findTask(taskName);
        taskList.remove(taskName);
        return getTaskViewList();
    }
    public TodoTask findTask(String $taskName){
        int index = 0;
        if(!taskList.isEmpty()){
            for(TodoTask task : taskList){
                if (task.taskName.equals($taskName)){
                    break;
                }
                else index++;
            }
        }
        return taskList.get(index);
    }

    //setSort method
    public void setSort(Sort srt) {
        this.sort = srt;
        switch (srt){
            case TITLE:
                Collections.sort(taskViewList, new TitleComparator());
                return;
            case DEADLINE:
                Collections.sort(taskViewList, new DeadlineComparator());
                return ;
            case MAKINGDATE:
                Collections.sort(taskViewList, new MakingDateComparator());
                return ;
            case COMPLETE:
                Collections.sort(taskViewList, new CompleteComparator());
                return ;
//            case TODAY:
//                return ;
        }
    }

    public ArrayList<TodoTask> changeVisibilityByCompletion(){
        this.showComplete = !this.showComplete;
        return getTaskViewList();
    }
    public ArrayList<TodoTask> getTaskViewList(){
        taskViewList = taskList;

        //complete에 따라 바꾸고
        if(!showComplete){
            for(TodoTask task : taskViewList){
                if(task.complete) taskViewList.remove(task);
            }
        }
        //sort
        setSort(this.sort);
        return taskViewList;
    }

    public void rename(String newName){
        this.listName = newName;
    }

    public String getListName(){
        return this.listName;
    }


}
