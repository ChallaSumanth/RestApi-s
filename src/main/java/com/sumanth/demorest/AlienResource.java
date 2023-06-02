package com.sumanth.demorest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	
	AlienRepository repo = new AlienRepository();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Alien> getAliens()
	{
		
		System.out.println("Get Alien Called");
		return repo.getAliens();
	}
	
	@GET
	@Path("alien/90")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien getAlien()
	{
		return repo.getAlien(90);
	}
	@POST
	@Path("alien")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien createAlien(Alien a1)
	{
		System.out.println(a1);
		repo.create(a1);
		return a1;
	}
	
	@PUT
	@Path("alien")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien updateAlien(Alien a1)
	{
		System.out.println(a1);
		if(repo.getAlien(a1.getId()).getId() == 0)
			repo.create(a1);
		else
		repo.update(a1);
		return a1;
	}
	@DELETE
	@Path("alien/128")
	public Alien killAlien()
	{
		Alien a = repo.getAlien(128);
		if(a.getId() != 0)
			repo.delete(128);
		return a;
	}
}
