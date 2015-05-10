package net.ichigotake.practice_20140511;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, emulateSdk = 21)
@RunWith(RobolectricGradleTestRunner.class)
public class MainTest {

    @Test
    public void test_hello() {
        assertTrue(true);
    }

}
