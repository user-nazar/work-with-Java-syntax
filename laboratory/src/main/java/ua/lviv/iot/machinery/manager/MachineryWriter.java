package ua.lviv.iot.machinery.manager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
 
public class MachineryWriter {
	public void writeToFile(LinkedList<Machinery> machinery) {
        File file;
     

       file = new File(("C:\\Users\\nazarcomp\\projects"), "5lab.csv"); 
      
         file.setWritable(true);
       if (!file.exists()) {
           try {
                file.createNewFile();
           } catch (IOException e) {
               e.printStackTrace();
            }
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
        	e.printStackTrace();
        }

        try {
        	fileWriter.write(machinery.get(0).getHeaders()+"\n");
            for (Machinery mach: machinery) {
            fileWriter.write(mach.toCSV()+"\n");
            }
           
          
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                } catch (IOException e) {
                	e.printStackTrace();
            }
            }

    }
}
