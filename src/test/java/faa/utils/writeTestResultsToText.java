package faa.utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writeTestResultsToText {

		private static final String FILENAME = "C:\\Users\\jfrankl6\\Tools\\TestResults\\JayTestResults.txt";

		public static void main(String[] args) {

			BufferedWriter bw = null;
			FileWriter fw = null;

			try {

				String data = "This is new content";

				File file = new File(FILENAME);

				// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				// true = append file
				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);
				bw.append(data);
				bw.append('\n');
				//bw.write(data);

				System.out.println("Done");

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}
			}

		}

	}
	
	
//}
