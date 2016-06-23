package tracking;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.Constant;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by buddyarifin on 5/31/16.
 */
public class NetClient extends BasePage {

    public static final String PROJECT_NAME = "AndroidOLXID";
    public static final String META = "meta";
    public static final String PAGINATION = "pagination";
    public static final String LINKS = "links";
    public static final String BUGS = "bugs";
    static String token = "rqHRZDI8lV257vz0qrsXNZkKpMIRtNqCr3OOD2U5";
    private int projID;
    private int projectVersionID;
    private int projectSectionID;
    private int bugsId = 0;
    static String endPoint = "https://api.leantesting.com";
    static String accessToken = "?access_token="+token;
    static String pathUserInfoUrl = endPoint+"/v1/me"+accessToken;
    static String pathListProjUrl = endPoint+"/v1/projects/"+accessToken;
    private String pathListBugs = endPoint+"/v1/projects/"+projID+"/bugs";
    private String pathCreateBugUrl = endPoint+"/v1/projects/"+this.projID+"/bugs";
    private String lastpageUrl;
    private String responseString;
    private HttpURLConnection conn;
    private JSONArray dataBugs = new JSONArray();

    public NetClient (WebDriver driver) { super(driver); };

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
            conn.setDoOutput(true);

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
            System.out.println("Cannot Connect to Lean Testing");
        }
        return responseString;
    }

    public String readInputStream(InputStream stream) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((stream)));
            responseString = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return responseString;
    }

    public void writeReqBody(JSONObject object, OutputStream stream){
        try {
            StringWriter out = new StringWriter();
            object.write(out);
            System.out.println("Request body : "+out.toString());

            DataOutputStream wr = new DataOutputStream(stream);
            wr.writeBytes(out.toString());
            wr.flush();
            wr.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getUserInfo() {
        return req(pathUserInfoUrl, "GET");
    }

    public String getListProject(){
        return req(pathListProjUrl, "GET");
    }

    public JSONObject getListBugs() {
        setProjID(PROJECT_NAME);
        String response = req(endPoint+"/v1/projects/"+projID+"/bugs", "GET");
        return new JSONObject(response);
    }

    public void setProjID(String project) throws JSONException{
        String response = getListProject();
        JSONObject objProj = new JSONObject(response);
        JSONArray arr = objProj.getJSONArray("projects");
        for (int i = 0 ; i < arr.length() ; i++) {
            if (arr.getJSONObject(i).getString("name").equalsIgnoreCase(project)) {
                this.projID = arr.getJSONObject(i).getInt("id");
                break;
            }
        }
    }

    public void setProjVersionSection(){
        JSONObject bugs = getListBugs();
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

    public String getLastBugsPageUrl(){
        JSONObject listBug = getListBugs();
        String lastPage = listBug.getJSONObject(META).getJSONObject(PAGINATION)
                .getJSONObject(LINKS).getString("last");
        if (lastPage == null){
            throw new RuntimeException("Failed request get last url links");
        }
        return lastPage;
    }

    public int getLastBugsID() {
        JSONObject res = new JSONObject(req(getLastBugsPageUrl(), "GET"));
        JSONArray arr = res.getJSONArray("bugs");
        return arr.getJSONObject(arr.length()-1).getInt("id");
    }

    public void sendAttachments(ITestResult result) {
        try {
            HttpPost post = new HttpPost(endPoint + "/v1/bugs/" + getLastBugsID() + "/attachments");
            post.setHeader("Authorization", "Bearer " + token);

            File screenshoot = new File(Constant.screenshotsDir+"/FailedOn_"+result.getTestClass().getName()
                    +result.getMethod().getMethodName()+".png");

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            FileBody fileBody = new FileBody(screenshoot);
            builder.addPart("file", fileBody);
            HttpEntity entity = builder.build();
            post.setEntity(entity);

            HttpClient client = HttpClientBuilder.create().build();
            HttpResponse response = client.execute(post);

            this.responseString = readInputStream(response.getEntity().getContent());
        }
        catch ( IOException e) {
            e.printStackTrace();
        }
        catch ( Exception e) {
            e.printStackTrace();
        }
    System.out.print("Response Uploading : "+responseString);
    }

    public JSONArray getBugsJson() {
        System.out.println("Store Existing Bugs from leantesting.com to Array");
        JSONArray jsonArray = new JSONArray();
        JSONObject listBugs = getListBugs();
        int totalPages = listBugs.getJSONObject(META).getJSONObject(PAGINATION).getInt("total_pages");
        for (int i=1 ; i<= totalPages; i++) {
            String res = req("https://api.leantesting.com/v1/projects/15087/bugs/?page="+i, "GET");
            JSONArray array = new JSONObject(res).getJSONArray(BUGS);
            for (int j = 1 ; j <= array.length() ; j++ ) {
                jsonArray.put(array.getJSONObject(j-1));
            }
        }
    return jsonArray;
    }

    public int searchBugsId(String title, JSONArray arr){
            for (int i = 0 ; i < arr.length() ; i++) {
                if (arr.getJSONObject(i).getString("title").equalsIgnoreCase(title)) {
                    this.bugsId = arr.getJSONObject(i).getInt("id");
                    System.out.println("Found Bugs with id : " + this.bugsId);
                }
            }
        return this.bugsId;
    }

    public void goToTracker(ITestResult testResult, JSONArray array){
        int checkId = searchBugsId("Automation Test : "+ testResult.getMethod().getMethodName(), array);
        if ( checkId > 0 ) {
            System.out.println("Update Existing Bugs for id : "+ checkId);
            updateCase(testResult, checkId);
        } else if ( checkId <= 0 ) {
            createBugsCase(testResult);
        } else {
            System.out.println("Not integrate anything ");
        }
    }

    public void createBugsCase(ITestResult result) {
        switch (result.getStatus()) {
            case 1 : System.out.println("Test Succeded");
                     break;
            case 2 : System.out.println("Creating new bugs ...");
                     create(result);
                     break;
            default:
                System.out.println("Invalid Status from ITestResult - Created Case");
        }
    }

    public void updateCase(ITestResult result, int bugsId) {
        switch (result.getStatus()) {
            // ITestResult status 1 = Success
            case 1 : update(bugsId, result, 6);
                     break;
            // ITestResult status 2 = Failure
            case 2 : update(bugsId, result, 1);
                     break;
            // ITestResult status 3 = Skip
            case 3 : System.out.println("Test Read as SKIP");
                     break;
            // ITestResult status 4 = Success precentage failure
            case 4 : System.out.println("Test Read as Success precentage failure");
                     break;
            default:
                System.out.println("Invalid Status from ITestResult - Updated Case");
        }

    }

    public void create(ITestResult result) {
        try{
            setProjVersionSection();
            this.conn = openConnection(endPoint+"/v1/projects/"+this.projID+"/bugs", "POST");
            conn.setDoOutput(true);
            JSONObject postBody = new JSONObject();
            postBody.put("title", "Automation Test : "+result.getMethod().getMethodName() );
            postBody.put("status_id", 1);
            postBody.put("severity_id", 2);
            postBody.put("project_version_id", this.projectVersionID);
            postBody.put("project_section_id", this.projectSectionID);
            postBody.put("type_id", 1);
            writeReqBody(postBody, conn.getOutputStream());
            conn.disconnect();
            this.sendAttachments(result);
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(int bugsid, ITestResult result, int status){
        try {
            setProjVersionSection();
            this.conn = openConnection(endPoint + "/v1/bugs/" + bugsid, "PUT");
            conn.setDoOutput(true);
            JSONObject bodyReq = new JSONObject();
            bodyReq.put("title", "Automation Test : "+ result.getMethod().getMethodName());
            bodyReq.put("status_id", status);
            bodyReq.put("severity_id", 2);
            bodyReq.put("project_version_id", this.projectVersionID);
            bodyReq.put("project_section_id", this.projectSectionID);
            bodyReq.put("type_id", 1);
            bodyReq.put("description", "Running date : "+result.getEndMillis());
            writeReqBody(bodyReq, conn.getOutputStream());
            readInputStream(conn.getInputStream());
            conn.disconnect();

        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}