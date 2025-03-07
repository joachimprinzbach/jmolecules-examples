/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.jmolecules.presentation.annotations.customer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.EmbeddedId;

import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

@Entity
@javax.persistence.Entity
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Address {

	private @Identity @EmbeddedId Address.AddressId id;
	private final String street, city, zipCode;

	public Address(String street, String city, String zipCode) {

		this.id = AddressId.of(UUID.randomUUID());
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	@Value
	@RequiredArgsConstructor(staticName = "of")
	@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
	public static class AddressId implements Serializable {

		private static final long serialVersionUID = -4137817684501259712L;
		private final UUID id;
	}
}
