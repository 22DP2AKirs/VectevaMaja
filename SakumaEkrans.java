public class SakumaEkrans {
    static int izvelnesSkaits = 1;
    static String[] sakumaEkranaIzvelesVarduVarianti = {"", "", "", "", ""};
    static String[] sakumaEkranaBildesCikls() {

        if (izvelnesSkaits == 1) { // Spēlēt.
            sakumaEkranaIzvelesVarduVarianti[0] = izvelnesBultinas[0] + " S P E L E T " + izvelnesBultinas[1];
        } else {
            sakumaEkranaIzvelesVarduVarianti[0] = "  S P E L E T  ";
        }

        if (izvelnesSkaits == 2) {
            sakumaEkranaIzvelesVarduVarianti[1] = izvelnesBultinas[0] + " I E S T A T I J U M I " + izvelnesBultinas[1];
        } else {
            sakumaEkranaIzvelesVarduVarianti[1] = "  I E S T A T I J U M I  ";
        }
        
        if (izvelnesSkaits == 3) {
            sakumaEkranaIzvelesVarduVarianti[2] = izvelnesBultinas[0] + " P A M A C I B A " + izvelnesBultinas[1];
        } else {
            sakumaEkranaIzvelesVarduVarianti[2] = "  P A M A C I B A  ";
        }

        if (izvelnesSkaits == 4) {
            sakumaEkranaIzvelesVarduVarianti[3] = izvelnesBultinas[0] + " A K A U N T S " + izvelnesBultinas[1];
        } else {
            sakumaEkranaIzvelesVarduVarianti[3] = "  A K A U N T S  ";
        }

        if (izvelnesSkaits == 5) {
            sakumaEkranaIzvelesVarduVarianti[4] = izvelnesBultinas[0] + " I Z I E T " + izvelnesBultinas[1];
        } else {
            sakumaEkranaIzvelesVarduVarianti[4] = "  I Z I E T  ";
        }

        String[] sakumaEkranaIzvelne = {

            "\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
            "\r|                                           :::::                                                      |",
            "\r|   :::    :::  :::::::  ::::::  ::::::::  :::::::  :::    :::  .::::::.                               |",
            "\r|    :::  :::   ::....   ::         ::     ::....    :::  :::   ::    ::                               |",
            "\r|     ::::::    ::''''   ::         ::     ::''''     ::::::    ::''''::                               |",
            "\r|      ::::     :::::::  ::::::     ::     :::::::     ::::     ::    ::                               |",
            "\r|                                                                          ::::::                      |",
            "\r|                                                              ::.   .::  .::::::.      ::  .::::::.   |",
            "\r|                                                              ::::.::::  ::    ::      ::  ::    ::   |",
            "\r|                                                              :: ':' ::  ::''''::      ::  ::''''::   |",
            "\r|                                                              ::     ::  ::    ::  ::::'   ::    ::   |",
            "\r|                                                                                                      |",
            "\r|               " + sakumaEkranaIzvelesVarduVarianti[0] + "                                                                        |",
            "\r|                                                                                                      |",
            "\r|          " + K.SARKANS + sakumaEkranaIzvelesVarduVarianti[1] + K.RESET + "                                                                   |", //14
            "\r|                                                                                                      |",
            "\r|             " + K.SARKANS + sakumaEkranaIzvelesVarduVarianti[2] + K.RESET + "                                                                      |",
            "\r|                                                                                                      |",
            "\r|              " + K.SARKANS + sakumaEkranaIzvelesVarduVarianti[3] + K.RESET + "                                                                       |",
            "\r|                                                                                                      |",
            "\r|                " + sakumaEkranaIzvelesVarduVarianti[4] + "                                                                         |",
            "\r|                                                                                                      |",
            "\r|                                                                                                ::    |",
            "\r|                                                                   .         :::                ::    |",
            "\r|                                                                 .:::.       :::            .:  ::    |",
            "\r|                                                                  :::       .:::.          :::::::    |",
            "\r|                                                             [w]  :::   [s]  ':'   [ENTER]  ':        |",
            "\r|    L I E T O T A J S : _ _ _ _ _ _ _ _ _ _                                                           |",
            "\r|                                                                                                      |",
            "\r|    V E R S I J A : K A U T   K A S   S A L I P I N A T S   A R   L I M L E N T I                     |",
            "\r|______________________________________________________________________________________________________|",
        };

        return sakumaEkranaIzvelne;
    }

    static String[] izvelnesBultinas = {K.DEBESU_ZILS + ">", "<" + K.RESET};

}
