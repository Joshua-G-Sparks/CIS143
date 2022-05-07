package com.olympic.cis143.m03.student.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.olympic.cis143.m03.student.homework.Card.Suit;
import com.olympic.cis143.m03.student.homework.Card.Value;

public class DeckIteratorImpl implements Deck 
{

	private List<Card> deck = new ArrayList<>();
	Iterator<Card> deckIt = deck.iterator();
	
	public DeckIteratorImpl(final boolean jokers) 
    {
        this.createDeck(jokers);
    }
	
	private void createDeck(boolean jokers) 
	{
		Suit[] suit = Card.Suit.values();
    	Value[] values = Card.Value.values();
    	
    	for (Suit suitGrab : suit)
    	{
    		if (suitGrab == Card.Suit.NONE) break;
    		for (Value valGrab : values)
    		{
    			if (valGrab != Card.Value.JOKER)
    			{
    				deck.add(new Card(suitGrab, valGrab));
    			}
    		}
    	}
    	
    	if (jokers)
    	{    		
    		for (int i = 0; i < 2; i++)
    		{
    			deck.add(new Card(Card.Suit.NONE, Card.Value.JOKER));
    		}
    	}
    	
    	deckIt = deck.iterator(); //need to update the iterator to retain parity with modCount
	}

	@Override
	public List<Card> getDeck() 
	{
		return deck;
	}

	@Override
	public void shuffle() 
	{
		Collections.shuffle(deck);
		deckIt = deck.iterator();
	}

	@Override
	public boolean hasNext() 
	{
		return deckIt.hasNext();
	}

	@Override
	public Card dealCard() 
	{
		
		// return deckIt.next(); // i was going to use this, but i think it does not remove the card from the deck
		Card nextCard = deckIt.next();
		deckIt.remove();
		return nextCard;
	}

}
