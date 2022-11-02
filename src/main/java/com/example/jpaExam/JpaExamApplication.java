package com.example.jpaExam;

import com.example.jpaExam.domain.Book;
import com.example.jpaExam.domain.Member;
import com.example.jpaExam.domain.Order;
import com.example.jpaExam.common.OrderStatus;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class JpaExamApplication {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			//비영속
			Book book = new Book("김영한","11111");
			book.setName("JPA");
			em.persist(book);

			em.flush();
			em.clear();

			Book b1 = em.getReference(Book.class,book.getId());
			b1.getName();

			System.out.println(emf.getPersistenceUnitUtil().isLoaded(b1));

			tx.commit();
		}catch (Exception e){
			tx.rollback();
		}finally {
			em.close();
		}

		emf.close();

//		SpringApplication.run(JpaExamApplication.class, args);
	}

}
