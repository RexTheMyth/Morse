public class MorseTester {
    public static void main(String[] args) {
        MorseTree morseTree = new MorseTree();
        
        System.out.println(morseTree.preOrder());

        System.out.println(morseTree.postOrder());

        String sentence = "shinx of black quartz judge my vow";
        String morse = morseTree.stringToMorse(sentence);
        String unMorsedMorse = morseTree.morseToString(morse);

        System.out.println(sentence);
        System.out.println(morse);
        System.out.println(unMorsedMorse);
    }
    
}
