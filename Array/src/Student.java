public class Student {

    private int age;
    private int year;
    private String name;

    public Student(int age, int year, String name){
        this.age = age;
        this.year = year;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Student another = (Student)obj;

        return this.age == another.age && this.year == another.year && this.name.toLowerCase().equals(another.name.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("Student(name : %s, age = %d, year = %d)", name, age, year);

    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student(10, 2, "bob"));
        arr.addLast(new Student(12, 3, "Alice"));
        System.out.println(arr);
    }
}
