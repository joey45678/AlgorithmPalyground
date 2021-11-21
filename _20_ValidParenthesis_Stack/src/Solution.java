import java.util.Stack;

public class Solution  {

    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c=='{' || c=='(' || c=='[') {
                characterStack.push(c);
            }else{
                if (characterStack.isEmpty())
                    return false;

                char character = characterStack.pop();

                if (character=='{' && c!='}')
                    return false;

                if(character=='(' && c !=')')
                    return false;

                if(character=='[' && c !=']')
                    return false;

            }
        }
        return characterStack.isEmpty();
    }

}
