
package it.davideromito.rest;

import it.davideromito.Tags;
import it.davideromito.crawler.Crawler;
import it.davideromito.lookup.Search;
import it.davideromito.lookup.cache.CacheOperation;
import it.davideromito.lookup.cache.CacheOperationImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("/")
public class RESTful {
    @HEAD
    @Produces("text/plain")
    @Path("generate-file")
    public Response generateFile() {
        Crawler c = new Crawler();
        c.generateKnowledge();
        return Response.status(200).entity("generateFile").build();
    }

    @HEAD
    @Produces("text/plain")
    @Path("populate-cache")
    public Response populateCache() {
        CacheOperation co = new CacheOperationImpl();
        co.populate();
        return Response.status(200).entity("populateCache").build();
    }

    @HEAD
    @Produces("text/plain")
    @Path("invalidate-cache")
    public Response invalidateCache() {
        CacheOperation co = new CacheOperationImpl();
        co.invalidate();
        return Response.status(200).entity("invalidateCache").build();
    }

    @GET
    @Produces("text/html")
    @Path("all-tags")
    public Response getAllTags() {
        StringBuilder sb = new StringBuilder();
        for (Tags tag : Tags.values()) {
            sb.append(tag).append("\n");
        }
        return Response.status(200).entity(sb.toString()).build();
    }

    @GET
    @Produces("text/html")
    @Path("search/{element}")
    public Response searchInAll(@PathParam("element") String element) {
        StringBuilder sb = new StringBuilder();
        Search s = new Search();
        for (Tags tag : Tags.values()) {
            Set<String> elements = s.performSearch(element, tag);
            for (String el : elements) {
                sb.append(tag).append("=").append(el).append("\n");
            }
        }
        return Response.status(200).entity(sb.toString()).build();
    }

    @GET
    @Produces("text/html")
    @Path("search/{element}/{tag}")
    public Response search(@PathParam("tag") String tag, @PathParam("element") String element) {
        StringBuilder sb = new StringBuilder();
        Search s = new Search();
        Set<String> elements = s.performSearch(element,Tags.valueOf(tag));
        for (String el : elements) {
            sb.append(el).append("\n");
        }
        return Response.status(200).entity(sb.toString()).build();
    }
}
