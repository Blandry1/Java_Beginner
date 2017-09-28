package Tutorial_2;

//ep11: constructors

public class Coordinate {
    int x, y, z;
    
    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
   
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
