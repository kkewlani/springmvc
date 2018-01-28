package kk.springframework.springmvc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import kk.springframework.springmvc.domain.Product;
import lombok.Setter;

@Service
@Profile("jpaDao")
public class ProductServiceDaoImpl implements ProductService {

    @Setter
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public List<Product> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Product.class, id);
    }

    @Override
    public Product createOrUpdate(Product input) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Product newProduct = em.merge(input);
        em.getTransaction().commit();

        return newProduct;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
    }
}
