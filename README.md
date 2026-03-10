# Exercices Java Streams

Projet d'apprentissage et de pratique des concepts modernes de Java, avec un accent particulier sur les Streams, les expressions Lambda, les Optional et les Records.

## 📋 Description

Ce dépôt contient une collection d'exercices pratiques pour maîtriser les fonctionnalités Java modernes introduites depuis Java 8. Le projet est structuré en plusieurs modules thématiques permettant une progression graduelle dans l'apprentissage.

## 🎯 Objectifs pédagogiques

- Maîtriser les **expressions Lambda** et les références de méthodes
- Comprendre et utiliser efficacement les **Java Streams**
- Manipuler les **Optional** pour gérer les valeurs nulles
- Utiliser les **Records** pour créer des classes de données immutables
- Pratiquer la programmation fonctionnelle en Java

## 🛠️ Prérequis

- Java 17 ou supérieur
- Maven 3.x
- Un IDE Java (IntelliJ IDEA, Eclipse, VS Code)

## 📦 Dépendances

- **Lombok** 1.18.34 - Réduction du code boilerplate

## 🏗️ Structure du projet

```
src/main/java/sbp/
├── lambda/               # Exercices sur les expressions lambda
│   ├── concepts/        # Concepts et exemples
│   └── exercices/       # Exercices pratiques
├── stream/              # Exercices sur les Java Streams
│   ├── concepts/        # Explications et démonstrations
│   └── exercices/       # Exercices simples et complexes
│       ├── simple/      # Exercices d'introduction
│       └── complexe/    # Exercices avancés
│           ├── exo1/    # Manipulation de listes de personnes et animaux
│           └── exo2/    # Analyse de données climatiques régionales
├── optional/            # Exercices sur les Optional
│   ├── concepts/        # Théorie et explications
│   └── exercice/        # Exercices pratiques
├── record/              # Concepts sur les Records Java
└── mob/                 # Exercices de programmation en groupe
    └── bonbonV2/        # Gestion de magasin de bonbons
```

## 📚 Modules d'apprentissage

### 1. Lambda (sbp.lambda)

Apprentissage progressif des expressions lambda :
- Transformation de boucles en forEach
- Utilisation de lambda pour filtrer et transformer
- Références de méthodes
- **9 exercices progressifs** sur les fruits, nombres et prénoms

### 2. Streams (sbp.stream)

#### Exercices simples
- Comptage et filtrage avec `filter()` et `count()`
- Élimination des doublons avec `distinct()`
- Transformation avec `map()`
- Aplatissement de listes imbriquées avec `flatMap()`

#### Exercices complexes

**Exo 1 - Gestion de personnes et animaux**
- Filtrage par âge, sexe et critères multiples
- Calculs de sommes et statistiques
- Groupement avec `Collectors.groupingBy()`
- Extraction et manipulation d'objets imbriqués
- Calcul d'impôts avec conditions complexes

**Exo 2 - Analyse de données climatiques**
- Traitement de données météo sur 3 années (2022-2024)
- 9 régions françaises (Bretagne, Corse, IDF, etc.)
- Analyse de températures et précipitations

### 3. Optional (sbp.optional)

Gestion sécurisée des valeurs nulles :
- Utilisation de `Optional.ofNullable()`
- Méthodes `orElse()`, `orElseGet()`, `orElseThrow()`
- Filtrage et transformation avec `filter()` et `map()`
- Exercices sur la gestion d'utilisateurs

### 4. Records (sbp.record)

Introduction aux classes de données immutables avec les Records Java.

### 5. Mob Programming (sbp.mob)

Exercices de programmation en groupe :
- **FizzBuzz** - Exercice classique
- **Gestion de magasin de bonbons** - Application complète avec stock et ventes

## 🚀 Utilisation

### Compilation

```bash
mvn clean compile
```

### Exécution d'un exercice

```bash
mvn exec:java -Dexec.mainClass="sbp.lambda.exercices.Exo1"
```

Ou lancez directement depuis votre IDE en exécutant la méthode `main()` de l'exercice souhaité.

## 💡 Conseils d'apprentissage

1. **Suivez l'ordre** : Commencez par les lambda, puis les streams simples, avant d'aborder les exercices complexes
2. **Lisez les concepts** : Chaque module contient des classes d'explications dans le package `concepts/`
3. **Testez vos solutions** : Les exercices complexes incluent une validation automatique
4. **Expérimentez** : N'hésitez pas à modifier et tester différentes approches

## 🎓 Niveau de difficulté

- 🟢 **Débutant** : `lambda/exercices`, `stream/exercices/simple`
- 🟡 **Intermédiaire** : `optional/exercice`, `stream/exercices/complexe/exo1`
- 🔴 **Avancé** : `stream/exercices/complexe/exo2`, calculs d'impôts réalistes

## 📄 Licence

Projet éducatif à des fins d'apprentissage.

## 👨‍💻 Auteur

Projet de formation Java - Exercices Streams et concepts modernes
