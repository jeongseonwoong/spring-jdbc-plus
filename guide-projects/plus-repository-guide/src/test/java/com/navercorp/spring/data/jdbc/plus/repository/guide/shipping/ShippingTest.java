package com.navercorp.spring.data.jdbc.plus.repository.guide.shipping;

import com.navercorp.spring.data.jdbc.plus.repository.guide.common.exception.InvalidValueException;
import com.navercorp.spring.data.jdbc.plus.repository.guide.order.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ShippingTest {

	@Test
	void validCreate() {
		//given
		UUID id = UUID.randomUUID();
		AggregateReference<Order, Long> orderId = AggregateReference.to(1L);
		String receiverAddress = "green factory";
		String memo = "fragile";

		//when
		Shipping shipping = Shipping.builder()
			.id(id)
			.orderId(orderId)
			.receiverAddress(receiverAddress)
			.memo(memo)
			.build();

		//then
		assertThat(shipping.getId()).isEqualTo(id);
		assertThat(shipping.getOrderId()).isEqualTo(orderId);
		assertThat(shipping.getReceiverAddress()).isEqualTo(receiverAddress);
		assertThat(shipping.getMemo()).isEqualTo(memo);
	}

	@ParameterizedTest
	@MethodSource("generateInvalidArguments")
	void invalidCreate(String receiverAddress) {
		//given
		UUID id = UUID.randomUUID();
		AggregateReference<Order, Long> orderId = AggregateReference.to(1L);
		String memo = "fragile";

		//expect
		org.junit.jupiter.api.Assertions.assertThrows(InvalidValueException.class, () -> Shipping.builder()
			.id(id)
			.orderId(orderId)
			.receiverAddress(receiverAddress)
			.memo(memo)
			.build());
	}

	private static Stream<Arguments> generateInvalidArguments() {
		return Stream.of(
			Arguments.of(""),
			Arguments.of(" ")
		);
	}
}
