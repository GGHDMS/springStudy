package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logTrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderServiceV4;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderServiceV4, LogTrace trace) {
        this.orderServiceV4 = orderServiceV4;
        template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {

        return template.execute("OrderController.request()", () -> {
            orderServiceV4.orderItem(itemId);
            return "ok";
        });
    }
}

