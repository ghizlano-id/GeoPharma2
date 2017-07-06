<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="carousel" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="principalHeader" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="principalFooter" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html >
<html>
<head>

<title>Page acceuil</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
		<principalHeader:principalHeader/>

	
	
	<div class="container">
	
	 
	 	<carousel:carousel/>
	 
	 
	   <div class="col-md-9 col-md-offset-1">
	  	<div class="panel  page">
			<div class="panel-body">
			<h3> POURQUOI ACHETER SUR INTERNET PLUTÔT QU'EN OFFICINE ?</h3>
				On peut légitimement se poser la question ! En effet, en cas de mal de crâne, mieux vaut se rendre dans l'officine la plus proche plutôt que d'attendre quelques jours pour se faire livrer un anti-douleur !<br/>
				En pratique, la pharmacie en ligne présente plusieurs avantages :<br>
				<strong>- Certaines personnes ne peuvent se déplacer</strong>, ou habitent dans un désert médical. Internet garantit à ces patients l'accès à l'automédication, 
				de chez eux. Ces situations ne sont pas rares et vont se multiplier : tous les 2 à 3 jours, une pharmacie ferme en France !<br>
				<strong>-L'achat en ligne permet aussi une confidentialité totale</strong>, qui n'est pas toujours garantie au comptoir de la pharmacie. Nombreux sont les patients qui n'osent pas s'adresser à leur 
				pharmacien de quartier en cas de pathologie qu'ils estiment honteuse, comme les hémorroïdes. Pour ces personnes, Internet permet d'accéder au médicament sans se sentir gêné !<br>
				<strong>-Internet offre une ergonomie qui facilite le choix du bon médicament</strong> : en quelques clics, il est très facile de trouver le médicament adapté à un symptôme, une personne (en fonction de son âge), 
				et sous une forme ou un autre (comprimé, sachets à diluer...)<br>
			</div>
	   </div>
	  	<div class="panel  page">
			<div class="panel-body">
			<h3 >QUELS MÉDICAMENTS PEUT-ON ACHETER SUR INTERNET ? </h3>
				Seuls les médicaments en <strong>accès direct</strong> peuvent être vendus sur internet. La liste des médicaments en accès direct est définie par l'Agence Nationale de la Sécurité du Médicament et des produits de santé. 
				Il s'agit toujours de <strong>médicaments sans ordonnance</strong>, pouvant être achetés et utilisés de manière autonome par le patient, dans le cadre d'une auto-médication responsable.
			</div>
	   </div>
      </div>

  <div class="container">
   	<div class="col-md-4">
     	<div class="panel panel-success">
     		<div class="panel-body">
     		 <img style="height:80px;width: 240px;" alt="image" src="resources/img/ordre-national-ph.png"/>
     		</div>
     	</div>
     </div >
     <div class="col-md-2">
     	<div class="panel panel-danger">
     		<div class="panel-body">
     		 <img style="height:80px; width: 100px;"  alt="image" src="resources/img/assurance.jpg" style="width: 130px;"/>
     		</div>
     	</div>
     </div >
     <div class="col-md-3">
     	<div class="panel panel-primary">
     		<div class="panel-body">
     		 <img style="height:80px; max-width: 180px;"  alt="image" src="resources/img/ministere-sante.jpg"/>
     		</div>
     	</div>
     </div>
     <div class="col-md-2">
     	<div class="panel panel-success">
     		<div class="panel-body">
     		 <img style="height:80px; width: 100px;"  alt="image" src="resources/img/amip.png" />
     		</div>
     	</div>
     </div>
   </div> 
  </div>

    
    <principalFooter:principalFooter/>
   
</body>
</html>