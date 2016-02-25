package wear.dartmouth.edu.intersection;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by _ReacTor on 16/2/22.
 */
public class FeaturesActivity extends WearableActivity {

    private Button confirmBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);
        confirmBtn = (Button) findViewById(R.id.button_features_confirm);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("settings", 0);

                int settingStep = preferences.getInt("SettingSteps", 0);
                if(settingStep < 2) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("SettingSteps", 2);
                    editor.commit();
                    startActivity(new Intent(FeaturesActivity.this, PreferencesActivity.class));
                    finish();
                }

                if(settingStep == 4){
                    finish();
                }
            }
        });
    }
}
