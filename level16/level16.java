package level16;

class level16 {
    public static void main(String[] args) {
        String[] words = { "pugnacious", "discombobulated", "incredulous", "superfluous", "aficionado", "fez", "gumshoe", "tintinnabulation", "wiseacre", "idiosyncrasies", "fracas", "bamboozle", "juxtaposition", "conundrum", "killjoy", "phantasmagorical", "hoodwink", "schadenfreude", "egads", "izzard", "wisenheimer", "shenanigans", "maelstrom", "effervescent" };

        System.out.println("Array Length is " + words.length + "\n");

        System.out.println("WHILE LOOP I");
        int i = 0;
        while (i < words.length) {
            System.out.print(words[i].length() + " ");
            ++i;
        }

        System.out.println("\n\nWHILE LOOP II");
        i = 0;
        while (i < words.length) {
            if (words[i].charAt(0) == 'i') {
                System.out.print(words[i] + " ");
            }
            ++i;
        }

        System.out.println("\n\nWHILE LOOP III");
        i = 0;
        while (i < words.length) {
            if (words[i].length() > 10) {
                System.out.print(words[i] + " ");
            }
            ++i;
        }

        System.out.println("\n\nWHILE LOOP IV");
        i = 0;
        while (i < words.length) {
            if (words[i].charAt(words[i].length() - 1) == 's') {
                System.out.print(words[i] + " ");
            }
            ++i;
        }

        System.out.println("\n\nWHILE LOOP V");
        i = 0;
        while (i < words.length) {
            if (words[i].length() % 2 == 0) {
                System.out.print(words[i] + " ");
            }
            ++i;
        }
    }
}
