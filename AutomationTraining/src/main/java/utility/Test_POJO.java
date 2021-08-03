package utility;

public class Test_POJO {
	private String username;
	private String password;
	private String PTN;
	private String cardName;
	private String cardNumber;
	private String expDate;
	private String CVV;
	
	public Test_POJO(String username, String password, String PTN,String cardName, String cardNumber, String expDate, String CVV) {
		this.username=username;
		this.password=password;
		this.PTN=PTN;
		this.cardName=cardName;
		this.cardNumber=cardNumber;
		this.expDate=expDate;
		this.CVV=CVV;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPTN() {
		return PTN;
	}

	public String getcardName() {
		return cardName;
	}

	public String getcardNumber() {
		return cardNumber;
	}

	public String getexpDate() {
		return expDate;
	}

	public String getCVV() {
		return CVV;
	}
}
