package corporation.hell.datepickercustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView datePicker = (TextView) findViewById(R.id.date_picker_text);

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pass Min date and max date in long format as 2nd and 3rd argument respectively
                CommonClass.datePicker(MainActivity.this,System.currentTimeMillis()-315569260l,System.currentTimeMillis()-+31556926l,datePicker);
            }
        });

    }
}
