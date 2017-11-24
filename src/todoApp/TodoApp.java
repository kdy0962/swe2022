package todoApp;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {

    ArrayList<TodoList> Lists = new ArrayList<>();
    //싱글톤 객체 app, Eager initialization

    ArrayList<String> keys = new ArrayList<>();
    {
        keys.add("addList");
        keys.add("list");
        keys.add("addTodo");
        keys.add("complete");
        keys.add("incomplete");
    }

    private static final TodoApp app = new TodoApp();

    private TodoApp(){

    }
    //addList & deleteList methods
    public void addList(String listName){
        Lists.add(new TodoList(listName));
    }

    public void deleteList(TodoList theList){
        Lists.remove(theList);
    }
    //getInstance method
    public static TodoApp getInstance(){
        return app;
    }

    public static void main(String[] args){
        app.addList("집에서 할 일");
        app.Lists.get(0).addTask("똥싸기");
        app.Lists.get(0).addTask("밥먹기");
        app.Lists.get(0).addTask("오줌싸기");
        app.Lists.get(0).deleteTask("밥먹기");
        //1. 최초 App에 등록된 TodoList 전체가 이름과 그 안에 소유한 TodoTask수로 표시된다.
        app.printLists();
//        System.out.println(app.Lists.get(0).getListName().equals("집에서 할 일"));
//        Scanner in = new Scanner(System.in);
//        String d = in.next();
//        int index = 0;
//        if(!app.Lists.isEmpty()){
//            for(TodoList list : app.Lists){
//                if (list.getListName().equals(d)){
//                    break;
//                }
//                else index++;
//            }
//            TodoList currentList = app.Lists.get(index);
//            currentList.printTasks();
//        }
        app.on(System.in);
    }
    public void printLists(){
        for (TodoList list :app.Lists){
            System.out.println(list.getListName()+" "+list.taskList.size());
        }
    }
    public void on(InputStream src){
        Scanner in = new Scanner(src).useDelimiter("\\n*");
        exit:
        while(true){
            in.reset();
            TodoList currentList = null;
            while (in.hasNext()){
                String c = in.nextLine();
                if(!keys.contains(c)||"exit".equals(c)) break exit;
                if(c.equals(keys.get(0))){
                    String d = in.nextLine();
                    app.addList(d);
                    app.printLists();
                }else if(c.equals(keys.get(1))){
                    String d = in.nextLine();
                    int index = 0;
                    if(!app.Lists.isEmpty()){
                        for(TodoList list : app.Lists){
                            if (list.getListName().equals(d)){
                                break;
                            }
                            else index++;
                        }
                        currentList = app.Lists.get(index);
                        currentList.printTasks();
                    }

                }else if(c.equals(keys.get(2))){
                    String [] d = in.nextLine().split(",");
//                    System.out.println(d[0]+"   "+d[1]);
                    currentList.addTask(d[0]);

                    SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    try {
                        currentList.findTask(d[0]).setDeadline(transFormat.parse(d[1]));
                        if (d.length>2){
                            currentList.findTask(d[0]).setAlarm(transFormat.parse(d[2]));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    currentList.printTasks();

                }else if(c.equals(keys.get(3))){
                    String d = in.nextLine();
                    currentList.findTask(d).setComplete(true);
                    currentList.printTasks();
                }else if(c.equals(keys.get(4))){
                    String d = in.nextLine();
                    currentList.findTask(d).setComplete(false);
                    currentList.printTasks();
                }

            }
        }
    }
}
