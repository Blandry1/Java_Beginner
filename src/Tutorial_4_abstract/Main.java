package Tutorial_4_abstract;

public class Main {
    public static void main(String[] args) {
       //abstraction adds functionality to parent/child relationship
       //it allows a parent method to be created in the child classes
        Shape myShape = new Shape() {
            @Override
            public void draw() {
                //draw new shape
            }
        };
        
        Shape s1 = new Circle();
        Shape s2 = new Circle();
       // s1.equals(s2);
    }

}
