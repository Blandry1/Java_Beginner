package Tutorial_5_Interface;

public class Ollie implements Player, Melee {
    //using interfaces:
    //make empty methods in a class (like abstraction)
    //call-implement the class you want to use, and write method in the active class.
    //difference between abstraction and interfaces is that interfaces are more general than specific.
    
    public int x,y,z;
    public int health = 100;
    
    @Override
    public void move(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void changeHealth(int amount) {
        health += amount;
    }

    @Override
    public int respawn() {
        x = 0;
        y= 0;
        z = 0;
        return 0;
    }

    @Override
    public void swingSword() {
        System.out.println("Swinging sword");
    }
    
    
}
