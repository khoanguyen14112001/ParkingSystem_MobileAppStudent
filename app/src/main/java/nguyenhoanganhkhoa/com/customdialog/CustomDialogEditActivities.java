package nguyenhoanganhkhoa.com.customdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.adapter.DialogNotificationAdapter;
import nguyenhoanganhkhoa.com.models.Notification;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.home.EditActivitiesScreen;

public class CustomDialogEditActivities extends Dialog {
    Activity activity;
    public CardView cvEdit;

    public CustomDialogEditActivities(@NonNull Activity activity, int dialogLayout, ImageButton button) {

        super(activity);
        this.activity =  activity;

        configureDialogWindow(dialogLayout,button);
        linkView();

        // Decorate window dialog


    }

    private void configureDialogWindow(int dialogLayout, ImageButton button) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(dialogLayout);

        Window window = this.getWindow();
        if (window == null){
            return;
        }

        int location[] = new int[2];
        button.getLocationOnScreen(location);
        int y = location[1];


        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtributes = window.getAttributes();
//        windowAtributes.gravity = Gravity.TOP|Gravity.RIGHT;
//        windowAtributes.x = 5;
//        windowAtributes.y = y - 35;
        window.setAttributes(windowAtributes);

}



    private void popupWindow(int dialogLayout, ImageButton button){
        LayoutInflater inflater = LayoutInflater.from(activity);


        View popupView = inflater.inflate(dialogLayout, null);
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it

//        popupView.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken

        popupWindow.showAsDropDown(button);

    }






    public void linkView() {
        cvEdit = findViewById(R.id.cvEdit);
    }
}
