package Array;

public class Student {
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Array.Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> studentArray = new Array<Student>();
        studentArray.addLast(new Student("frank", 10));
        studentArray.addLast(new Student("mentai", 20));
        studentArray.addLast(new Student("tarako", 40));
        System.out.println(studentArray);
    }
}
