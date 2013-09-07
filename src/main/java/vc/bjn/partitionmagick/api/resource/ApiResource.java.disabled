package vc.bjn.partitionmagick.api.resource;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.UriInfo;

public interface ApiResource<I> {

	@GET
	List<I> listAll(UriInfo uriInfo);

	@GET
	@Path("{id}")
	I get(@PathParam("id") final BigInteger id);

	/** expects a post body like
	 *
	 * { name: "foo", ipAddress: "1.2.3.4" }
	 */
	@POST
	I insert(final I entity);

	@PUT
	@Path("{id}")
	I update(@PathParam("id") final BigInteger id,
			final Map<String, Object> modifiedFields);

	@DELETE
	@Path("{id}")
	void delete(@PathParam("id") final BigInteger id);

}