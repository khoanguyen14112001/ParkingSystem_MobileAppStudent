package nguyenhoanganhkhoa.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.textclassifier.TextLanguage;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

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

    private Boolean validateEmail(){
        String email = edtEmail.getText().toString();
        String emailPattern1 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String emailPattern2 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";

        if (email.isEmpty()){
            txtErrorEmail.setText("Field cannot be empty");
            txtErrorEmail.setTextSize(15);
            edtEmail.setBackground(ContextCompat.getDrawable(LoginScreen.this,R.drawable.edt_custom_error));
            edtEmail.setCompoundDrawableTintList(ContextCompat.getColorStateList(LoginScreen.this,R.color.red));
            edtEmail.setTextColor(ContextCompat.getColorStateList(LoginScreen.this,R.color.red));
            return false;
        }

         if (!email.matches(emailPattern1) && !email.matches(emailPattern2)) {
             txtErrorEmail.setText("Invalid email address");
             txtErrorEmail.setTextSize(15);
             edtEmail.setBackground(ContextCompat.getDrawable(LoginScreen.this,R.drawable.edt_custom_error));
             edtEmail.setCompoundDrawableTintList(ContextCompat.getColorStateList(LoginScreen.this,R.color.red));
             edtEmail.setTextColor(ContextCompat.getColorStateList(LoginScreen.this,R.color.red));

             return false;
        }

        else {
            edtEmail.setBackground(ContextCompat.getDrawable(LoginScreen.this,R.drawable.custom_edt));
            edtEmail.setCompoundDrawableTintList(ContextCompat.getColorStateList(LoginScreen.this,R.color.blackUI));
            edtEmail.setTextColor(ContextCompat.getColorStateList(LoginScreen.this,R.color.xamChu));
            txtErrorEmail.setText(null);
            txtErrorEmail.setTextSize(0);
            return true;
        }

    }

    private Boolean validatePassword(){
        String password = edtPassword.getText().toString();

        if (password.isEmpty()){
            txtErrorPassword.setText("Field cannot be empty");
            txtErrorPassword.setTextSize(15);
            edtPassword.setBackground(ContextCompat.getDrawable(LoginScreen.this,R.drawable.edt_custom_error));
            edtPassword.setCompoundDrawableTintList(ContextCompat.getColorStateList(LoginScreen.this,R.color.red));
            edtPassword.setTextColor(ContextCompat.getColorStateList(LoginScreen.this,R.color.red));


            return false;
        }

        else {
            edtPassword.setBackground(ContextCompat.getDrawable(LoginScreen.this,R.drawable.custom_edt));
            edtPassword.setCompoundDrawableTintList(ContextCompat.getColorStateList(LoginScreen.this,R.color.blackUI));
            edtPassword.setTextColor(ContextCompat.getColorStateList(LoginScreen.this,R.color.xamChu));
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

    private void addEvents() {

        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edtEmail.setBackground(ContextCompat.getDrawable(LoginScreen.this,R.drawable.custom_edt));
                edtEmail.setCompoundDrawableTintList(ContextCompat.getColorStateList(LoginScreen.this,R.color.blackUI));
                edtEmail.setTextColor(ContextCompat.getColorStateList(LoginScreen.this,R.color.xamChu));
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
                edtPassword.setBackground(ContextCompat.getDrawable(LoginScreen.this,R.drawable.custom_edt));
                edtPassword.setCompoundDrawableTintList(ContextCompat.getColorStateList(LoginScreen.this,R.color.blackUI));
                edtPassword.setTextColor(ContextCompat.getColorStateList(LoginScreen.this,R.color.xamChu));
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
            @Override
            public void onClick(View view) {
                if(edtPassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    ((ImageView)(view)).setImageResource(R.drawable.ic_open_toggle);
                    //Show Password
                    edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
                else{
                    ((ImageView)(view)).setImageResource(R.drawable.ic_close_toggle);
                    //Hide Password
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(!validateEmail() | !validatePassword()){

                    edtEmail.clearFocus();
                    edtPassword.clearFocus();

                    return;
                }


                else
                {
                    String email = edtEmail.getText().toString();
                    String password = edtPassword.getText().toString();
                    if(attemp > 4)
                    {
                        setAttemp("Too many failed login. Try again in 30 seconds",30000);
                        trytime++;
                        edtEmail.clearFocus();
                        edtPassword.clearFocus();
                    }

                    else if(attemp<4| attemp==4)
                    {
                        if(email.equals("123@gmail.com")&&password.equals("123"))
                        {
                            Toast t = Toast.makeText(LoginScreen.this,"login zo",Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER|Gravity.TOP, 0, 10);
                            t.show();
                            attemp=0;
                        }
                        else
                        {
                            if(trytime<3)
                            {
                                createDialog();
                                attemp++;
                                edtEmail.clearFocus();
                                edtPassword.clearFocus();
                            }

                            if(trytime==3)
                            {
                                setAttemp("Too many failed login. Try again in an hour",3600000);
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

        txtForgotPassword.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                return false;
            }
        });


    }

    private void setAttemp(String noiDungBlock, int time) {

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
            txtErrorLogTooMuch.setText(noiDungBlock);
            txtErrorLogTooMuch.setTextSize(15);

            new CountDownTimer(time, 10) { //Set Timer for 5 seconds
                public void onTick(long millisUntilFinished) {
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

            attemp = 0;



    }

}