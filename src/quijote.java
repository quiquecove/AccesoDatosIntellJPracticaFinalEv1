import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class quijote {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader fr;
		fr = new FileReader("b.txt");

		try {
			int i = fr.read();
			while(i!=-1){
				System.out.println((char)i);
				i=fr.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}

}
