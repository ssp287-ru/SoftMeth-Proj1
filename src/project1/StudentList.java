package project1;

/**
 * The project1.StudentList class manages a collection of project1.Student objects
 * @author Lucas Barrales
 */

public class StudentList {

    //Initial capacity of the array
    private static final int INITIAL_CAPACITY = 4;

    //array that stores students
    private Student[] students;

    //Number of students currently in the list
    private int size;

    /**
     * Constructor Method
     * Initializes students as array size 4 & size as int 0
     */
    public StudentList(){
        students = new Student[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Checks if students array is empty
     * @return True if size == 0, False otherwise
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Checks for submitted student in this.students
     * @param student
     * @return Index in students if student found, -1 otherwise
     */
    private int find(Student student){
        for(int i = 0; i < size; i++){
            if(students[i].equals(student)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Increases size of students array by 4 and copies all students over
     */
    private void grow(){
        Student[] newArray = new Student[students.length + 4];

        //Copy old array into new array
        for (int i = 0; i < size; i++){
            newArray[i] = students[i];
        }
        students = newArray;
    }

    public boolean add(Student student){
        if (find(student) != -1) {
            return false;
        }

        //grow if full
        if (size == students.length){
            grow();
        }

        students[size] = student;
        size++;
        return true;
    }

    // removes a student from the list
    public boolean remove(Student student) {
        int index = find(student);

        if (index == -1){
            return false;
        }

        //shift elements lef to fill gap
        for (int i = index; i < size -1; i++) {
            students[i] = students[i + 1];
        }
        students[size-1] = null;
        size--;
        return true;
    }

    /**
     * Prints out student list
     * Prints "student list is empty" is list is empty, else prints
     */
    public void print() {
        if (isEmpty()){
            System.out.println("project1.Student list is empty!");
            return;
        }

        for (int i = 0; i < size; i++){
            System.out.println(students[i].toString());
        }

    }

}
