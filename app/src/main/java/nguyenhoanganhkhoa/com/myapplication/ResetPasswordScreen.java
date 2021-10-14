package nguyenhoanganhkhoa.com.myapplication;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ResetPasswordScreen extends AppCompatActivity {
    EditText edtPhone;
    TextView txtErrorPhone;
    Button btnSendPassword;
    ImageView imvRestBack;

    private void linkView() {
        edtPhone = findViewById(R.id.edtPhone);
        txtErrorPhone = findViewById(R.id.txtErrorPhone);
        btnSendPassword = findViewById(R.id.btnSendPassword);
        imvRestBack = findViewById(R.id.imvResetBack);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_screen);
        linkView();
        addCondition();
        addEvents();

    }

    private void addCondition() {
        String s = AppUtil.eMessage;
        if(s.equals("key"))
            addTimerLock();
        else if (s.equals(""))
            return;


    }
    private void addTimerLock() {


        new CountDownTimer(6000, 10) { //Set Timer for 5 seconds
            public void onTick(long millisUntilFinished) {
                btnSendPassword.setBackground(getDrawable(R.drawable.button_login_block));
                AppUtil.eMessage = null;
                btnSendPassword.setTextColor(getColor(R.color.xamBlcok));
                edtPhone.setBackground(getDrawable(R.drawable.edt_custom_block));
                edtPhone.setHintTextColor(getColor(R.color.xamChu));
                edtPhone.setCompoundDrawableTintList(getColorStateList(R.color.xamBlockIcon));
                btnSendPassword.setEnabled(false);
                edtPhone.setEnabled(false);

            }


            @Override
            public void onFinish() {
                setCustomColor(edtPhone,R.drawable.custom_edt,R.color.blackUI,R.color.blackUI);
                edtPhone.setHintTextColor(getColor(R.color.xamChu));
                btnSendPassword.setEnabled(true);
                btnSendPassword.setBackground(getDrawable(R.drawable.custom_button));
                btnSendPassword.setTextColor(getColor( R.color.blackUI));
                edtPhone.setEnabled(true);
                AppUtil.eMessage="";
            }
        }.start();
    }




    private void setCustomColor(EditText edtCanSua, int edtColor, int iconColor, int textColor)
    {
        // Chỉnh màu cho thanh edit text khi gặp error, focus, ...

        edtCanSua.setBackground(getDrawable(edtColor));
        edtCanSua.setCompoundDrawableTintList(getColorStateList(iconColor));
        edtCanSua.setTextColor(getColorStateList(textColor));
    }


    private Boolean validatePhoner(){
        String password = edtPhone.getText().toString();

        if (password.isEmpty()){
            txtErrorPhone.setText(R.string.field_cannot_be_empty);
            txtErrorPhone.setTextSize(15);
            setCustomColor(edtPhone,R.drawable.edt_custom_error,R.color.red,R.color.red);
            edtPhone.setHintTextColor(getColor(R.color.red));
            return false;
        }

        else {

            setCustomColor(edtPhone,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            edtPhone.setHintTextColor(getColor(R.color.xamChu));

            txtErrorPhone.setText(null);
            txtErrorPhone.setTextSize(0);
            return true;
        }

    }
    private void addEvents() {
        btnSendPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validate password và email
                if(!validatePhoner()){
                    edtPhone.clearFocus();
                    return;
                }

                else {
                    if(!edtPhone.getText().toString().equals("0908315280"))
                    {
                        txtErrorPhone.setText(R.string.your_phone_does_not_exists);
                        txtErrorPhone.setTextSize(15);
                        setCustomColor(edtPhone,R.drawable.edt_custom_error,R.color.red,R.color.red);


                    }
                    else{

                        Intent intent = new Intent(ResetPasswordScreen.this,VerificationScreen.class);
                        startActivity(intent);
                        setCustomColor(edtPhone,R.drawable.custom_edt,R.color.blackUI,R.color.blackUI);
                    }

                }



            }
        });

        edtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s = edtPhone.getText().toString();
                if(s.length()>12)
                {
                    setCustomColor(edtPhone,R.drawable.edt_custom_error,R.color.red,R.color.red);
                    txtErrorPhone.setText(R.string.your_phone_number_is_too_long);
                    txtErrorPhone.setTextSize(15);

                    btnSendPassword.setEnabled(false);
                    btnSendPassword.setBackground(getDrawable( R.drawable.button_login_block));

                    btnSendPassword.setTextColor(getColor(R.color.xamBlcok));

                }
                else
                {
                    setCustomColor(edtPhone,R.drawable.custom_edt,R.color.blackUI,R.color.blackUI);
                    txtErrorPhone.setText(null);
                    txtErrorPhone.setTextSize(0);
                    edtPhone.setHintTextColor(getColor(R.color.xamChu));

                    btnSendPassword.setEnabled(true);
                    btnSendPassword.setBackground(getDrawable(R.drawable.custom_button));
                    btnSendPassword.setTextColor(getColor( R.color.blackUI));

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        imvRestBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResetPasswordScreen.this,LoginScreen.class);
                startActivity(intent);
            }
        });



    }



}