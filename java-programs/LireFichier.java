import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LireFichier {
    public static void main(String[] args) {
        String filePath = "/input/data.txt";
        
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://namenode:9000");
        
        try {
            FileSystem fs = FileSystem.get(conf);
            Path path = new Path(filePath);
            
            if (!fs.exists(path)) {
                System.out.println("❌ Le fichier n'existe pas : " + filePath);
                return;
            }
            
            System.out.println("📖 Contenu du fichier " + filePath + " :");
            System.out.println("==========================================");
            
            BufferedReader br = new BufferedReader(
                new InputStreamReader(fs.open(path))
            );
            
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(lineNumber + ". " + line);
                lineNumber++;
            }
            
            System.out.println("==========================================");
            System.out.println("✅ Lecture terminée avec succès!");
            
            br.close();
            fs.close();
            
        } catch (Exception e) {
            System.err.println("❌ Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
