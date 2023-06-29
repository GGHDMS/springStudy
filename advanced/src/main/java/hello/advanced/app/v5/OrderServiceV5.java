package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logTrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepositoryV4;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepositoryV4, LogTrace trace) {
        this.orderRepositoryV4 = orderRepositoryV4;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        template.execute("OrderService.orderItem()", () -> {
            orderRepositoryV4.save(itemId);
            return null;
        });
    }
}
