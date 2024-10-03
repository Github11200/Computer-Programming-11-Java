package level14;

class level14 {
    public static void main(String[] args) {
        String userWord = args[0];

        if (userWord.length() < 4) {
            System.out.println("ERROR! LENGTH OF WORD IS INSUFFICIENT");
            return;
        }

        int wordLength = userWord.length();

        char firstCharacter = userWord.charAt(0);
        char fourthCharacter = userWord.charAt(3);
        int lastCharacterIndex = userWord.length() - 1;
        char lastCharacter = userWord.charAt(lastCharacterIndex);

        int numberOfTs = 0;
        int i = 0;
        while (i < wordLength) {
            if (userWord.charAt(i) == 'T' || userWord.charAt(i) == 't') {
                ++numberOfTs;
            }
            ++i;
        }

        int numberOfVowels = 0;
        int nonVowels = 0;
        i = 0;
        while (i < wordLength) {
            char currentChar = Character.toLowerCase(userWord.charAt(i));
            if (currentChar == 'a' ||
                    currentChar == 'e' ||
                    currentChar == 'i' ||
                    currentChar == 'o' ||
                    currentChar == 'u') {
                ++numberOfVowels;
            } else {
                ++nonVowels;
            }
            ++i;
        }

        String reversed = "";
        i = lastCharacterIndex;
        while (i >= 0) {
            reversed += userWord.charAt(i);
            --i;
        }

        System.out.println("Your word has " + wordLength + " characters.");
        System.out.println("The first character of your word is " + firstCharacter + ".");
        System.out.println("The fourth character of your word is " + fourthCharacter + ".");
        System.out.println("The index of the last character is " + lastCharacterIndex + ".");
        System.out.println("The last character of your word is " + lastCharacter + ".");
        System.out.println("The number of t's or T's (combined) is " + numberOfTs + ".");
        System.out.println("Your word has " + numberOfVowels + " vowels.");
        System.out.println("Your word has " + nonVowels + " non-vowels.");
        System.out.println("Your word in reverse order is " + reversed);
    }
}
