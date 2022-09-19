import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Tree {
	public Tree (ArrayList <String> strList) throws IOException, NoSuchAlgorithmException
	{
		String str = "";
		int count = 0;
		for (String g : strList) {
			count++;
			str+= g;
			if (count<strList.size()) {
				str+="\n";
			}
		}
		
        MessageDigest md = MessageDigest.getInstance("SHA-1");

      
        byte[] messageDigest = md.digest(str.getBytes());

        BigInteger no = new BigInteger(1, messageDigest);

        String hashtext = no.toString(16);

        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("objects/"+hashtext));
        writer.write(str);
        writer.close();
        }
	public static void main (String[]args) throws NoSuchAlgorithmException, IOException {
		ArrayList<String> t = new ArrayList<String>();
		t.add("blob : 81e0268c84067377a0a1fdfb5cc996c93f6dcf9f");
		t.add("blob : 01d82591292494afd1602d175e165f94992f6f5f");
		t.add("blob : f1d82236ab908c86ed095023b1d2e6ddf78a6d83");
		t.add("tree : bd1ccec139dead5ee0d8c3a0499b42a7d43ac44b");
		t.add("tree : e7d79898d3342fd15daf6ec36f4cb095b52fd976");
		Tree ne = new Tree(t);
		
	}
}

