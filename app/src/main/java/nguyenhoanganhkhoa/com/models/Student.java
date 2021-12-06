package nguyenhoanganhkhoa.com.models;

public class Student {
    private String usernameStudent, passwordStudent,emailStudent
            ,fullnameStudent, phoneStudent, IDStudent, majorStudent,dateOfBirthStudent
            ,facultyStudent, genderStudent;
    private int avatarStudent;

    public Student(String usernameStudent, String passwordStudent,
                   String emailStudent, String fullnameStudent,
                   String phoneStudent, String IDStudent, String majorStudent,
                   String dateOfBirthStudent, String facultyStudent,
                   String genderStudent, int avatarStudent) {
        this.usernameStudent = usernameStudent;
        this.passwordStudent = passwordStudent;
        this.emailStudent = emailStudent;
        this.fullnameStudent = fullnameStudent;
        this.phoneStudent = phoneStudent;
        this.IDStudent = IDStudent;
        this.majorStudent = majorStudent;
        this.dateOfBirthStudent = dateOfBirthStudent;
        this.facultyStudent = facultyStudent;
        this.genderStudent = genderStudent;
        this.avatarStudent = avatarStudent;
    }

    public String getUsernameStudent() {
        return usernameStudent;
    }

    public void setUsernameStudent(String usernameStudent) {
        this.usernameStudent = usernameStudent;
    }

    public String getPasswordStudent() {
        return passwordStudent;
    }

    public void setPasswordStudent(String passwordStudent) {
        this.passwordStudent = passwordStudent;
    }

    public String getEmailStudent() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    public String getFullnameStudent() {
        return fullnameStudent;
    }

    public void setFullnameStudent(String fullnameStudent) {
        this.fullnameStudent = fullnameStudent;
    }

    public String getPhoneStudent() {
        return phoneStudent;
    }

    public void setPhoneStudent(String phoneStudent) {
        this.phoneStudent = phoneStudent;
    }

    public String getIDStudent() {
        return IDStudent;
    }

    public void setIDStudent(String IDStudent) {
        this.IDStudent = IDStudent;
    }

    public String getMajorStudent() {
        return majorStudent;
    }

    public void setMajorStudent(String majorStudent) {
        this.majorStudent = majorStudent;
    }

    public String getDateOfBirthStudent() {
        return dateOfBirthStudent;
    }

    public void setDateOfBirthStudent(String dateOfBirthStudent) {
        this.dateOfBirthStudent = dateOfBirthStudent;
    }

    public String getFacultyStudent() {
        return facultyStudent;
    }

    public void setFacultyStudent(String facultyStudent) {
        this.facultyStudent = facultyStudent;
    }

    public String getGenderStudent() {
        return genderStudent;
    }

    public void setGenderStudent(String genderStudent) {
        this.genderStudent = genderStudent;
    }

    public int getAvatarStudent() {
        return avatarStudent;
    }

    public void setAvatarStudent(int avatarStudent) {
        this.avatarStudent = avatarStudent;
    }
}
