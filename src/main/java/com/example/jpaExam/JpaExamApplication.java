package com.example.jpaExam;

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
			Member member = new Member();
			member.setUsername("A");
			em.persist(member);

			Order order = new Order();
			order.setStatus(OrderStatus.ORDER);

			order.setMember(member);
			em.persist(order);

			System.out.println(order.getMember().getId()+"===============");
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
