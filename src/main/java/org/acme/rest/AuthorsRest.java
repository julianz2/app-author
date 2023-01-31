package org.acme.rest;

import org.acme.Entity.Authors;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorsRest {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
		public List<Authors> finAll() {
			return Authors.listAll();
		}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
		public Authors getById(Long id) {
			return Authors.findById(id);
		}
	@POST
	@Transactional
	public Response AddAuthor(Authors author) {
		author.persist();
		return Response.status(Response.Status.CREATED).entity(author).build();
	}
	
	
	
	@PUT
	@Path("/{id}")
	@Transactional
	public Authors EditAuthor(Long id, Authors author) {
		Authors entity = Authors.findById(id);
		if(entity == null) {
			throw new NotFoundException();
		}
		entity.first_name = author.first_name;
		entity.last_name = author.last_name;
		
		return entity;
	}
	@DELETE
	@Path("/{id}")
	@Transactional
	public void DeleteAuthor(Long id) {
		Authors entity = Authors.findById(id);
		if(entity == null) {
			throw new NotFoundException();
		}
		entity.delete();
	}
}
