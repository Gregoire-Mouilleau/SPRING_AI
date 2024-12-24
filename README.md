# SPRING AI Chatbot

Ce projet est une application Spring Boot intégrant l'API d'Ollama pour créer un chatbot interactif capable de répondre à des messages tout en conservant un historique de conversation. Ce chatbot illustre l'utilisation de **design patterns** et de bonnes pratiques dans une architecture en couches.

---

## Fonctionnalités

- **Architecture en couches** : séparation des responsabilités entre contrôleurs, services et repositories pour une meilleure maintenabilité.
- **Gestion de l'historique des conversations** : l'IA peut suivre une conversation en gardant en mémoire les échanges précédents.
- **Persistance des données** : les messages envoyés et reçus sont stockés dans une base de données pour un suivi des interactions.

---

## Technologies utilisées

- **Spring Boot** 3.3.4
- **JPA** pour la gestion des entités et des interactions avec la base de données.
- **H2 Database** pour le stockage des données en mémoire.
- **API Ollama** pour la génération des réponses de l'IA.

---

## Prérequis

- Java 17+
- Gradle

---

## Installation et démarrage

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/Gregoire-Mouilleau/SPRING_AI.git
   cd SPRING_AI
   ```

2. Compilez et démarrez l'application :
   ```bash
   ./gradlew clean bootRun
   ```

3. L'application sera accessible sur `http://localhost:8080`.

---

## Utilisation

### API Endpoints

#### 1. **Démarrer une conversation**
   - **Endpoint** : `POST /api/conversations/start`
   - **Body** :
     ```json
     {
       "personality": "friendly"
     }
     ```
   - **Réponse** : Retourne une clé unique pour identifier la conversation.

#### 2. **Envoyer un message à l'IA**
   - **Endpoint** : `POST /api/conversations/{conversationId}/messages`
   - **Body** :
     ```json
     {
       "message": "Hello, how are you?"
     }
     ```
   - **Réponse** : L'IA répond et l'échange est enregistré en base de données.

---

## Tester avec Postman

1. Importez les endpoints dans Postman.
2. Suivez ces étapes :
   - Démarrez une conversation via `POST /api/conversations/start`.
   - Utilisez la clé retournée pour envoyer des messages à l'IA via `POST /api/conversations/{conversationId}/messages`.

---

## Déploiement sur GitHub

1. Initialisez un dépôt :
   ```bash
   git init
   git remote add origin https://github.com/Gregoire-Mouilleau/SPRING_AI.git
   ```

2. Ajoutez et poussez votre code :
   ```bash
   git add .
   git commit -m "Initial commit"
   git push -u origin main
   ```

---

## Points à améliorer

- Ajouter des tests unitaires pour garantir la stabilité de l'application.
- Intégrer une base de données relationnelle comme MySQL pour un stockage persistant.
- Déployer l'application sur une plateforme cloud comme Heroku ou AWS.

---

## Auteur

- **Grégoire Mouilleau**  
  Étudiant en troisième année à l'EPSI Bordeaux, passionné par le développement web et logiciel.
