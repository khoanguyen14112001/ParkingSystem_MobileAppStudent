package nguyenhoanganhkhoa.com.myapplication.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.adapter.FacultyAdapter;
import nguyenhoanganhkhoa.com.myapplication.data.Faculty;

public class MainActivity2 extends AppCompatActivity {
    private Spinner spnTest;
    private FacultyAdapter facultyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spnTest = findViewById(R.id.spnTest);
        facultyAdapter = new FacultyAdapter(this,R.layout.item_faculty_selected,getListFaculty());

        spnTest.setAdapter(facultyAdapter);


    }


    private List<Faculty> getListFaculty() {
        List<Faculty> list =new ArrayList<>();
        list.add(new Faculty("Faculty*"));
        list.add(new Faculty("Faculty of Economics"));
        list.add(new Faculty("Faculty of International Economic Relations"));
        list.add(new Faculty("Faculty of Finance - Banking"));
        list.add(new Faculty("Faculty of Accounting - Auditing"));
        list.add(new Faculty("Faculty of Information Systems"));
        list.add(new Faculty("Faculty of Business Administration "));
        list.add(new Faculty("Faculty of Economic Mathematics"));
        list.add(new Faculty("Faculty of Law"));
        list.add(new Faculty("Faculty of Economic Law"));
        list.add(new Faculty("Department of Foreign Languages"));
        return list;

    }
}