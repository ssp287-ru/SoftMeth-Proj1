public class Schedule {
    private Section[] sections;
    private int numSections;

    /**
     * Finds index of given section in sections array
     * @param section Section to search for
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
     * @param section Section to add to the sections array
     */
   public void add(Section section) {
        if (sections.length == numSections){
            grow();
        }
        sections[numSections] = section;
        numSections++;
   }

    /**
     * Removes specified section, if section is in middle of array copy elements left and delete last element.
     * @param section Section to be deleted
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
     * Checks if section is full, student has too many credit hours, or student has time conflict, if none then enrolls student to section
     * @param section
     * @param student
     */
   //public void enroll(Section section, Student student){

   //}

    public boolean contains(Section section) {
       for (int i = 0; i < sections.length; i++){
           if (sections[i].equals(section)){
               return true;
           }
       }
       return false;
    }

    public void printByClassroom() {
        //for (int i  )
    } // sort by campus/building
//    public void printByCourse() {} //sort by course number/period

}
