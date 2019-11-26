<%@page import="java.util.ArrayList"%>
<%@page import="lsi.m1.models.Employees"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://www.iut-fbleau.fr/css/concise.min.css">
        <link rel="stylesheet" href="http://www.iut-fbleau.fr/css/concise-utils/concise-utils.min.css">
        <link rel="stylesheet" href="http://www.iut-fbleau.fr/css/concise-ui/concise-ui.min.css">
        <title>Bienvenue</title>
    </head>
    <body style="margin-bottom: 30px">
        <h1>Bonjour ${input}! Votre session est active</h1>
        <c:choose>
            <c:when test="${!vide}">

                <form action="Control">
                    <div>

                        <table id="table" >
                            <thead>
                                <tr>
                                    <th scope="col"></th>
                                    <th scope="col">NOM</th>
                                    <th scope="col">PRENOM</th>
                                    <th scope="col">TEL DOMICILE</th>
                                    <th scope="col">TEL PORTABLE</th>
                                    <th scope="col">TEL PRO</th>
                                    <th scope="col">ADRESSE</th>
                                    <th scope="col">CODE POSTAL</th>
                                    <th scope="col">VILLE</th>
                                    <th scope="col">EMAIL</th>
                                </tr>
                            </thead>




                            <tbody>


                                <c:forEach items="${liste}" var="emp">





                                <label></label>
                                <tr>
                                    <td>
                                        <input type="radio" value="${emp.id}" name="radiobtn"></td>
                                    <td><c:out value="${emp.nom}"></c:out></td>
                                    <td><c:out value="${emp.pnom}"></c:out></td>
                                    <td><c:out value="${emp.teldom}"></c:out></td>
                                    <td><c:out value="${emp.telport}"></c:out></td>
                                    <td><c:out value="${emp.telpro}"></c:out></td>
                                    <td><c:out value="${emp.adresse}"></c:out></td>
                                    <td><c:out value="${emp.codep}"></c:out></td>
                                    <td><c:out value="${emp.ville}"></c:out></td>

                                        <td><c:out value="${emp.email}"></c:out></td></tr>





                            </c:forEach>


                            </tbody>

                        </table>
                    </div>
                    <c:if test="${isAdmin}">
                        <div style="position: fixed; bottom: 5px">
                            <button type="submit" name="action" value="ajouter" style="background-color: #007BFF">Ajouter</button>



                            <button  type="submit" name="action" value="supprimer" style="background-color: #007BFF">Supprimer</button>

                            <button type="submit" name="action" value="details" style="background-color: #007BFF">Details</button>
                            <c:if test="${!empty SUPR_MSG}">
                                <h3 class="text-success"> ${SUPR_MSG}</h3>
                            </c:if>
                            <c:if test="${!empty SUPR_MSG_ERR}">
                                <h3 class="text-danger"> ${SUPR_MSG_ERR}}</h3>
                            </c:if>

                        </div>




                    </c:if>
                    <button type="submit" name="action" value="deconnecter" style="position: absolute; top: 5px; right: 5px">Deconnexion</button>       

                </c:when>
                <c:otherwise>
                    <c:if test="${isAdmin}">

                        <button type="submit" name="action" value="ajouter" >Ajouter</button>

                    </c:if>
                    <h1>il serait temps qu'on recrute</h1>
                    <button type="submit" name="action" value="deconnecter" style="position: absolute; top: 5px; right: 5px">Deconnexion</button>

                </c:otherwise>
            </c:choose>           


        </form>










    </body>
</html>
