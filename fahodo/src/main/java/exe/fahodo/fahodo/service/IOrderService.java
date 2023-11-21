package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.Order;

import java.util.List;

public interface IOrderService {
    public List<Order> GetAllOrder();
    public List<Order> GetOrderByUsername(String username);

    public boolean CreatOrder(Order order);

    public Order GetOrderById(long id);

}
