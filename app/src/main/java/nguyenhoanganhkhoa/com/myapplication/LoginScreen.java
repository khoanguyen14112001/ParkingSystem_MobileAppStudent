package nguyenhoanganhkhoa.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class LoginScreen extends AppCompatActivity {

    EditText edtEmail,edtPassword;
    Button btnLogin,btnOK;
    TextView txtErrorPassword, txtErrorEmail,txtErrorLogTooMuch,txtForgotPassword;
    ImageView imgPasswordToggleClose;

    private void linkView() {
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnOK = findViewById(R.id.btnOK);
        txtErrorEmail = findViewById(R.id.txtErrorEmail);
        txtErrorPassword = findViewById(R.id.txtErrorPassword);
        imgPasswordToggleClose = findViewById(R.id.imgToggleClose);
        txtErrorLogTooMuch = findViewById(R.id.txtErrorLogTooMuch);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
    }

    private void setCustomColor(EditText edtCanSua, int edtColor, int iconColor, int textColor)
    {
        // Chỉnh màu cho thanh edit text khi gặp error, focus, ...

        edtCanSua.setBackground(ContextCompat.getDrawable(LoginScreen.this,edtColor));
        edtCanSua.setCompoundDrawableTintList(ContextCompat.getColorStateList(LoginScreen.this,iconColor));
        edtCanSua.setTextColor(ContextCompat.getColorStateList(LoginScreen.this,textColor));
    }

    private Boolean validateEmail(){
        String email = edtEmail.getText().toString();
        String emailPattern1 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String emailPattern2 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";

        if (email.isEmpty()){
            txtErrorEmail.setText(R.string.field_cannot_be_empty);
            txtErrorEmail.setTextSize(15);
            setCustomColor(edtEmail,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }

         if (!email.matches(emailPattern1) && !email.matches(emailPattern2)) {
             txtErrorEmail.setText(R.string.invalid_email_address);
             txtErrorEmail.setTextSize(15);
             setCustomColor(edtEmail,R.drawable.edt_custom_error,R.color.red,R.color.red);
             return false;
        }

        else {
            setCustomColor(edtEmail,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            txtErrorEmail.setText(null);
            txtErrorEmail.setTextSize(0);
            return true;
        }

    }

    private Boolean validatePassword(){
        String password = edtPassword.getText().toString();

        if (password.isEmpty()){
            txtErrorPassword.setText(R.string.field_cannot_be_empty);
            txtErrorPassword.setTextSize(15);
            setCustomColor(edtPassword,R.drawable.edt_custom_error,R.color.red,R.color.red);
            imgPasswordToggleClose.setImageTintList(getResources().getColorStateList(R.color.red));
            return false;
        }

        else {

            setCustomColor(edtPassword,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            txtErrorPassword.setText(null);
            txtErrorPassword.setTextSize(0);
            return true;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        linkView();
        addEvents();
    }


    private void createDialog() {
        Dialog dialog = new Dialog(LoginScreen.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_login);

        Window window = dialog.getWindow();
        if (window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtributes = window.getAttributes();
        windowAtributes.gravity = Gravity.CENTER;
        window.setAttributes(windowAtributes);


        btnOK = dialog.findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    int attemp = 1;
    int trytime = 0;

    private void showHidePassword(EditText edtPass, View view ) {
        if(edtPass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
            ((ImageView)(view)).setImageResource(R.drawable.ic_open_toggle);
            //Show Password
            edtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

        }
        else{
            ((ImageView)(view)).setImageResource(R.drawable.ic_close_toggle);
            //Hide Password
            edtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }

    }

    private void addEvents() {

        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setCustomColor(edtEmail,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
                txtErrorEmail.setText(null);
                txtErrorEmail.setTextSize(0);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setCustomColor(edtPassword,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
                imgPasswordToggleClose.setImageTintList(getResources().getColorStateList(R.color.black80));
                txtErrorPassword.setText(null);
                txtErrorPassword.setTextSize(0);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        imgPasswordToggleClose.setOnClickListener(new View.OnClickListener() {
            // Ẩn hiện password
            @Override
            public void onClick(View view) {
                showHidePassword(edtPassword,view);
            }
        });





        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Validate password và email
                if(!validateEmail() | !validatePassword()){

                    edtEmail.clearFocus();
                    edtPassword.clearFocus();

                    return;
                }


                else
                {
                    // Nếu lần thử > 4 --> bát user chờ 30s, tăng trytime (số lần bị khóa) lên 1 lần
                    String email = edtEmail.getText().toString();
                    String password = edtPassword.getText().toString();
                    if(attemp > 4)
                    {
                        setAttemp(30000);
                        trytime++;
                        edtEmail.clearFocus();
                        edtPassword.clearFocus();
                    }
                    // Nếu lần thử <= 4 --> thực hiện verify email và password

                    else if(attemp<4| attemp==4)
                    {
                        // Nếu đúng thì cho user đi tiếp, reset lại attemp và trytime
                        if(email.equals("123@gmail.com")&&password.equals("123"))
                        {
                            Toast t = Toast.makeText(LoginScreen.this,"login zo",Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER|Gravity.TOP, 0, 10);
                            t.show();
                            attemp=1;
                            trytime=0;
                        }
                        // Nếu sai thì bắt đầu làm tiếp như sau:
                        else
                        {
                            // Nếu số lần bị khóa < 3 lần --> tạo hộp thoại dialog thông báo sai password và email
                            if(trytime<3)
                            {
                                createDialog();
                                attemp++;
                                edtEmail.clearFocus();
                                edtPassword.clearFocus();
                            }
                            // Nếu lần bị khóa thứ 3 rồi, set time cho user phải chờ đến 1 tiếng, sau đó set trytime lại từ đầu

                            if(trytime==3)
                            {
                                setAttemp(3600000);
                                trytime = 0;
                                edtEmail.clearFocus();
                                edtPassword.clearFocus();
                            }

                        }

                    }

                }
            }
        });

        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this,ResetPasswordScreen.class);
                startActivity(intent);

            }
        });


    }



    private void setAttemp(int time) {

            // Nếu attemp(lần thử) > 4 --> block hết phần nhập của user và mở lại sau 30s
            btnLogin.setEnabled(false);
            edtEmail.setEnabled(false);
            edtPassword.setEnabled(false);
            imgPasswordToggleClose.setEnabled(false);
            edtPassword.setCompoundDrawableTintList(ContextCompat.getColorStateList(LoginScreen.this, R.color.xamBlcok));
            edtPassword.setBackground(ContextCompat.getDrawable(LoginScreen.this, R.drawable.edt_custom_block));

            edtEmail.setCompoundDrawableTintList(ContextCompat.getColorStateList(LoginScreen.this, R.color.xamBlockIcon));
            edtEmail.setBackground(ContextCompat.getDrawable(LoginScreen.this, R.drawable.edt_custom_block));

            btnLogin.setBackground(ContextCompat.getDrawable(LoginScreen.this, R.drawable.button_login_block));
            btnLogin.setTextColor(ContextCompat.getColor(LoginScreen.this, R.color.xamBlcok));

            // set time mở lại cho user
            new CountDownTimer(time, 10) { //Set Timer for 5 seconds
                public void onTick(long millisUntilFinished) {
                    long remainedSecs = millisUntilFinished / 1000;
                    if(time ==30000) {
                        txtErrorLogTooMuch.setTextSize(TypedValue.COMPLEX_UNIT_SP,13);
                        txtErrorLogTooMuch.setText(getString(R.string.too_many_failed_login_try_again_in) + (remainedSecs % 60) + getString(R.string.seconds));
                    }
                    else
                    {
                        txtErrorLogTooMuch.setTextSize(TypedValue.COMPLEX_UNIT_SP,13);
                        txtErrorLogTooMuch.setText(R.string.try_again_after_an_hour);
                    }
                }


                @Override
                public void onFinish() {
                    edtEmail.setEnabled(true);
                    edtPassword.setEnabled(true);
                    btnLogin.setEnabled(true);
                    imgPasswordToggleClose.setEnabled(true);

                    edtPassword.setCompoundDrawableTintList(ContextCompat.getColorStateList(LoginScreen.this, R.color.blackUI));
                    edtPassword.setBackground(ContextCompat.getDrawable(LoginScreen.this, R.drawable.custom_edt));

                    btnLogin.setBackground(ContextCompat.getDrawable(LoginScreen.this, R.drawable.button_login));
                    btnLogin.setTextColor(ContextCompat.getColor(LoginScreen.this, R.color.blackUI));

                    edtEmail.setCompoundDrawableTintList(ContextCompat.getColorStateList(LoginScreen.this, R.color.blackUI));
                    edtEmail.setBackground(ContextCompat.getDrawable(LoginScreen.this, R.drawable.custom_edt));

                    txtErrorLogTooMuch.setText("");
                    txtErrorLogTooMuch.setTextSize(0);
                }
            }.start();
            // Chỉnh lại attemp ở mức 1
            attemp = 1;


    }


}