# TP Hadoop avec Docker

## 👨‍🎓 Informations
- **Nom**: [Votre Nom]
- **Classe**: [Votre Classe]
- **Date**: 31 Décembre 2025
- **Sujet**: Travaux Pratiques Hadoop - Commandes HDFS et Programmation Java

## 📋 Description
Ce projet contient le TP Hadoop réalisé avec Docker, incluant :
- Exercice 1 : Manipulation des commandes HDFS
- Exercice 2 : Programmes Java pour lire et écrire dans HDFS

## 🐳 Prérequis
- Docker Desktop installé
- Au moins 4GB de RAM allouée à Docker

## 🚀 Installation et Démarrage

### 1. Cloner le projet
```bash
git clone https://github.com/[VotreUsername]/tp-hadoop.git
cd tp-hadoop
```

### 2. Lancer Hadoop
```bash
docker-compose up -d
```

### 3. Vérifier que les conteneurs sont lancés
```bash
docker ps
```

Vous devriez voir 2 conteneurs : `namenode` et `datanode`

### 4. Accéder à l'interface web
Ouvrez votre navigateur : **http://localhost:9870**

## 📝 Exercice 1 : Commandes HDFS

### Entrer dans le conteneur
```bash
docker exec -it namenode bash
```

### Commandes principales testées

#### Création de répertoires
```bash
hdfs dfs -mkdir /input
hdfs dfs -mkdir /user
hdfs dfs -mkdir /user/hadoop
```

#### Upload de fichier
```bash
hdfs dfs -put /data/data.txt /input/
```

#### Affichage
```bash
# Afficher le contenu
hdfs dfs -cat /input/data.txt

# Premières lignes
hdfs dfs -cat /input/data.txt | head -n 2

# Dernières lignes
hdfs dfs -cat /input/data.txt | tail -n 2
```

#### Copie et déplacement
```bash
# Créer backup
hdfs dfs -mkdir /backup
hdfs dfs -cp /input/data.txt /backup/data.txt

# Déplacer
hdfs dfs -mkdir /output
hdfs dfs -mv /backup/data.txt /output/data.txt

# Renommer
hdfs dfs -mv /output/data.txt /output/data_renamed.txt
```

#### Statistiques
```bash
# Compter lignes, mots, caractères
hdfs dfs -cat /input/data.txt | wc

# Taille du fichier
hdfs dfs -du -h /input/

# Test d'existence
hdfs dfs -test -e /input/data.txt && echo "Existe" || echo "N'existe pas"
```

#### Permissions
```bash
# Modifier permissions
hdfs dfs -chmod 755 /input/data.txt

# Voir les permissions
hdfs dfs -ls /input/
```

#### Téléchargement
```bash
# Vers le conteneur
hdfs dfs -get /input/data.txt /tmp/downloaded.txt

# Vers le volume partagé
hdfs dfs -get /input/data.txt /data/downloaded_from_hdfs.txt
```

#### Diagnostics
```bash
# Santé du système
hdfs dfsadmin -report

# Informations sur les blocs
hdfs fsck /input/data.txt -files -blocks -locations

# Configuration
hdfs getconf -confKey fs.defaultFS
```

#### Nettoyage
```bash
# Supprimer fichier
hdfs dfs -rm /output/data_renamed.txt

# Supprimer répertoire

hdfs dfs -rm -r /backup/
```

## 💻 Exercice 2 : Programmes Java

### Structure des programmes
