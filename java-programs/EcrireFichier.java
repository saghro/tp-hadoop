import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EcrireFichier {
    public static void main(String[] args) {
        String filePath = "/output/nouveau_fichier.txt";
        
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://namenode:9000");
        
        try {
            FileSystem fs = FileSystem.get(conf);
            Path path = new Path(filePath);
            
            System.out.println("✍️  Écriture dans " + filePath + "...");
            
            BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(fs.create(path, true))
            );
            
            // Obtenir la date actuelle
            String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            
            // Écrire du contenu
            bw.write("===========================================\n");
            bw.write("  FICHIER CRÉÉ AVEC JAVA ET HADOOP\n");
            bw.write("===========================================\n");
            bw.write("Date de création : " + timestamp + "\n");
            bw.write("-------------------------------------------\n");
            bw.write("Ligne 1: Hello Hadoop depuis Java!\n");
            bw.write("Ligne 2: Big Data Processing\n");
            bw.write("Ligne 3: HDFS File System\n");
            bw.write("Ligne 4: Docker Container\n");
            bw.write("Ligne 5: Apache Hadoop 3.2.1\n");
            bw.write("===========================================\n");
            
            bw.close();
            fs.close();
            
            System.out.println("✅ Fichier écrit avec succès!");
            System.out.println("📁 Emplacement : " + filePath);
            
        } catch (Exception e) {
            System.err.println("❌ Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
