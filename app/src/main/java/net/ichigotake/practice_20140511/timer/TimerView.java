package net.ichigotake.practice_20140511.timer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import net.ichigotake.practice_20140511.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static net.ichigotake.practice_20140511.timer.TimeCalculator.generateRandomHour;

public class TimerView extends FrameLayout {

    @InjectView(R.id.timer_status)
    View timerStatus;
    @InjectView(R.id.timer_display)
    TextView timerDisplay;

    public TimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.timer, this, true);
        ButterKnife.inject(this);
        if (isInEditMode()) {
            setTimerAsRandom();
        }
    }

    public void setTimerAsRandom() {
        Timer timer = new Timer(generateRandomHour(), generateRandomHour());
        setTimer(timer, generateRandomHour());
    }

    public void setTimer(Timer timer, int betweenHour) {
        String display = getResources().getString(R.string.timer_display,
                timer.getStartHour(), betweenHour, timer.getPeriodHour());
        timerDisplay.setText(display);
        boolean between = new TimeCalculator(timer).isBetween(betweenHour);
        timerStatus.setBackgroundResource(
                between ? R.color.timer_status_valid : R.color.timer_status_invalid);
    }

    /** visible for testing */
    public String getText() {
        return timerDisplay.getText().toString();
    }

}
