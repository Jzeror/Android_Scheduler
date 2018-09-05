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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Context ctx = Main.this;
        class MyDate{
           String year, month, day, hour, minute;
        }
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
        final MyDate m= new MyDate();
        today.setText(new SimpleDateFormat("yyyy-MM-dd-hh:mm").format(new Date()));
        findViewById(R.id.btnEnd).setOnClickListener(
                (View v)->{
                    m.hour=time.getHour()+"";
                    m.minute=time.getMinute()+"";
                    year.setText(m.year);
                    month.setText(m.month);
                    day.setText(m.day);
                    hour.setText(m.hour);
                    minute.setText(m.minute);
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
                   m.year=year+"";
                   m.month=""+Integer.parseInt(month+"")+1;
                   m.day=String.valueOf(dayOfMonth);
              }
        });
    }
}
