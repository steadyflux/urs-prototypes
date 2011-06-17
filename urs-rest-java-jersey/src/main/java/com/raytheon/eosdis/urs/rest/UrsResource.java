/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raytheon.eosdis.urs.rest;

import com.raytheon.urs.models.Name;
import com.raytheon.urs.models.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author kbaynes
 */
@Path("user")
public class UrsResource {

  @GET
  @Produces({"application/xml", "application/json"})
  public User getUser() {
    System.out.println("Invoking GET Service");
    User user = new User();
    Name name = new Name();
    name.setFirst("Eleanor");
    name.setMiddle("Baynes");
    name.setLast("Caltagirone");
    user.setName(name);
    return user;
  }

  @PUT
  @Consumes({"application/xml", "application/json"})
  public JAXBElement<User> putUser(JAXBElement<User> user) {
    System.out.println("Invoking PUT Service");
    return user;
  }

  /**
   * Remove a car from the database.
   */
  @DELETE
  public void deleteCar() {
    System.out.println("Invoking Delete Service");
  }
}
