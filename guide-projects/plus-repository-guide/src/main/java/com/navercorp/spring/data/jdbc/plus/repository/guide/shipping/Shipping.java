/*
 * Spring JDBC Plus
 *
 * Copyright 2020-2021 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.spring.data.jdbc.plus.repository.guide.shipping;

import java.util.UUID;

import com.navercorp.spring.data.jdbc.plus.repository.guide.common.exception.ErrorCode;
import com.navercorp.spring.data.jdbc.plus.repository.guide.common.exception.InvalidValueException;
import jakarta.annotation.PostConstruct;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.With;

import com.navercorp.spring.data.jdbc.plus.repository.guide.order.Order;

/**
 * @author Myeonghyeon Lee
 */
@Table("n_shipping")
@Getter
public class Shipping {
	@Id
	@With
	private final UUID id;

	private final AggregateReference<Order, Long> orderId;

	private final String receiverAddress;

	private String memo;

	@Builder
	public Shipping(UUID id, AggregateReference<Order,Long> orderId, String receiverAddress, String memo){
		this.id = id;
		this.orderId = orderId;
		this.receiverAddress = receiverAddress;
		validateReceiverAddress();
		this.memo = memo;
	}

	public void changeMemo(String memo) {
		this.memo = memo;
	}

	private void validateReceiverAddress(){
		if(this.receiverAddress == null || this.receiverAddress.isBlank() || this.receiverAddress.isEmpty())
			throw new InvalidValueException(ErrorCode.INVALID_ADDRESS);
	}
}
