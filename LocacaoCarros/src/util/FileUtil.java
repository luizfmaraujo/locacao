package util;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

public class FileUtil {

	public String read(String nomeArquivo) throws Exception {
		File file = null;
        FileReader fr = null;
        LineNumberReader lnr = null;
        
		try {
			String caminhoArquivo = "/arquivos/Arquivo"+nomeArquivo;
			file = new File(getClass().getResource(caminhoArquivo).toURI());
			fr = new FileReader(file);
			lnr = new LineNumberReader(fr);

			String text = "";
			String line = "";
			
			while ((line = lnr.readLine()) != null) {
				text += line + "\n";
				
			}
            
			return text;
			
		} finally {
			
          if (fr != null) {
	          fr.close();
	      }
          
	      if (lnr != null) {
	          lnr.close();
	      }

		}
	}
}
