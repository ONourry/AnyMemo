package org.liberty.android.fantastischmemo.downloader.google;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import android.os.Bundle;

import android.widget.Toast;

public class GoogleAccountScreen extends GoogleAccountActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }


    @Override
    protected void onAuthenticated(final String authToken) {
        Toast.makeText(this,"Token "+authToken, Toast.LENGTH_LONG).show();
        final String apiKey = "AIzaSyBgSh_sLf2FUvKgc6ZjoYXLvf6viYWFZSo";
        try {
        URL url = new URL("https://www.googleapis.com/drive/v2/files?key=" + apiKey);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.addRequestProperty("client_id", "45533559525-77qfkgj6skoo222jqu2r18p2gcgreouc.apps.googleusercontent.com");
        conn.addRequestProperty("client_secret", "oD_rScGrwBO0iO3lArIktDoL");
        conn.addRequestProperty("Authorization", "OAuth " + authToken);

        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    conn.getErrorStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //final HttpTransport transport = new ApacheHttpTransport(ApacheHttpTransport.newDefaultHttpClient());

        //final JsonFactory jsonFactory = new GsonFactory();
        //GoogleCredential credential = new GoogleCredential();
        //credential.setAccessToken(authToken);

        //Drive service = new Drive.Builder(transport, jsonFactory, credential)
        //    .setJsonHttpRequestInitializer(new JsonHttpRequestInitializer() {

        //        @Override
        //        public void initialize(JsonHttpRequest request) throws IOException {
        //            DriveRequest driveRequest = (DriveRequest) request;
        //            driveRequest.setPrettyPrint(true);
        //            driveRequest.setKey(apiKey);
        //            driveRequest.setOauthToken(authToken);
        //        }
        //    })

        //    .build();

        //List<File> files = retrieveAllFiles(service);
        //Log.i("CHEOK", "size is " + files.size());
        //for (File file : files) {
        //    Log.i(TAG, "title = " + file.getTitle());
        //}

        //((GoogleHeaders) transport.defaultHeaders).setGoogleLogin(authToken);
        //authenticated();
    }

//private static List<File> retrieveAllFiles(Drive service) {
//        List<File> result = new ArrayList<File>();
//        Files.List request = null;
//        try {
//            request = service.files().list();
//        } catch (IOException e) {
//            Log.e(TAG, "", e);
//            return result;
//        }
//
//        do {
//            try {
//                FileList files = request.execute();
//                for (File f : files.getItems()) {
//
//                result.addAll(files.getItems());
//                request.setPageToken(files.getNextPageToken());
//                }
//            } catch (IOException e) {
//                Log.e(TAG, "", e);
//                request.setPageToken(null);
//            }
//        } while (request.getPageToken() != null && request.getPageToken().length() > 0);
//
//        Log.i("CHEOK", "yup!");
//        return result;
//    } 

}