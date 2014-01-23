package tester;
import java.util.regex.*;

public class RegexTest {
	public static void main(String[] args){
		String str = "(513)-379-3440";
		Pattern pattern = Pattern.compile("\\(?\\d\\d\\d\\)?-?\\d\\d\\d-?\\d\\d\\d\\d");
		
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()){
			System.out.println(matcher.group());
		}
		
		Matcher m2 = pattern.matcher(str);
		System.out.println(m2.replaceAll("asd"));
		
		System.out.println(str.replaceAll("\\(?\\d\\d\\d\\)?-?\\d\\d\\d-?\\d\\d\\d\\d","xyz"));
	}
}
