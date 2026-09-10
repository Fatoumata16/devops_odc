package com.odc.devops.controlleurs;

import com.odc.devops.modeles.student;
import com.odc.devops.services.serviceImplementestudent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class control {

    private final serviceImplementestudent studentService;

    @GetMapping
    public List<student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<student> findById(@PathVariable Long id) {

        return studentService.findByUid(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<student> save(@RequestBody student student) {

        student savedStudent = studentService.save(student);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<student> update(
            @PathVariable Long id,
            @RequestBody student student
    ) {

        try {
            student updatedStudent =
                    studentService.update(String.valueOf(id), student);

            return ResponseEntity.ok(updatedStudent);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        try {
            String message = studentService.deleteByUid(id);

            return ResponseEntity.ok(message);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}