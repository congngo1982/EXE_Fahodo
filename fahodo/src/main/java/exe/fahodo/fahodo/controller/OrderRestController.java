package exe.fahodo.fahodo.controller;

import exe.fahodo.fahodo.entity.Account;
import exe.fahodo.fahodo.entity.Order;
import exe.fahodo.fahodo.entity.OrderResponse;
import exe.fahodo.fahodo.service.*;
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

    @Autowired
    private IAccountService accountService;

    @Autowired
    private EmailService emailService;

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
        Order createOrder = orderService.CreatOrder(order);
        boolean result = createOrder != null ? true : false;
        emailService.sendEmail(accountService.GetAccountByUsername(authentication.getName()).getEmail(),
                "Your Order has been Created",
                EmailTemplate(createOrder));
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
            orders = orderService.GetAllOrder();
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
            Order orderUpdate = orderService.CreatOrder(order);
            System.out.println(orderUpdate.getStatus());
            Account account = accountService.GetAccountByUsername(orderUpdate.getUsername());
            emailService.sendEmail(account.getEmail(),
                    "Your Order has been Updated",
                    EmailTemplate(orderUpdate));
        }
        return ResponseEntity.ok("OK");
    }

    public String EmailTemplate(Order order) {
        int status = order.getStatus();
        String orderStatus = "";
        if(status == 1){
            orderStatus = "Chờ xác nhận";
        }
        if(status == 2){
            orderStatus = "Sẵn sàng giao";
        }
        if(status == 3){
            orderStatus = "Giao hàng thành công";
        }
        String template = String.format("Xin chào %s,\n" +
                "\n" +
                "Fahodo xin phép cập nhật trạng thái đơn hàng.\n" +
                "\n" +
                "Thông tin chi tiết đơn hàng:\n" +
                "Mã đơn hàng: %s\n" +
                "Giá: %,.2f\n" +
                "Trạng thái: %s\n" +
                "\n" +
                "Cảm ơn bạn đã tham khảo và sử dụng dịch vụ tại Fahodo,\n" +
                "\n" +
                "FAHODO.", order.getUsername(), order.getId(), order.getTotalPrice(), orderStatus);
        return template;
    }
}
