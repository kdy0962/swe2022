package todoApp;

import java.io.Serializable;

public class TodoTheme implements Serializable{
    //field - Color, Icon
    private String Color;
    private String Icon;

    public enum Color {BLUE, ORANGE, PURPLE, GREEN, SKY};
    public enum Icon {AIRPLANE, MOUNTAIN, HOUSE, BUS, TOWER};

    TodoTheme(){
        Color = Color.valueOf("BLUE");
        Icon = Icon.valueOf("AIRPLANE");
    }

    public void setTheme(String Color, String Icon){
        this.Color = Color;
        this.Icon = Icon;
    }

}
