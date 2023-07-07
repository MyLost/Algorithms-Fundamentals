package exams;

import java.util.*;

public class BitcoinTransactions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] transactionsOne = scanner.nextLine().split(" ");
        String[] transactionsTwo = scanner.nextLine().split(" ");

        List<String> transactions = findLongestTransaction(transactionsOne, transactionsTwo);

        System.out.println("[" + String.join(" ", transactions) + "]");
    }

    public static void findTransactions(String[] transactions, int index, Map<String, List<Integer>> indices,
                                     List<String> currentTransaction, List<List<String>> inTransaction) {
        if (index == transactions.length) {
            inTransaction.add(new ArrayList<>(currentTransaction));
            return;
        }

        String transaction = transactions[index];
        if (indices.containsKey(transaction)) {
            List<Integer> transactionIndices = indices.get(transaction);
            for (int i : transactionIndices) {
                if (currentTransaction.isEmpty() || i > Integer.parseInt(currentTransaction.get(currentTransaction.size() - 1).substring(2))) {
                    currentTransaction.add(transaction);
                    findTransactions(transactions, index + 1, indices, currentTransaction, inTransaction);
                    currentTransaction.remove(currentTransaction.size() - 1);
                }
            }
        }
        findTransactions(transactions, index + 1, indices, currentTransaction, inTransaction);
    }

    public static List<String> findLongestTransaction(String[] transactionsOne, String[] transactionsTwo) {
        Map<String, List<Integer>> indices = new HashMap<>();

        for (int i = 0; i < transactionsTwo.length; i++) {
            String transaction = transactionsTwo[i];
            if (!indices.containsKey(transaction)) {
                indices.put(transaction, new ArrayList<>());
            }
            indices.get(transaction).add(i);
        }

        List<List<String>> transaction = new ArrayList<>();
        List<String> currentTransaction = new ArrayList<>();
        findTransactions(transactionsOne, 0, indices, currentTransaction, transaction);

        int maxLength = 0;
        for (List<String> seq : transaction) {
            if (seq.size() > maxLength) {
                maxLength = seq.size();
            }
        }

        List<String> longestTransactions = new ArrayList<>();
        for (List<String> trans : transaction) {
            if (trans.size() == maxLength) {
                longestTransactions = trans;
                break;
            }
        }

        return longestTransactions;
    }

}
