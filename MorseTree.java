public class MorseTree{
    public TreeNode<Character> root;

    public MorseTree(){
        this.root = new TreeNode<Character>(' ');
        root.insertLeft(new TreeNode<Character>('e'));
        root.getLeft().insertLeft(new TreeNode<Character>('i'));
        root.getLeft().getLeft().insertLeft(new TreeNode<Character>('s'));
        root.getLeft().getLeft().getLeft().insertLeft(new TreeNode<Character>('h'));
        root.insertRight(new TreeNode<Character>('t'));
        root.getLeft().insertRight(new TreeNode<Character>('a'));
        root.getRight().insertLeft(new TreeNode<Character>('n'));
        root.getRight().insertRight(new TreeNode<Character>('m'));
        root.getLeft().getLeft().insertRight(new TreeNode<Character>('u'));
        root.getLeft().getRight().insertLeft(new TreeNode<Character>('r'));
        root.getLeft().getRight().insertRight(new TreeNode<Character>('w'));
        root.getRight().getLeft().insertLeft(new TreeNode<Character>('d'));
        root.getRight().getLeft().insertRight(new TreeNode<Character>('k'));
        root.getRight().getRight().insertLeft(new TreeNode<Character>('g'));
        root.getRight().getRight().insertRight(new TreeNode<Character>('o'));
        root.getLeft().getLeft().getLeft().insertRight(new TreeNode<Character>('v'));
        root.getLeft().getLeft().getRight().insertLeft(new TreeNode<Character>('f'));
        root.getLeft().getRight().getLeft().insertLeft(new TreeNode<Character>('l'));
        root.getLeft().getRight().getRight().insertLeft(new TreeNode<Character>('p'));
        root.getLeft().getRight().getRight().insertRight(new TreeNode<Character>('j'));
        root.getRight().getLeft().getLeft().insertLeft(new TreeNode<Character>('b'));
        root.getRight().getLeft().getLeft().insertRight(new TreeNode<Character>('x'));
        root.getRight().getLeft().getRight().insertLeft(new TreeNode<Character>('c'));
        root.getRight().getLeft().getRight().insertRight(new TreeNode<Character>('y'));
        root.getRight().getRight().getLeft().insertLeft(new TreeNode<Character>('z'));
        root.getRight().getRight().getLeft().insertRight(new TreeNode<Character>('q'));
        //finish the tree
    }

    public String lookFor(char letter, TreeNode<Character> node, String morseString){
       if (node.getElement() == letter){
        return morseString;
       }
       else if(node.getLeft() != null && node.getRight() != null){
        String leftOut = lookFor(letter, node.getLeft(), morseString + "o");
        if(leftOut == null){
            return lookFor(letter, node.getRight(), morseString + "-");

            // incase of bug, look here
            /*String rightOut = lookFor(letter, node.getRight(), morseString + "-");
            if (rightOut == null){
                return null;
            }
            else{
                return rightOut;
            }*/

        }
        else{
            return leftOut;
        }
       }
       else if(node.getLeft() == null && node.getRight() == null){
        return null;
       }
       else if(node.getLeft() == null){
        return lookFor(letter, node.getRight(), morseString + "-");
       }
       else{
        return lookFor(letter, node.getLeft(), morseString + "o");
       }
    }

    public String stringToMorse(String string){
        String morseString = "";
        for (int i = 0; i < string.length(); i++){
            char index = string.charAt(i);
            if (index == ' '){
                
            }
            else{
                morseString = morseString + lookFor(index, root, "") + "|";
            }
        }
        return morseString;
    }
    
    public String morseToString(String morse){
        String unMorsedString = "";
        TreeNode<Character> node = root;
        for (int i = 0; i < morse.length(); i++){
            if (morse.charAt(i) == 'o'){
                node = node.getLeft();
            }
            else if (morse.charAt(i) == '-'){
                node = node.getRight();
            }
            else{
                unMorsedString = unMorsedString + node.getElement();
                node = root;
            }
        }
        return unMorsedString;
    }

    public String preOrder(){
        return this.root.preorder();
    }

    public String postOrder(){
        return this.root.postorder();
    }
}