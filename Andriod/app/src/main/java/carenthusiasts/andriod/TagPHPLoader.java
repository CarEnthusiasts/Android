package carenthusiasts.andriod;


/**
 * Created by Alex on 4/22/2016.
 */




        import android.content.Context;
        import android.os.AsyncTask;
        import android.widget.Toast;

        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.net.URLEncoder;


public class TagPHPLoader extends AsyncTask<String, Void, String> {

    private Context context;

    public TagPHPLoader(Context context) {
        this.context = context;
    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... arg0) {
        String category = arg0[0];
        String tag = arg0[1];
        String description = arg0[2];
        String carid = arg0[3];

        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try {
            data = "?category=" + URLEncoder.encode(category, "UTF-8");
            data += "&tag=" + URLEncoder.encode(tag, "UTF-8");
            data += "&description=" + URLEncoder.encode(description, "UTF-8");
            data += "&carid=" + URLEncoder.encode(carid, "UTF-8");

            link = "http://192.168.0.6/carenthusiasts/tag.php" + data;

            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
            con.disconnect();
            return result;
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        String jsonStr = result;
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String query_result = jsonObj.getString("query_result");

                if (query_result.equals("FAILURE")) {
                    Toast.makeText(context, "Data could not be inserted.", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();

                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
        }
    }
}
