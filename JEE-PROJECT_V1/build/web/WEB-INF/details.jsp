<%-- 
    Document   : details
    Created on : 25 nov. 2019, 13:02:51
    Author     : dahak
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!------ Include the above in your HEAD tag ---------->

<!doctype html>
<link rel="stylesheet" href="http://www.iut-fbleau.fr/css/concise.min.css">
	<link rel="stylesheet" href="http://www.iut-fbleau.fr/css/concise-utils/concise-utils.min.css">
	<link rel="stylesheet" href="http://www.iut-fbleau.fr/css/concise-ui/concise-ui.min.css">
<!------ Include the above in your HEAD tag ---------->

<!doctype html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Fonts -->
        <link rel="dns-prefetch" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">

        <link rel="stylesheet" href="css/style.css">

        <link rel="icon" href="Favicon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

        <title>Login</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light navbar-laravel"></nav>

        <main class="login-form">
            <div class="cotainer">
                <div class="row justify-content-center">
                    <div class="col-md-3">
                        <div class="card"style="width: 400px;">
                           
                            <div class="card-body">
                                <form method="post" action="Control" >
                                    <div class="form-group row">
                                        <input type="hidden" id="idForm" class="form-control" name="idForm" value="${employee.id}"  >
                                        <div class="col-md-12 d-flex flex-row">
                                            <div class="p-2">
                                                <label for="exampleInputEmail1">Nom</label>
                                                <input type="text" id="nomForm" class="form-control" name="nomForm" placeholder="Nom"  value="${employee.nom}" autofocus>
                                            </div>
                                            <div class="p-2">
                                                <label for="exampleInputEmail1">Prenom</label>
                                                <input type="text" id="prenomForm" class="form-control" name="prenomForm" placeholder="Prenom" value="${employee.pnom}" >
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group row">
                                        <div class="col-md-12">
                                            <label for="exampleInputEmail1">Tél dom</label>
                                            <input type="text" id="telDomForm" class="form-control" name="telDomForm" placeholder="Téléphone domicile" value="${employee.teldom}" >
                                        </div>
                                    </div>
                                    
                                    <div class="form-group row">
                                        <div class="col-md-12">
                                            <label for="exampleInputEmail1">Tel mob</label>
                                            <input type="text" id="telMobForm" class="form-control" name="telMobForm" placeholder="Téléphone mobile" value="${employee.telport}">
                                        </div>
                                    </div>
                                        <div class="col-md-12">
                                            <label for="exampleInputEmail1">Tel pro</label>
                                            <input type="text" id="telProForm" class="form-control" name="telProForm" placeholder="Téléphone pro" value="${employee.telpro}" >
                                        </div>
                                    </div>
                                    
                                  
                                    
                                    <div class="form-group row">
                                        <div class="col-md-12 d-flex flex-row">
                                            <div class="p-2">
                                                <label for="exampleInputEmail1">Adresse</label>
                                                <input type="text" id="adresseForm" class="form-control" name="adresseForm" placeholder="Adresse" value="${employee.adresse}">
                                            </div>
                                            <div class="p-2">
                                                <label for="exampleInputEmail1">Code postal</label>
                                                <input type="text" id="codePostalForm" class="form-control" name="codePostalForm" placeholder="Code Postal" value="${employee.codep}">
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group row">
                                        <div class="col-md-12 d-flex flex-row">
                                            <div class="p-2">
                                                <label for="exampleInputEmail1">Ville</label>
                                                <input type="text" id="villeForm" class="form-control" name="villeForm" placeholder="Ville" value="${employee.ville}" >
                                            </div>
                                            <div class="p-2">
                                                <label for="exampleInputEmail1">Adresse e-mail</label>
                                                <input type="text" id="emailForm" class="form-control" name="emailForm" placeholder="Adresse e-mail"value="${employee.email}" >
                                            </div>
                                        </div>
                                    </div>
                                    </div>

                                          <button type="submit" class="btn btn-primary" name="action" value="Modifier">
                                            Modifier
                                        </button>
                                            <button type="submit" class="btn btn-primary" name="action" value="Retourliste">
                                            Voir liste
                                        </button>
                                      
                                    </div>
                                </form>
                                        
                                       
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </main>
</body>
</html>