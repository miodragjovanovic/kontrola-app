package com.name.no.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.name.no.exception.NodeException;
import com.name.no.model.NodeEntity;
import com.name.no.service.NodeService;

@RequestMapping("/api")
@RestController
public class NodeController {
	
	@Autowired
	NodeService nodeService;
	
	@RequestMapping(path="/createNode", method=RequestMethod.POST)
	public String createNode(@RequestParam(value="name") String name, String parentId) throws NodeException {
		nodeService.createNode(name, parentId);
		return "Success";
	}
	
	@RequestMapping(path="/getByParent", method=RequestMethod.GET)
	public List<NodeEntity> getByParentId(@RequestParam("parentId") String parentId) throws NodeException {
		return nodeService.getByParentId(parentId);
	}
	
	@RequestMapping(path="/deleteNode", method=RequestMethod.DELETE)
	public void deleteNode(@RequestParam("id") String id) throws NodeException {
		nodeService.deleteNode(id);
	}
	
	@RequestMapping(path="/updateNode", method=RequestMethod.PUT)
	public void updateNode(@RequestParam(value="name") String name, @RequestParam(value="id") String id) throws NodeException {
		nodeService.updateNode(id, name);
	}
	
	@RequestMapping(path="/getAllNodes", method=RequestMethod.GET)
	public List<NodeEntity> getAllNodes() throws NodeException {
		return nodeService.getAllNodes();
	}

}
