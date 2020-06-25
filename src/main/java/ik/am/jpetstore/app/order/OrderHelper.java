package ik.am.jpetstore.app.order;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import ik.am.jpetstore.domain.model.Account;
import ik.am.jpetstore.domain.model.Cart;
import ik.am.jpetstore.domain.model.Order;
import ik.am.jpetstore.domain.model.UserDetails;
import ik.am.jpetstore.domain.service.order.OrderService;

@Component
public class OrderHelper {
	@Inject
	protected OrderService orderService;

	@Inject
	protected Mapper beanMapper;

	public Order newOrder(OrderForm orderForm, Cart cart) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Account account = userDetails.getAccount();

		Order order = new Order();
		order.initOrder(account, cart);
		beanMapper.map(orderForm, order);
		int orderId = orderService.insertOrder(order);
		order.setOrderId(orderId);
		return order;
	}
}
