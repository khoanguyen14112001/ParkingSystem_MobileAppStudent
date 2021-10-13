package nguyenhoanganhkhoa.com.myapplication;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        addEvents();
    }

    private void setCustomColor(EditText edtCanSua, int edtColor, int iconColor, int textColor)
    {
        // Chỉnh màu cho thanh edit text khi gặp error, focus, ...

        edtCanSua.setBackground(ContextCompat.getDrawable(ResetPasswordScreen.this,edtColor));
        edtCanSua.setCompoundDrawableTintList(ContextCompat.getColorStateList(ResetPasswordScreen.this,iconColor));
        edtCanSua.setTextColor(ContextCompat.getColorStateList(ResetPasswordScreen.this,textColor));
    }


    private Boolean validatePhoner(){
        String password = edtPhone.getText().toString();

        if (password.isEmpty()){
            txtErrorPhone.setText(R.string.field_cannot_be_empty);
            txtErrorPhone.setTextSize(15);
            setCustomColor(edtPhone,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }

        else {

            setCustomColor(edtPhone,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
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
                    Intent intent = new Intent(ResetPasswordScreen.this,VerificationScreen.class);
                    startActivity(intent);
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
                    btnSendPassword.setBackground(ContextCompat.getDrawable(ResetPasswordScreen.this, R.drawable.button_login_block));
                    btnSendPassword.setTextColor(ContextCompat.getColor(ResetPasswordScreen.this, R.color.xamBlcok));

                }
                else
                {
                    setCustomColor(edtPhone,R.drawable.edt_custom_focus,R.color.blackUI,R.color.blackUI);
                    txtErrorPhone.setText(null);
                    txtErrorPhone.setTextSize(0);

                    btnSendPassword.setEnabled(true);
                    btnSendPassword.setBackground(ContextCompat.getDrawable(ResetPasswordScreen.this, R.drawable.button_login));
                    btnSendPassword.setTextColor(ContextCompat.getColor(ResetPasswordScreen.this, R.color.blackUI));

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        imvRestBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }



}