package Tutorial_4_abstract;

public abstract class Shape {
    public int x,y;
    public int width, height;
    
    public abstract void draw();
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Shape) {
             Shape compare = (Shape) obj;
             return  x == compare.x &&
                     y == compare.y &&
                     width == compare.width &&
                     height == compare.height;
        }       
        else {
            return false;
        }
    
    }
}
