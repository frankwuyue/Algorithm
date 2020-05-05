package Sort;

public class Student implements Comparable<Student> {
    String name;
    int score;

    public Student() {

    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return (this.score < o.score) ? -1 : ((this.score == o.score) ? 0 : 1);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
