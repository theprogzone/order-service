package com.ecommerce.order_service.service;

import com.ecommerce.order_service.dto.ItemDTO;
import com.ecommerce.order_service.dto.OrderDTO;
import com.ecommerce.order_service.model.LineItem;
import com.ecommerce.order_service.model.Order;
import com.ecommerce.order_service.repository.ItemRepository;
import com.ecommerce.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ItemRepository itemRepository;

    @Override
    public void createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        // Generate order number. This is unique value. Use the current timestamp to generate this one
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new java.util.Date());
        order.setOrderNumber(timeStamp);
        orderRepository.save(order);

        List<LineItem> list = new ArrayList<>();
        // Loop the list of items coming from front end.
        // Convert ItemDTO to LineItem entity inside the for loop
        // Add the LineItem entity classes to ArrayList
        // End of the for loop, save the LineItem ArrayList using itemRepository saveAll method
        for (ItemDTO itemDTO : orderDTO.getItems()) {
            LineItem lineItem = new LineItem();
            BeanUtils.copyProperties(itemDTO, lineItem);
            lineItem.setOrderId(order.getId());
            list.add(lineItem);
        }
        itemRepository.saveAll(list);
    }
}
