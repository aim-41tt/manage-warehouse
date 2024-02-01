package ru.warehouse.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernateUtil {

	 private static SessionFactory sessionFactory;

	    /**
	     * Returns the Hibernate SessionFactory instance, creating it if it doesn't exist.
	     * Uses the Hibernate configuration from the "hibernate.cfg.xml" file.
	     * 
	     * @return the Hibernate SessionFactory instance
	     */

	    private static SessionFactory getSessionFactory() {
	        if (sessionFactory == null || sessionFactory.isClosed()) {
	            try {
	                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	                sessionFactory = configuration.buildSessionFactory();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return sessionFactory;
	    }


	    /**
	     * Saves or updates the specified entity of type T in the database.
	     * Uses the current Hibernate session to perform the operation.
	     *
	     * @param <T>     the type of the entity
	     * @param entity  the entity to be saved or updated
	     */
	    public static <T> void saveOrUpdateEntity(T entity) {
	        Session session = getSessionFactory().openSession();
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            session.saveOrUpdate(entity);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	    
	 
	    /**
	     * Deletes the specified entity of type T from the database.
	     * Uses the current Hibernate session to perform the deletion.
	     *
	     * @param <T>     the type of the entity
	     * @param entity  the entity to be deleted
	     */
	    public static <T> void deleteEntity(T entity) {
	        Session session = getSessionFactory().openSession();
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            session.delete(entity);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	    
	    /**
	     * Retrieves an entity of type T from the database based on the specified ID.
	     * Uses the current Hibernate session to perform the retrieval.
	     *
	     * @param <T>         the type of the entity
	     * @param entityType  the class type of the entity
	     * @param id          the ID of the entity to be retrieved
	     * @return            the retrieved entity, or null if not found
	     */
	    public static <T> T getEntity(Class<T> entityType, Long id) {
	        Session session = getSessionFactory().openSession();
	        T entity = null;
	        try {
	            entity = session.get(entityType, id);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return entity;
	    }
	    
	    /**
	     * Retrieves a list of entities of type T from the database.
	     * Uses the current Hibernate session to perform the retrieval.
	     *
	     * @param <T>         the type of the entities
	     * @param entityType  the class type of the entities
	     * @return            a list of retrieved entities, or null if an error occurs
	     */
	    public static <T> List<T> getEntities(Class<T> entityType) {
	        Session session = getSessionFactory().openSession();
	        List<T> entities = null;

	        try {
	            String hql = "FROM " + entityType.getName();
	            Query<T> query = session.createQuery(hql, entityType);
	            entities = query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }

	        return entities;
	    }

	    
	}
