package project1;

/**
 * Class that defines overall schedule, including list of sections and number of sections
 * @author Shivang Patel
 */
public class Schedule {
    private Section[] sections;
    private int numSections;

    /**
     * Finds index of given section in sections array
     * @param section project1.Section to search for
     * @return Index of given section, returns -1 if not found
     */
    private int find(Section section) {
        for (int i = 0; i < sections.length; i++){
            if (sections[i].equals(section)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Increases the size of the sections array by 4, copying previous sections
     */
    private void grow() {
        Section[] temp = new Section[sections.length + 4];
        for (int i = 0; i < sections.length; i++){
            temp[i] = sections[i];
        }
        sections = temp;
   }

    /**
     * Adds a section to the sections array
     * @param section project1.Section to add to the sections array
     */
   public void add(Section section) {
        if (sections.length == numSections){
            grow();
        }
        sections[numSections] = section;
        numSections++;
   }

    /**
     * Removes specified section
     * @param section project1.Section to be deleted
     */
   public void remove(Section section) {
       for (int i = 0; i < sections.length; i++){
           if (sections[i].equals(section) && i != sections.length - 1){ // have to shift sections left
               for (int j = i; j < sections.length - 1; j++){
                   sections[j] = sections[j + 1]; // shift all elements left
               }
               sections[sections.length - 1] = null; // delete the last element after all are shifted left
           }
           else if (sections[i].equals(section) && i == sections.length - 1) { // looking at last element
               sections[i] = null;
           }
       }
   }

    /**
     * Enrolls student into section after verifying they are able to enroll in section.
     * @param section
     * @param student
     */
   public void enroll(Section section, Student student){
       for (int i = 0; i < sections.length; i++){
            if (sections[i].getTime().getHour() == section.getTime().getHour() // checks if checked section has the same time
            && sections[i].contains(student)){ // checks if section with matching time contains the student
                System.out.println("project1.Time conflict: " + student.toString() +" enrolled in another class at " + section.getTime().toString());
                return;
            }
        } // checks for time conflicts for given section
       int studentCreditHours = 0;
       for (int i = 0; i < sections.length; i++){
           if (sections[i].contains(student)){
               studentCreditHours += sections[i].getCourse().getCreditHours();
           }
       } // calculates the student's current credit hours
       if (studentCreditHours + section.getCourse().getCreditHours() > 18){
           System.out.println("Cannot enroll " + student.toString() + "; now has " + studentCreditHours +
                   " will exceeds credit limit of 18.");
           return;
       } // checks if enrolling would go over credit limit
       if (section.isFull()){
           System.out.println("Cannot enroll " + student.toString() + ", " + section.getCourse().name()
                   + " " + section.getTime().getHour() + ":" + section.getTime().getMinute() + " is full.");
           return;
       } // checks if section is full;
        sections[find(section)].enroll(student); // enrolls student in submitted section
       System.out.println(student.toString() + " enrolled to " + section.getCourse().name() + " " +
               section.getTime().getHour() + ":" + section.getTime().getMinute());
   }

    /**
     * Checks if a submitted section is contained within current list of sections
     * @param section
     * @return true if section is in current list, false otherwise
     */
    public boolean contains(Section section) {
       for (int i = 0; i < sections.length; i++){
           if (sections[i].equals(section)){
               return true;
           }
       }
       return false;
    }

    /**
     * Prints sections array ordered by campus first, then building
     */
    public void printByClassroom() {
        Section[] sortedSections = sections;
        for (int i = 0; i < sortedSections.length; i++){
            for (int j = i; j > 0; j--){
                switch(sortedSections[j].compareTo(sortedSections[j-1], "campus")){
                    case(1):
                        Section swap = sortedSections[j];
                        sortedSections[j-1] = sortedSections[j];
                        sortedSections[j] = swap;
                    case(0):
                        if (sortedSections[j].compareTo(sortedSections[j - 1], "building") == 1) {
                            Section swapA = sortedSections[j]; // alternate name used to avoid errors during compilation
                            sortedSections[j - 1] = sortedSections[j];
                            sortedSections[j] = swapA;
                        }
                        else{ j = 0;}
                    default:
                        j = 0;
                }


            }
        }
        System.out.println("* List of sections ordered by campus, building *");
        for (int i = 0; i < sortedSections.length; i++){
            sortedSections[i].print();
        }
        System.out.println("* end of list **");
    } // sort by campus/building

    /**
     * Prints sections array ordered by course number, then period
     */
    public void printByCourse() {
        Section[] sortedSections = sections;
        for (int i = 0; i < sortedSections.length; i++){
            for (int j = i; j > 0; j--){
                switch(sortedSections[j].compareTo(sortedSections[j-1], "courseNumber")){
                    case(1):
                        Section swap = sortedSections[j];
                        sortedSections[j] = sortedSections[j-1];
                        sortedSections[j-1] = swap;
                    case(0):
                        if(sortedSections[j].compareTo(sortedSections[j-1], "period") == 1){
                            Section swapA = sortedSections[j]; // alternate name used to avoid errors on compilation
                            sortedSections[j] = sortedSections[j-1];
                            sortedSections[j-1] = swapA;
                        }
                        else{
                            j = 0;
                        }
                    default:
                        j = 0;
                }
            }
        }
        System.out.println("* List of sections ordered by course number, section time *");
        for (int i = 0; i < sortedSections.length; i++){
            sortedSections[i].print();
        }
        System.out.println("* end of list *");
    } //sort by course number/period

}
