package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.santalu.maskara.widget.MaskEditText;

import java.text.Format;

import nguyenhoanganhkhoa.com.myapplication.R;

public class TopUpScreen extends AppCompatActivity {
    ImageView imvBackTopUp;
    Button btnRequestTransfer;
    Button btn10k, btn20k, btn50k, btn100k, btn150k, btn200k;
    EditText edtAmount;
    ImageButton imbPlus, imbMinus;

    int m10k = 10000;
    int m20k = 20000;
    int m50k = 50000;
    int m100k = 100000;
    int m150k = 150000;
    int m200k = 200000;
    int m500k = 500000;

    private void linkView() {
        imvBackTopUp = findViewById(R.id.imvBackTopUp);

        imbPlus = findViewById(R.id.imbPlus);
        imbMinus = findViewById(R.id.imbMinus);

        btnRequestTransfer = findViewById(R.id.btnRequestTransfer);

        btn10k = findViewById(R.id.btn10k);
        btn20k = findViewById(R.id.btn20k);
        btn50k = findViewById(R.id.btn50k);
        btn100k = findViewById(R.id.btn100k);
        btn150k = findViewById(R.id.btn150k);
        btn200k = findViewById(R.id.btn200k);

        edtAmount= findViewById(R.id.edtAmount);
    }



    private void formatNumber(int amount) {
        String amountFormat = String.format("%,d", amount);
        edtAmount.setText(amountFormat);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_screen);

        linkView();
        addEvents();
    }

    private String deleteCharDot (String s) {
        if(!s.isEmpty())
        {
            StringBuilder stringBuilder = new StringBuilder(s);

            if(s.length() == 6)
            {
                stringBuilder.deleteCharAt(2);
            }
            else if(s.length() == 7)
            {
                stringBuilder.deleteCharAt(3);
            }
            return stringBuilder.toString();
        }
        return "";
    }

    private void setStatusButton(boolean isEnable, int colorButton, int colorText) {
        btnRequestTransfer.setEnabled(isEnable);
        btnRequestTransfer.setBackground(getDrawable(colorButton));
        btnRequestTransfer.setTextColor(getResources().getColor(colorText));
    }

    private void validateAmount() {
        String s = edtAmount.getText().toString();
        if(s.isEmpty()|s.equals("0"))
        {
            setStatusButton(false,R.drawable.button_login_block,R.color.xamBlcok);
        }
        else
        {
            setStatusButton(true,R.drawable.custom_button, R.color.black);
        }
    }

    private void addEvents() {
        validateAmount();
        edtAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validateAmount();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        imbPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edtAmount.getText().toString();
                int amountMoneyCurrent;
                if(!s.equals("")){
                    amountMoneyCurrent = Integer.parseInt(deleteCharDot(s));
                }
                else{
                    amountMoneyCurrent = 0;
                }
                int newAmount;
                if(!((amountMoneyCurrent + m10k) > m500k)){
                    newAmount = amountMoneyCurrent + m10k;
                    formatNumber(newAmount);
                }
            }
        });

        imbMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edtAmount.getText().toString();
                int amountMoneyCurrent;
                if(!s.equals("")){
                    amountMoneyCurrent = Integer.parseInt(deleteCharDot(s));
                }
                else{
                    amountMoneyCurrent = 0;
                }
                int newAmount;
                if(((amountMoneyCurrent - m10k) >= 0)){
                    newAmount = amountMoneyCurrent - m10k;
                    formatNumber(newAmount);
                }
            }
        });

        btn10k.setOnClickListener(clickForMoney);
        btn20k.setOnClickListener(clickForMoney);
        btn50k.setOnClickListener(clickForMoney);
        btn100k.setOnClickListener(clickForMoney);
        btn150k.setOnClickListener(clickForMoney);
        btn200k.setOnClickListener(clickForMoney);

        imvBackTopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnRequestTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TopUpScreen.this,TopUpQRCodeScreen.class);
                startActivity(intent);
            }
        });

    }


    View.OnClickListener clickForMoney = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn10k:
                    formatNumber(m10k);
                    break;
                case R.id.btn20k:
                    formatNumber(m20k);
                    break;
                case R.id.btn50k:
                    formatNumber(m50k);
                    break;
                case R.id.btn100k:
                    formatNumber(m100k);
                    break;
                case R.id.btn150k:
                    formatNumber(m150k);
                    break;
                case R.id.btn200k:
                    formatNumber(m200k);
                    break;
            }


        }
    };

}