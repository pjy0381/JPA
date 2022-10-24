package com.example.jpaExam;

import com.example.jpaExam.entity.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootApplication
public class JpaExamApplication {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			//비영속
			Member member = em.find(Member.class, 150L);
			member.setName("ㅠㅠㅠㅠ");

			 em.detach(member);

			//영속
			System.out.println("===BEFORE===");

			System.out.println("===AFTER===");

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
