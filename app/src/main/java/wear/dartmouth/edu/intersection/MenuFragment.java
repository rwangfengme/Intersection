package wear.dartmouth.edu.intersection;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by _ReacTor on 16/2/22.
 */
public class MenuFragment extends Fragment implements View.OnClickListener{

    private Button btnFeatures;
    private Button btnPreferences;
    private Button btnLikeOrNot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        btnFeatures = (Button) view.findViewById(R.id.button_features);
        btnPreferences = (Button) view.findViewById(R.id.button_preferences);
        btnLikeOrNot = (Button) view.findViewById(R.id.button_likeornot);

        btnFeatures.setOnClickListener(this);
        btnPreferences.setOnClickListener(this);
        btnLikeOrNot.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_features:
                startActivity(new Intent(getActivity(), FeaturesActivity.class));
                break;

            case R.id.button_preferences:
                startActivity(new Intent(getActivity(), PreferencesActivity.class));
                break;

            case R.id.button_likeornot:
                startActivity(new Intent(getActivity(), LikeOrNotActivity.class));
                break;

            default:
                break;
        }
    }
}
