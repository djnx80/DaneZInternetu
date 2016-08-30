import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;
 
class PobierzDane {
 
 public static void main(String[] args) throws Exception {
	 // przyk³adowy adres
	 String urlString = "http://www.mini.pw.edu.pl/MiNIwyklady/index.html";
	 readAndSaveFromURL(new URL(urlString));
	 System.exit(0);
 }
  
 static void readAndSaveFromURL(URL url) throws Exception {
	 System.out.println("Odczytuje dane ze strony:\n" + url);
	 // zwraca InputStream zwi¹zany z URLem
	 BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
 
	 String filename = null;
	 // zwraca nazwê pliku dla URLa i odcinamy domene pobieramu uri
	 StringTokenizer st = new StringTokenizer(url.getFile(), "/");
	// pobieramy nazwê pliku pod któr¹ ma byæ zachowany
	 while (st.hasMoreTokens()) filename = st.nextToken(); 
	 if(filename == null){
		//jesli filename okaze sie nullem to nazwa=index.html
		 filename = "index.html"; 
	 }
 
	 BufferedWriter out = new BufferedWriter(new FileWriter(filename));
 
	//odczyt ze strumienia i zapis do pliku
	 String s;
	 while ((s = in.readLine()) != null) {
         out.write(s);
         out.newLine();
	 }
	 // pozamykaj pliki
	 in.close();
	 out.close();
 }

}