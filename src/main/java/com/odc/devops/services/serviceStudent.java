package com.odc.devops.services;

import com.odc.devops.modeles.student;

import java.util.List;
import java.util.Optional;

public interface serviceStudent {
    student save(student dto);

    Optional<student> findByUid(Long uid);

    student update(String uid, student dto);

    String deleteByUid(Long id);

    List<student> findAll();
}
