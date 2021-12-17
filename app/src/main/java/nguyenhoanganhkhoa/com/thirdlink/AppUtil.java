package nguyenhoanganhkhoa.com.thirdlink;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Locale;
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

    public static String DATE_OF_BIRTH1 = "dateofbirth1";
    public static String FACULTY1 = "faculty1";
    public static String MAJOR1 = "major1";
    public static String PHONE1 = "phone1";
    public static String NAME1 = "name1";
    public static String ID1 = "id1";
    public static String GENDER1 = "gender1";

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM dd, yyyy", Locale.US);

    //Khai báo database
    public static DatabaseReference databaseReference =  FirebaseDatabase.getInstance().getReference("account");

    public static final String DATA_OBJECT = "Student";

    public static String USERNAME_S = "";
    public static String PASSWORD_S = "";
    public static String PHONE_S = "";
    public static String FULLNAME_S = "";
    public static String EMAIL_S = "";


    public final static String top_up = "Top Up";
    public final static String qr_code = "QR Code";
    public final static String news = "News";
    public final static String about_us = "About Us";
    public final static String history = "History";
    public final static String help_center = "Help Center";
    public final static String security_center = "Security Center";

    public static final String SELECTED_ITEM = "my_clicked_item";
    public static final String MY_BUNDLE = "my_bundle";

    public static final String HELP_SCREEN = "";










}
