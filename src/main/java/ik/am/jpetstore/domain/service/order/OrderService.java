package ik.am.jpetstore.domain.service.order;

import java.util.List;

import ik.am.jpetstore.domain.model.Order;

public interface OrderService {

	int insertOrder(Order order);

	Order getOrder(int orderId);

	List<Order> getOrdersByUsername(String username);

}
