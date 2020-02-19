package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintDateStringOnOrder() {
        Order order = new Order(new ArrayList<LineItem>(),  LocalDate.parse("2020-02-17"));
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("2020年2月17日，星期一"));
    }

    @Test
    void shouldPrintLineItemAmountOnOrder() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.0, 1));
        }};
        Order order = new Order(lineItems,  LocalDate.parse("2020-02-17"));
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("总价:\t58.30"));
    }

    @Test
    void shouldPrintLineItemAmountWithDiscountOnOrder() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.0, 1));
        }};
        Order order = new Order(lineItems,  LocalDate.parse("2020-02-19"));
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("折扣:\t1.17"));
        assertThat(output, containsString("总价:\t57.13"));
    }

}