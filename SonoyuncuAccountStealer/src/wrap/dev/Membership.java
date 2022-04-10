package wrap.dev;

public class Membership {
	   private MemberShipType typeShip;
	    private String qjn;
	    private String qjm;
	    private String qjr;

	    public Membership(String string, String string2) {
	        this.typeShip = MemberShipType.SONOYUNCU;
	        this.qjn = string;
	        this.qjm = string2;
	        this.qjr = null;
	    }

	    public Membership(String string) {
	        this.typeShip = MemberShipType.UNKOWN;
	        this.qjr = string;
	        this.qjn = null;
	        this.qjm = null;
	    }

	    public MemberShipType getMemberShipType() {
	        return this.typeShip;
	    }

	    public String y() {
	        return this.qjn;
	    }

	    public String d() {
	        return this.qjm;
	    }

	    public String c() {
	        return this.qjr;
	    }
}
