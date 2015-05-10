package net.ichigotake.practice_20140511;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.ichigotake.practice_20140511.timer.TimerSpec;
import net.ichigotake.practice_20140511.timer.TimerView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TimerActivity extends AppCompatActivity {

    @InjectView(R.id.activity_main_timer)
    TimerView timerView;
    @InjectView(R.id.activity_main_randomize)
    Button randomize;
    @InjectView(R.id.activity_main_spec)
    TextView specView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        randomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerView.setTimerAsRandom();
            }
        });
        timerView.setTimerAsRandom();
        new TimerSpec().inject(specView);
    }

}
