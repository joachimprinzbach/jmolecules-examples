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
package example.jmolecules.presentation.types.order;

import example.jmolecules.presentation.types.customer.Customer;
import example.jmolecules.presentation.types.customer.Customer.CustomerId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.List;
import java.util.UUID;

import javax.persistence.Table;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.ddd.types.Identifier;

/**
 * @author Oliver Drotbohm
 */

@Table(name = "SAMPLE_ORDER")
@Getter
@RequiredArgsConstructor
public class Order implements AggregateRoot<Order, Order.OrderId> {

	private final OrderId id;

	private List<LineItem> lineItems;
	private Association<Customer, CustomerId> customer;

	public Order(Customer customer) {

		this.id = OrderId.of(UUID.randomUUID());
		this.customer = Association.forAggregate(customer);
	}

	@Value(staticConstructor = "of")
	public static class OrderId implements Identifier {
		private final UUID orderId;
	}
}
