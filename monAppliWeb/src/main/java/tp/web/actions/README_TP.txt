A faire en Tp pour s'entrainer:

calcul de mensualit� d'emprunt:

emprunt_input.jsp
emprunt_result.jsp

EmpruntAction.java

--------
� saisir:
  nbMois (dur�e , exemple 120 pour 10 ans)
  taux (taux int�ret annuel , ex: 1 pour 1% par an)
  montant (montant � emprunter et � rembouser)
  
formule de calcul:
tauxMensuel = taux / 12 / 100
mensualite =  montant * tauxMensuel / ( 1 - Math.pow(1+tauxMensuel,-nbMois))  