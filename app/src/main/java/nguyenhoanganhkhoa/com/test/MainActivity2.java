package nguyenhoanganhkhoa.com.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.adapter.FacultyAdapter;
import nguyenhoanganhkhoa.com.models.Faculty;

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