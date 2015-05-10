package net.ichigotake.practice_20140511.timer;

import android.text.TextUtils;
import android.widget.TextView;

import net.ichigotake.practice_20140511.R;
import net.ichigotake.practice_20140511.content.ResourcesReader;

import java.util.List;

public class TimerSpec {

    public void inject(TextView textView) {
        List<String> spec = new ResourcesReader(textView.getResources()).readRawResource(R.raw.spec);
        textView.setText(TextUtils.join("\n", spec));
    }

}
