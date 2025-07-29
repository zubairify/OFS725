public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        // Calling another constructor on the same object - Chaining
        this("anonymous", -1);
    }

    public void print() {
        System.out.println(this.name + " " + this.age);
    }

    @Override
    public String toString() {
        return "Name: " +  this.name + ", Age: " + this.age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person) {
            Person p = (Person) obj;
            if(this.name.equals(p.name) && this.age == p.age)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Polo", 21);
        p1.print();

        Person p2 = new Person("Polo", 21);
        p2.print();

        System.out.println(p1.hashCode());
        System.out.println(p1); // implicitly calling toString()
        System.out.println(p1.equals(p2));

        String s1 = "Hello";
        String s2 = new String("Hello");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
