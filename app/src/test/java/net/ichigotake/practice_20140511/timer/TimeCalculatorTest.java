package net.ichigotake.practice_20140511.timer;

import net.ichigotake.practice_20140511.BuildConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, emulateSdk = 21)
@RunWith(RobolectricGradleTestRunner.class)
public class TimeCalculatorTest {

    @Test
    public void test_TimeCalculator_isBetween() {
        assertTrue("(startHour < periodHour) && (startHour == betweenHour < periodHour)", isBetween(2, 10, 2));
        assertTrue("(startHour < periodHour) && (startHour < betweenHour < periodHour)", isBetween(2, 10, 9));
        assertFalse("(startHour < periodHour) && (startHour < betweenHour == periodHour)", isBetween(2, 10, 10));
        assertFalse("(startHour < periodHour) && (startHour < betweenHour > periodHour)", isBetween(2, 10, 20));

        assertTrue("(startHour > periodHour) && (startHour == betweenHour < periodHour)", isBetween(16, 10, 16));
        assertTrue("(startHour > periodHour) && (startHour < betweenHour < periodHour)", isBetween(16, 10, 9));
        assertFalse("(startHour > periodHour) && (startHour < betweenHour == periodHour)", isBetween(16, 10, 10));
        assertFalse("(startHour > periodHour) && (startHour < betweenHour > periodHour)", isBetween(16, 10, 14));
    }

    private boolean isBetween(int start, int end, int betweenHour) {
        return new TimeCalculator(new Timer(start, end)).isBetween(betweenHour);
    }
}
