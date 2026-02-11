/**
 * The StudentList class manages a collection of Student objects
 * @author Lucas Barrales
 */
public class StudentList {

    //Initial capacity of the array
    private static final int INITIAL_CAPACITY = 4;

    //array that stores students
    private Student[] students;

    //Number of students currently in the list
    private int size;

    //Constructor; initializes the array and size
    public StudentList(){
        students = new Student[INITIAL_CAPACITY];
        size = 0;
    }

    //Checks if the list is empty
    public boolean isEmpty(){
        return size == 0;
    }

    //Finds the index of the student in the list
    private int find(Student student){
        for(int i = 0; i < size; i++){
            if(students[i].equals(student)) {
                return i;
            }
        }
        return -1;
    }

    //increases the size of the array when full
    private void grow(){
        Student[] newArray = new Student[students.length * 2];

        //Copy old array into new array
        for (int i = 0; i < size; i++){
            newArray[i] = students[i];
        }
        students = newArray;
    }

    //adds a student to the list
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

    //prints all students in list
    public void print() {
        if (isEmpty()){
            System.out.println("Student list is empty.");
            return;
        }

        for (int i = 0; i < size; i++){
            System.out.println(students[i]);
        }

    }

}
