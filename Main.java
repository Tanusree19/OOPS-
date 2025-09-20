// Parent Class
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void makeSound() {
        System.out.println(name + " makes a sound.");
    }
}

// Child Class
class Dog extends Animal {

    Dog(String name) {
        super(name); // calling parent constructor
    }

    @Override
    void makeSound() {
        System.out.println(name + " barks: Woof Woof!");
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal("Generic Animal");
        Dog d1 = new Dog("Buddy");

        a1.makeSound();  
        d1.makeSound();  
    }
}