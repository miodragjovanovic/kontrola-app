package com.name.no.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.name.no.model.NodeEntity;

@Repository
public interface NodeRepository extends JpaRepository<NodeEntity, String> {
	
	List<NodeEntity> findByParentId(String id);

}
