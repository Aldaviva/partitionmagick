package vc.bjn.partitionmagick.data.repository;

import vc.bjn.partitionmagick.data.entity.Partition;

import java.math.BigInteger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartitionRepository extends MongoRepository<Partition, BigInteger>{


}
