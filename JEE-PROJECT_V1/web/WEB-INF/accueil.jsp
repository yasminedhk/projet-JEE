<%-- 
   Document   : accueil
   Created on : 18 nov. 2019, 12:42:06
   Author     : dahak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://www.iut-fbleau.fr/css/concise.min.css">
        <link rel="stylesheet" href="http://www.iut-fbleau.fr/css/concise-utils/concise-utils.min.css">
        <link rel="stylesheet" href="http://www.iut-fbleau.fr/css/concise-ui/concise-ui.min.css">
        <title>Page acceuil</title>
    </head>

    <body class="id">
        <div id="box">
            <%
                String err = (String) request.getAttribute("errKey");
                if (err != null) {
                    out.print(err);
                }
            %>
            
            <form method="POST" action="Control" style="display: flex; justify-content: center">
                <fieldset>
                    <legend>Login</legend>
                    <p><input type="text" name= "pseudo"  placeholder="Pseudo" id ="pseudo"/></p>
                    <br />

                    <input type="password" name="pass" id="pass" placeholder="Mot de passe"/>
                    <input type="checkbox" onclick="afficher()" name="affiche" > afficher mot de passe
                    <br/>
                    <button name="action" value="connexion" type="submit" style="background-color: #007BFF; color: white">Login</button>
                    <script>
                        function afficher() {
                            var x = document.getElementById("pass");
                            if (x.type === "password") {
                                x.type = "text";
                            } else {
                                x.type = "password";
                            }
                        }
                    </script>
                </fieldset>
            </form>

        </div>


    </body>
</html>

       
