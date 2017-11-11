package todoApp;

public class TodoList {
    //field - 이름, 정렬방향, 테마
    String listName;
    TodoTheme theme;
    String sort = "title";

    //constructor
    public TodoList(String listName) {
        this.listName = listName;
    }
    //setter of fields
    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setTheme(TodoTheme theme) {
        this.theme = theme;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
