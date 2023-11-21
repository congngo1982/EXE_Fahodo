package exe.fahodo.fahodo.controller;

import exe.fahodo.fahodo.entity.Order;
import exe.fahodo.fahodo.entity.OrderResponse;
import exe.fahodo.fahodo.service.IBookService;
import exe.fahodo.fahodo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderRestController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IBookService bookService;

    @GetMapping("/getall")
    public List<Order> GetAll() {
        return orderService.GetAllOrder();
    }

    @GetMapping("/get/{username}")
    public List<Order> GetByUsername(@PathVariable String username) {
        return orderService.GetOrderByUsername(username);
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<Boolean> Create(Authentication authentication, @RequestBody Order order, @PathVariable int id) {
        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
//        order = new Order(1, bookService.GetBookById(id), authentication.getName(), "OK", 10, 1, "HCM", "0101");
//        order.setBook(bookService.GetBookById(id));

        order.setBookTitle(bookService.GetBookById(id).getTitle());
        order.setUsername(authentication.getName());
        System.out.println(order);
        boolean result = orderService.CreatOrder(order);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getorder")
    public ResponseEntity<OrderResponse> GetOrder(Authentication authentication) {
        OrderResponse orderResponse = new OrderResponse("", new ArrayList<>());
        List<Order> orders = new ArrayList<>();
        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        String username = authentication.getName();
        if (authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
            orders = orderService.GetAllOrder();
            orderResponse.setRole("ADMIN");
            orderResponse.setOrders(orders);
        } else if (authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_STORE"))) {
            orderResponse.setRole("STORE");
            orderResponse.setOrders(orders);
        } else if (authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_CUSTOMER"))) {
            orders = orderService.GetOrderByUsername(username);
            orderResponse.setRole("CUSTOMER");
            orderResponse.setOrders(orders);
        }
        return ResponseEntity.ok(orderResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<String> UpdateOrder(Authentication authentication, @RequestParam(name = "orderId") long orderId, @RequestParam(name = "status") int status) {
        if (authentication == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
        }
        Order order = orderService.GetOrderById(orderId);
        if (order != null) {
            order.setStatus(status);
            orderService.CreatOrder(order);
        }
        return ResponseEntity.ok("OK");
    }
}
