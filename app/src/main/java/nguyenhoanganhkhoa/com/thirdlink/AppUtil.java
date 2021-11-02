package nguyenhoanganhkhoa.com.thirdlink;

import java.util.regex.Pattern;

public class AppUtil {
    public static String eMessage = "";
    public static String eMessageForSignUp = "";
    public static int mSelectedIndex = 0;
    public static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    //   "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{8,15}" +
                    "$");
    public static String LOCK_CONDITION_SIGNUP = "LOCK";
    public static String LOCK_CONDITION_FORGOTPASS = "KEY";

    // Thông tin dữ liệu để validate APP.
    public static String USERNAME_APP = "nckh123";
    public static String PASSWORD_APP = "NCKH12345a";
    public static String VERIFICATION_CODE_APP = "1234";
    public static String PHONE_APP = "0908315280";

    //Dữ liệu đẩy
    public static String DATE_OF_BIRTH = "dateofbirth";
    public static String FACULTY = "faculty";
    public static String MAJOR = "major";
    public static String PHONE = "phone";
    public static String NAME = "name";
    public static String ID = "id";
    public static String GENDER = "gender";






}
