public class MorseTree{
    public TreeNode<Character> root;

    public MorseTree(){
        this.root = new TreeNode<Character>(' ');
    }

    public MorseTree morseify(MorseTree tree){
        tree.root.insertLeft(new TreeNode<Character>('e'));
        tree.root.getLeft().insertLeft(new TreeNode<Character>('i'));
        tree.root.getLeft().getLeft().insertLeft(new TreeNode<Character>('s'));
        tree.root.getLeft().getLeft().getLeft().insertLeft(new TreeNode<Character>('h'));
        tree.root.insertRight(new TreeNode<Character>('t'));
        tree.root.getLeft().insertRight(new TreeNode<Character>('a'));
        tree.root.getRight().insertLeft(new TreeNode<Character>('n'));
        tree.root.getRight().insertRight(new TreeNode<Character>('m'));
        tree.root.getLeft().getLeft().insertRight(new TreeNode<Character>('u'));
        tree.root.getLeft().getRight().insertLeft(new TreeNode<Character>('r'));
        tree.root.getLeft().getRight().insertRight(new TreeNode<Character>('w'));
        tree.root.getRight().getLeft().insertLeft(new TreeNode<Character>('d'));
        tree.root.getRight().getLeft().insertRight(new TreeNode<Character>('k'));
        tree.root.getRight().getRight().insertLeft(new TreeNode<Character>('g'));
        tree.root.getRight().getRight().insertRight(new TreeNode<Character>('o'));
        tree.root.getLeft().getLeft().getLeft().insertRight(new TreeNode<Character>('v'));
        tree.root.getLeft().getLeft().getRight().insertLeft(new TreeNode<Character>('f'));
        tree.root.getLeft().getRight().getLeft().insertLeft(new TreeNode<Character>('l'));
        tree.root.getLeft().getRight().getRight().insertLeft(new TreeNode<Character>('p'));
        tree.root.getLeft().getRight().getRight().insertRight(new TreeNode<Character>('j'));
        tree.root.getRight().getLeft().getLeft().insertLeft(new TreeNode<Character>('b'));
        tree.root.getRight().getLeft().getLeft().insertRight(new TreeNode<Character>('x'));
        tree.root.getRight().getLeft().getRight().insertLeft(new TreeNode<Character>('c'));
        tree.root.getRight().getLeft().getRight().insertRight(new TreeNode<Character>('y'));
        tree.root.getRight().getRight().getLeft().insertLeft(new TreeNode<Character>('z'));
        tree.root.getRight().getRight().getLeft().insertRight(new TreeNode<Character>('q'));
        return tree;
    }

    public String lookFor(char letter, TreeNode<Character> node, String morseString){
       if (node.getElement() == letter){
        return morseString;
       }
       else if(node.getLeft() != null && node.getRight() != null){
        String leftOut = lookFor(letter, node.getLeft(), morseString + "o");
        if(leftOut == null){
            return lookFor(letter, node.getRight(), morseString + "-");
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