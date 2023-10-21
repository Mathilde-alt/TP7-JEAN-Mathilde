<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panier</title>
</head>
<body>
    <!-- Formulaire pour ajouter un produit -->
    <form action="cart" method="post">
        <label for="productCode">Code du produit:</label>
        <input type="text" id="productCode" name="productCode" required><br>s

        <label for="productLibelle">Libellé du produit:</label>
        <input type="text" id="productLibelle" name="productLibelle" required><br>

        <label for="productDescription">Description du produit:</label>
        <input type="text" id="productDescription" name="productDescription" required><br>

        <input type="submit" value="Ajouter le produit">
    </form>

    <!-- Liste des produits dans le panier -->
    <table>
        <tr>
            <th>Code</th>
            <th>Libellé</th>
            <th>Description</th>
            <th>Action</th>
        </tr>

        <c:forEach items="${cartItems}" var="product">
            <tr>
                <td>${product.code}</td>
                <td>${product.libelle}</td>
                <td>${product.description}</td>
                <td>
                    <!-- Bouton pour supprimer le produit -->
                    <form action="cart" method="post">
                        <input type="hidden" name="productIdToDelete" value="${product.id}">
                        <input type="submit" value="Supprimer le produit">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <!-- Bouton pour finaliser la commande -->
    <form action="cart" method="post">
        <input type="submit" name="checkout" value="Finaliser la commande">
    </form>
</body>
</html>

