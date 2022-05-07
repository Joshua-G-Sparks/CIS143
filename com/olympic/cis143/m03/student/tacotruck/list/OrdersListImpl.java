package com.olympic.cis143.m03.student.tacotruck.list;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.olympic.cis143.m03.student.tacotruck.*;

public class OrdersListImpl implements Orders 
{
	List<TacoImpl> list = new ArrayList<>();
	Iterator<TacoImpl> listIt = list.iterator();

	@Override
	public void addOrder(TacoImpl tacoOrder) 
	{
		list.add(tacoOrder);
		
	}

	@Override
	public boolean hasNext() 
	{
		return listIt.hasNext();
	}

	@Override
	public TacoImpl closeNextOrder() 
	{
		return list.remove(0);
	}

	@Override
	public int howManyOrders() 
	{
		return list.size();
	}

}
