package wear.dartmouth.edu.intersection;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;

/**
 * Created by _ReacTor on 16/2/22.
 */
public class BindFBActivity extends WearableActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindfb);

        SharedPreferences preferences = getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt("SettingSteps", 1);
        editor.commit();
    }
}
