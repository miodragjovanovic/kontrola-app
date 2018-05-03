package com.name.no.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.name.no.exception.NodeException;
import com.name.no.model.NodeEntity;
import com.name.no.repository.NodeRepository;

@Service
public class NodeService {
	
	@Autowired
	NodeRepository nodeRepository;
	
	public void createNode(String name, String parentId) throws NodeException {
		
		NodeEntity node = new NodeEntity();
		if (parentId != null) {
			Optional<NodeEntity> parent = nodeRepository.findById(parentId);
			if (!parent.isPresent()) {
				throw new NodeException("Non existing parent node");
			}
			node.setParent(parent.get());
		}
		
		node.setId(UUID.randomUUID().toString());
		node.setName(name);
		
		nodeRepository.save(node);
		
	}
	
	public List<NodeEntity> getByParentId(String id) throws NodeException {
		if (id == null) {
			throw new NodeException("Parent id is empty");
		}
		List<NodeEntity> nodes = nodeRepository.findByParentId(id);
		return nodes;
	}
	
	public void deleteNode(String id) throws NodeException {
		if (id == null) {
			throw new NodeException("Node id is empty");
		}
		NodeEntity node = nodeRepository.getOne(id);
		if (node == null) {
			throw new NodeException("Node does not exist");
		}
		NodeEntity parent = node.getParent();
		List<NodeEntity> children = nodeRepository.findByParentId(id);
		for (NodeEntity child : children) {
			child.setParent(parent);
		}
		nodeRepository.saveAll(children);
		nodeRepository.delete(node);
	}
	
	public void updateNode(String id, String name) throws NodeException {
		if (id == null) {
			throw new NodeException("Node id is empty");
		}
		NodeEntity node = nodeRepository.getOne(id);
		if (node == null) {
			throw new NodeException("Node does not exist");
		}
		node.setName(name);
		nodeRepository.save(node);
	}
	
	public List<NodeEntity> getAllNodes() throws NodeException {
		List<NodeEntity> nodes = nodeRepository.findAll();
		return nodes;
	}

}
