package todoApp;

import java.util.ArrayList;

public class TodoApp {

    ArrayList<TodoList> Lists = new ArrayList<>();
    //싱글톤 객체 app, Eager initialization
    private static final TodoApp app = new TodoApp();

    private TodoApp(){

    }
    //addList & deleteList methods
    public void addList(TodoList newList){
        Lists.add(newList);
    }

    public void deleteList(TodoList theList){
        Lists.remove(theList);
    }
    //getInstance method
    public static TodoApp getInstance(){
        return app;
    }
}
