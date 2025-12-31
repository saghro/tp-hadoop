### Programme 1 : Lire un fichier HDFS

**Fichier** : `LireFichier.java`

**Fonctionnalité** : Lit le contenu d'un fichier depuis HDFS et l'affiche ligne par ligne.

**Chemin HDFS** : `/input/data.txt`

### Programme 2 : Écrire dans HDFS

**Fichier** : `EcrireFichier.java`

**Fonctionnalité** : Crée un nouveau fichier dans HDFS avec du contenu formaté et un timestamp.

**Chemin HDFS** : `/output/nouveau_fichier.txt`

### Compilation et Exécution

#### Dans le conteneur
```bash
# Entrer dans le conteneur
docker exec -it namenode bash

# Aller dans le répertoire
cd /opt/hadoop-java

# Définir CLASSPATH
export HADOOP_CLASSPATH=$(hadoop classpath)

# Compiler avec UTF-8
javac -encoding UTF-8 -classpath $HADOOP_CLASSPATH LireFichier.java
javac -encoding UTF-8 -classpath $HADOOP_CLASSPATH EcrireFichier.java

# Exécuter
java -classpath .:$HADOOP_CLASSPATH EcrireFichier
java -classpath .:$HADOOP_CLASSPATH LireFichier
```

#### Vérifier les résultats
```bash
# Lister les fichiers créés
hdfs dfs -ls /output/

# Afficher le contenu
hdfs dfs -cat /output/nouveau_fichier.txt
```

## 📊 Résultats Obtenus

### Exercice 1
✅ Toutes les commandes HDFS testées avec succès
- Création de répertoires
- Upload/Download de fichiers
- Manipulation (copie, déplacement, renommage)
- Gestion des permissions
- Diagnostics système

### Exercice 2
✅ Programmes Java fonctionnels
- **LireFichier.java** : Lecture réussie du fichier `/input/data.txt`
- **EcrireFichier.java** : Création réussie de `/output/nouveau_fichier.txt`

## 📸 Captures d'écran

Les captures d'écran sont disponibles dans le dossier `/screenshots/` :
- `1-docker-containers.png` : Conteneurs en cours d'exécution
- `2-hdfs-web-interface.png` : Interface web HDFS
- `3-hdfs-commands.png` : Exécution des commandes HDFS
- `4-java-compilation.png` : Compilation des programmes Java
- `5-java-execution.png` : Exécution des programmes Java

## 🛠️ Technologies Utilisées
- **Hadoop** : 3.2.1
- **Docker** : Desktop pour Mac
- **Java** : 1.8.0_232
- **OS** : macOS

## 📁 Structure du Projet

tp-hadoop/
├── README.md
├── docker-compose.yml
├── hadoop.env
├── data/
│   ├── data.txt
│   └── downloaded_from_hdfs.txt
├── java-programs/
│   ├── LireFichier.java
│   ├── EcrireFichier.java
│   ├── LireFichier.class
│   └── EcrireFichier.class
├── screenshots/
│   ├── 1-docker-containers.png
│   ├── 2-hdfs-web-interface.png
│   ├── 3-hdfs-commands.png
│   ├── 4-java-compilation.png
│   └── 5-java-execution.png
└── docs/
└── TP_hadoop.docx
## 🔧 Dépannage

### Problème : Les conteneurs ne démarrent pas
```bash
docker-compose down
docker-compose up -d
docker ps
```

### Problème : Erreur de compilation Java
Utilisez l'option `-encoding UTF-8` :
```bash
javac -encoding UTF-8 -classpath $HADOOP_CLASSPATH LireFichier.java
```

### Problème : Impossible d'accéder à l'interface web
Vérifiez que le port 9870 n'est pas utilisé :
```bash
lsof -i :9870
```

## 📚 Ressources
- [Documentation Hadoop](https://hadoop.apache.org/docs/r3.2.1/)
- [HDFS Commands Guide](https://hadoop.apache.org/docs/r3.2.1/hadoop-project-dist/hadoop-common/FileSystemShell.html)
- [Hadoop Java API](https://hadoop.apache.org/docs/r3.2.1/api/)

## 🎓 Conclusion
Ce TP a permis de :
1. Maîtriser les commandes HDFS de base
2. Comprendre l'architecture distribuée de Hadoop
3. Développer des applications Java pour interagir avec HDFS
4. Utiliser Docker pour un environnement Hadoop isolé

## 👤 Auteur
Ayoub SAGHRO - ayoub_saghro@um5.ac.ma

## 📄 Licence
Ce projet est réalisé dans le cadre d'un TP académique.