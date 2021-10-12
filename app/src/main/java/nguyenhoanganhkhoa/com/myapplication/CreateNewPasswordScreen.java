package nguyenhoanganhkhoa.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateNewPasswordScreen extends AppCompatActivity {

    EditText edtNewPassword, edtConfirmPassword;
    ImageView imgPasswordToggle1, imgPasswordToggle2;
    TextView txtErrorChangePass, txtErrorConfirmPass;
    Button btnUpdate,btnOK;

    private void linkView() {
        edtNewPassword = findViewById(R.id.edtNewPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        imgPasswordToggle1 = findViewById(R.id.imgToggleClose1);
        imgPasswordToggle2 = findViewById(R.id.imgToggleClose2);
        txtErrorChangePass = findViewById(R.id.txtErrorChangePass);
        txtErrorConfirmPass = findViewById(R.id.txtErrorConfirmPass);
        btnUpdate = findViewById(R.id.btnUpdate);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_password_screen);


        linkView();
        addEvents();
    }
    private void clearFocus(){
        edtConfirmPassword.clearFocus();
        edtNewPassword.clearFocus();
    }

    private void addEvents() {
        edtNewPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setCustomColor(edtNewPassword,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
                imgPasswordToggle1.setImageTintList(getResources().getColorStateList(R.color.black80));
                txtErrorChangePass.setText(null);
                txtErrorChangePass.setTextSize(0);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edtConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setCustomColor(edtConfirmPassword,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
                imgPasswordToggle2.setImageTintList(getResources().getColorStateList(R.color.black80));
                txtErrorConfirmPass.setText(null);
                txtErrorConfirmPass.setTextSize(0);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        imgPasswordToggle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHidePassword(edtNewPassword,view);
            }
        });

        imgPasswordToggle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHidePassword(edtConfirmPassword,view);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateNewPassword() | !validateConfirmPassword()){
                    clearFocus();
                    return;
                }

                else{
                    if(edtConfirmPassword.getText().toString().equals(edtNewPassword.getText().toString())){
                       createDialog(CreateNewPasswordScreen.this,btnOK,R.layout.custom_dialog_update_password);
                        clearFocus();

                    }
                    else
                    {
                        txtErrorConfirmPass.setText("Your password must be match");
                        txtErrorConfirmPass.setTextSize(15);
                        setCustomColor(edtConfirmPassword,R.drawable.edt_custom_error,R.color.red,R.color.red);
                        clearFocus();
                    }
                }
            }
        });
    }


    private Boolean validateNewPassword(){
        String password = edtNewPassword.getText().toString();

        if (password.isEmpty()){
            txtErrorChangePass.setText("Field cannot be empty");
            txtErrorChangePass.setTextSize(15);
            setCustomColor(edtNewPassword,R.drawable.edt_custom_error,R.color.red,R.color.red);
            imgPasswordToggle1.setImageTintList(getResources().getColorStateList(R.color.red));
            return false;
        }

        else {

            setCustomColor(edtNewPassword,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            txtErrorChangePass.setText(null);
            txtErrorChangePass.setTextSize(0);
            return true;
        }

    }

    private void createDialog(Context context, Button btnOK, int dialogScreen ) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(dialogScreen);

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

    private Boolean validateConfirmPassword(){
        String password = edtConfirmPassword.getText().toString();

        if (password.isEmpty()){
            txtErrorConfirmPass.setText("Field cannot be empty");
            txtErrorConfirmPass.setTextSize(15);
            setCustomColor(edtConfirmPassword,R.drawable.edt_custom_error,R.color.red,R.color.red);
            imgPasswordToggle2.setImageTintList(getResources().getColorStateList(R.color.red));
            return false;
        }

        else {

            setCustomColor(edtConfirmPassword,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            txtErrorConfirmPass.setText(null);
            txtErrorConfirmPass.setTextSize(0);
            return true;
        }

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

    private void setCustomColor(EditText edtCanSua, int edtColor, int iconColor, int textColor)
    {
        // Chỉnh màu cho thanh edit text khi gặp error, focus, ...

        edtCanSua.setBackground(ContextCompat.getDrawable(CreateNewPasswordScreen.this,edtColor));
        edtCanSua.setCompoundDrawableTintList(ContextCompat.getColorStateList(CreateNewPasswordScreen.this,iconColor));
        edtCanSua.setTextColor(ContextCompat.getColorStateList(CreateNewPasswordScreen.this,textColor));
    }


}