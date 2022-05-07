package com.olympic.cis143.m04.student.tacotruck.set;

import java.util.HashSet;
import java.util.Iterator;

import com.olympic.cis143.m04.student.tacotruck.Orders;
import com.olympic.cis143.m04.student.tacotruck.TacoImpl;

public class OrdersSetImpl  implements Orders 
{
	HashSet<TacoImpl> set = new HashSet<TacoImpl>();
	
    @Override
    public void addOrder(TacoImpl tacoOrder) 
    {
    	set.add(tacoOrder);
    }

    @Override
    public boolean hasNext() 
    {
    	Iterator<TacoImpl> setIt = this.set.iterator();
    	return setIt.hasNext();
    }

    @Override
    public TacoImpl closeNextOrder() 
    {
    	Iterator<TacoImpl> setIt = set.iterator();
    	for (TacoImpl grab : set) 
    	{
    		setIt.next();
    		if (!setIt.hasNext()) 
    		{
    			setIt.remove();
    			return grab;
    		}
    	}
    	return null; // if you never reached the end of the set, there is a serious problem
    }

    @Override
    public int howManyOrders() {
        return set.size();
    }
}
