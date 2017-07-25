package com.rabbitmq.example1.domain;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Artem Karpov
 */
public class ProgrammingLangDTO {
	@SerializedName("Name")
	private String name;
	@SerializedName("Type")
	private String type;
	@SerializedName("Designed by")
	private String designedBy;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesignedBy() {
		return designedBy;
	}

	public void setDesignedBy(String designedBy) {
		this.designedBy = designedBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ProgrammingLangDTO)) {
			return false;
		}
		ProgrammingLangDTO that = (ProgrammingLangDTO) o;
		return Objects.equals(getName(), that.getName()) && Objects.equals(getType(), that.getType()) && Objects
				.equals(getDesignedBy(), that.getDesignedBy());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getType(), getDesignedBy());
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ProgrammingLangDTO{");
		sb.append("name='").append(name).append('\'');
		sb.append(", type='").append(type).append('\'');
		sb.append(", designedBy='").append(designedBy).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
