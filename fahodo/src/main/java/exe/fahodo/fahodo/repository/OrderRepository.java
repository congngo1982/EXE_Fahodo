package exe.fahodo.fahodo.repository;

import exe.fahodo.fahodo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> getAllByUsername(String username);

    public Order getById(long id);

}
