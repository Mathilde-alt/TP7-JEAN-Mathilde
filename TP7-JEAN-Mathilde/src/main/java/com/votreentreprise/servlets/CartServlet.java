package com.votreentreprise.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votreentreprise.panier.Product;
import com.votreentreprise.panier.CartBeanLocal;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	
	private CartBeanLocal cartBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vous allez gérer les requêtes GET pour afficher le formulaire de saisie et la liste des produits du panier.
    	request.setAttribute("cartItems", cartBean.getCartItems()); // Suppose que cartBean.getCartItems() renvoie une liste d'articles du panier

    	// Redirigez l'utilisateur vers la JSP appropriée pour afficher les données
    	request.getRequestDispatcher("/cart.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vous allez gérer les requêtes POST pour traiter les actions de l'utilisateur, comme l'ajout de produits et la finalisation de la commande.
    	String productCode = request.getParameter("productCode");
    	String productLibelle = request.getParameter("productLibelle");
    	String productDescription = request.getParameter("productDescription");

    	// Créez une instance de Product
    	Product product = new Product();
    	product.setCode(productCode);
    	product.setLibelle(productLibelle);
    	product.setDescription(productDescription);

    	// Appelez le bean EJB pour ajouter ce produit au panier
    	cartBean.addProductToCart(product);
    	
    	cartBean.checkOut(); // Cette méthode devrait persister les produits en base de données

    	// Dans la servlet, lorsque l'utilisateur demande de supprimer un produit
    	String productIdToDelete = request.getParameter("productIdToDelete");
    	// Appelez une méthode du bean EJB pour supprimer le produit correspondant
    	cartBean.removeProduct(productIdToDelete);

    }
    
    @PersistenceContext
    private EntityManager entityManager;

    public void persistProduct(Product product) {
        entityManager.persist(product); // Pour insérer un produit dans la base de données
    }

}
