
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Tutorial {
    public static void main(String[] args) throws IOException {
        //ep1
        //variables: variable-type, identifier; assignment-operator, value
        int answer = add(10,5);
        print("The answer is: " + answer);
        System.out.println("-------");
        
        //ep2
        //arrays: variable-type, array, identifier; assignment-operator, new ,variable-type, array-value
        String[] namesOfWorkers = new String[4];
        
        //identifier, array-value = value;
        namesOfWorkers[0] = "Ollie";
        namesOfWorkers[1] = "Alex";
        namesOfWorkers[2] = "Matt";
        namesOfWorkers[3] = "Chloe";
        
        int x = 0;
        
        System.out.println("There are " + namesOfWorkers.length + "workers");
        
        while (x < 4) {
            System.out.println(namesOfWorkers[x]);
            x++;
        }
        System.out.println("-------");
        
        //ep3
        //arrays work well with loops
        //break statement are set in if-statements
        
        //for loop: variable; condition; Increment/decrement
        String[] names = {"Ollie", "Alex", "Ellie", "Jason"};
        
        for(int y = 0; y < names.length; y++) {
            System.out.println(names[y]);
        }
        System.out.println("--");
        //or using the enhanced for-loop
        //it gets the array value and makes it equal to the identifier
        for(String name : names) {
            System.out.println(name);
        }
        
        System.out.println("-------");
        
        //ep4
        //class, identifier = new-instance, class, constructor;
        Person person1 = new Person("Ollie", "17/03/93", 17);
        Person person2 = new Person("Martin", "13/02/63", 50);
       
        
        System.out.println("Person 1:\n" + "Name: " + person1.name + "\n" + "Age:" + person1.age 
                + "\n" + person1.dob + "\n");
        System.out.println("Person 2:\n" + "Name: " + person2.name + "\n" + "Age:" + person2.age 
                + "\n" + person2.dob);
        
        System.out.println("-----");
       
        //ep5
        //multi-dimensional arrays
        float[][][] coordinates = new float[16][16][16];
         
        for(int xp =0; xp < 16; xp++) {
            for(int y= 0; y<16; y++){
                for(int z = 0; z <16; z++){
                    coordinates[x][y][z] = 3.14f;
                }
            }
        }
        
       //ep6
       //arrayList
       // object-type, identifier = new, object-type, constructor
       ArrayList list = new ArrayList(); 
       
       String name1 = "Ollie";
       String name2 = "Aiden";
       
       list.add(name1);
       list.add(name2);
       
       System.out.println(list.get(0));
       System.out.println(list.get(1));
       
       list.remove(name1);
       System.out.println(list.get(0));
       
       System.out.println("-----");
       
       //ep7
       //name1.equal(name2));
       
       //ep8: Reading from the Console
       
//       Scanner in = new Scanner(System.in);
//       
//       System.out.println("What is your name?");
//       String name = in.nextLine();
//       System.out.println("How old are you?");
//       
//       int age = 0;
//       boolean gotIt = false;
//      
//       while(!gotIt) {
//           try {
//               age = in.nextInt();
//               gotIt = true;
//           } catch (Exception e) {
//               System.out.println("Invalid input, please input an integer");
//               in.next();
//           }
//       }
//       System.out.println("Your name is " + name + " and your age is " + age);
       
       //ep8: Writing and Reading to-from a file. 
       //Open and close data-pipeline, i.e. close pipeline on write, and loop until false for read.
       
       BufferedWriter write = new BufferedWriter(new FileWriter("C:/Users/Benjamin/Desktop/test.txt"));
       
       write.write("Hello World");
       write.newLine();
       write.write("This is a test...");
       
       write.close();
       
       BufferedReader read = new BufferedReader(new FileReader("C:/Users/Benjamin/Desktop/test.txt"));
       
       String line;
       
       while((line = read.readLine()) != null) {
           System.out.println(line);
       }
       
       //ep9: FNS Machine
       
//       enum Days {
//           MONDAY, TUESDAY, WEDNESDAY, THURSDAY,FRIDAY, SATURDAY, SUNDAY;
//       }
//       public Tutorial {
//            Days day = Days.Sunday;
//            
//            switch(day) {
//                case Monday:
//                    System.out.println("this is monday");
//                    break;
//                case Tuesday:
//                    break;
//                default:
//                    System.out.println("Invalid input");
//                    break;
//            }  
    }
    
    
    
    //methods: return-type, identifier, parameters
    static void print (String s){
        System.out.println(s);
    }
    static int add(int a, int b) {
        int c = a + b;
        return c;
    }
}