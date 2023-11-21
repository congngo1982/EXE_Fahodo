package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.Order;
import exe.fahodo.fahodo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> GetAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> GetOrderByUsername(String username) {
        return orderRepository.getAllByUsername(username);
    }

    @Override
    public boolean CreatOrder(Order order) {
        boolean result = true;
        try {
            orderRepository.save(order);
        }catch (Exception ex){
            result = false;
        }
        return result;
    }

    @Override
    public Order GetOrderById(long id) {
        Order order = null;
        try{
            order = orderRepository.getById(id);
        }catch (Exception e){

        }
        return order;
    }
}
