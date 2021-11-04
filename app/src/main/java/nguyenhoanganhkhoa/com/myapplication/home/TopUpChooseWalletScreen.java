package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import nguyenhoanganhkhoa.com.myapplication.R;

public class TopUpChooseWalletScreen extends AppCompatActivity {

    ImageView imvBackTopUp3;
    Button btnNextTopup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_choose_wallet_screen);

        linkView();
        addEvents();
    }

    private void addEvents() {
        imvBackTopUp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnNextTopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TopUpChooseWalletScreen.this,TopUpScreen.class);
                startActivity(intent);
            }
        });

    }

    private void linkView() {
        imvBackTopUp3 = findViewById(R.id.imvBackTopUp3);
        btnNextTopup =findViewById(R.id.btnNextTopup);

    }
}