package Tutorial_5_Interface;

public interface Player {
    
    public void move(int x, int y, int z);
    
    public void changeHealth(int amount);
    
    public int respawn();
}
