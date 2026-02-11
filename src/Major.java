/**
 * Enum class for Majors, includes additional properties: School
 * @author Lucas Barrales & Shivang Patel
 */
public enum Major {
    CS ("School of Arts & Sciences"),
    ECE ("School of Engineering"),
    MATH ("School of Arts & Sciences"),
    ITI ("School of Communication and Information"),
    BAIT ("Rutgers Business School");

    private final String school; // The school that hosts the major

    /**
     * Constructor method used by JVM to construct Major objects defined above
     * @param school
     */
    Major(String school){
        this.school = school;
    }

    /**
     * Getter Method
     * @return
     */
    public String getSchool(){
        return this.school;
    }

    /**
     * Overrides toString() method
     * @return Major with the format majorName,schoolName
     */
    @Override
    public String toString(){
        return this.name() + "," + this.getSchool();
    }





}
