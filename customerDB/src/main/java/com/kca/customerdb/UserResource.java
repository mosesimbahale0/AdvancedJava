/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kca.customerdb;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/application")
public class UserResource {

    @GET
    @Produces("application/xml") // or "application/json"
    public String getWadl() {
        // return WADL content or configuration
        return "WADL content here";
    }
}
