## Rapport

 # Instruction

le port d'ecoute dans le fichier RestServer.java a été changé .
Nous avons utilisé le port 8081 pour eviter certains conflits sur notre machine

la base de donnée utilisé est une base de donnée mysql qui se nomme tp_jpa avec pour indentifiant de connection
 utilisateur = root
 mdp = ""

 # Routes disponibles


        **fiche**
                1- localhost:8081/fiche  : voir la liste des fiches
                2- localhost:8081/fiche/{ficheId}:  retrouver une fiche grace a son Id
                3- localhost:8081/fiche/delete/{ficheId} : suprimer la fiche qui a l'Id ficheId
                4- localhost:8081/fiche/creation : créer une fiche
                5- localhost:8081/fiche/modif/{ficheId} : modifier la fiche qui a l'id ficheId

        **user**
                1- localhost:8081/user  : voir la liste des users
                2- localhost:8081/user/{userId}:  retrouver une user grace a son Id
                3- localhost:8081/user/delete/{userId} : suprimer la user qui a l'Id userId
                4- localhost:8081/user/creation : créer une user
                5- localhost:8081/user/modif/{userId} : modifier la user qui a l'id userId
                
        **section**
                1- localhost:8081/section  : voir la liste des sections
                2- localhost:8081/section/{sectionId}:  retrouver une section grace a son Id
                3- localhost:8081/section/delete/{sectionId} : suprimer la section qui a l'Id sectionId
                4- localhost:8081/section/creation : créer une section 
                5- localhost:8081/section/modif/{sectionId} : modifier la section qui a l'id sectionId
                
        **tag**
                1- localhost:8081/tag  : voir la liste des tags
                2- localhost:8081/tag/{tagId}:  retrouver une tag grace a son Id
                3- localhost:8081/tag/delete/{tagId} : suprimer la tag qui a l'Id tagId
                4- localhost:8081/tag/creation : créer une tag 
                5- localhost:8081/tag/modif/{tagId} : modifier la tag qui a l'id tagId


 # Acquis et Problemes

            De maniere individuel le back et le front fonctionne tres bien chaque routes a été testé.
            Nous avons donc appris à creer une base de donné via jpa et appris a utilisé jaxrs.

            Comme difficulté nous avons eu du mal a gerer les probleme de Cors. L'utilisation de proxy avec vuesJs a été difficile et la methode qu'on a trouvé qui marchait un temps soit peu nous redirigeait directement sur notre server sans passer par notre front
            On aimerait donc si possible avoir un retour de votre part pour expliquer et/ou montrer ce qu'on aurait du faire pour resoudre efficacement ce probleme. ce la nous sera tres utile tout au long de notre cursus



