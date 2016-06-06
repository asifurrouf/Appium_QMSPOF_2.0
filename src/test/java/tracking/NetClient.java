package tracking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by buddyarifin on 5/31/16.
 */
public class NetClient {

    public static final String PROJECT_NAME = "AndroidOLXID";
    public static final String META = "meta";
    public static final String PAGINATION = "pagination";
    public static final String LINKS = "links";
    static String token = "esjeDdcllCuWGEqfW8yOM4LjL7lfwyEjMKKhNrrY";
    int projID;
    int projectVersionID;
    int projectSectionID;
    int bugsId;
    static String endPoint = "https://api.leantesting.com";
    static String accessToken = "?access_token="+token;
    static String pathUserInfoUrl = endPoint+"/v1/me"+accessToken;
    static String pathListProjUrl = endPoint+"/v1/projects/"+accessToken;
    String pathListBugs = endPoint+"/v1/projects/"+projID+"/bugs";
    String pathCreateBugUrl = endPoint+"/v1/projects/"+this.projID+"/bugs";
    String lastpageUrl;
    String responseString;
    HttpURLConnection conn;

    public HttpURLConnection openConnection(String URL, String restMethod) {
        try{
            URL url = new URL(URL);
            this.conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(restMethod);
            conn.setRequestProperty("Content-Type","application/json");
            conn.setRequestProperty("Authorization","Bearer "+token);
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(HttpURLConnection conn){
        conn.disconnect();
    }

    public String req(String URL, String restMethod) {
        try{
            conn = openConnection(URL, restMethod);

            if (conn.getResponseCode() != 200 ){
                throw new RuntimeException("Failed request :" +conn.getResponseCode());
            }
            responseString = readInputStream(conn.getInputStream());

            closeConnection(conn);

        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return responseString;
    }

    public String readInputStream(InputStream stream) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((stream)));
            responseString = br.readLine();
            if (responseString != null) {
                System.out.print(this.responseString);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return responseString;
    }

    public String getUserInfo() {
        return req(pathUserInfoUrl, "GET");
    }

    public String getListProject(){
        return req(pathListProjUrl, "GET");
    }

    public String getListBugs() {
        setProjID(PROJECT_NAME);
        return req(endPoint+"/v1/projects/"+projID+"/bugs", "GET");
    }

    public void setProjID(String project) throws JSONException{
        String response = getListProject();
        JSONObject objProj = new JSONObject(response);
        JSONArray arr = objProj.getJSONArray("projects");
        for (int i = 0 ; i < arr.length() ; i++) {
            if (arr.getJSONObject(i).getString("name").equalsIgnoreCase(project)) {
                this.projID = arr.getJSONObject(i).getInt("id");
                System.out.println("AndroidOLXID project id : " +this.projID);
                break;
            }
        }
        System.out.println("Project ID : "+this.projID);
    }


    public void setProjVersionSection(){
        String response = getListBugs();
        JSONObject bugs = new JSONObject(response);
        JSONArray arr = bugs.getJSONArray("bugs");
        for (int i = 0 ; i < arr.length() ; i++) {
            System.out.println(arr.getJSONObject(i).getString("title"));
            if (arr.getJSONObject(i).getString("title") != null ) {
                this.projectVersionID = arr.getJSONObject(i).getInt("project_version_id");
                this.projectSectionID = arr.getJSONObject(i).getInt("project_section_id");
                break;
            }
        }
        System.out.println("AndroidOLXID project version id bugs : " +this.projectVersionID+" and project section id bugs : "+this.projectSectionID);
    }

    public void createBug(String testname) {
        try{
            setProjVersionSection();
            this.conn = openConnection(endPoint+"/v1/projects/"+this.projID+"/bugs", "POST");
            conn.setDoOutput(true);

            JSONObject postBody = new JSONObject();
            postBody.put("title", "Automation Test : "+testname );
            postBody.put("status_id", 1);
            postBody.put("severity_id", 2);
            postBody.put("project_version_id", this.projectVersionID);
            postBody.put("project_section_id", this.projectSectionID);
            postBody.put("type_id", 1);

            StringWriter out = new StringWriter();
            postBody.write(out);

            System.out.println("Request body : "+out.toString());

            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(out.toString());
            wr.flush();
            wr.close();

            readInputStream(conn.getInputStream());

            conn.disconnect();
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLastpageUrl(){
        String response = getListBugs();
        JSONObject listBug = new JSONObject(response);
        String lastPage = listBug.getJSONObject(META).getJSONObject(PAGINATION)
                .getJSONObject(LINKS).getString("last");
        if (lastPage == null){
            throw new RuntimeException("Failed request get last url links");
        }
        return lastPage;
    }
    
    public void setBugsID() {
        JSONObject res = new JSONObject(req(getLastpageUrl(), "GET"));
        JSONArray arr = res.getJSONArray("bugs");
        this.bugsId = arr.getJSONObject(arr.length()-1).getInt("id");
        System.out.print("Latest Bugs ID :"+bugsId);
    }

}
