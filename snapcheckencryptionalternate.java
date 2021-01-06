import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class snapcheckencryptionalternate {
	public static final UnaryOperator<String> removeWhiteSpace =
            str -> str.codePoints()
                    .boxed()
                    .filter(code -> !Character.isWhitespace((char)code.intValue()))
                    .collect(Collector.of(
                            () -> new String[] {""},
                            (result, item) -> result[0] += (char) item.intValue(),
                            (r1, r2) ->  {
                                r1[0] += r2[0];
                                return r1; },
                            r -> r[0]));


	public static void main(String[] args)  {
		try {
			System.out.println(encrypt(args[0]));
			System.out.println(decrypt(encrypt(args[0])));
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("You did not provide text to be encrypted.");
		}
	}

	public static String encrypt(String s) {
		String encrypted = s.transform(removeWhiteSpace);
		double lengthRoot = Math.sqrt(encrypted.length());
		int rows = (int)Math.floor(lengthRoot);
		int cols = (int)Math.ceil(lengthRoot);

		StringBuilder encryptedString = new StringBuilder();
		for (int i = 0; i < cols; i++) {
			for (int j = i; j < encrypted.length(); j+= cols) {
				encryptedString.append(encrypted.charAt(j));
			}
			encryptedString.append(" ");
		}

		return encryptedString.toString();
	}

	public static String decrypt(String s) {
		String encrypted = s.transform(removeWhiteSpace);
		double lengthRoot = Math.sqrt(encrypted.length());
		int rows = (int)Math.floor(lengthRoot);
		int cols = (int)Math.ceil(lengthRoot);

		String[] tokens = s.split(" ");
		
		StringBuilder encryptedString = new StringBuilder();
		for (int j = 0; j < cols; j++)
		for (int i = 0; i < tokens.length; i++) {
			try {
				encryptedString.append(tokens[i].charAt(j));
			} catch (StringIndexOutOfBoundsException ex) {}
		}

		return encryptedString.toString();
	}
}
