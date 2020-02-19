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
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>(),  LocalDate.parse("2020-02-17"));
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
        Order order = new Order("Mr X", "Chicago, 60601", lineItems,  LocalDate.parse("2020-02-17"));
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
        Order order = new Order("Mr X", "Chicago, 60601", lineItems,  LocalDate.parse("2020-02-19"));
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("折扣:\t1.17"));
        assertThat(output, containsString("总价:\t57.13"));
    }

    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>(), LocalDate.parse("2020-02-17"));
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems, LocalDate.parse("2020-02-17")));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
        assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
        assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
        assertThat(output, containsString("税额:\t6.5"));
        assertThat(output, containsString("总价:\t71.5"));
    }

}