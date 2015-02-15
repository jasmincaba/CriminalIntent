package criminalintent.android.bignerdranch.com.criminalintent;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by samuel on 15/02/15.
 */
public class Photo {
    private static final String JSON_FILENAME = "filename";
    private String mFilename;

    public Photo(String mFilename) {
        this.mFilename = mFilename;
    }

    public Photo(JSONObject json) throws JSONException {
        mFilename = json.getString(JSON_FILENAME);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_FILENAME, mFilename);
        return json;
    }

    public String getFilename() {
        return mFilename;
    }
}
