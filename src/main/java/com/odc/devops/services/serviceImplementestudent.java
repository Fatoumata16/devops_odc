package com.odc.devops.services;

import com.odc.devops.modeles.student;
import com.odc.devops.repository.studentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class serviceImplementestudent {

    private final studentRepo studentRepository;

    
    public student save(student student) {
        return studentRepository.save(student);
    }

  
    public Optional<student> findByUid(Long uid) {
        return studentRepository.findById(uid);
    }

   
    public student update(String uid, student dto) {

        Long id = Long.valueOf(uid);

        student existingstudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Étudiant introuvable avec l'id : " + id)
                );

        existingstudent.setNom(dto.getNom());
        existingstudent.setPrenom(dto.getPrenom());
        existingstudent.setEmail(dto.getEmail());
        existingstudent.setTelephone(dto.getTelephone());

        return studentRepository.save(existingstudent);
    }

  
    public String deleteByUid(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new RuntimeException(
                    "Étudiant introuvable avec l'id : " + id
            );
        }

        studentRepository.deleteById(id);

        return "Étudiant supprimé avec succès";
    }


    public List<student> findAll() {
        return studentRepository.findAll();
    }
}