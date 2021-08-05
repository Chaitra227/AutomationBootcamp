package utility;

public class Test_POJO {
	private String username;
	private String password;
	private String PTN;
	private String cardName;
	private String cardNumber;
	private String expDate;
	private String CVV;
	private String testMethod;
	
//	public Test_POJO(String testMethod, String username, String password, String PTN,String cardName, String cardNumber, String expDate, String CVV) {
//		this.testMethod=testMethod;
//		this.username=username;
//		this.password=password;
//		this.PTN=PTN;
//		this.cardName=cardName;
//		this.cardNumber=cardNumber;
//		this.expDate=expDate;
//		this.CVV=CVV;
//	}
	
	public String getMethodName() {
		return testMethod;
	}
	
	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getTestMethod() {
		return testMethod;
	}

	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPTN(String pTN) {
		PTN = pTN;
	}

	public void setCVV(String cVV) {
		CVV = cVV;
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
