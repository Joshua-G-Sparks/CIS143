package com.olympic.cis143.m02.student.homework;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//modified this to import the homework Card rather than the lab Card
import com.olympic.cis143.m02.student.homework.Card;
import com.olympic.cis143.m02.student.homework.Card.Suit;
import com.olympic.cis143.m02.student.homework.Card.Value;

/**
 * Note that you can think of the deck implementation as being an iterator in that its creates and used once. Meaning, when a card is
 * delt is  MUST be removed from the deck.
 */
public class DeckLinkedListImpl 
{

    /**
     * This will be the stack object for you to work with.
     */
    private Deque<Card> deck = new LinkedList<>();

    /**
     * Const.
     * @param jokers True if you want jokers in this deck.
     */
    public DeckLinkedListImpl(final boolean jokers) 
    {
        this.createDeck(jokers);
    }

    /**
     * Private. THis is the place where you will need to create a deck of cards. You can iterate throug
     * ther enums in Card.
     *
     * Some rules:
     * ============
     * 1. Note the boolean jokers parameter. If true add the Jokers to the deck with a Card.Suite.NONE.
     * 2. Do not create cards, other than jokers, with a Card.Suite.NONE.
     *
     * Outcome
     * ========
     * if jokers == true, 54 cards will be created.
     * if jokers == false, 52 cards are created.
     *
     * @param jokers True if you want jokers added to the deck.
     */
    private void createDeck(final boolean jokers) 
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
    				deck.push(new Card(suitGrab, valGrab));
    			}
    		}
    	}
    	if (jokers)
    	{    		
    		for (int i = 0; i < 2; i++)
    		{
    			deck.push(new Card(Card.Suit.NONE, Card.Value.JOKER));
    		}
    	}
    }

    /**
     * Gets the deck.
     * @return The deck.
     */
    public Deque<Card> getDeck() {
        return this.deck;
    }
    /**
     * Randomize and shuffle the deck of cards.
     */
    public void shuffle() {
    	Collections.shuffle((List<?>) deck);
    }

    /**
     * True if the deck has cards remaining else false.
     * @return
     */
    public boolean hasNext() 
    {
        if (deck.isEmpty()) return false;
        else return true;
    }

    /**
     * Always call the hasNext() method before calling this method.
     * This method should get the next card in the deck.
     *
     * Outcome
     * =======
     * The method will remove the next from the deck and return it in the method.
     *
     * If the deck is empty it should through a RuntimeException.
     * @return
     */
    public Card dealCard() 
    {
    	/* 
    	 * since a deck of cards is a LIFO structure, assuming it is face down on a table, a stack is best as it is a LIFO structure as well
    	 * however, since we are using a LinkedList
    	 */
    	if (this.hasNext()) return deck.pop();
    	else throw new RuntimeException();
    	
    }
}
