package app.rstone.com.myapp8schedule;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

public class Main extends AppCompatActivity {
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Context ctx = Main.this;
        TextView today = findViewById(R.id.today);
        CalendarView calendar =findViewById(R.id.calendar);
        TimePicker time = findViewById(R.id.time);
        TextView year =findViewById(R.id.year);
        TextView month =findViewById(R.id.month);
        TextView day = findViewById(R.id.day);
        TextView hour = findViewById(R.id.hour);
        TextView minute =findViewById(R.id.minute);
        calendar.setVisibility(View.VISIBLE);
        time.setVisibility(View.INVISIBLE);
        today.setText(new SimpleDateFormat("yyyy-MM-dd-hh:mm").format(new Date()));
        findViewById(R.id.btnEnd).setOnClickListener(
                (View v)->{
                 year.setText(String.valueOf(date.split("/")[0]));
                  month.setText(String.valueOf(Integer.parseInt(date.split("/")[1])+1));
                    day.setText(String.valueOf(date.split("/")[2]));
                    hour.setText(String.valueOf(time.getHour()));
                    minute.setText(String.valueOf(time.getMinute()));
                }
        );
        findViewById(R.id.rdoCalendar).setOnClickListener(
                (View v)->{
                    calendar.setVisibility(View.VISIBLE);
                    time.setVisibility(View.INVISIBLE);
                }
        );
        findViewById(R.id.rdoTime).setOnClickListener(
                (View v)->{
                    calendar.setVisibility(View.INVISIBLE);
                    time.setVisibility(View.VISIBLE);
                }
        );
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                    date = year+"/"+month+"/"+dayOfMonth;
              }
        });
    }
}
