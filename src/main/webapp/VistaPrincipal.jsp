<%-- 
    Document   : VistaPrincipal
    Created on : Jun 15, 2020, 3:30:19 AM
    Author     : Vincenzo Angelone
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.math.BigInteger"%>
<%@page import="edu.cecar.modelo.FactorialHilo"%>
<%@page import="edu.cecar.modelo.FactorialHilo"%>
<%@page import="edu.cecar.controlador.ControladorNumeros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Doble factorial</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/bootstrap.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    </head>
    <body>
        <h4>Proyecto Doble Factorial de numeros grandes</h4>
        <form action="ServletControlador" method="post" >
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1"># Cores</span>
                </div>
                <input type="number" name="cores" class="form-control" aria-label="Cores" aria-describedby="basic-addon1"  value='<%=request.getAttribute("cores")%>' />
            </div>
            <br>
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">Número</span>
                </div>
                <textarea class="form-control" name="numero" aria-label="textnumero"><%= request.getAttribute("numero") %></textarea>
            </div>
            <br>
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">Resultado</span>
                </div>
                <textarea readonly type="number" name="resultado" class="form-control" aria-label="textresultado"><%= request.getAttribute("resultado") %></textarea>
            </div>
            <br>

            <button type="submit" class="btn btn-outline-dark">Calcular</button>
            <button type="button" class="btn btn-outline-dark">Descargar Resultado</button>
            <input type="hidden" name="accion" value="calcular"/>
        </form>
        

    </body>
</html>