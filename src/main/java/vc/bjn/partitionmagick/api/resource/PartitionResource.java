package vc.bjn.partitionmagick.api.resource;

import vc.bjn.partitionmagick.data.entity.Partition;
import vc.bjn.partitionmagick.data.repository.PartitionRepository;

import java.math.BigInteger;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
@Path("partitions")
@Produces(MediaType.APPLICATION_JSON)
public class PartitionResource extends AbstractApiResource<Partition> {

	@Autowired private PartitionRepository partitionRepository;

	@Override
	protected Class<Partition> getEntityClass() {
		return Partition.class;
	}

	@Override
	protected MongoRepository<Partition, BigInteger> getRepository() {
		return partitionRepository;
	}

}
