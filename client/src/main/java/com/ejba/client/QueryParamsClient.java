package com.ejba.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@RegisterRestClient
public interface QueryParamsClient {

  @GET
  @Path("example")
  String callService(@QueryParam("q") List<String> q);
}
