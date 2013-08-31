package vc.bjn.partitionmagick.api.resource;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;

@Consumes({"application/json"})
@Produces({"application/json"})
public abstract class AbstractApiResource<I> implements ApiResource<I> {

	@Autowired protected MongoOperations mongoOperations;

	protected abstract Class<I> getEntityClass();

	protected abstract MongoRepository<I, BigInteger> getRepository();

	@Override
	@GET
	public List<I> listAll(@Context final UriInfo uriInfo) {
		return getRepository().findAll();
	}

	@Override
	@GET
	@Path("{id}")
	public I get(@PathParam("id") final BigInteger id) {
		return getRepository().findOne(id);
	}

	@Override
	@POST
	public I insert(final I entity) {
		return getRepository().save(entity);
	}

	@Override
	@PUT
	@Path("{id}")
	public I update(@PathParam("id") final BigInteger id, final Map<String, Object> modifiedFields) {
		final Update update = new Update();
		for (final Entry<String, Object> field : modifiedFields.entrySet()) {
			update.set(field.getKey(), field.getValue());
		}
		mongoOperations.updateFirst(new Query(Criteria.where("id").is(id)), update, getEntityClass());
		return get(id);
	}

	@Override
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") final BigInteger id) {
		getRepository().delete(id);
	}
}
