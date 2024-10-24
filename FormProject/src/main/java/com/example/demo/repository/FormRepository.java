package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.modal.FormSubmission;

@Repository
public interface FormRepository extends JpaRepository<FormSubmission, Long> {
}
