package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.BusRepository;
import com.cg.entity.Bus;

@RestController
public class BusController {

	@Autowired
	private BusRepository busRepository;
	
	//admin's work
	@GetMapping(path="buses/displayAllBuses")
	public List<Bus> displayAllBuses()
	{
		List<Bus> buses=new ArrayList<Bus>();
		buses=busRepository.findAll();
		return buses;
	}
	
	//admin's work
	@PutMapping(path="buses/updateBusDetails/{busId}")
	public Bus updateBusDetails(@PathVariable String busId)
	{
		
	}
	
//	@PostMapping(path="buses/addBusDetails")
//	public String addBusDetails()
//	{
//		return "adds the  bus details";
//	}
	
//	@DeleteMapping(path="buses/deleteBusDetails")
//	public String deleteBusDetails(int busId)
//	{
//		return "delete bus details";
//	}
//	
	
	//user's/passenger's task
	@GetMapping(path="buses/findBusesBySourceAndDestination/source/{source}/destination/{destination}")
	public List<Bus> findBusesByRoute(@PathVariable String source,@PathVariable String destination) 
	{
		
		List<Bus> buses=new ArrayList<Bus>();
		buses=busRepository.findBySrcAndDest(source, destination);
		return buses;
	}
	
	@GetMapping(path="buses/seatAvailability")
	public String   seatAvailability(int busId)
	{
		return "fuction used to display seats and the status of bus seats for a respective bus";
		
	}
	
//	@PostMapping(path="buses/addRoute")
//	public String addRoute()
//	{
//		return "adds the route";
//	}
	
	
	
}
