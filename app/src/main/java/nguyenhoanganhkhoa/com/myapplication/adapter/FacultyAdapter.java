package nguyenhoanganhkhoa.com.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.data.Faculty;
import nguyenhoanganhkhoa.com.myapplication.model.PersonalInformationSetScreen;

public class FacultyAdapter extends ArrayAdapter<Faculty> {
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faculty_selected,parent,false);
        TextView txtFacultySelected = convertView.findViewById(R.id.txtFacultySelectedItem);

        Faculty faculty = this.getItem(position);
        if (faculty !=null){
            txtFacultySelected.setText(faculty.getNameFaculty());

        }
        return convertView;
//        return super.getView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faculty,parent,false);
        TextView txtFaculty = convertView.findViewById(R.id.txtFacultyItem);

        Faculty faculty = this.getItem(position);
        if (faculty !=null){
            txtFaculty.setText(faculty.getNameFaculty());

            if(position ==0)
                txtFaculty.setTextColor(ContextCompat.getColorStateList(getContext(),R.color.black));
            else
                txtFaculty.setTextColor(ContextCompat.getColorStateList(getContext(),R.color.xamChu));
        }

        if(PersonalInformationSetScreen.selectedFaculty==position && PersonalInformationSetScreen.selectedFaculty!=0)
            txtFaculty.setTextColor(ContextCompat.getColorStateList(getContext(),R.color.primary_yellow));


        return convertView;

    }




    public boolean isEnabled(int position){
        if(position == 0)
        {
            // Disable the first item from Spinner
            // First item will be use for hint
            return false;
        }
        else
        {
            return true;
        }
    }
    public FacultyAdapter(@NonNull Context context, int resource, @NonNull List<Faculty> objects) {


        super(context, resource, objects);
    }

}
