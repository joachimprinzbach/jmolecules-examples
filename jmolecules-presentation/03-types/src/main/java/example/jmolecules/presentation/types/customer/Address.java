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
package example.jmolecules.presentation.types.customer;

import lombok.Getter;
import lombok.Value;

import java.util.UUID;

import org.jmolecules.ddd.types.Entity;
import org.jmolecules.ddd.types.Identifier;

@Getter
public class Address implements Entity<Customer, Address.AddressId> {

	private Address.AddressId id;
	private final String street, city, zipCode;

	public Address(String street, String city, String zipCode) {

		this.id = AddressId.of(UUID.randomUUID());
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	@Value(staticConstructor = "of")
	public static class AddressId implements Identifier {
		private final UUID id;
	}
}
