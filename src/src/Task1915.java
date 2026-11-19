import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Task1915 {
    /**
     * - "aabb" -> "a"
     * - "aabb" -> "aa"
     * - "aabb" -> "aab"
     * - "aabb" -> "aabb"
     * - "aabb" -> "a"
     * - "aabb" -> "abb"
     * - "aabb" -> "b"
     * - "aabb" -> "bb"
     * - "aabb" -> "b"
     * */

    public long wonderfulSubstrings(String word) {
        Set<String> set = new HashSet<String>();
        long count = 0;
        for (int i = 0; i <= word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                if (!set.contains(word.substring(i, j))) {
                    if (isWonderful(word.substring(i, j))) {
                        count++;
                        //System.out.println(word.substring(i, j));
                        set.add(word.substring(i, j));
                    }
                } else {
                    count++;
                    //System.out.println(word.substring(i, j));
                }
            }
        }
        return count;
    }

    private boolean isWonderful(String substring) {
        int[] alphabet = new int[11];
        boolean isOddOnce = false;
        for (int i = 0; i < substring.length(); i++) {
            alphabet[substring.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 11; i++) {
            if (alphabet[i] % 2 != 0) {
                if (isOddOnce) {
                    return false;
                } else {
                    isOddOnce = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Task1915 task1915 = new Task1915();
        System.out.println(task1915.wonderfulSubstrings("faecdbcjjbjccjgcadeeaeddbibjiiecggbchebffdchbdicacdbcgdchdgeciceghcdhfbdhcaagghhhjichcgfdaijicahcihgdejhdafjghhjjeaeajdbiheegghhbfgdidcbbfgbdihedfgghjejafdbeedadcagcfejaaihihfdgdedibiiaaaajeifcfcjeeahhcgidcigjhafibejcadaegbeejbficdjgcjfjcgefeifcijibdhaaccdigjeafcebjaiciicghbheifebdadhdeceidcaijihhecjcfcdagdjhfabejjaijajdeaehfghehggjhaidibdidggfghejbggcadhfgjfaeehhicbgjeibbhbijhfghiejadefebigahfeheageagejehgbfajjadicggiegbcbeigdjbcijagajgfaihedcfcjgibiicbjegjgadahdeefajjbajdhcchdeiediecefacdabeegedhcfbiefjagacbfbgbdhejieffhjhcifijjfbccdfgdhhjfbdcejefedgihdjcahaggcjdfafciecibacijddbebccefchjbjfhgeghbhgaacehebafbdghdjdjdbiajeaiiccifcdcjhiaadchfagjdbhfhhiddhaehcjeafediehghbjaafiicgfejadcahfdgagfadbaiehaeaaiifcbcegihfbiacaadjjgahibbfijdbhbcfhhgccihdahchdeeahjeabeiegdgjfdgdfabfiajhagfdhhjaafacaihiagacgijfjdfafehicbeaicafciegfbefehddbfbgfhdcdchabgdigbceeiegabggeiafejbbdgjgijdfjiibadgfjehhaehjdhcdghadeejdfaicjdajjbiachaiadcghjfbefhgdfagbjibjfhegcbeiiecaaifiidgidbcbgidfgibhjcgjcifaegfgbifcjdgddadgedhbeidgbagiddfbaedhjefgjgfdbcabjcigahfbjcjhdhccjjhhffjcbhjhaeaiifajhjcfaejehjabeeggfaebjeiaacaabijjbeiggjfbdfcfgjcebbehbhcjjggaefgbdhfaigaagfafegbbahfiaabijcffbjddjefcfhhdbbgdjiiabdeaihfccbbfdaifcjhidfijdjdbaebaibfcijhhcddachacfbgddfejeafeddjabbdgcfibgijbcjjijhagddidhhaijiafbaajgejihadjdcdjagbfghjabdhhbbicgceifddgbjeceejbigjfgdedeejbjhdibjghigegjigghghhedhdadgedgbhebedjgjbjjhfedgbhhaebgaeebiajijdhdcacffbfedcbdebidbhieijdcbcdfjgdejehbgecgjcdcfhihgajjggffbaaheiabbbebjcbhdhaajbhicibgajddceaaacgaighhbaacbcbdbdbfacgiaaaaaiedfhcgfgfhhgeeidhgghfbbaadfegchahjcebacbhibbbjbhechefigefhcdcagjjhbhfggjgejfaceeebfibaegfchdabdjgfdjjcacgiifcdcigcfjbegddafefaiaihcbdgdccgiijejdadehgibbagjeajafaggehdajahfcbadjibdgjjcigccbdeiadijejhcjiihcbjijgabhcjfgaiajjigefiddhjcbjjhijbbgbjjeffedffdefbdbhifcidajichgcdchafcfhffifgcfedgafgdhbcedafabhgaejbhdejadiagibiijbdeeggejigadcedbcfbbbcijhjdhdhjceecjjbbfbegegahefigfeahgjbeddaedeaefeehhdhbcdiafhediejdbgaicahgeedfcffjagfgccbbfaajadaeijegfffjiidhgiiadiecbhifeicigjegijecgdjihfbjabigfhbjeejbfghfddehechdjffdbadieibjdddeaejhgijhhihejjcibbaaagbihcagifcjhebhgcjdejgabjjabgbfbbigbjccggbegfcfebfbcjaffhgcjfadaeggcajbgegdejhbfjiehbfgacdgaedeicigeejjgfijjjcgdjaeiadgjhgcdjfgdeagfcfdaicffifgbfdjbebeeadcdbdihjfijiiehbchhbdbbjgcgaejcefacjahcgaeajajejehhbdadihbcjfihaejjbabegbiehjhiccdacjaacdgcbfabgfeifchacbegffhccdgihbbbdcjihibjbjjdbgcfjcehedfjfahajbcfbfdhcgbjdcacbbafejafdciideecfacdhcjdbaigcieghigjfhacfeaifjifchdiggijcfaihhbaifcfjiafhffebbdcfhhacgadhcdcfcieifiifdjhhgjjiicbjjjijahcjijehbghfbbigiaieheiehbdfagijaghhjbfgbbdiajiadbddhbcidahiejehcgcjdegfidhhhcebgfhcifagjdiigicdedfjcifdbcfejifcihjgjeggbfifgbeeejcjfadadafghhhgaifegcajffcceedaejbdidhjajhabigfbaegjiejgaihhahecfccefcfgdhgaaabeiibibgdcgdeajbbjceififfdebdjcigehdgdjbgajhjhigjifejjccheceabcgbafbibiibgiicefefhiceigjhijjafdeiafffgcacjdccadcbecieegfgbfdejiafdhdhhfcjhbfjbehdfdfgcbjijiiddcafaaedcacedfebcafhcibcghhcieihdjdgbeaddgdbjheedjgihffbcbiaccbcgibjgcfagjgcbhhbbaafagefgbfcfdfajecfdhdfjifbffcacfbeccdbfgieegefjdhgdffcfjfajafhggfdjhhfhabgdgfcjhjgjjgicahghegdjddabdiechjdcbaichjijbbgehfgadibgajgdebfgahiidibahabgbcbhfddgefjgjbhbjgjdhhfbccheibbfcebjciafgbgijchchedeahagbcbegjehjgfejhcgihcbiheggeehjcigbjebddcbbedfjieijjjbdafbcdhajchgbbhebeijgheaghjhfidceiediagjhggjchefdjfhbadihaaggdchfhfbdifbibbjahbfadihefeaedgcedgdffdjecdhbhfjebihfgfbcfgieedhcijcfgaiifedebbefbgbgaihiafgafbchggdbceeiiadcbgfbfedihbjidicifdjbggebcdcjbgjfabadfgifiiehfffdfbfidghdhjieiifehiccabechjhggfbcaeccghdchccjhchgcjhdehjjecfbfbgjbabjjdjcgadfaffiicgabheadagadhfchibdbdbfeghdhhcedghdfahcgcihaaaeabfbghijgbbbfjaejhidbaaefgeiihdgdfaeijihfifjdcdjjbjfifdbhdhgeiedfcfcecjeecjcaccjjedefabaaghfbcgdagbdbjggjgjgijcijbbbeddiahahhcbjieabehcjgajcihhdjbgjibbiidigjgifhdididaifcfadcghgfceidhicfegaacideifeighghaggdacdhaiaaffafgchgaffhfjhaddgiaigjefbeabgfeaaibabffiiadgfgcddhfiijahcdccichdeebajhfacajgcihhjccajfdehbaehbdfebcaafiahibjbchcfggicbddbhhbbcfghdehjijhggiidagebfdhaifeghajabbejcgcbigifbedgaagdcccagbeccifgfbdhaidddbdehcafbefcifjjiiibb"));
    }
}

/**
 *
 *
 * e
 * ehaeh
 * ehaehcjja
 * h
 * a
 * e
 * eh
 * h
 * c
 * cjj
 * cjjaa
 * j
 * jj
 * jja
 * jjaa
 * jjaaf
 * j
 * jaa
 * jaafj
 * a
 * aa
 * aaf
 * a
 * f
 * j
 * d
 * c
 * e
 * a
 * c*/