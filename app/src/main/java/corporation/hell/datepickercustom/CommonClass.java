package corporation.hell.datepickercustom;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * @author harsh on 2/25/2017.
 */

public class CommonClass {

    /**
     * Date Picker
     * @param context Context
     * @param minDate Set Minimum date: pass min date in long format
     * @param maxDate Set Maximum date: Pass max Date in long format
     * @param textview pass text view on which you want to set date
     */
    public static void datePicker(final Activity context, long minDate, long maxDate, final TextView textview) {
        int popupWidth = 500;
        int popupHeight = 500;

        // Inflate the popup_layout.xml
        LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popup);
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.date_picker, viewGroup);

        // Creating the PopupWindow
        final PopupWindow popup = new PopupWindow(context);
        popup.setContentView(layout);
        popup.setWidth(popupWidth);
        popup.setHeight(popupHeight);
        popup.setFocusable(true);

        // Clear the default translucent background
        //popup.setBackgroundDrawable(getResources().getDrawable(R.drawable.abc));

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.CENTER, 0, 0);

        // Getting a reference to Close button, and close the popup when clicked.
        final DatePicker datePicker = (DatePicker) layout.findViewById(R.id.date_picker);
        datePicker.setMinDate(minDate);
        datePicker.setMaxDate(maxDate);
        Button close = (Button) layout.findViewById(R.id.ok);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(getProperFormat(datePicker.getDayOfMonth()) + "-" + getProperFormat((datePicker.getMonth() + 1)) + "-" + getProperFormat(datePicker.getYear()));
                popup.dismiss();
            }
        });
    }

    /**
     * Setting a proper format for time
     * @param hhORmm time digit
     * @return proper Digit
     */
    public static String getProperFormat(int hhORmm) {
        String temp = hhORmm + "";
        if (temp.length() == 1) {
            temp = "0" + temp;
        } else {

        }
        return temp;
    }
}
