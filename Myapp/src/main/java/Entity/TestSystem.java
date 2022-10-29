package Entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class TestSystem {

		private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistance.craeteEntityManagerFactory("Myaapp");  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addCustomer(1, "Sue", "Smith");
		addCustomer(2, "Sam", "Smith");
		addCustomer(3, "Sid", "Smith");
		addCustomer(4, "Sally", "Smith");
		getCustomer(1);
		getCustomers();
			
	    	ENTITY_MANAGER_FACTORY.close();

	}
	public static void addCustomer(int id,String fname,String lname)
	{
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et=null;
		try {
			et = em.getTransaction();
			et.begin();
			Customer cust = new Customer();
			cust.setId(id);
			cust.setFirstName(fname);
			cust.setLastName(lname);
			em.persist(cust);
		}catch(Exception ex)
		{
			if(et!=null)
			{
				et.rollback();
			}
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	public static void getCustomer(int id)
	{
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT c FROM customer WHERE c.id = :custID";
		
		TypedQuery<Customer> tq = em.createQuery(query,Customer.class);
		tq.setParameter("crustID", id);
		Customer cust = null;
		try {
			cust = tq.getSingleResult();
			System.out.println(cust.getFirstName() + "" + cust.getLastName());
			
		}catch(NoResultException ex)
		{
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
	}
    public static void getCustomers() {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	
    
    	String strQuery = "SELECT c FROM Customer c WHERE c.id IS NOT NULL";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<Customer> tq = em.createQuery(strQuery, Customer.class);
    	List<Customer> custs;
    	try {
    		// Get matching customer object and output
    		custs = tq.getResultList();
    		custs.forEach(cust->System.out.println(cust.getFirstName() + " " + cust.getLastName()));
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }

}
