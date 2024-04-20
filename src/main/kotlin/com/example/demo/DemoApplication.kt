package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

/**
 * scoping
 * minimum requirement
 * how to do input handling ?
 * database layer ?
 * should go by main method Or controller service repo pattern
 *
 *
 * */
















/**
 * Trello :
 *
 *
 * Board :
 *      id name lists, members(i.e. users)
 *
*  List
 *      id name cards
 * Card
 *      id name assignedTo?
*  Users
 *      id name
 *
 *
 * create , delete get add lists board
 * add card
 * assign card to user
 * show
 *
 *
 *
 *
 * */






























/**
 *
 * Splitwise :
 * interface distribution
 *
 * class PercentDistribution
 * class ExactDistribution
 *
 * User
 * id name
 *
 * Transaction
 * user		amount 		transContri
 *
 * TransParticipant
 * distributionType 		Contri
 *
 * Ows
 * userSource 	userDest	amount
 *
 *
 * can transaction be done by multiple people
 *
 * */


/*
*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

            bufferedWriter.write(String.valueOf(n));
            bufferedWriter.newLine();


            List<Integer> l =  Stream.of(br.readLine().trim().split("\\s+")).map(Integer::parseInt).collect(toList());

            for (int i: l){
                bufferedWriter.write(String.valueOf(i));
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
        *
* */


/*
 * Ideal design for Snake n ladder
 *
 *
 * Snake
 *      start   end
 * Ladder
 *      start   end
 * Player
 *      name    id      position
 * Board
 *      players     ladders     snakes      sizeOfBoard
 *
 *
 * Dice
 * DiceService
 *      having roll function
 *
 * SnakeAndLadderService
 *      having main logic
 *      startGame function
 *
 *
 * players can be managed with Queue
 *
 *
 * */


/**
 * Ideal for Splitwise
 *
 *
 * User (id name)
 * Split (Subclasses EqualSplit, ExactSplit, PercentSplit)
 * ExpenseMetadata (For Optional requirement #1)
 * Expense (Subclasses EqualExpense, ExactExpense, PercentExpense)
 * ExpenseType (enum to differentiate between different expense types)
 *
 *
 * public class EqualSplit extends Split {
 *     public EqualSplit(User user) {
 *         super(user);
 *     }
 * }
 *
 * public class ExactSplit extends Split {
 *     public ExactSplit(User user, double amount) {
 *         super(user);
 *         this.amount = amount;
 *     }
 * }
 *
 * public class PercentSplit extends Split {
 *     double percent;
 *
 *     public PercentSplit(User user, double percent) {
 *         super(user);
 *         this.percent = percent;
 *     }
 *
 *
 * public abstract class Expense {
 *     private String id;
 *     private double amount;
 *     private User paidBy;
 *     private List<Split> splits;*
 *    }
 * }
 *
 * public class ExpenseManager {
 *     List<Expense> expenses;
 *     Map<String, User> userMap;
 *     Map<String, Map<String, Double> > balanceSheet;
 *    }
 *
 * */