public class Animal {
    String name;
    int age;

    void makeSound() {
        System.out.println("Making Sound");
    }
}

class Cat extends Animal {
    String breed;
    void meow() {
        System.out.println("Making Sound");
    }
}

class Dog extends Animal {
    String color;
    void bark() {
        System.out.println("Making Sound");
    }
}


