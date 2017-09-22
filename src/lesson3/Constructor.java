package lesson3;

import java.util.ArrayList;

public class Constructor {
    final String firstName;
    private String lastName;
    private String separator;
    private ArrayList<String> friends;
    {
        separator = " ";
    }
    {
        friends = new ArrayList<>();
        friends.add("mike");
        friends.add("jane");
    }

    public Constructor(){
        this("john","doe");
    }
    public Constructor(String fname){
        this(fname,"doe");
    }
    public Constructor(String fname,String lname){
        firstName =fname;
        lastName = lname;
    }
    public String getName(){
        return firstName+separator+lastName;
    }
    public String getFriend(int index){
        return friends.get(index);
    }

}
