package com.odc.devops.repository;

import com.odc.devops.modeles.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<student, Long> {

}
