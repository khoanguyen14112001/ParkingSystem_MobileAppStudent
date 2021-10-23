package nguyenhoanganhkhoa.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.regex.Pattern;

public class SignUpScreen_UserInfo extends AppCompatActivity {
    EditText edtFullname, edtPhoneSignUp, edtUsernameSignUp,edtPassSignUp,edtConfirmPassSignup;
    TextView txtErrorFullname, txtErrorPhoneSignUp, txtErrorUsernameSignUp, txtErrorPassSignup, txtErrorConfirmPassSignUp;
    Button btnSignUp;
    ImageView imvToggleClose3, imvToggleClose4,imvSignupUserInfoBack;
    private void linkView() {
        edtFullname = findViewById(R.id.edtFullname);
        edtPhoneSignUp = findViewById(R.id.edtPhoneSignup);
        edtUsernameSignUp = findViewById(R.id.edtUsernameSignup);
        edtPassSignUp = findViewById(R.id.edtPasswordSignup);
        edtConfirmPassSignup = findViewById(R.id.edtConfirmPasswordSignup);

        txtErrorFullname = findViewById(R.id.txtErrorFullname);
        txtErrorPhoneSignUp = findViewById(R.id.txtErrorPhoneSignUp);
        txtErrorUsernameSignUp = findViewById(R.id.txtErrorUsernameSignup);
        txtErrorPassSignup = findViewById(R.id.txtErrorPasswordSignup);
        txtErrorConfirmPassSignUp = findViewById(R.id.txtErrorConfirmPassSignup);

        btnSignUp = findViewById(R.id.btnSignup);

        imvToggleClose3 = findViewById(R.id.imgToggleClose3);
        imvToggleClose4 = findViewById(R.id.imgToggleClose4);
        imvSignupUserInfoBack = findViewById(R.id.imvSignupUserInfoBack);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen_user_info);
        linkView();
        addEvents();

    }
    public static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    //   "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{8,15}" +
                    "$");


    private Boolean validateFullname(){
        String s = edtFullname.getText().toString();
        if(s.isEmpty())
        {
            txtErrorFullname.setText(R.string.field_cannot_be_empty);
            txtErrorFullname.setTextSize(15);
            edtFullname.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtFullname,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }

        else
        {
            setCustomColor(edtFullname,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            edtFullname.setHintTextColor(getColor(R.color.xamChu));
            txtErrorFullname.setText(null);
            txtErrorFullname.setTextSize(0);
            return true;
        }
    }
    private Boolean validatePhone(){
        String s = edtPhoneSignUp.getText().toString();
        if(s.isEmpty())
        {
            txtErrorPhoneSignUp.setText(R.string.field_cannot_be_empty);
            txtErrorPhoneSignUp.setTextSize(15);
            edtPhoneSignUp.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtPhoneSignUp,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }
        else if(s.equals("0123123123"))
        {
            txtErrorPhoneSignUp.setText(R.string.your_phone_is_already_registered);
            txtErrorPhoneSignUp.setTextSize(15);
            edtPhoneSignUp.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtPhoneSignUp,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }
        else{
            setCustomColor(edtPhoneSignUp,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            edtPhoneSignUp.setHintTextColor(getColor(R.color.xamChu));
            txtErrorPhoneSignUp.setText(null);
            txtErrorPhoneSignUp.setTextSize(0);
            return true;
        }
    }
    private Boolean validatePhoneTextChange(){
        String s = edtPhoneSignUp.getText().toString();
        if(s.isEmpty())
        {
            txtErrorPhoneSignUp.setText(R.string.field_cannot_be_empty);
            txtErrorPhoneSignUp.setTextSize(15);
            edtPhoneSignUp.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtPhoneSignUp,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }
        else{
            setCustomColor(edtPhoneSignUp,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            edtPhoneSignUp.setHintTextColor(getColor(R.color.xamChu));
            txtErrorPhoneSignUp.setText(null);
            txtErrorPhoneSignUp.setTextSize(0);
            return true;
        }
    }
    private Boolean validateUsername(){
        String s = edtUsernameSignUp.getText().toString();
        if(s.isEmpty())
        {
            txtErrorUsernameSignUp.setText(R.string.field_cannot_be_empty);
            txtErrorUsernameSignUp.setTextSize(15);
            edtUsernameSignUp.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtUsernameSignUp,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }
        else if(s.equals("123nckh"))
        {
            txtErrorUsernameSignUp.setText(R.string.your_username_is_already_exists);
            txtErrorUsernameSignUp.setTextSize(15);
            edtUsernameSignUp.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtUsernameSignUp,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }
        else{
            setCustomColor(edtUsernameSignUp,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            edtUsernameSignUp.setHintTextColor(getColor(R.color.xamChu));
            txtErrorUsernameSignUp.setText(null);
            txtErrorUsernameSignUp.setTextSize(0);
            return true;
        }

    }
    private Boolean validateUsernameTextChange(){
        String s = edtUsernameSignUp.getText().toString();
        if(s.isEmpty())
        {
            txtErrorUsernameSignUp.setText(R.string.field_cannot_be_empty);
            txtErrorUsernameSignUp.setTextSize(15);
            edtUsernameSignUp.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtUsernameSignUp,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }

        else{
            setCustomColor(edtUsernameSignUp,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            edtUsernameSignUp.setHintTextColor(getColor(R.color.xamChu));
            txtErrorUsernameSignUp.setText(null);
            txtErrorUsernameSignUp.setTextSize(0);
            return true;
        }

    }
    private Boolean validateNewPassword(){
        String password = edtPassSignUp.getText().toString();

        if (password.isEmpty()){
            txtErrorPassSignup.setText(R.string.field_cannot_be_empty);
            txtErrorPassSignup.setTextSize(15);
            edtPassSignUp.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtPassSignUp,R.drawable.edt_custom_error,R.color.red,R.color.red);
            imvToggleClose3.setImageTintList(getColorStateList(R.color.red));
            return false;
        }
        if(!PASSWORD_PATTERN.matcher(password).matches())
        {
            if(password.length()<=15)
            {
                txtErrorPassSignup.setText(R.string.your_password_is_too_weak);
            }

            else if(password.length()>15)
            {
                txtErrorPassSignup.setText(R.string.your_password_is_too_long);
            }
            txtErrorPassSignup.setTextSize(15);
            edtPassSignUp.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtPassSignUp,R.drawable.edt_custom_error,R.color.red,R.color.red);
            imvToggleClose3.setImageTintList(getColorStateList(R.color.red));
            return false;
        }
        else {
            setCustomColor(edtPassSignUp,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            imvToggleClose3.setImageTintList(getResources().getColorStateList(R.color.black80));
            edtPassSignUp.setHintTextColor(getColor(R.color.xamChu));
            txtErrorPassSignup.setText(null);
            txtErrorPassSignup.setTextSize(0);
            return true;
        }

    }
    private Boolean validateConfirmPassword(){
        String password = edtConfirmPassSignup.getText().toString();

        if (password.isEmpty()){
            txtErrorConfirmPassSignUp.setText(R.string.field_cannot_be_empty);
            txtErrorConfirmPassSignUp.setTextSize(15);
            edtConfirmPassSignup.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtConfirmPassSignup,R.drawable.edt_custom_error,R.color.red,R.color.red);
            imvToggleClose4.setImageTintList(getColorStateList(R.color.red));
            return false;
        }

        else if(!password.equals(edtPassSignUp.getText().toString()))
        {
            txtErrorConfirmPassSignUp.setText(R.string.your_password_must_be_match);
            txtErrorConfirmPassSignUp.setTextSize(15);
            edtConfirmPassSignup.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtConfirmPassSignup,R.drawable.edt_custom_error,R.color.red,R.color.red);
            imvToggleClose4.setImageTintList(getColorStateList(R.color.red));
            return false;
        }


        else {
            setCustomColor(edtConfirmPassSignup,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            imvToggleClose4.setImageTintList(getResources().getColorStateList(R.color.black80));
            edtConfirmPassSignup.setHintTextColor(getColor(R.color.xamChu));
            txtErrorConfirmPassSignUp.setText(null);
            txtErrorConfirmPassSignUp.setTextSize(0);
            return true;
        }

    }
    private Boolean validateConfirmPasswordTextChange(){
        String password = edtConfirmPassSignup.getText().toString();

        if (password.isEmpty()){
            txtErrorConfirmPassSignUp.setText(R.string.field_cannot_be_empty);
            txtErrorConfirmPassSignUp.setTextSize(15);
            edtConfirmPassSignup.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtConfirmPassSignup,R.drawable.edt_custom_error,R.color.red,R.color.red);
            imvToggleClose4.setImageTintList(getColorStateList(R.color.red));
            return false;
        }

        else {
            setCustomColor(edtConfirmPassSignup,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            imvToggleClose4.setImageTintList(getResources().getColorStateList(R.color.black80));
            edtConfirmPassSignup.setHintTextColor(getColor(R.color.xamChu));
            txtErrorConfirmPassSignUp.setText(null);
            txtErrorConfirmPassSignUp.setTextSize(0);
            return true;
        }

    }




    private void addEvents() {

        imvSignupUserInfoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtFullname.getText().toString();
                String phone = edtPhoneSignUp.getText().toString();
                String username = edtUsernameSignUp.getText().toString();
                String password = edtPassSignUp.getText().toString();
                String confirm = edtConfirmPassSignup.getText().toString();
                if(!name.isEmpty()|!phone.isEmpty()|!username.isEmpty()|!password.isEmpty()|!confirm.isEmpty())
                {
                    CustomDialogTwoButton customDialogTwoButton = new CustomDialogTwoButton
                            (SignUpScreen_UserInfo.this,R.layout.custom_dialog_unsaved_changes);
                    customDialogTwoButton.btnOK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                        }
                    });

                    customDialogTwoButton.btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            customDialogTwoButton.dismiss();
                        }
                    });
                    customDialogTwoButton.show();
                }
                else
                    finish();

            }
        });

        imvToggleClose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHidePassword(edtPassSignUp,view);
            }
        });

        imvToggleClose4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHidePassword(edtConfirmPassSignup,view);
            }
        });

        edtFullname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validateFullname();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtPhoneSignUp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validatePhoneTextChange();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtUsernameSignUp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validateUsernameTextChange();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edtPassSignUp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validateNewPassword();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtConfirmPassSignup.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validateConfirmPasswordTextChange();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateFullname()|!validateUsername()|!validatePhone()|!validateNewPassword()|!validateConfirmPassword())
                {
                    clearAllFocus();
                }
                else{
                    clearAllFocus();
                    Intent intent = new Intent(SignUpScreen_UserInfo.this,VerificationSignupScreen.class);
                    startActivity(intent);
                    // Move to next screen
                }
            }
        });
    }

    private void clearAllFocus() {
        edtUsernameSignUp.clearFocus();;
        edtFullname.clearFocus();;
        edtPhoneSignUp.clearFocus();;
        edtPassSignUp.clearFocus();;
        edtConfirmPassSignup.clearFocus();;
    }

    private void setCustomColor(EditText edtCanSua, int edtColor, int iconColor, int textColor)
    {
        // Chỉnh màu cho thanh edit text khi gặp error, focus, ...

        edtCanSua.setBackground(getDrawable(edtColor));
        edtCanSua.setCompoundDrawableTintList(getColorStateList(iconColor));
        edtCanSua.setTextColor(getColorStateList(textColor));
    }

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



}