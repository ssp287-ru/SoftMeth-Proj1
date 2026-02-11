import java.util.Arrays;

public class Section {

    private Course course;
    private Instructor instructor;
    private Classroom classroom;
    private Time time;
    private Student[] roster;
    private int numStudents;

    /**
     * Constructor Method, roster instantialized as an empty size 4 array and numStudents set to 0
     * @param course
     * @param instructor
     * @param classroom
     * @param time
     */
    public Section(Course course, Instructor instructor, Classroom classroom, Time time) {
        this.course = course;
        this.instructor = instructor;
        this.classroom = classroom;
        this.time = time;
        this.roster = new Student[4];
        this.numStudents = 0;
    }

    /**
     * Adds a student to current section and upticks numStudents
     * @param student
     */
    public void enroll(Student student) {
        roster[numStudents] = student;
        numStudents++;
    }

    /**
     * Searches for student index in roster and removes, shifting elements left. Decrements numStudents
     * @param student
     */
    public void drop(Student student) {
        for (int i = 0; i < numStudents; i++){
            if (roster[i].equals(student) && i < roster.length - 1){
                for (int j = i; j < numStudents - 1; j++){
                    roster[j] = roster[j + 1];
                }
                roster[roster.length - 1] = null;
            } // must shift elements left
            else if (roster[i].equals(student) && i == roster.length - 1){
                roster[i] = null;
            }
        }
        numStudents--;
    }

    /**
     * Checks if section contains a specified student
     * @param student
     * @return true if student is found in section, false otherwise
     */
    public boolean contains(Student student) {
        for (int i = 0; i < roster.length; i++){
            if (roster[i].equals(student)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a section is full
     * @return true if there are 4 students in the section, false otherwise
     */
    public boolean isFull() {
        return numStudents == 4;
    }

    /**
     * Prints out the section with the format:
     * [courseName timeHour:timeMinute] [instructor] [Classroom, Building, Campus]
     * **Roster**
     * List of Students
     * or if there are no students
     * **No students enrolled**
     */
    public void print() {
        System.out.println(this.toString());
        if (numStudents == 0){
            System.out.println("**No students enrolled**");
        }
        else{
            System.out.println("**Roster**");
            for (int i = 0; i < numStudents; i++){
                System.out.println(roster[i].toString());
            }
        }
    }

    /**
     * Accessor Method
     * @return this.course
     */
    public Course getCourse(){
        return course;
    }

    /**
     * Accessor Method
     * @return this.classroom
     */
    public Classroom getClassroom(){
        return classroom;
    }

    /**
     * Accessor Method
     * @return this.time
     */
    public Time getTime(){
        return time;
    }

    /**
     * Accessor Method
     * @return this.instructor
     */
    public Instructor getInstructor() { return instructor; }

    /**
     * Compares two sections based on a submitted specification, uses period specification if not a valid specification
     * @param section Section to compare this.section to
     * @param specification Specifies to compare by campus, building, courseNumber, and period/anything else
     * @return -1 if this.section is earlier than section, 1 if section is earlier, 0 if same
     */
    public int compareTo(Section section, String specification){
        if (specification.equalsIgnoreCase("campus")){
            return this.getClassroom().getCampus().compareToIgnoreCase(
                    section.getClassroom().getCampus());
        } // compare this campus to section's campus
        else if (specification.equalsIgnoreCase("building")){
            return this.getClassroom().getBuilding().compareToIgnoreCase(
                    section.getClassroom().getBuilding());
        } // compare this building to section's building
        else if (specification.equalsIgnoreCase("courseNumber")){
            return this.getCourse().name().compareToIgnoreCase(
                    section.getCourse().name());
        } // compare this course number to section's course number
        int sectionHour = Integer.parseInt(section.getTime().getHour());
        int thisSectionHour = Integer.parseInt(this.getTime().getHour());
        if (thisSectionHour < sectionHour){
            return -1;
        }
        else if (thisSectionHour == sectionHour){
            return 0;
        }
        else{
            return 1;
        }
    }

    /**
     * Overrides .equals, checks if toStrings for courses, instructors, classrooms, times, and rosters are the same
     * @param obj   the reference object with which to compare.
     * @return True if all 5 checks are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Section){
            if (this.getCourse().toString().equals(((Section) obj).getCourse().toString()) // check if courses are the same
            && this.getInstructor().toString().equals(((Section) obj).getInstructor().toString()) // check if instructors are the same
            && this.getClassroom().toString().equals(((Section) obj).getInstructor().toString()) // check if classrooms are the same
            && this.getTime().toString().equals(((Section) obj).getTime().toString()) // check if times are the same
            && Arrays.equals(this.roster, ((Section) obj).roster)){ // check if rosters are the same
                return true;
            }
        }
        return false;
    }

    /**
     * Overrides toString() method, returns a string with the format:
     * [courseName timeHour:timeMinute] [instructorName] [classroomRoom, classroomBuilding, classroomCampus]
     * @return String with format [courseName timeHour:timeMinute] [instructorName] [classroomRoom, classroomBuilding, classroomCampus]
     */
    @Override
    public String toString(){
        return "[" + this.getCourse().name() + " " + this.getTime().getHour() + ":" + this.getTime().getMinute() + "] [" +
                this.getInstructor().name() + "] [" + this.getClassroom().name() + ", " + this.getClassroom().getBuilding() + ", "
                + this.getClassroom().getCampus() + "]";
    }

}
