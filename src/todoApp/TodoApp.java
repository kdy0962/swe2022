package todoApp;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp implements Serializable{

    ArrayList<TodoList> Lists = new ArrayList<>();
    //싱글톤 객체 app, Eager initialization

    ArrayList<String> keys = new ArrayList<>();
    {
        keys.add("addList");
        keys.add("list");
        keys.add("addTodo");
        keys.add("complete");
        keys.add("incomplete");
        keys.add("save");
        keys.add("load");
    }

    private static TodoApp app = new TodoApp();

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
//    public static TodoApp getInstance(){
//        return app;
//    }

    public static void main(String[] args){
//        app.addList("집에서 할 일");
//        app.Lists.get(0).addTask("똥싸기");
//        app.Lists.get(0).addTask("밥먹기");
//        app.Lists.get(0).addTask("오줌싸기");
//        app.Lists.get(0).deleteTask("밥먹기");
        //1. 최초 App에 등록된 TodoList 전체가 이름과 그 안에 소유한 TodoTask수로 표시된다.
        //app.printLists();
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
                //addList
                if(c.equals(keys.get(0))){
                    String d = in.nextLine();
                    app.addList(d);
                    app.printLists();
                 //list
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
                //addTodo
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
                //complete
                }else if(c.equals(keys.get(3))){
                    String d = in.nextLine();
                    currentList.findTask(d).setComplete(true);
                    currentList.printTasks();
                //incomplete
                }else if(c.equals(keys.get(4))){
                    String d = in.nextLine();
                    currentList.findTask(d).setComplete(false);
                    currentList.printTasks();
                //save
                }else if(c.equals(keys.get(5))){
                    try {
                        Path p =  Paths.get("c:/test","test.txt");
                        if (!Files.exists(p))
                            Files.createFile(p);
                        ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(p));
                        out.reset();
                        out.writeObject(app);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //Writer out = Files.newBufferedWriter(p, StandardCharsets.UTF_8);
                    //out.flush();
                //load
                }else if(c.equals(keys.get(6))){
                    try {
                        Path p =  Paths.get("c:/test","test.txt");
                        if (!Files.exists(p)){
                            System.out.println("파일이 없습니다.");
                            continue;
                        }
                        ObjectInputStream input = null;
                        input = new ObjectInputStream(Files.newInputStream(p));
                        app = (TodoApp)input.readObject();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                    }

                }

            }
        }
    }
}
