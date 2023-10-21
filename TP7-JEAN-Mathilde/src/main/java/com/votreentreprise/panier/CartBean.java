package com.votreentreprise.panier;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;

@Stateful
public class CartBean implements CartBeanLocal {
    private List<Product> cart = new ArrayList<>();
    
    @Override
    public List<Product> getCartItems() {
        // Logique pour récupérer les produits du panier
        return cart;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void addProductToCart(Product product) {
        cart.add(product);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public void checkOut() {
        // Ici, vous pouvez implémenter la logique pour persister les produits du panier dans la base de données MySQL.
        // Vous devrez utiliser JPA pour effectuer l'insertion en base de données.
        EntityManager entityManager = null;
         for (Product product : cart) {
             entityManager.persist(product); 
         }
    }

    @Remove
    public void cancel() {
        // Méthode pour annuler la session EJB
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void removeProduct(String productId) {
        // Logique pour supprimer un produit du panier
        // Utilisez l'ID du produit pour le retrouver dans la liste et le supprimer
        for (Product product : cart) {
            if (product.getId().equals(productId)) {
                 cart.remove(product);
                 break; // Sortez de la boucle une fois le produit trouvé et supprimé
             }
         }
    }
}
