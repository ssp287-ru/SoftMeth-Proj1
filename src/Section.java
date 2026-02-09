public class Section {

    private Course course;
    private Instructor instructor;
    private Classroom classroom;
    private Time time;
    //private Student[] roster;
    private int numStudents;

    //public void enroll(Student student) {}

    //public void drop(Student student) {}

    //public boolean contains(Student student) { }

    public boolean isFull() {
        return numStudents == 4;
    }

    public void print() { }

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
        int sectionHour = section.getTime().getHour();
        int thisSectionHour = this.getTime().getHour();
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


}
