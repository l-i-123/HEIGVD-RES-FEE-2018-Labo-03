# Introduction

Dans le cadre du laboratoire de RES sur la communication SMTP on a eu le plaisir d'implémenter un client SMTP pouvant faire des blagues en forgeant des mails.



# Fonctionnement du programme

Ce programme permet d'envoyer des mails à une liste de victimes séparées par groupe. Chaque groupe est composé d'au moins deux destinataires et recevra le même message.

Les émetteurs de ces mails sont eux-même des victimes puisque qu'ils ne sont pas les vrais émetteur de ces mails.

# Configuration

- Après avoir cloné notre projet (`git clone https://github.com/l-i-123/HEIGVD-RES-FEE-2018-Labo-03.git`)
- Vous trouverez dans le dossier config un fichier "messages.txt" contenant la liste des messages. Il faut noter que chacun de ces messages est séparé par la chaine "===".
- De même un fichier "victims_recipient.txt" contenant la liste des victimes.
- Il y a aussi un fichier "witness_recipient.txt" contenant les adresses mails à mettre en copie des mails.
- Finalement, il y a un fichier "config.properties" contenant l'adresse ip et le numéro de port du serveur SMTP ainsi que le nombre de groupes à créer.

#### Lancement du serveur mock smtp

Pour lancer le serveur mock, afin d'éviter les ennuis, il suffit d'utiliser la commande suivante

`java -jar MockMock.jar -p 25 -h 8282`