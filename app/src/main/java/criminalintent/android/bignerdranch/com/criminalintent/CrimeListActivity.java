package criminalintent.android.bignerdranch.com.criminalintent;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by samuel on 07/02/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    private CrimeListFragment crimeListFragment;

    @Override
    protected Fragment createFragment() {
        crimeListFragment = new CrimeListFragment();
        return crimeListFragment;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        crimeListFragment.onActivityResult(requestCode, resultCode, data);
    }
}
