package wear.dartmouth.edu.intersection;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.support.wearable.view.GridViewPager;

import java.text.SimpleDateFormat;
import java.util.Locale;

import wear.dartmouth.edu.intersection.data.SimpleFragGridAdapter;

public class LauncherActivity extends WearableActivity {

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    public GridViewPager mGridPager;
    private BoxInsetLayout mContainerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        setAmbientEnabled();

        mContainerView = (BoxInsetLayout) findViewById(R.id.container);

        SharedPreferences preferences = getSharedPreferences("settings", 0);

        switch (preferences.getInt("SettingSteps", 0)){
            case 0:
                startActivity(new Intent(LauncherActivity.this, BindFBActivity.class));
                finish();
                break;
            case 1:
                startActivity(new Intent(LauncherActivity.this, FeaturesActivity.class));
                finish();
                break;
            case 2:
                startActivity(new Intent(LauncherActivity.this, PreferencesActivity.class));
                finish();
                break;
            case 3:
                startActivity(new Intent(LauncherActivity.this, LikeOrNotActivity.class));
                finish();
                break;
            case 4:
                mGridPager = (GridViewPager) findViewById(R.id.pager);
                SimpleFragGridAdapter mAdapter = new SimpleFragGridAdapter(getFragmentManager());
                mGridPager.setAdapter(mAdapter);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putInt("SettingSteps", 0);
                editor.commit();

                break;
            default:
                break;

        }
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
        if (isAmbient()) {
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
        } else {
            mContainerView.setBackground(null);
        }
    }
}
