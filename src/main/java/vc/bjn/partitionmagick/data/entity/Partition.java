package vc.bjn.partitionmagick.data.entity;

import java.math.BigInteger;

public class Partition {

	private BigInteger id;
	private String name;
	private String environment;
	private String version;
	private String branch;
	private int popCount;
	private String appNodeCount;
	private String conNodeCount;
	private String medNodeCount;
	private String comments;

	public BigInteger getId() {
		return id;
	}
	public void setId(final BigInteger id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(final String environment) {
		this.environment = environment;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(final String version) {
		this.version = version;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(final String branch) {
		this.branch = branch;
	}
	public int getPopCount() {
		return popCount;
	}
	public void setPopCount(final int popCount) {
		this.popCount = popCount;
	}
	public String getAppNodeCount() {
		return appNodeCount;
	}
	public void setAppNodeCount(final String appNodeCount) {
		this.appNodeCount = appNodeCount;
	}
	public String getConNodeCount() {
		return conNodeCount;
	}
	public void setConNodeCount(final String conNodeCount) {
		this.conNodeCount = conNodeCount;
	}
	public String getMedNodeCount() {
		return medNodeCount;
	}
	public void setMedNodeCount(final String medNodeCount) {
		this.medNodeCount = medNodeCount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(final String comments) {
		this.comments = comments;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appNodeCount == null) ? 0 : appNodeCount.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((conNodeCount == null) ? 0 : conNodeCount.hashCode());
		result = prime * result + ((environment == null) ? 0 : environment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medNodeCount == null) ? 0 : medNodeCount.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + popCount;
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Partition other = (Partition) obj;
		if (appNodeCount == null) {
			if (other.appNodeCount != null) {
				return false;
			}
		} else if (!appNodeCount.equals(other.appNodeCount)) {
			return false;
		}
		if (branch == null) {
			if (other.branch != null) {
				return false;
			}
		} else if (!branch.equals(other.branch)) {
			return false;
		}
		if (comments == null) {
			if (other.comments != null) {
				return false;
			}
		} else if (!comments.equals(other.comments)) {
			return false;
		}
		if (conNodeCount == null) {
			if (other.conNodeCount != null) {
				return false;
			}
		} else if (!conNodeCount.equals(other.conNodeCount)) {
			return false;
		}
		if (environment == null) {
			if (other.environment != null) {
				return false;
			}
		} else if (!environment.equals(other.environment)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (medNodeCount == null) {
			if (other.medNodeCount != null) {
				return false;
			}
		} else if (!medNodeCount.equals(other.medNodeCount)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (popCount != other.popCount) {
			return false;
		}
		if (version == null) {
			if (other.version != null) {
				return false;
			}
		} else if (!version.equals(other.version)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return String.format(
			"Partition [id=%s, name=%s, environment=%s, version=%s, branch=%s, popCount=%s, appNodeCount=%s, conNodeCount=%s, medNodeCount=%s, comments=%s]",
			id, name, environment, version, branch, popCount, appNodeCount, conNodeCount, medNodeCount, comments);
	}



}
