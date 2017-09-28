package Tutorial_3_inheritance;

//makes Pet Class, the Parent with the "extend" keyword.
public class Cat extends Pet { 

    boolean kitten;
    
    public Cat(boolean Kitten, String name, String price, int age){
        super(name, price, age);
        this.kitten = kitten;
    }
}
