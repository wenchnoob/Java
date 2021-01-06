import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class snapcheckencryption {
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
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("You did not provide text to be encrypted.");
		}
	}

	public static String encrypt(String s) {
		String encrypted = s.transform(removeWhiteSpace);
		double lengthRoot = Math.sqrt(encrypted.length());
		int rows = (int)Math.floor(lengthRoot);
		int cols = (int)Math.ceil(lengthRoot); 

		char[][] encryptionArr = new char[rows][cols];
		fillArr(encrypted, encryptionArr);

		StringBuilder encryptedString = new StringBuilder();
		buildEncryption(encryptionArr, encryptedString);

		return encryptedString.toString();
	}

	public static void fillArr(String src, char[][] target) {
		int cols = target[0].length;
		for (int i = 0; i < src.length(); i++) target[i/cols][i%cols] = src.charAt(i);
	}

	public static void buildEncryption(char[][] src, StringBuilder target) {
		for (int i = 0; i < src[0].length; i++) {
			for (int j = 0; j < src.length; j++) target.append(src[j][i]);
			target.append(" ");
		}
	}
}