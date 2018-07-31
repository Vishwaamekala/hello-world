package ui.utility;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class WebServicesHelper {
	private static WebServicesHelper helperSingleInstance = null;
	public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String lower = upper.toLowerCase(Locale.ROOT);
	public static final String digits = "0123456789";
	public static final String alphanum = upper + lower + digits;
	private final Random random;
	private final char[] symbols;
	private final char[] buf;

	// static method to create instance of Singleton class
	public static WebServicesHelper getInstance() {
		if (helperSingleInstance == null)
			helperSingleInstance = new WebServicesHelper();
		return helperSingleInstance;
	}

	/** Random number generation for unique fields **/
	/*** Generate a random string. **/
	public String nextString() {
		for (int idx = 0; idx < buf.length; ++idx)
			buf[idx] = symbols[random.nextInt(symbols.length)];
		return new String(buf);
	}

	public WebServicesHelper(int length, Random random, String symbols) {
		if (length < 1)
			throw new IllegalArgumentException();
		if (symbols.length() < 2)
			throw new IllegalArgumentException();
		this.random = Objects.requireNonNull(random);
		this.symbols = symbols.toCharArray();
		this.buf = new char[length];
	}

	/** Create an alphanumeric string generator. */
	public WebServicesHelper(int length, Random random) {
		this(length, random, alphanum);
	}

	/** Create an alphanumeric strings from a secure generator. */
	public WebServicesHelper(int length) {
		this(length, new SecureRandom());
	}

	/** * Create session identifiers. */
	public WebServicesHelper() {
		this(21);
	}

	public String randomAlphaNumericString() {
		String easy = WebServicesHelper.digits + "ACEFGHJKLMNPQRUVWXY";
		WebServicesHelper tickets = new WebServicesHelper(7, new SecureRandom(), easy);
		String randomString = tickets.nextString();
		return randomString;
	}

	public String randomNumericString() {
		String easy = WebServicesHelper.digits;
		WebServicesHelper tickets = new WebServicesHelper(5, new SecureRandom(), easy);
		String randomString = tickets.nextString();
		return randomString;
	}

	public char[] generatePswd() {
		String charsCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Chars = "abcdefghijklmnopqrstuvwxyz";
		String nums = "0123456789";
		String symbols = "!@#$%^&*()_+-=.,/';:?><~*/-+";
		String passSymbols = charsCaps + Chars + nums + symbols;
		Random rnd = new Random();
		char[] password = new char[3];

		for (int i = 0; i < 3; i++) {
			password[i] = passSymbols.charAt(rnd.nextInt(passSymbols.length()));
		}
		return password;

	}

	/**
	 * * creating xpath for the elements which have absulte xpaths findings not
	 * * relative
	 **/
	public String xpathBuilder(int fieldIndex, String fieldBlock) {
		int addLeftElements[] = { 1, 2, 3, 4, 6 };
		int addRightElements[] = { 3, 4 };
		int genElements[] = { 1, 2, 6, 7 };
		int invoiceLeftElements[] = { 2, 3 };
		int invoiceRightElementsdiv1[] = { 1, 2, 3 };
		int paymentElements[] = { 1, 2, 3, 4, 5, 6, 7, 8, 13 };
		int shipmentElements[] = { 1, 2, 3 };
		int costCenterElements[] = { 3, 5, 10, 11, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
		int dealerSettingElements[] = { 1, 2, 3 };
		List<String> elementList = new ArrayList<>();
		if (fieldBlock.equals("AddressBlockLeft")) {
			for (int element : addLeftElements) {
				elementList
						.add("//div[@class='ms-nav-cardform part-autoheight-lastChild']/div[2]/div[2]/div[1]/div[1]/div[2]/div["
								+ element + "]/div[1]/input[1]");
			}
		} else if (fieldBlock.equals("AddressBlockRight")) {
			for (int element : addRightElements) {
				elementList
						.add("//div[@class='ms-nav-cardform part-autoheight-lastChild']/div[2]/div[2]/div[1]/div[2]/div[2]/div["
								+ element + "]/div[1]/input[1]");
			}
		} else if (fieldBlock.equals("GeneralBlock")) {
			for (int element : genElements) {
				if (element == 7) {
					elementList
							.add("//div[@class='ms-nav-cardform part-autoheight-lastChild']/div[1]/div[2]/div[1]/div["
									+ element + "]/div[1]/select[1]");
				} else {
					elementList
							.add("//div[@class='ms-nav-cardform part-autoheight-lastChild']/div[1]/div[2]/div[1]/div["
									+ element + "]/div[1]/input[1]");
				}
			}
		} else if (fieldBlock.equals("InvoiceBlockLeft")) {
			for (int element : invoiceLeftElements) {
				if (element == 3) {
					elementList
							.add("//div[@class='ms-nav-cardform part-autoheight-lastChild']/div[3]/div[2]/div[1]/div["
									+ element + "]/div[1]/select[1]");
				} else {
					elementList
							.add("//div[@class='ms-nav-cardform part-autoheight-lastChild']/div[3]/div[2]/div[1]/div["
									+ element + "]/div[1]/input[1]");
				}
			}

		} else if (fieldBlock.equals("InvoiceBlockRight")) {
			for (int element : invoiceRightElementsdiv1) {
				if (element == 2) {
					elementList
							.add("//div[@class='ms-nav-cardform part-autoheight-lastChild']/div[3]/div[2]/div[1]/div[6]/div[2]/div["
									+ element + "]/div[1]/input[1]");
				} else {
					elementList
							.add("//div[@class='ms-nav-cardform part-autoheight-lastChild']/div[3]/div[2]/div[1]/div[5]/div[2]/div["
									+ element + "]/div[1]/input[1]");
				}
			}
		} else if (fieldBlock.equals("PaymentBlock")) {
			for (int element : paymentElements) {
				if (element == 2 || element == 3 || element == 4) {
					elementList
							.add("//div[@class='ms-nav-cardform part-autoheight-lastChild']/div[4]/div[2]/div[1]/div["
									+ element + "]/div[1]/select[1]");
				} else {
					elementList
							.add("//div[@class='ms-nav-cardform part-autoheight-lastChild']/div[4]/div[2]/div[1]/div["
									+ element + "]/div[1]/input[1]");
				}
			}

		} else if (fieldBlock.equals("CostCenter")) {
			for (int element : costCenterElements) {
				elementList.add("//table[1]/tbody[1]/tr[1]/td[" + element + "]/input[1]");
			}

		} else if (fieldBlock.equals("dealerSetting")) {
			for (int element : dealerSettingElements) {
				elementList
						.add("//div[@class='ms-nav-cardform part-autoheight-lastChild ms-nav-noCommandBar']/div[1]/div[1]/div[1]/div[4]/div[2]/div["
								+ element + "]/div[1]/span[1]");
			}
		} else if (fieldBlock.equals("Shipment")) {
			for (int element : shipmentElements) {
				if (element == 2) {
					elementList
							.add("//div[@class='ms-nav-cardform part-autoheight-lastChild']/div[5]/div[2]/div[1]/div["
									+ element + "]/div[2]/div[1]/div[1]/input[1]");
				}
				elementList.add("//div[@class='ms-nav-cardform part-autoheight-lastChild']/div[5]/div[2]/div[1]/div["
						+ element + "]/div[1]/input[1]");
			}

		}
		return elementList.get(fieldIndex);
	}
}
