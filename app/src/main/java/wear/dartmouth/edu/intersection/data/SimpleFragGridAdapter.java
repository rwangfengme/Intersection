package wear.dartmouth.edu.intersection.data;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.wearable.view.FragmentGridPagerAdapter;

/**
 * Created by _ReacTor on 16/2/22.
 */
public class SimpleFragGridAdapter extends FragmentGridPagerAdapter {
    public SimpleFragGridAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getFragment(int i, int i1) {
        return null;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount(int i) {
        return 0;
    }
}
