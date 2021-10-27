package nguyenhoanganhkhoa.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TopUpScreen extends AppCompatActivity {
    ImageView imvBackTopUp;
    Button btnRequestTransfer;

    private void linkView() {
        imvBackTopUp = findViewById(R.id.imvBackTopUp);
        btnRequestTransfer = findViewById(R.id.btnRequestTransfer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_screen);

        linkView();
        addEvents();
    }

    private void addEvents() {
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
}