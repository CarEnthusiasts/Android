package carenthusiasts.andriod;
/**
 * This Activity written by: Alex Brooks
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

/**
 * this class with load saved searches. front end never implemented
 */
public class SearchPHPLoader extends AsyncTask<String, Void, String> {

    private Context context;

    public SearchPHPLoader(Context context) {
        this.context = context;
    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... arg0) {
        String user = arg0[0];
        String search = arg0[1];
        String searchname = arg0[2];

        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try {
            data = "?user=" + URLEncoder.encode(user, "UTF-8");
            data += "&search=" + URLEncoder.encode(search, "UTF-8");
            data += "&searchname=" + URLEncoder.encode(searchname, "UTF-8");

            link = "http://192.168.0.6/carenthusiasts/search.php" + data;

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
                if (query_result.equals("SUCCESS")) {
                    Toast.makeText(context, "Data inserted successfully. Signup successfull.", Toast.LENGTH_SHORT).show();
                } else if (query_result.equals("FAILURE")) {
                    Toast.makeText(context, "Data could not be inserted. Signup failed.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Couldn't connect to remote database.", Toast.LENGTH_SHORT).show();
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
