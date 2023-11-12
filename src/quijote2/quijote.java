package quijote2;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class quijote {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		FileReader fr;
		fr = new FileReader("./src/quijote2/Quijote2.txt");

		try {
			int i = fr.read();
//			while(i=fr.read!=-1) {}
			while(i!=-1){
				System.out.print((char)i);
				i=fr.read();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}

}
