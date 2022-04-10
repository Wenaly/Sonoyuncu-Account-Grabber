package wrap.dev;

public enum MemberShipType {
	UNKOWN("unkown"),
	SONOYUNCU("sonoyuncu");
	
	private String strType;

    private MemberShipType(String string2) {
        this.strType = string2;
    }

    public String getStrTpye() {
        return this.strType;
    }

    public static MemberShipType getMemberShipType(String string) {
        MemberShipType[] paArray = MemberShipType.values();
        int n = 0;
        while (n < paArray.length) {
            MemberShipType pa2 = paArray[n];
            if (pa2.getStrTpye().equalsIgnoreCase(string)) {
                return pa2;
            }
            ++n;
        }
        return UNKOWN;
    }
	
}
