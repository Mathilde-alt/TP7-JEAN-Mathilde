<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Récapitulatif de la commande</title>
</head>
<body>
    <!-- Afficher le récapitulatif du panier persisté depuis la base de données -->
    <h1>Récapitulatif de la commande</h1>

    <table>
        <tr>
            <th>Code du produit</th>
            <th>Libelle du produit</th>
            <th>Description du produit</th>
        </tr>

        <c:forEach items="${orderedProducts}" var="product">
            <tr>
                <td>${product.code}</td>
                <td>${product.libelle}</td>
                <td>${product.description}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

