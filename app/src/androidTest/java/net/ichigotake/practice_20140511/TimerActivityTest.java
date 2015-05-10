package net.ichigotake.practice_20140511;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.text.TextUtils;

import com.squareup.spoon.Spoon;

import net.ichigotake.practice_20140511.timer.Timer;
import net.ichigotake.practice_20140511.timer.TimerView;

public class TimerActivityTest extends ActivityInstrumentationTestCase2<TimerActivity> {

    private TimerActivity activity;
    private Instrumentation instrumentation;
    private TimerView timerView;

    public TimerActivityTest() {
        super(TimerActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
        instrumentation = getInstrumentation();
        timerView = (TimerView) activity.findViewById(R.id.activity_main_timer);
    }

    public void testTimerActivity_randomize() {
        String beforeRandomize = timerView.getText();
        instrumentation.runOnMainSync(new Runnable() {
            @Override
            public void run() {
                timerView.setTimer(new Timer(18, 10), 18);
            }
        });
        instrumentation.waitForIdleSync();
        Spoon.screenshot(activity, "TimerActivity_beforeRandomize");

        instrumentation.runOnMainSync(new Runnable() {
            @Override
            public void run() {
                timerView.setTimer(new Timer(18, 10), 10);
            }
        });
        instrumentation.waitForIdleSync();
        String afterRandomize = timerView.getText();
        assertFalse(TextUtils.equals(beforeRandomize, afterRandomize));
        Spoon.screenshot(activity, "TimerActivity_afterRandomize");
    }

}
