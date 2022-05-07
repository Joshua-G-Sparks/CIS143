package com.olympic.cis143.m04.student.homework.tacotruckmap.impl;

import com.olympic.cis143.m04.student.homework.tacotruckmap.OrderDoesNotExistException;
import com.olympic.cis143.m04.student.homework.tacotruckmap.Orders;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersMapImpl implements Orders {
	HashMap<String, ArrayList<TacoImpl>> orders = new HashMap<String, ArrayList<TacoImpl>>();

    @Override
    public void createOrder(final String orderid) {
    	ArrayList<TacoImpl> orderList = new ArrayList<TacoImpl>();
    	orders.put(orderid, orderList);
    }

    @Override
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException {
    	ArrayList<TacoImpl> addTo = orders.get(orderid);
    	if (orders.containsKey(orderid)) {
    		addTo.add(taco);
    		orders.replace(orderid, addTo);
    	}
        else throw new OrderDoesNotExistException(orderid);
    	
    }

    @Override
    public boolean hasNext() {
        return ! orders.isEmpty();
    }

    @Override
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException {
    	if (orders.containsKey(orderid)) return orders.remove(orderid);
        else throw new OrderDoesNotExistException(orderid);
    }

    @Override
    public int howManyOrders() {
        return orders.size();
    }

    @Override
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException {
        if (orders.containsKey(orderid)) return orders.get(orderid);
        else throw new OrderDoesNotExistException(orderid);
        //misleading method name, a list of orders would be all orders standing, not all tacos in an order
        //the latter is what is described in the Orders. interface
    }
}
