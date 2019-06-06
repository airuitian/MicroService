package org.newit.microservice.ebusiness.controller;

import java.util.List;

import org.newit.microservice.ebusiness.model.Item;
import org.newit.microservice.ebusiness.model.Order;
import org.newit.microservice.ebusiness.model.User;
import org.newit.microservice.ebusiness.service.ItemService;
import org.newit.microservice.ebusiness.service.OrderService;
import org.newit.microservice.ebusiness.service.UserService;
import org.newit.microservice.ebusiness.view.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

@Controller
public class OrderController extends BaseController{

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @RequestMapping("/order/detail/{orderId}")
    public String orderDetail(@PathVariable Long orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        OrderView orderView = orderService.getOrderView(order);
        model.addAttribute("orderView", orderView);
        return "order/orderDetail";
    }

    @RequestMapping("/order/list")
    public String orderList(@RequestParam(value = "buyerId", required = false, defaultValue = "0") long buyerId,
                            @RequestParam(value = "sellerId", required = false, defaultValue = "0")
                                    long sellerId,
                            Model model) {
        List<Order> orderList = Lists.newArrayList();
        if (buyerId > 0) {
            orderList = orderService.getOrderListByBuyerId(buyerId);
        } else if (sellerId > 0) {
            orderList = orderService.getOrderListBySellerId(sellerId);
        }
        List<OrderView> orderViewList = Lists.newArrayList();
        orderList.forEach(order -> orderViewList.add(orderService.getOrderView(order)));
        model.addAttribute("orderViewList", orderViewList);
        return "order/orderList";
    }

    @RequestMapping("/order/create")
    @ResponseBody
    public JSONObject createOrder(@RequestBody Item item) {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        orderService.createOrder(item.getId(), userDetails.getUsername());
        JSONObject result = new JSONObject();
        result.put("success", true);
        return result;
    }
}
