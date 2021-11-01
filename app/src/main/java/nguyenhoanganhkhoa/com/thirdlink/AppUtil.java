package nguyenhoanganhkhoa.com.thirdlink;

import android.content.Context;
import android.text.Html;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

import nguyenhoanganhkhoa.com.myapplication.R;

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

    // Cac password
    public static String USERNAME_APP = "nckh123";
    public static String PASSWORD_APP = "NCKH12345a";
    public static String VERIFICATION_CODE_APP = "1234";
    public static String PHONE_APP = "0908315280";

}
