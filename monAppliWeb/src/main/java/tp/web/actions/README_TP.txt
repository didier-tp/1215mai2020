A faire en Tp pour s'entrainer:

calcul de mensualité d'emprunt:

emprunt_input.jsp
emprunt_result.jsp

EmpruntAction.java

--------
à saisir:
  nbMois (durée , exemple 120 pour 10 ans)
  taux (taux intéret annuel , ex: 1 pour 1% par an)
  montant (montant à emprunter et à rembouser)
  
formule de calcul:
tauxMensuel = taux / 12 / 100
mensualite =  montant * tauxMensuel / ( 1 - Math.pow(1+tauxMensuel,-nbMois))  