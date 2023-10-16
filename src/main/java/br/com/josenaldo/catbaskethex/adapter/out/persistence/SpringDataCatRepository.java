package br.com.josenaldo.catbaskethex.adapter.out.persistence;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataCatRepository extends JpaRepository<CatEntity, UUID> {
    List<CatEntity> findByNameLike(String name, Sort sort);
}
