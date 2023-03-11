package e2;

public class Cell {

    private final Type type;
    private final int value;
    private boolean clicked;
    private boolean flag;

    public Cell(Type type, int value){
        this.type = type;
        this.value = value;
        this.clicked = false;
        this.flag = false;
    }

    public Type getType() {
        return this.type;
    }

    public int getValue() {
        return this.value;
    }

    public boolean getClicked(){
        return this.clicked;
    }

    public void setClicked(){
        this.clicked = true;
    }

    public void changeFlag(){
        this.flag = !this.flag;
    }

    public boolean getFlag(){
        return this.flag;
    }
    
}
