//package hcmute.alohcmute.daos;
//
//import java.util.List;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.TypedQuery;
//
//public abstract class AbstractDao<T> {
//	private Class<T> entityClass;
//	
//	public AbstractDao(Class<T> cls) {
//		this.entityClass = cls;
//	}
//	
//	@Override
//	public void insert(T entity) {
//		EntityManager enma = JPAConfig.getEntityManager();
//		EntityTransaction trans = enma.getTransaction();
//		
//		try {
//			trans.begin();
//			enma.persist(entity);
//			trans.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			trans.rollback();
//			throw e;
//		} finally {
//			enma.close();
//		}
//
//	}
//	
//	@Override
//	public void update(T entity) {
//		EntityManager enma = JPAConfig.getEntityManager();
//		EntityTransaction trans = enma.getTransaction();
//
//		try {
//			trans.begin();
//			enma.merge(entity);
//			trans.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			trans.rollback();
//			throw e;
//		} finally {
//			enma.close();
//		}
//	}
//	
//	@Override
//	public void delete(int id) throws Exception {
//		EntityManager enma = JPAConfig.getEntityManager();
//		EntityTransaction trans = enma.getTransaction();
//
//		try {
//			trans.begin();
//			T entity = enma.find(T.class, id);
//			
//			if (entity != null) {
//				enma.remove(entity);
//			} else {
//				throw new Exception("Không tìm thấy");
//			}
//			
//			trans.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			trans.rollback();
//			throw e;
//		} finally {
//			enma.close();
//		}
//	}
//
//	@Override
//	public T findById(int id) {
//		EntityManager enma = JPAConfig.getEntityManager();
//		T entity = enma.find(T.class, cateid);
//		return entity;
//	}
//
//	@Override
//	public List<T> findAll() {
//		EntityManager enma = JPAConfig.getEntityManager();
//		TypedQuery<T> query = enma.createNamedQuery("T.findAll", T.class);
//		return query.getResultList();
//	}
//
//	@Override
//	public List<T> findAll(int page, int pagesize) {
//		EntityManager enma = JPAConfig.getEntityManager();
//		TypedQuery<T> query = enma.createNamedQuery("T.findAll", T.class);
//
//		query.setFirstResult(page * pagesize);
//		query.setMaxResults(pagesize);
//
//		return query.getResultList();
//	}
//}
