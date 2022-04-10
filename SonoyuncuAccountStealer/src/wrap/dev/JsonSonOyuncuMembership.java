package wrap.dev;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import java.nio.charset.Charset;
import org.apache.commons.codec.binary.Base64;

public class JsonSonOyuncuMembership {
    @Expose
    private String membershipType;
    @Expose
    private String sonOyuncuUsername;
    @Expose
    private String sonOyuncuPassword;

    public JsonSonOyuncuMembership(String username, String password) {
        this.membershipType = MemberShipType.SONOYUNCU.getStrTpye();
        this.sonOyuncuUsername = username;
        this.sonOyuncuPassword = Base64.encodeBase64String(password.getBytes(Charset.forName("UTF-8")));
    }

    public JsonSonOyuncuMembership(String nickname) {
        this.membershipType = MemberShipType.UNKOWN.getStrTpye();
        this.sonOyuncuUsername = "";
        this.sonOyuncuPassword = "";
    }

    public JsonSonOyuncuMembership(Membership membership) {
        this.membershipType = membership.getMemberShipType() == null ? MemberShipType.UNKOWN.getStrTpye() : membership.getMemberShipType().getStrTpye();
        this.sonOyuncuUsername = membership.y() == null ? "" : membership.y();
        this.sonOyuncuPassword = membership.d() == null ? "" : Base64.encodeBase64String(membership.d().getBytes(Charset.forName("UTF-8")));
    }

    public MemberShipType getMembershipType() {
        if (this.membershipType == null || this.membershipType.isEmpty()) {
            return MemberShipType.SONOYUNCU;
        }
        return MemberShipType.getMemberShipType(this.membershipType);
    }

    public String getSonOyuncuUsername() {
        if (this.sonOyuncuUsername == null || this.sonOyuncuUsername.isEmpty()) {
            return "";
        }
        return this.sonOyuncuUsername;
    }

    public String getEncodedSonOyuncuPassword() {
        if (this.sonOyuncuPassword == null || this.sonOyuncuPassword.isEmpty()) {
            return "";
        }
        return this.sonOyuncuPassword;
    }

    public String getDecodedSonOyuncuPassword() {
        if (this.sonOyuncuPassword == null || this.sonOyuncuPassword.isEmpty()) {
            return "";
        }
        return new String(Base64.decodeBase64(this.sonOyuncuPassword), Charset.forName("UTF-8"));
    }

    public JsonObject toJsonObject() {
        JsonObject obj = new JsonObject();
        obj.addProperty("membershipType", this.membershipType);
        obj.addProperty("sonOyuncuUsername", this.sonOyuncuUsername);
        obj.addProperty("sonOyuncuPassword", this.sonOyuncuPassword);
        return obj;
    }

    public static JsonSonOyuncuMembership fromJsonElement(JsonElement elem) {
        if (elem == null || !elem.isJsonObject()) {
            return null;
        }
        JsonObject obj = elem.getAsJsonObject();
        JsonSonOyuncuMembership mem = new JsonSonOyuncuMembership((String)null);
        mem.membershipType = obj.get("membershipType").getAsString();
        mem.sonOyuncuUsername = obj.get("sonOyuncuUsername").getAsString();
        mem.sonOyuncuPassword = obj.get("sonOyuncuPassword").getAsString();
        return mem;
    }
}
