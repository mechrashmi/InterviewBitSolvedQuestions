package String;

import java.util.ArrayList;

public class PrintAllPossibleStringsOfLengthkThatCanBeFormedFromASetOfnCharacters {
    public static void main(String[] args) {
        String[] input = {"a", "b"};
        ArrayList<String> result = new ArrayList<>();
        findAll(result, input, new StringBuilder(), 4);

        for(String str : result){
            System.out.println(str);
        }
    }

    public static void findAll(ArrayList<String> resultSet, String[] charList, StringBuilder current, int k){
        if(current.length() == k){
            resultSet.add(current.toString());
            return;
        }

        for(int i = 0; i < charList.length; i++){
            StringBuilder newBuilder = new StringBuilder(current);
            newBuilder.append(charList[i]);
            findAll(resultSet, charList, newBuilder, k);
        }
    }
}
